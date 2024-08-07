package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoVoraz;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class CargadorExperimento2 extends CargadorExperimento {

/*
Algortimo voraz
 */

    @Override
    public void cargarExperimento(){
        List<Instancia> listadoInstancias= generarListaInstancia();

        for (Instancia instancia: listadoInstancias){
            TiemposMaximos tiemposMaximos= new TiemposMaximos();
            Solucion solucionActual = null;

            if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())!=null){
                Constructivo constructivo= new ConstructivoVoraz();
                long inicio= System.nanoTime();
                while ((System.nanoTime()-inicio)/1e9d < tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())){
                    solucionActual= constructivo.construir(instancia);
                }
                Solucion solucionMejorada= MejoraSolucion.mejorarSolucion(solucionActual);
                double tiempoTotal= (System.nanoTime()-inicio)/1e9;

                // generamos imagenes y csv
                escribirCSV_Mejora(instancia.getFileName(), 1, solucionActual.size(), solucionMejorada.size(), tiempoTotal);
                generarImagen(solucionActual ,instancia.getFileName());
                generarImagenMejorada(solucionMejorada, instancia.getFileName());
            }
        }
    }


    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion,  int tamMejora, Number tiempoTotalConMejora) {
        String informacion = "Voraz" + " ; " + nombreFichero + " ; " + iteracion + " ; " + solucion +" ; "+tamMejora+" ; "+numberToCSV(tiempoTotalConMejora);
        EscrituraCSV.addCSV(informacion, "experimento2.csv");
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {}

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento2";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }
    @Override
    protected void generarImagenMejorada(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento2_mejor";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }
}
