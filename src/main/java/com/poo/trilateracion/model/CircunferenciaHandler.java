package com.poo.trilateracion.model;

import com.poo.trilateracion.exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CircunferenciaHandler {
    private static final String CIRCUNFERENCIAS_IGUALES_ERROR = "ERROR: Las circunferencias se encuentran en " +
            "la misma posicion. Posicion: (%.1f, %.1f)";
    private static final String RADIO_NULO_ERROR = "ERROR: Hay una circunferencia con radio nulo. C1: %.1f - C2: %.1f.";
    private static final String CIRCUNFERENCIAS_NO_SE_TOCAN_ERROR = "ERROR: No hay interseccion entre las " +
            "circunferencias. C1: (%.1f, %.1f) - C2: (%.1f, %.1f)";
    private static final String CIRCUFERENCIA_DENTRO_DE_OTRA_ERROR = "ERROR: Hay una circunferencia dentro de otra";
    private static final String NO_EXISTE_INTERSECCION_COMUN_ERROR = "ERROR: No hay una interseccion entre las tres " +
            "circunferencias";
    private static List<Coordenada> calcularInterseccion(Circunferencia c1, Circunferencia c2) {
        if (c1.getRadio() == 0 || c2.getRadio() == 0) {
            throw new RadioNuloException(String.format(RADIO_NULO_ERROR, c1.getRadio(), c2.getRadio()));
        }

        // vector cuya norma es la distancia entre ambos centros
        Vector w = new Vector(c2.getCentro().getX() - c1.getCentro().getX(),
                c2.getCentro().getY() - c1.getCentro().getY());

        if (vectorEsNulo(w)) {
            throw new CircunferenciasIgualesException
                    (String.format(CIRCUNFERENCIAS_IGUALES_ERROR, c1.getCentro().getX(), c1.getCentro().getY()));
        }

        // calculo dicha distancia
        double distancia = Math.sqrt(Math.pow(w.getX(), 2) + Math.pow(w.getY(), 2));

        double radioMasGrande = Math.max(c1.getRadio(), c2.getRadio());
        double radioMasChico = Math.min(c1.getRadio(), c2.getRadio());

        if (distancia < (radioMasGrande - radioMasChico)) {
            throw new CircuferenciaDentroDeOtraException(CIRCUFERENCIA_DENTRO_DE_OTRA_ERROR);
        }

        if (distancia > (c1.getRadio() + c2.getRadio())) {
            throw new CircunferenciasNoSeTocanException(String.format(CIRCUNFERENCIAS_NO_SE_TOCAN_ERROR,
                    c1.getCentro().getX(), c1.getCentro().getY(), c2.getCentro().getX(), c2.getCentro().getY()));
        }

        // calculo la distancia desde c1 hasta donde deberia pasar la recta interseccion
        double x = (Math.pow(c2.getRadio(), 2) - Math.pow(distancia, 2) - Math.pow(c1.getRadio(), 2))
                / (-2 * distancia);

        // calculo el factor para poder achicar w hasta que la norma valga x
        double factor = x / distancia;

        // obtengo u multiplicando w por el factor resultante
        Vector u = new Vector(w.getX() * factor, w.getY() * factor);

        // vectores perpendiculares a u
        Vector z = new Vector(-u.getY(), u.getX());
        Vector s = new Vector(u.getY(), -u.getX());

        // calculo el factor para poder achicar / agrandar z y s hasta que la norma llegue a las intersecciones
        factor = (Math.sqrt(Math.pow(c1.getRadio(), 2) - Math.pow(x, 2))) / x;

        // multiplico z y s por el factor resultante
        Vector h = new Vector(z.getX() * factor, z.getY() * factor);
        Vector g = new Vector(s.getX() * factor, s.getY() * factor);

        // obtengo un vector que parte del origen y termina donde termina u
        Vector n = new Vector(u.getX() + c1.getCentro().getX(), u.getY() + c1.getCentro().getY());

        // calculo las intersecciones sumando n con h y g
        Coordenada interseccionUno = new Coordenada(n.getX() + h.getX(), n.getY() + h.getY());
        Coordenada interseccionDos = new Coordenada(n.getX() + g.getX(), n.getY() + g.getY());

        return new ArrayList<>(Arrays.asList(interseccionUno, interseccionDos));
    }

    private static boolean vectorEsNulo(Vector vector) {
        return vector.getX() == 0 && vector.getY() == 0;
    }

    public static Coordenada encontrarPuntoFinal(Circunferencia c1, Circunferencia c2, Circunferencia c3){
        List<Coordenada> interseccionesDosUno = calcularInterseccion(c2, c1);
        List<Coordenada> interseccionesTresUno = calcularInterseccion(c3, c1);
        List<Coordenada> interseccionesTresDos = calcularInterseccion(c3, c2);

        Optional<Coordenada> candidato = Optional.empty();
        for(Coordenada c : interseccionesDosUno){
            if(interseccionesTresUno.contains(c) && interseccionesTresDos.contains(c)){
                candidato = Optional.of(c);
            }
        }
        if(candidato.isEmpty()){
            throw new NoExisteInterseccionComunException(NO_EXISTE_INTERSECCION_COMUN_ERROR);
        }
        return candidato.get();

    }


}
