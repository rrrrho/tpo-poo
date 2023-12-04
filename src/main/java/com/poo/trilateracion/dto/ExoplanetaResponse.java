package com.poo.trilateracion.dto;

import lombok.Getter;
/**
 * Clase que representa la response de un exoplaneta, incluyendo información como el nombre, radio y masa.
 */
@Getter
public class ExoplanetaResponse {
    private static int currentId = 1;
    double radio;
    double masa;
    private String nombre;

    /**
     * Construye una nueva instancia de ExoplanetaResponse con el nombre, radio y masa especificados.
     * El nombre se forma concatenando el nombre dado con un id único incremental, que solo se usa para eso.
     *
     * @param nombre nombre del exoplaneta.
     * @param radio  radio del exoplaneta.
     * @param masa   masa del exoplaneta.
     */

    public ExoplanetaResponse(String nombre, double radio, double masa) {
        this.nombre = nombre + "-" + currentId;
        this.radio = radio;
        this.masa = masa;
        currentId++;
    }
}
