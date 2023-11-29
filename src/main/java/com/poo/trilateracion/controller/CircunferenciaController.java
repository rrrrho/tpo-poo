package com.poo.trilateracion.controller;

import com.poo.trilateracion.dto.TrilateracionRequest;
import com.poo.trilateracion.dto.TrilateracionResponse;
import com.poo.trilateracion.service.CircunferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trilateracion")
public class CircunferenciaController {
    @Autowired
    private CircunferenciaService circunferenciaService;

    @PostMapping
    public ResponseEntity<TrilateracionResponse> encontrarExoplaneta(@RequestBody TrilateracionRequest request) {
        return ResponseEntity.ok(circunferenciaService.encontrarPuntoFinal(request));
    }
}
