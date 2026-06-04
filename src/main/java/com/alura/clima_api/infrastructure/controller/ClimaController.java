package com.alura.clima_api.infrastructure.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.clima_api.application.usecase.ObtenerClimaUseCase;
import com.google.gson.Gson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/V1/clima")
@CrossOrigin(origins = "*")
@Tag(name = "Clima API", description = "Controlador para obtener el clima de una ciudad")
public class ClimaController {
    private final ObtenerClimaUseCase obtenerClimaUseCase;

    private final Gson gson = new Gson();

    public ClimaController(ObtenerClimaUseCase obtenerClimaUseCase) {
        this.obtenerClimaUseCase = obtenerClimaUseCase;
    }

    @GetMapping("/{ciudad}")
    @Operation(summary = "Obtener el clima de una ciudad", description = "Devuelve el clima actual de la ciudad especificada")
    public String getClima(@PathVariable String ciudad) throws Exception {
        return gson.toJson(obtenerClimaUseCase.execute(ciudad));
    }
    
}
