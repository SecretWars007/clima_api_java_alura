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

    public Clima execute(String ciudad) throws Exception {
        if  (ciudad == null || ciudad.isEmpty() || ciudad.isBlank()) {
            throw new IllegalArgumentException("La ciudad no puede ser nula o vacía");
        }
        return climaRepository.obtenerPorCiudad(ciudad);
    }
}
