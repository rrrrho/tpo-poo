package com.poo.trilateracion.dto;

import java.util.List;

public record TrilateracionRequest(List<Satelite> satelites) {

    public static record Satelite(Coordenada centro, double radio) { }

    public static record Coordenada(double x, double y) { }
}
