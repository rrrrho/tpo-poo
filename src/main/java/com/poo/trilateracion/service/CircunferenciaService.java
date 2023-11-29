package com.poo.trilateracion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poo.trilateracion.dto.TrilateracionRequest;
import com.poo.trilateracion.dto.TrilateracionResponse;
import com.poo.trilateracion.exceptions.*;
import com.poo.trilateracion.model.Circunferencia;
import com.poo.trilateracion.model.Coordenada;
import com.poo.trilateracion.model.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class CircunferenciaService {
    @Autowired
    private ObjectMapper mapper;

    private static final String CIRCUNFERENCIAS_IGUALES_ERROR = "ERROR: Los satelites se encuentran en " +
            "la misma posicion. Posicion: (%.1f, %.1f)";
    private static final String RADIO_NULO_ERROR = "ERROR: Hay un satelite con distancia nula. C1: %.1f - C2: %.1f.";
    private static final String CIRCUNFERENCIAS_NO_SE_TOCAN_ERROR = "ERROR: Los alcances de los satelites no se " +
            "intersectan. S1: (%.1f, %.1f) - S2: (%.1f, %.1f)";
    private static final String CIRCUFERENCIA_DENTRO_DE_OTRA_ERROR = "ERROR: El alcance de un satelite se encuentra " +
            "dentro de otro.";
    private static final String NO_EXISTE_INTERSECCION_COMUN_ERROR = "ERROR: Las distancias no se hayan en un solo " +
            "punto.";

    private List<Coordenada> calcularInterseccion(Circunferencia c1, Circunferencia c2) {
        if (c1.radio() == 0 || c2.radio() == 0) {
            throw new RadioNuloException(String.format(RADIO_NULO_ERROR, c1.radio(), c2.radio()));
        }

        // vector cuya norma es la distancia entre ambos centros
        Vector w = new Vector(c2.centro().getX() - c1.centro().getX(),
                c2.centro().getY() - c1.centro().getY());

        if (vectorEsNulo(w)) {
            throw new CircunferenciasIgualesException
                    (String.format(CIRCUNFERENCIAS_IGUALES_ERROR, c1.centro().getX(), c1.centro().getY()));
        }

        // calculo dicha distancia
        double distancia = Math.sqrt(Math.pow(w.getX(), 2) + Math.pow(w.getY(), 2));

        double radioMasGrande = Math.max(c1.radio(), c2.radio());
        double radioMasChico = Math.min(c1.radio(), c2.radio());

        if (distancia < (radioMasGrande - radioMasChico)) {
            throw new CircuferenciaDentroDeOtraException(CIRCUFERENCIA_DENTRO_DE_OTRA_ERROR);
        }

        if (distancia > (c1.radio() + c2.radio())) {
            throw new CircunferenciasNoSeTocanException(String.format(CIRCUNFERENCIAS_NO_SE_TOCAN_ERROR,
                    c1.centro().getX(), c1.centro().getY(), c2.centro().getX(), c2.centro().getY()));
        }

        // calculo la distancia desde c1 hasta donde deberia pasar la recta interseccion
        double x = (Math.pow(c2.radio(), 2) - Math.pow(distancia, 2) - Math.pow(c1.radio(), 2))
                / (-2 * distancia);

        // calculo el factor para poder achicar w hasta que la norma valga x
        double factor = x / distancia;

        // obtengo u multiplicando w por el factor resultante
        Vector u = new Vector(w.getX() * factor, w.getY() * factor);

        // vectores perpendiculares a u
        Vector z = new Vector(-u.getY(), u.getX());
        Vector s = new Vector(u.getY(), -u.getX());

        // calculo el factor para poder achicar / agrandar z y s hasta que la norma llegue a las intersecciones
        factor = (Math.sqrt(Math.pow(c1.radio(), 2) - Math.pow(x, 2))) / x;

        // multiplico z y s por el factor resultante
        Vector h = new Vector(z.getX() * factor, z.getY() * factor);
        Vector g = new Vector(s.getX() * factor, s.getY() * factor);

        // obtengo un vector que parte del origen y termina donde termina u
        Vector n = new Vector(u.getX() + c1.centro().getX(), u.getY() + c1.centro().getY());

        // calculo las intersecciones sumando n con h y g
        Coordenada interseccionUno = new Coordenada(n.getX() + h.getX(), n.getY() + h.getY());
        Coordenada interseccionDos = new Coordenada(n.getX() + g.getX(), n.getY() + g.getY());

        return new ArrayList<>(Arrays.asList(interseccionUno, interseccionDos));
    }

    private boolean vectorEsNulo(Vector vector) {
        return vector.getX() == 0 && vector.getY() == 0;
    }

    public TrilateracionResponse encontrarPuntoFinal(TrilateracionRequest request) {
        List<Circunferencia> circunferencias = request.satelites().stream().map(satelite ->
            mapper.convertValue(satelite, Circunferencia.class)).collect(Collectors.toList());

        List<Coordenada> interseccionesDosUno = calcularInterseccion(circunferencias.get(1), circunferencias.get(0));
        List<Coordenada> interseccionesTresUno = calcularInterseccion(circunferencias.get(2), circunferencias.get(0));
        List<Coordenada> interseccionesTresDos = calcularInterseccion(circunferencias.get(2), circunferencias.get(1));

        Optional<Coordenada> candidato = Optional.empty();
        for (Coordenada c : interseccionesDosUno) {
            if (interseccionesTresUno.contains(c) && interseccionesTresDos.contains(c)) {
                candidato = Optional.of(c);
            }
        }
        if (candidato.isEmpty()) {
            throw new NoExisteInterseccionComunException(NO_EXISTE_INTERSECCION_COMUN_ERROR);
        }

        return mapper.convertValue(candidato.get(), TrilateracionResponse.class);
    }
}
