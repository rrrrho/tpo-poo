package com.poo.trilateracion.dto;

import lombok.Getter;

import java.util.Random;

/**
 * Clase final que representa la respuesta al metodo para buscar el exoplaneta.
 */
@Getter
public final class TrilateracionResponse {
    private static int currentId = 1;
    private double x;
    private double y;
    private double radio;
    private double masa;
    private String nombre;

    private static final Random random = new Random();

    public TrilateracionResponse(double x, double y) {
        this.x = Math.round(x * 100.0) / 100.0;
        this.y = Math.round(y * 100.0) / 100.0;
        this.nombre = generarNombre() + "-" + currentId;
        this.radio = generarRadio();
        this.masa = generarMasa();
        currentId++;
    }

    /**
     * Genera un nombre random a partir de un enumerado.
     *
     * @return un nombre random.
     */
    private String generarNombre() {
        return ExoplanetasNombres.values()[random.nextInt(ExoplanetasNombres.values().length)].name();
    }

    /**
     * Genera un radio random.
     *
     * @return un radio random.
     */
    private double generarRadio() {
        double radio = random.nextDouble() * 100;
        return Math.round(radio * 100.0) / 100.0;
    }

    /**
     * Genera una masa random.
     *
     * @return una masa random.
     */
    private double generarMasa() {
        double masa = random.nextDouble() * 100;
        return Math.round(masa * 100.0) / 100.0;
    }

    /**
     * Enum con los nombres de exoplanetas.
     * Los nombres posibles son: KEPLER, MILETO, GALILEO, COPERNICO y NEWTON.
     */
    private enum ExoplanetasNombres {
        KEPLER,
        MILETO,
        GALILEO,
        COPERNICO,
        NEWTON
    }
}
