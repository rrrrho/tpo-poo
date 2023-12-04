package com.poo.trilateracion.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Clase abstracta que representa una tupla con componentes x e y.
 */
@AllArgsConstructor
@Getter
public abstract class Tupla {
    private double x;
    private double y;
}
