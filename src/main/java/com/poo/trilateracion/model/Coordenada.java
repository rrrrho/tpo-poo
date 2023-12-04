package com.poo.trilateracion.model;
/**
 * Clase final que representa una coordenada.
 * La coordenada tiene componentes x e y y hereda de la clase abstracta Tupla.
 */
public final class Coordenada extends Tupla {
    public Coordenada(double x, double y) {
        super(x, y);
    }

    /**
     * Compara esta coordenada con el objeto dado. El resultado sera <code>true</code> si y solo si el objeto no es nulo
     * y es una coordenada con x e y iguales al de esta coordenada.
     *
     * @param o objeto con el comparo la coordenada
     * @return <code>true</code> si el objeto dado representa una coordena equivalente a <code>false</code> en caso
     * contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenada coordenada = (Coordenada) o;
        return coordenada.getX() == this.getX() && coordenada.getY() == this.getY();
    }

    /**
     * Devuelve una representación en String de la coordenada
     *
     * @return una representación en String de la coordenada de la siguiente manera: (x, y)
     */
    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", getX(), getY());
    }
}
