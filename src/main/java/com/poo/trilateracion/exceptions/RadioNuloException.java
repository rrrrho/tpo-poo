package com.poo.trilateracion.exceptions;

/**
 * Excepción que indica un error cuando se encuentra un radio con valor 0 en una circunferencia.
 * Extiende la clase RuntimeException.
 */
public class RadioNuloException extends RuntimeException {
    public RadioNuloException(String mensaje) {
        super(mensaje);
    }
}
