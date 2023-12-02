package com.poo.trilateracion.model;

public class Exoplaneta {
    private static int currentId = 1;

    private String nombre;
    private double radio;
    double masa;

    public Exoplaneta(String nombre, double radio, double masa) {
        this.nombre = nombre + "-" + currentId;
        this.radio = radio;
        this.masa = masa;
        currentId++;
    }
}
