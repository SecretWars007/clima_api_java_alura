package com.alura.clima_api.infrastructure.adapter;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.alura.clima_api.domain.model.Clima;
import com.alura.clima_api.domain.port.ClimaRepository;
import com.alura.clima_api.infrastructure.dto.OpenWeatherResponse;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ClimaRespositoryImpl implements ClimaRepository {
    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url}")
    private String apiUrl;

    private Gson gson = new Gson();
    private HttpClient httpClient = HttpClient.newHttpClient();

    @Override
    public Clima obtenerClimaMundial(String ciudad, String pais) throws Exception {

        String climaCodificada = URLEncoder.encode(ciudad.trim() + "," + pais.trim(), StandardCharsets.UTF_8);

        String url = String.format("%s?q=%s&appid=%s&units=metric&lang=es", apiUrl, climaCodificada, apiKey);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Error al obtener el clima: " + response.body());
        }

        OpenWeatherResponse weatherResponse = gson.fromJson(response.body(), OpenWeatherResponse.class);

        return new Clima(
                weatherResponse.name,
                pais,
                weatherResponse.main.getTemp(),
                weatherResponse.main.getHumidity(),
                weatherResponse.weather[0].getDescription()
        );
    }
}
