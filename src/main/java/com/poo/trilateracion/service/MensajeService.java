package com.poo.trilateracion.service;

import com.poo.trilateracion.dto.MensajeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Servicio que realiza operaciones relacionadas con el descifrado de mensajes.
 * Este servicio incluye un método para recibir tres mensajes con desfasajes o errores,
 * completarlos en base a los otros y generar un mensaje descifrado.
 */

@Service
public final class MensajeService {
    /**
     * Recibe tres con desfasajes o errores mensajes y los completa en base a los otros.
     *
     * @param m1 lista de String con el primer mensaje.
     * @param m2 lista de String con el segundo mensaje.
     * @param m3 lista de String con el tercer mensaje.
     * @return una instancia de <code>MensajeResponse</code> con el mensaje descifrado.
     * @throws RuntimeException si la cantidad de palabras en las los mensajes es diferente (sacando el desfasaje), si
     *                          no se puede completar una parte del mensaje descifrado debido a que los 3 mensajes tienen esa posicion vacía o
     *                          si hay una palabra diferente en la misma posición de los mensajes.
     */
    public MensajeResponse descifrarMensaje(List<String> m1, List<String> m2, List<String> m3) {
        List<String> resultado = new ArrayList<>();
        int longitudFinal;
        if (m1.get(0).isBlank() && m2.get(0).isBlank() && m3.get(0).isBlank()) {
            m1.remove(0);
            m2.remove(0);
            m3.remove(0);
            longitudFinal = m1.size();
        } else {
            int longitudFinalCandidato = Math.min(m1.size(), m2.size());
            longitudFinal = Math.min(longitudFinalCandidato, m3.size());
            if (m1.size() > longitudFinal) {
                if (!m1.get(0).equals("")) {
                    throw new RuntimeException("la cantidad de palabras no coincide");
                }
                m1.remove(0);
            }
            if (m2.size() > longitudFinal) {
                if (!m2.get(0).equals("")) {
                    throw new RuntimeException("la cantidad de palabras no coincide");
                }
                m2.remove(0);
            }
            if (m3.size() > longitudFinal) {
                if (!m3.get(0).equals("")) {
                    throw new RuntimeException("la cantidad de palabras no coincide");
                }
                m3.remove(0);
            }
        }

        if (m1.size() != longitudFinal || m2.size() != longitudFinal || m3.size() != longitudFinal) {
            throw new RuntimeException("al menos un mensaje tiene palabras de mas :(");
        }

        for (int i = 0; i < longitudFinal; i++) {
            String palabra1 = m1.get(i);
            String palabra2 = m2.get(i);
            String palabra3 = m3.get(i);
            if (palabra1.isBlank() && palabra2.isBlank() && palabra3.isBlank()) {
                throw new RuntimeException("no hay ninguna palabra");
            }

            if (!palabra1.equals(palabra2) && !(palabra1.isBlank() || palabra2.isBlank()) ||
                    !palabra2.equals(palabra3) && !(palabra2.isBlank() || palabra3.isBlank())) {
                throw new RuntimeException("no coinciden las palabras :(");
            }
            if (!palabra1.equals("")) {
                resultado.add(palabra1);
                continue;
            }
            if (!palabra2.equals("")) {
                resultado.add(palabra2);
                continue;
            }
            if (!palabra3.equals("")) {
                resultado.add(palabra3);
            }
        }
        return new MensajeResponse(resultado);
    }
}
