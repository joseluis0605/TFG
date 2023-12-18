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
Nuestro experimento 2 va a consistir en ejecutar 1 vez cada fichero para obtener la solucion
Algoritmo usar: algortimo voraz
tiempo: tiempo que tarda cada ejecucion del algoritmo
 */

    @Override
    public void cargarExperimento(){
        List<Instancia> listadoInstancias= generarListaInstancia();

        for (Instancia instancia: listadoInstancias){
            TiemposMaximos tiemposMaximos= new TiemposMaximos();

            if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())!=null){
                double tiempoAcumulado=0;
                boolean escrito= false;
                while ((tiempoAcumulado/1e9)<tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())){
                    long inicio= super.getTime();
                    Constructivo constructivo= new ConstructivoVoraz();
                    Solucion solucion = constructivo.construir(instancia);
                    long fin= super.getTime();
                    double tiempoTotal= super.tiempoEjecucion(inicio,fin);
                    double tiempoEjecucionSinMejora= tiempoTotal;

                    //aplicamos mejora
                    inicio= super.getTime();
                    Solucion mejora= MejoraSolucion.mejorarSolucion(solucion);
                    fin= super.getTime();
                    tiempoTotal= tiempoTotal+super.tiempoEjecucion(inicio, fin);
                    int tamMejora= mejora.size();

                    if (!escrito){
                        // generamos imagenes y csv
                        escribirCSV_Mejora(instancia.getFileName(), 1, solucion.size(), tiempoEjecucionSinMejora, tamMejora, tiempoTotal);
                        generarImagen(solucion ,instancia.getFileName());
                        escrito= true;
                    }
                    tiempoAcumulado = tiempoAcumulado+tiempoTotal;
                }
            }
        }
    }


    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion, int tamMejora, Number tiempoTotalConMejora) {
        String informacion = "Voraz" + " ; " + nombreFichero + " ; " + iteracion + " ; " + solucion + " ; " + numberToCSV(tiempoEjecucion)+" ; "+tamMejora+" ; "+numberToCSV(tiempoTotalConMejora);
        EscrituraCSV.addCSV(informacion, "experimento2.csv");
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {}

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento2";
        GenDOT.writeSolutionToDisk(mejorSolucionArray, ruta, nombreFichero);
    }
}
