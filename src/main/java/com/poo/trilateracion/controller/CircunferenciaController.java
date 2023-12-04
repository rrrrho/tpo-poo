package com.poo.trilateracion.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poo.trilateracion.dto.TrilateracionRequest;
import com.poo.trilateracion.dto.TrilateracionResponse;
import com.poo.trilateracion.model.Circunferencia;
import com.poo.trilateracion.model.Coordenada;
import com.poo.trilateracion.service.CircunferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controller que maneja las requests relacionadas con la trilateración.
 * Se encarga de encontrar el punto final de trilateración a través de la ruta "/trilateracion".
 */
@RestController
@RequestMapping("/trilateracion")
public class CircunferenciaController {
    @Autowired
    private CircunferenciaService circunferenciaService;
    @Autowired
    private ObjectMapper mapper;

    /**
     * Método POST que encuentra el punto final de trilateración a partir de la información de los satélites.
     *
     * @param request Solicitud que contiene la información de los satélites.
     * @return ResponseEntity con la respuesta que contiene las coordenadas del punto final de trilateración.
     */
    @PostMapping
    public ResponseEntity<TrilateracionResponse> encontrarExoplaneta(
            @RequestBody TrilateracionRequest request) {
        List<Circunferencia> circunferencias = mapearACircunferencias(request);

        Coordenada ubicacion = circunferenciaService.encontrarPuntoFinal(circunferencias.get(0),
                circunferencias.get(1), circunferencias.get(2));

        return ResponseEntity.ok(new TrilateracionResponse(ubicacion.getX(), ubicacion.getY()));
    }

    private List<Circunferencia> mapearACircunferencias(TrilateracionRequest request) {
        return request.satelites().stream().map(satelite ->
                mapper.convertValue(satelite, Circunferencia.class)).collect(Collectors.toList());
    }
}
