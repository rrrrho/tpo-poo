package com.poo.trilateracion.dto;

import java.util.List;
/**
 * Record que representa una request de mensajes, incluyendo tres listas de String correspondientes a tres mensajes.
 *
 * @param m1 Lista de String que representa el primer mensaje.
 * @param m2 Lista de String que representa el segundo mensaje.
 * @param m3 Lista de String que representa el tercer mensaje.
 */
public record MensajeRequest(List<String> m1, List<String> m2, List<String> m3) {
}
