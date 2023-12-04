package com.poo.trilateracion.model;

/**
 * Record que representa una circunferencia.
 * La circunferencia tiene un centro, que es una coordenada, y un radio.
 *
 * @param centro La coordenada que representa el centro de la circunferencia.
 * @param radio  El radio de la circunferencia.
 */
public record Circunferencia(Coordenada centro, double radio) {
}
