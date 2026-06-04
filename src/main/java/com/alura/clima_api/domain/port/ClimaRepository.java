package com.alura.clima_api.domain.port;

import com.alura.clima_api.domain.model.Clima;

public interface ClimaRepository {
    Clima obtenerPorCiudad(String ciudad) throws Exception;
}
