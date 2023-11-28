package com.poo.trilateracion.model;

public class Coordenada extends Tupla {
    public Coordenada(double x, double y) {
        super(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada coordenada = (Coordenada) o;
        return coordenada.getX() == this.getX() && coordenada.getY() == this.getY();
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", getX(), getY());
    }
}
