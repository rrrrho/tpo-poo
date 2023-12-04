package com.poo.trilateracion.dto;

import java.util.List;

/**
 * Record que representa la response de un mensaje descifrado, incluyendo una lista de palabras del mensaje.
 *
 * @param mensaje Lista de palabras que forman el mensaje descifrado.
 */
public record MensajeResponse(List<String> mensaje) {
}
