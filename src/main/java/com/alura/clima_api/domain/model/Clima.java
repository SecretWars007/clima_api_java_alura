package com.alura.clima_api.domain.model;

public class Clima {
    private final String ciudad;
    private final double temperatura;
    private final int humedad;
    private final String descripcion;

    public Clima(String ciudad, double temperatura, int humedad, String descripcion) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public int getHumedad() {
        return humedad;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
