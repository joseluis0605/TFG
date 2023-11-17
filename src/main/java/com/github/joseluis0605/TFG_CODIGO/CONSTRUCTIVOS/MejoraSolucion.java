package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.HashSet;
import java.util.Set;

public class MejoraSolucion {
/*
Vamos a recibir una solucion de una instancia y vamos a intentar mejorarlo, eliminando las distintas soluciones
 */

    public static Set<Integer> mejorarSolucion (Solucion solucion, Instancia instancia){

        //copiamos Solucion forma manual
        Set<Integer> solucionCopia= new HashSet<>();
        solucionCopia.addAll(solucion.getSolucion());

        //set con los mejorados que luego eliminaremos
        Set<Integer>nodosInutiles= new HashSet<>();


        //recorremos las soluciones

        return solucionCopia;
    }
}
