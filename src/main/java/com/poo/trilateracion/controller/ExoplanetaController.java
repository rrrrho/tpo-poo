package com.poo.trilateracion.controller;

import com.poo.trilateracion.dto.ExoplanetaResponse;
import com.poo.trilateracion.service.ExoplanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Controller que maneja las requests relacionadas con exoplanetas.
 * Se encarga de generar datos de exoplanetas a través de la ruta "/exoplaneta".
 */
@RestController
@RequestMapping("/exoplaneta")
public class ExoplanetaController {
    @Autowired
    private ExoplanetaService exoplanetaService;
    /**
     * Método GET que genera datos aleatorios de un exoplaneta.
     *
     * @return ResponseEntity con la respuesta que contiene los datos generados del exoplaneta.
     */
    @GetMapping
    public ResponseEntity<ExoplanetaResponse> generarDatos() {
        return ResponseEntity.ok(exoplanetaService.generarDatos());
    }
}
