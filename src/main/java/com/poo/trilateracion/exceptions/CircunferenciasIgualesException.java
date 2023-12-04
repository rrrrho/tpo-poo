package com.poo.trilateracion.exceptions;
/**
 * Excepción que indica un error cuando se encuentra con una circunferencia igual a la otra.
 * Extiende la clase RuntimeException.
 *
 */
public class CircunferenciasIgualesException extends RuntimeException {
    public CircunferenciasIgualesException(String mensaje) {
        super(mensaje);
    }
}
