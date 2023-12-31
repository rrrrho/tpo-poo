package com.poo.trilateracion.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CircuferenciaDentroDeOtraException.class)
    public ResponseEntity<String> handleCircuferenciaDentroDeOtraException(CircuferenciaDentroDeOtraException exp) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exp.getMessage());
    }

    @ExceptionHandler(CircunferenciasIgualesException.class)
    public ResponseEntity<String> handleCircunferenciasIgualesException(CircunferenciasIgualesException exp) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exp.getMessage());
    }

    @ExceptionHandler(RadioNuloException.class)
    public ResponseEntity<String> handleRadioNuloException(RadioNuloException exp) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exp.getMessage());
    }

    @ExceptionHandler(NoExisteInterseccionComunException.class)
    public ResponseEntity<String> handleNoExisteInterseccionComunException(NoExisteInterseccionComunException exp) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exp.getMessage());
    }

    @ExceptionHandler(CircunferenciasNoSeTocanException.class)
    public ResponseEntity<String> handleCircunferenciasNoSeTocanException(CircunferenciasNoSeTocanException exp) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exp.getMessage());
    }

    @ExceptionHandler(CantidadDePalabrasNoCoincidenException.class)
    public ResponseEntity<String> handleCantidadDePalabrasNoCoincidenException(CantidadDePalabrasNoCoincidenException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }

    @ExceptionHandler(MensajeIncompletoException.class)
    public ResponseEntity<String> handleMensajeIncompletoException(MensajeIncompletoException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }

    @ExceptionHandler(MensajeDiferenteException.class)
    public ResponseEntity<String> handleMensajeDiferenteException(MensajeDiferenteException exp) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exp.getMessage());
    }
}
