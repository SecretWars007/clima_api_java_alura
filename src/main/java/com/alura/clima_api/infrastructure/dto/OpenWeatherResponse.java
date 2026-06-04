package com.alura.clima_api.infrastructure.dto;

public class OpenWeatherResponse {
    public String name;
    public Main main;
    public Weather[] weather;

    public static class Main {
        double temp;
        int humidity;

        public double getTemp() {
            return temp;
        }

        public int getHumidity() {
            return humidity;
        }
    }

    public static class Weather {
        String description;

        public String getDescription() {
            return description;
        }
    }
}
