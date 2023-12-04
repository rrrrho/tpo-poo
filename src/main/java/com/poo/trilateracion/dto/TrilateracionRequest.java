package com.poo.trilateracion.dto;

import java.util.List;

/**
 * Record que representa una request de trilateración, incluyendo una lista de satélites.
 *  *
 *  * @param satelites Lista de satélites con los que se hará la trilateración.
 *
 */

public record TrilateracionRequest(List<Satelite> satelites) {
    /**
     * Record que representa un satélite con coordenada y radio.
     *
     * @param centro Coordenada que representa el centro del satélite.
     * @param radio  El radio del alcance del satélite.
     */
    public static record Satelite(Coordenada centro, double radio) {
    }

    /**
     * Record que representa una coordenada.
     *
     * @param x La coordenada x.
     * @param y La coordenada y.
     */
    public static record Coordenada(double x, double y) {
    }
}
