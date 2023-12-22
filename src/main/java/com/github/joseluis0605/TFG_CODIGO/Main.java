package com.github.joseluis0605.TFG_CODIGO;

import com.github.joseluis0605.TFG_CODIGO.CARGADORES.CargadorExperimento;
import com.github.joseluis0605.TFG_CODIGO.CARGADORES.CargadorExperimento1;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoRandom;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.ComprobarComponentesConexas;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CargadorExperimento cargadorExperimento= new CargadorExperimento1();
        List<Instancia> listado= cargadorExperimento.generarListaInstancia();
        for (Instancia instancia: listado){
            Constructivo constructivo= new ConstructivoRandom();
            Solucion solucion= constructivo.construir(instancia);
            ComprobarComponentesConexas.comprobarComponentesConexas(solucion);

            Solucion mejorada= MejoraSolucion.mejorarSolucion(solucion);
            ComprobarComponentesConexas.comprobarComponentesConexas(mejorada);

            Scanner input= new Scanner(System.in);
            input.nextLine();
        }
    }
}