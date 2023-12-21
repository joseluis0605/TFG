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
Nuestro experimento 3 va a consistir en ejecutar 1 vez cada fichero para obtener la solucion
Algoritmo usar: algortimo voraz con ordenacion tras eliminacion
tiempo: tiempo que tarda cada ejecucion del algoritmo
 */

    public void cargarExperimento(){

        List<Instancia> listadoInstancias= generarListaInstancia();

        for (Instancia instancia: listadoInstancias){
            TiemposMaximos tiemposMaximos= new TiemposMaximos();

            if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName()) != null){
                double tiempoTotal=0;
                Solucion solucionActual=null;
                Solucion solucionMejorada= null;

                while (tiempoTotal<tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())){
                    Constructivo constructivo= new ConstructivoVorazOrdenacionTrasEliminacion();
                    long inicio= super.getTime();
                    solucionActual= constructivo.construir(instancia);
                    long fin= super.getTime();
                    tiempoTotal= tiempoTotal+super.tiempoEjecucion(inicio, fin);
                }

                long inicio= super.getTime();
                solucionMejorada= MejoraSolucion.mejorarSolucion(solucionActual);
                long fin= super.getTime();
                tiempoTotal= tiempoTotal+ super.tiempoEjecucion(inicio, fin);

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
