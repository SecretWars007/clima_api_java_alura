package com.alura.clima_api.domain.port;

import com.alura.clima_api.domain.model.Clima;

public interface ClimaRepository {
    Clima obtenerClimaMundial(String ciudad, String pais) throws Exception;
}
