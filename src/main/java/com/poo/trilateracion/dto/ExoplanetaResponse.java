package com.poo.trilateracion.dto;

import lombok.Getter;

@Getter
public class ExoplanetaResponse {
    private static int currentId = 1;
    private String nombre;
    double radio;
    double masa;
    public ExoplanetaResponse(String nombre, double radio, double masa) {
        this.nombre = nombre + "-" + currentId;
        this.radio = radio;
        this.masa = masa;
        currentId++;
    }
}
