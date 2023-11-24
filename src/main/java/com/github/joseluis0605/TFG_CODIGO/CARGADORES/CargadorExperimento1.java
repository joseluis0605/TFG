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
            int mejorSolucionNumero= 999999;
            int mejorIteracion=0;
            Solucion mejorSolucion= new Solucion();
            double tiempoTotal=0;
            int tamMejora=0;

            Solucion solucionActual= new Solucion(instancia);

            if (super.esComponenteConexa(solucionActual.getInstanciaOriginal())){
                for (int i = 0; i < 400.000; i++) {

                    long inicio= super.getTime();
                    Constructivo constructivo= new ConstructivoRandom();
                    Solucion solucion = constructivo.construir(instancia);
                    long fin= super.getTime();
                    tiempoTotal= tiempoTotal + super.tiempoEjecucion(inicio,fin);

                    if (solucion.size() < mejorSolucionNumero){
                        mejorSolucionNumero= solucion.size();
                        mejorSolucion.copiarSolucion(solucion);
                        mejorIteracion=i;
                        Solucion mejora= MejoraSolucion.mejorarSolucion(solucion);
                        mejorSolucion.copiarSolucion(mejora);
                        tamMejora= mejora.size();
                    }

                }

                // generamos imagenes y csv
                escribirCSV_Mejora(instancia.getFileName(), mejorIteracion, mejorSolucionNumero, tiempoTotal, tamMejora);
                generarImagen(mejorSolucion, instancia.getFileName());
            }
        }
    }

    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion, int mejora) {
        String informacion = "Random" + ";" + nombreFichero + ";" + iteracion + ";" + solucion + ";" + numberToCSV(tiempoEjecucion)+";"+mejora;
        EscrituraCSV.addCSV(informacion, "experimento1.csv");
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {}

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento1";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }
}