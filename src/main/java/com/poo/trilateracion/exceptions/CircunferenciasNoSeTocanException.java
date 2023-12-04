package com.poo.trilateracion.exceptions;
/**
 * Excepción que indica un error cuando no se tocan dos circunferencias y, por lo tanto, no hay intersección
 * Extiende la clase RuntimeException.
 *
 */
public class CircunferenciasNoSeTocanException extends RuntimeException {
    public CircunferenciasNoSeTocanException(String mensaje) {
        super(mensaje);
    }
}
