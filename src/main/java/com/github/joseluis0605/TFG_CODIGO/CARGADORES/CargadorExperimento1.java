package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoRandom;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.ArrayList;
import java.util.List;

public class CargadorExperimento1 extends CargadorExperimento{
/*
Nuestro experimento 1 va a consistir en ejecutar 400.000 veces cada fichero para obtener el mejor tiempo
Algoritmo usar: algortimo random
mejor solucion: menor tamaño del set solucion
tiempo: el sumatorio de todas las iteraciones sobre la misma instancia
 */

    public void resolucion() {
        List<String> listadoNombreFichero = new ArrayList<>(FileNameList.getFileNameList());
        
        for (String nombreFichero : listadoNombreFichero){
            int mejorSolucionNumero= 999999;
            int mejorIteracion=0;
            Solucion mejorSolucionArray= new Solucion();
            double tiempoTotal=0;
            Instancia instanciaPuntero= null;

            for (int i = 0; i < 400.000; i++) {
                List <String> contenido= CargadorFile.leerFile(nombreFichero);
                if (contenido!=null){
                    Instancia instancia= new Instancia(contenido);
                    instanciaPuntero= instancia;

                    long inicio= super.getTime();
                    Solucion solucion = ConstructivoRandom.algoritmoRandom(instancia);
                    long fin= super.getTime();

                    tiempoTotal= tiempoTotal + super.tiempoEjecucion(inicio,fin);
                    if (solucion.size() < mejorSolucionNumero){
                        mejorSolucionNumero= solucion.size();
                        mejorSolucionArray.setSolucion(solucion.getSolucion());
                        mejorIteracion=i;
                    }
                }
            }

            // generamos imagenes y csv
            if (super.esComponenteConexa(instanciaPuntero)){
                escribirCSV(nombreFichero, mejorIteracion, mejorSolucionNumero, tiempoTotal);
                generarImagen(instanciaPuntero, mejorSolucionArray,nombreFichero);
            }
        }
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {
        String informacion = "Random" + ";" + nombreFichero + ";" + iteracion + ";" + solucion + ";" + numberToCSV(tiempoEjecucion);
        EscrituraCSV.addCSV(informacion, "experimento1.csv");
    }

    @Override
    protected void generarImagen(Instancia instanciaPuntero, Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento1";
        GenDOT.writeSolutionToDisk(instanciaPuntero, mejorSolucionArray, ruta, nombreFichero);
    }
}