package com.poo.trilateracion.controller;

import com.poo.trilateracion.dto.MensajeRequest;
import com.poo.trilateracion.dto.MensajeResponse;
import com.poo.trilateracion.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    @PostMapping("/topsecret")
    public ResponseEntity<MensajeResponse> descifrarMensaje(@RequestBody MensajeRequest request) {
        return ResponseEntity.ok(mensajeService.descifrarMensaje(request.getM1(), request.getM2(), request.getM3()));
    }
}
