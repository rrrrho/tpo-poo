package com.poo.trilateracion.exceptions;

/**
 * Excepción que indica un error cuando la cantidad de palabras en los mensajes es diferente (sacando el desfasaje).
 * Extiende la clase RuntimeException.
 */
public class CantidadDePalabrasNoCoincidenException extends RuntimeException {
    public CantidadDePalabrasNoCoincidenException(String mensaje) {
        super(mensaje);
    }
}
