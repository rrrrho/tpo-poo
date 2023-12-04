package com.poo.trilateracion.exceptions;

/**
 * Excepción que indica un error cuando no se puede completar una parte del mensaje descifrado debido a que los 3
 * mensajes tienen esa posicion vacía.
 * Extiende la clase RuntimeException.
 */
public class MensajeIncompletoException extends RuntimeException {
    public MensajeIncompletoException(String mensaje) {
        super(mensaje);
    }
}
