package com.poo.trilateracion.dto;

/**
 * Record que muestra la response al algoritmo de trilateración.
 * @param x coordenada x del punto final donde se encuentra el exoplaneta.
 * @param y coordenada y del punto final donde se encuentra el exoplaneta.
 */
public record TrilateracionResponse(double x, double y) {
}
