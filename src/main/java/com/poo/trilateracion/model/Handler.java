package com.poo.trilateracion.model;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    public List<String> descifrarMensaje(List<String> m1, List<String> m2, List<String> m3) {
        int longitudFinalCandidato = Math.min(m1.size(), m2.size());
        int longitudFinal = Math.min(longitudFinalCandidato, m3.size());
        List<String> resultado = new ArrayList<>();

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

        if (m1.size() != longitudFinal || m2.size() != longitudFinal || m3.size() != longitudFinal) {
            throw new RuntimeException("al menos un mensaje tiene palabras de mas :(");
        }

        for (int i = 0; i < longitudFinal; i++) {
            String palabra1 = m1.get(i);
            String palabra2 = m2.get(i);
            String palabra3 = m3.get(i);
            if (palabra1.isBlank() && palabra2.isBlank() && palabra3.isBlank()) {
                //hacer una exception para este caso :)
                throw new RuntimeException("no hay ninguna palabra");
            }

            if (!palabra1.equals(palabra2) && !(palabra1.isBlank() || palabra2.isBlank()) ||
                    !palabra2.equals(palabra3) && !(palabra2.isBlank() || palabra3.isBlank())) {
                //hacer una exception para este caso :)
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
        return resultado;
    }
}