package com.poo.trilateracion.service;

import com.poo.trilateracion.dto.ExoplanetaResponse;
import com.poo.trilateracion.model.ExoplanetasNombres;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Servicio que proporciona operaciones relacionadas con la generación de datos para exoplanetas.
 * Este servicio incluye un método para generar de forma aleatoria el nombre, radio y masa de un exoplaneta.
 */
@Service
public class ExoplanetaService {

    /**
     * Genera los datos de forma aleatoria del exoplaneta (nombre, radio y masa)
     *
     * @return una instancia de <code>ExoplanetaResponse</code> con los datos aleatorios.
     */
    public ExoplanetaResponse generarDatos() {
        Random random = new Random();
        String nombre = ExoplanetasNombres.values()[random.nextInt(ExoplanetasNombres.values().length)].name();
        double radio = random.nextDouble() * 100;
        double radioRedondeado = Math.round(radio * 100.0) / 100.0;
        double masa = random.nextDouble() * 100;
        double masaRedondeada = Math.round(masa * 100.0) / 100.0;
        return new ExoplanetaResponse(nombre, radioRedondeado, masaRedondeada);
    }
}
