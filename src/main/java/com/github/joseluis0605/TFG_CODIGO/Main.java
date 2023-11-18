package com.github.joseluis0605.TFG_CODIGO;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        //DetectorComponentesConexas.detectorComponentesConexas();
/*
        CargadorExperimento cargadorExperimento1= new CargadorExperimento1();
        CargadorExperimento cargadorExperimento2= new CargadorExperimento2();
        CargadorExperimento cargadorExperimento3= new CargadorExperimento3();
        CargadorExperimento cargadorExperimento4= new CargadorExperimento4();
        CargadorExperimento cargadorExperimento5= new CargadorExperimento5();

        cargadorExperimento1.resolucion();
        cargadorExperimento2.resolucion();
        cargadorExperimento3.resolucion();
        cargadorExperimento4.resolucion();
        cargadorExperimento5.resolucion();
 */


        String nombre= FileNameList.getFileNameList().get(0);
        List<String> contenido= CargadorFile.leerFile(nombre);
        Instancia instancia= new Instancia(contenido);
        instancia.eliminarNodo(4);
        instancia.eliminarNodo(6);
        instancia.eliminarNodo(7);

        Solucion solucion= new Solucion();
        solucion.addNodo(4);
        solucion.addNodo(6);
        solucion.addNodo(7);

        Set<Integer> mejorada= MejoraSolucion.mejorarSolucion(solucion, instancia);

        System.out.println(mejorada);
    }
}