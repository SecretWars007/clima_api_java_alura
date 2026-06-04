package com.alura.clima_api.domain.model;

public class Clima {
    private final String ciudad;
    private final String pais;
    private final double temperatura;
    private final int humedad;
    private final String descripcion;

    public Clima(String ciudad, String pais, double temperatura, int humedad, String descripcion) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
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
