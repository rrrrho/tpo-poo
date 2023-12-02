package com.poo.trilateracion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poo.trilateracion.dto.ExoplanetaResponse;
import com.poo.trilateracion.model.ExoplanetasNombres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ExoplanetaService {

    public ExoplanetaResponse generarDatos(){
        Random random = new Random();
        String nombre = ExoplanetasNombres.values()[random.nextInt(ExoplanetasNombres.values().length)].name();
        double radio = random.nextDouble() * 100;
        double radioRedondeado = Math.round(radio * 100.0) / 100.0;
        double masa = random.nextDouble() * 100;
        double masaRedondeada = Math.round(masa * 100.0) / 100.0;
        return new ExoplanetaResponse(nombre, radioRedondeado, masaRedondeada);
    }
}
