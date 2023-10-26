package com.poo.trilateracion;

import com.poo.trilateracion.model.Circunferencia;
import com.poo.trilateracion.model.Coordenada;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TrilateracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrilateracionApplication.class, args);
		Circunferencia circunferenciaUno = new Circunferencia(new Coordenada(2, 4), 2);
		Circunferencia circunferenciaDos = new Circunferencia(new Coordenada(2, 4), 2);
		Circunferencia circunferenciaTres = new Circunferencia(new Coordenada(3, 0), Math.sqrt(5));

		List<Coordenada> interseccionesDosUno = circunferenciaDos.calcularInterseccion(circunferenciaUno);
		List<Coordenada> interseccionesTresUno = circunferenciaTres.calcularInterseccion(circunferenciaUno);

		System.out.printf("(%.2f, %.2f)\n", interseccionesDosUno.get(0).getX(), interseccionesDosUno.get(0).getY());
		System.out.printf("(%.2f, %.2f)\n", interseccionesDosUno.get(1).getX(), interseccionesDosUno.get(1).getY());

		System.out.printf("(%.2f, %.2f)\n", interseccionesTresUno.get(0).getX(), interseccionesTresUno.get(0).getY());
		System.out.printf("(%.2f, %.2f)", interseccionesTresUno.get(1).getX(), interseccionesTresUno.get(1).getY());
	}

}
