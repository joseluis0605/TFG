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
            double tiempoEjecucion=0;
            double tiempoMejora;
            Solucion solucionActual;
            Solucion solucionMejor= new Solucion(instancia);
            int mejorSolucionTam=9999;
            int iteracion=0;
            int mejorIteracion=0;
            TiemposMaximos tiemposMaximos= new TiemposMaximos();

            // si componente conexa == 1
            if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName()) != null){
                // mientras el tiempo sea menor, ejecutar el algoritmo
                //tiempoEjecucion/1e9 < )
                double tiempoMaximoInstancia= tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName());
                while ((tiempoEjecucion) < tiempoMaximoInstancia){

                    Constructivo constructivo= new ConstructivoRandom();

                    long tiempoInicio= super.getTime();
                    solucionActual = constructivo.construir(instancia);
                    long tiempoFin= super.getTime();
                    tiempoEjecucion= tiempoEjecucion + super.tiempoEjecucion(tiempoInicio, tiempoFin);


                    if (solucionActual.size() < mejorSolucionTam){
                        solucionMejor.copiarSolucion(solucionActual);
                        mejorIteracion= iteracion;
                        mejorSolucionTam= solucionMejor.size();
                    }
                    iteracion++;
                    System.out.println(instancia.getFileName()+" "+tiempoEjecucion+" --> "+tiempoMaximoInstancia);
                }

                // una vez que termine, vamos a realizar la mejora
                long tiempoInicio= super.getTime();
                Solucion solucionMejorada = MejoraSolucion.mejorarSolucion(solucionMejor);
                long tiempoFin= super.getTime();
                tiempoMejora= super.tiempoEjecucion(tiempoInicio, tiempoFin);

                //vamos a buscar siempre una solucion mejorada
                tiempoEjecucion= tiempoEjecucion+ tiempoMejora;


                //escribimos y generamos imagenes
                escribirCSV_Mejora(instancia.getFileName(), mejorIteracion, solucionMejor.size(), solucionMejorada.size(), tiempoEjecucion);
                generarImagen(solucionMejor, instancia.getFileName());
                generarImagen(solucionMejorada, instancia.getFileName());
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
