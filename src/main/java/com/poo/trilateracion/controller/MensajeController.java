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

/**
 * Controller que maneja las requests relacionadas con mensajes.
 * Se encarga de descifrar mensajes recibidos a través de la ruta "/mensaje/topsecret".
 */
@RestController
@RequestMapping("/mensaje")
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    /**
     * Método POST que descifra un mensaje a partir de las tres listas de cadenas proporcionadas en la solicitud.
     *
     * @param request contiene las tres listas de String correspondientes a tres mensajes.
     * @return ResponseEntity con la respuesta de descifrar el mensaje.
     */
    @PostMapping("/topsecret")
    public ResponseEntity<MensajeResponse> descifrarMensaje(@RequestBody MensajeRequest request) {
        return ResponseEntity.ok(mensajeService.descifrarMensaje(request.m1(), request.m2(), request.m3()));
    }
}
