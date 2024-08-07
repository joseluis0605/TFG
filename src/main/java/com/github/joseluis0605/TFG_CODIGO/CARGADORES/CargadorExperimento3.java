package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoVorazOrdenacionTrasEliminacion;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class CargadorExperimento3 extends CargadorExperimento{

/*
Algoritmo usar: algortimo voraz con ordenacion tras eliminacion
 */

    public void cargarExperimento(){

        List<Instancia> listadoInstancias= generarListaInstancia();

        for (Instancia instancia: listadoInstancias){
            TiemposMaximos tiemposMaximos= new TiemposMaximos();

            if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName()) != null){
                Solucion solucionActual = null;
                Constructivo constructivo= new ConstructivoVorazOrdenacionTrasEliminacion();

                long inicio= System.nanoTime();
                while ((System.nanoTime()-inicio)/1e9d <tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())){
                    solucionActual= constructivo.construir(instancia);
                }
                Solucion solucionMejorada= MejoraSolucion.mejorarSolucion(solucionActual);
                double tiempoTotal= (System.nanoTime()-inicio)/1e9d;

                escribirCSV_Mejora(instancia.getFileName(), 1, solucionActual.size(), solucionMejorada.size(), tiempoTotal);
                generarImagen(solucionActual, instancia.getFileName());
                generarImagenMejorada(solucionMejorada, instancia.getFileName());
            }
        }
    }
    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, int mejora, Number tiempoTotal) {
        String informacion = "Voraz Ordenado Tras Eliminacion" + ";" + nombreFichero + ";" + iteracion + ";" + solucion + ";"+mejora+";"+numberToCSV(tiempoTotal);
        EscrituraCSV.addCSV(informacion, "experimento3.csv");
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {}

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento3";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }

    @Override
    protected void generarImagenMejorada(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento3_mejor";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }
}
