package com.github.joseluis0605.TFG_CODIGO;

import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;

import java.util.ArrayList;
import java.util.List;

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

        List<String> listadoNombreFichero = new ArrayList<>(FileNameList.getFileNameList());
        String nombre= listadoNombreFichero.get(0);
        List<String> contenido = CargadorFile.leerFile(nombre);

        Instancia instanciaOriginal= new Instancia(contenido);
        //COPIAMOS
        Instancia instanciaCopia= new Instancia(instanciaOriginal);

        instanciaOriginal.eliminarNodo(4);

        instanciaOriginal.mostrarGrafoCopia();
        instanciaCopia.mostrarGrafoCopia();





        //Set<Integer> mejorada= MejoraSolucion.mejorarSolucion(solucionPrimera, instanciaOriginal);
        //System.out.println(mejorada);


        System.out.println("tamaño maximo de la componente: "+ instanciaOriginal.getTamComponenteConexa());

    }
}