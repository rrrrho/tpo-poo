package com.poo.trilateracion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TrilateracionRequest {
    private List<Satelite> satelites;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Satelite {
        private Coordenada centro;
        private double radio;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Coordenada {
        private double x;
        private double y;
    }
}
