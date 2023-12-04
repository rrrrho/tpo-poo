package com.poo.trilateracion.exceptions;

/**
 * Excepción que indica un error si hay una palabra diferente en la misma posición de los mensajes.
 * Extiende la clase RuntimeException.
 */
public class MensajeDiferenteException extends RuntimeException {
    public MensajeDiferenteException(String mensaje) {
        super(mensaje);
    }
}
