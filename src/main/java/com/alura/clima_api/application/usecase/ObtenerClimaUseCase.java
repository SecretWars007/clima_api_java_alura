package com.alura.clima_api.application.usecase;

import org.springframework.stereotype.Component;

import com.alura.clima_api.domain.model.Clima;
import com.alura.clima_api.domain.port.ClimaRepository;

@Component
public class ObtenerClimaUseCase {
    private final ClimaRepository climaRepository;

    public ObtenerClimaUseCase(ClimaRepository climaRepository) {
        this.climaRepository = climaRepository;
    }

    public Clima execute(String ciudad, String pais) throws Exception {
        if  (pais == null || pais.isEmpty() || pais.isBlank()) {
            throw new IllegalArgumentException("El país no puede ser nulo o vacío");
        }
        if  (ciudad == null || ciudad.isEmpty() || ciudad.isBlank()) {
            throw new IllegalArgumentException("La ciudad no puede ser nula o vacía");
        }
        return climaRepository.obtenerClimaMundial(ciudad, pais);
    }
}
