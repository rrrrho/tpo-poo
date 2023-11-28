package com.poo.trilateracion;

import com.poo.trilateracion.model.Circunferencia;
import com.poo.trilateracion.model.CircunferenciaHandler;
import com.poo.trilateracion.model.Coordenada;
import com.poo.trilateracion.model.Handler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TrilateracionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrilateracionApplication.class, args);

		Circunferencia c1 = new Circunferencia(new Coordenada(2, 2), 2);
		Circunferencia c2 = new Circunferencia(new Coordenada(4, 4), 2);
		Circunferencia c3 = new Circunferencia(new Coordenada(2, 5), 2);

        System.out.println(CircunferenciaHandler.encontrarPuntoFinal(c1, c2, c3));

        Handler handler = new Handler();

        /*
        System.out.println(handler.descifrarMensaje(new ArrayList<>(Arrays.asList("bienvenidos", "a", "", "orientada", "al", "")),
                new ArrayList<>(Arrays.asList("bienvenidos", "a","", "", "orientada", "al", "objeto")),
                new ArrayList<>(Arrays.asList("", "bienvenidos", "", "programacion", "", "", ""))));
                */

    }

}
