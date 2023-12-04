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
/**
 * Controller que maneja las requests relacionadas con la trilateración.
 * Se encarga de encontrar el punto final de trilateración a través de la ruta "/trilateracion".
 */
@RestController
@RequestMapping("/trilateracion")
public class CircunferenciaController {
    @Autowired
    private CircunferenciaService circunferenciaService;

    /**
     * Método POST que encuentra el punto final de trilateración a partir de la información de los satélites.
     *
     * @param request Solicitud que contiene la información de los satélites.
     * @return ResponseEntity con la respuesta que contiene las coordenadas del punto final de trilateración.
     */
    @PostMapping
    public ResponseEntity<TrilateracionResponse> encontrarExoplaneta(@RequestBody TrilateracionRequest request) {
        return ResponseEntity.ok(circunferenciaService.encontrarPuntoFinal(request));
    }
}
