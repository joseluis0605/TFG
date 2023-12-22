package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoRandom;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class CargadorExperimento1 extends CargadorExperimento{
/*
Nuestro experimento 1 va a consistir en ejecutar 400.000 veces cada fichero para obtener el mejor tiempo
Algoritmo usar: algortimo random
mejor solucion: menor tamaño del set solucion
tiempo: el sumatorio de todas las iteraciones sobre la misma instancia
 */

    public void cargarExperimento() {

        List<Instancia> listadoInstancias= generarListaInstancia();

        for (Instancia instancia: listadoInstancias){
            //variables declaradas
            Solucion solucionActual;
            Solucion solucionMejor= new Solucion(instancia);
            int mejorSolucionTam=9999;
            int iteracion=0;
            int mejorIteracion=0;
            TiemposMaximos tiemposMaximos= new TiemposMaximos();

            if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName()) != null){
                double tiempoMaximoInstancia= tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName());
                Constructivo constructivo= new ConstructivoRandom();

                long inicio = System.nanoTime();
                while ((System.nanoTime()- inicio)/1e9d < tiempoMaximoInstancia){

                    solucionActual = constructivo.construir(instancia);

                    if (solucionActual.size() < mejorSolucionTam){
                        solucionMejor.copiarSolucion(solucionActual);
                        mejorIteracion= iteracion;
                        mejorSolucionTam= solucionMejor.size();
                    }
                    iteracion++;
                }
                //ComprobarComponentesConexas.comprobarComponentesConexas(solucionMejor);

                Solucion solucionMejorada = MejoraSolucion.mejorarSolucion(solucionMejor);
                //ComprobarComponentesConexas.comprobarComponentesConexas(solucionMejorada);

                double tiempoTotal= (System.nanoTime()- inicio)/1e9d;

                //escribimos y generamos imagenes
                escribirCSV_Mejora(instancia.getFileName(), mejorIteracion, solucionMejor.size(), solucionMejorada.size(), tiempoTotal);
                generarImagen(solucionMejor, instancia.getFileName());
                generarImagenMejorada(solucionMejorada, instancia.getFileName());
            }
        }
    }

    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, int mejora, Number tiempoTotal) {
        String informacion = "Random" + " ; " + nombreFichero + " ; " + iteracion + " ; " + solucion + " ; "+mejora+" ; "+numberToCSV(tiempoTotal);
        EscrituraCSV.addCSV(informacion, "experimento1.csv");
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {}

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento1";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }

    @Override
    protected void generarImagenMejorada(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento1_mejor";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }
}
