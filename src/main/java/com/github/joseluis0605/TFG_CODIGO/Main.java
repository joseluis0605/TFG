package com.github.joseluis0605.TFG_CODIGO;

import com.github.joseluis0605.TFG_CODIGO.CARGADORES.CargadorExperimento;
import com.github.joseluis0605.TFG_CODIGO.CARGADORES.CargadorExperimento1;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoRandom;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CargadorExperimento cargadorExperimento= new CargadorExperimento1();
        List<Instancia> listadoInstancias= cargadorExperimento.generarListaInstancia();

        Instancia instancia1 = listadoInstancias.get(0);

        Constructivo constructivo1= new ConstructivoRandom();
        Solucion solucionActual= constructivo1.construir(instancia1);

        System.out.println(solucionActual);

        Solucion solucionMejor= MejoraSolucion.mejorarSolucion(solucionActual);
        System.out.println(solucionMejor);

    }
}