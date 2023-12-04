package com.poo.trilateracion.exceptions;

/**
 * Excepción que indica un error cuando no se encuentra una intersección común entre las 3
 * circunferencias.
 * Extiende la clase RuntimeException.
 */
public class NoExisteInterseccionComunException extends RuntimeException {
    public NoExisteInterseccionComunException(String mensaje) {
        super(mensaje);
    }
}
