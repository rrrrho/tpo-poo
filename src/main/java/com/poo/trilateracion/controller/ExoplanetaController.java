package com.poo.trilateracion.controller;

import com.poo.trilateracion.dto.ExoplanetaResponse;
import com.poo.trilateracion.service.ExoplanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exoplaneta")
public class ExoplanetaController {
    @Autowired
    private ExoplanetaService exoplanetaService;

    @GetMapping
    public ResponseEntity<ExoplanetaResponse> generarDatos(){
        return ResponseEntity.ok(exoplanetaService.generarDatos());
    }
}
