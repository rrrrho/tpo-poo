package com.poo.trilateracion.model;

import com.poo.trilateracion.exceptions.CircuferenciaDentroDeOtraException;
import com.poo.trilateracion.exceptions.CircunferenciasIgualesException;
import com.poo.trilateracion.exceptions.CircunferenciasNoSeTocanException;
import com.poo.trilateracion.exceptions.RadioNuloException;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Circunferencia {
    private static final String CIRCUNFERENCIAS_IGUALES_ERROR = "ERROR: Las circunferencias se encuentran en " +
            "la misma posicion. Posicion: (%.1f, %.1f)";
    private static final String RADIO_NULO_ERROR = "ERROR: Hay una circunferencia con radio nulo. C1: %.1f - C2: %.1f.";
    private static final String CIRCUNFERENCIAS_NO_SE_TOCAN_ERROR = "ERROR: No hay interseccion entre las " +
            "circunferencias. C1: (%.1f, %.1f) - C2: (%.1f, %.1f)";
    private static final String CIRCUFERENCIA_DENTRO_DE_OTRA_ERROR = "ERROR: Hay una circunferencia dentro de otra";
    private Coordenada centro;
    private double radio;

    // entra r2
    public List<Coordenada> calcularInterseccion(Circunferencia circunferencia) {
        if (this.radio == 0 || circunferencia.radio == 0) {
            throw new RadioNuloException(String.format(RADIO_NULO_ERROR, this.radio, circunferencia.radio));
        }

        // vector cuya norma es la distancia entre ambos centros
        Vector w = new Vector(circunferencia.centro.getX() - this.centro.getX(),
                circunferencia.centro.getY() - this.centro.getY());

        if (vectorEsNulo(w)) {
            throw new CircunferenciasIgualesException
                    (String.format(CIRCUNFERENCIAS_IGUALES_ERROR, this.centro.getX(), this.centro.getY()));
        }

        // calculo dicha distancia
        double distancia = Math.sqrt(Math.pow(w.getX(), 2) + Math.pow(w.getY(), 2));

        double radioMasGrande = Math.max(this.radio, circunferencia.radio);
        double radioMasChico = Math.min(this.radio, circunferencia.radio);

        if (distancia < (radioMasGrande - radioMasChico)) {
            throw new CircuferenciaDentroDeOtraException(CIRCUFERENCIA_DENTRO_DE_OTRA_ERROR);
        }

        if (distancia > (this.radio + circunferencia.radio)) {
            throw new CircunferenciasNoSeTocanException(String.format(CIRCUNFERENCIAS_NO_SE_TOCAN_ERROR,
                    this.centro.getX(), this.centro.getY(), circunferencia.centro.getX(), circunferencia.centro.getY()));
        }

        // calculo la distancia desde c1 hasta donde deberia pasar la recta interseccion
        double x = (Math.pow(circunferencia.radio, 2) - Math.pow(distancia, 2) - Math.pow(this.radio, 2))
                / (-2 * distancia);

        // calculo el factor para poder achicar w hasta que la norma valga x
        double factor = x / distancia;

        // obtengo u multiplicando w por el factor resultante
        Vector u = new Vector(w.getX() * factor, w.getY() * factor);

        // vectores perpendiculares a u
        Vector z = new Vector(-u.getY(), u.getX());
        Vector s = new Vector(u.getY(), -u.getX());

        // calculo el factor para poder achicar / agrandar z y s hasta que la norma llegue a las intersecciones
        factor = (Math.sqrt(Math.pow(this.radio, 2) - Math.pow(x, 2))) / x;

        // multiplico z y s por el factor resultante
        Vector h = new Vector(z.getX() * factor, z.getY() * factor);
        Vector g = new Vector(s.getX() * factor, s.getY() * factor);

        // obtengo un vector que parte del origen y termina donde termina u
        Vector n = new Vector(u.getX() + this.centro.getX(), u.getY() + this.centro.getY());

        // calculo las intersecciones sumando n con h y g
        Coordenada interseccionUno = new Coordenada(n.getX() + h.getX(), n.getY() + h.getY());
        Coordenada interseccionDos = new Coordenada(n.getX() + g.getX(), n.getY() + g.getY());

        return new ArrayList<>(Arrays.asList(interseccionUno, interseccionDos));
    }

    private boolean vectorEsNulo(Vector vector) {
        return vector.getX() == 0 && vector.getY() == 0;
    }
}
