package com.poo.trilateracion.model;

import com.poo.trilateracion.exceptions.CircuferenciaDentroDeOtraException;
import com.poo.trilateracion.exceptions.CircunferenciasIgualesException;
import com.poo.trilateracion.exceptions.CircunferenciasNoSeTocanException;
import com.poo.trilateracion.exceptions.RadioNuloException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public class Circunferencia {
    private Coordenada centro;
    private double radio;
}
