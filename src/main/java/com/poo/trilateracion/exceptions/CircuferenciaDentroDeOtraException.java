package com.poo.trilateracion.exceptions;
/**
 * Excepción que indica un error cuando se encuentra una circunferencia completamente dentro de otra y, por lo tanto, no
 * hay intersección.
 * Extiende la clase RuntimeException.
 *
 */
public class CircuferenciaDentroDeOtraException extends RuntimeException {
    public CircuferenciaDentroDeOtraException(String mensaje) {
        super(mensaje);
    }
}
