package com.github.joseluis0605.TFG_CODIGO.VORAZ;

import com.github.joseluis0605.TFG_CODIGO.CargadorExperimento;
import com.github.joseluis0605.TFG_CODIGO.Instancia;

import java.util.List;

/*
ejecutamos todas las instancias una unica vez y almacenamos el tiempo y la solucion
la imagen generada es la de cada una de las soluciones
 */

public class CargadorExperimentoVorazSimple extends CargadorExperimento {

    public CargadorExperimentoVorazSimple(){
        super("Experimento Voraz simple");
    }

    public void cargadorVoraz(){
        //obtenemos el listado con el nombre de todos los fichero
        List<String> listadoFicheros= super.getListadoFicheros();

        // sacamos el nombre del primer fichero
        String nombrePrimero = super.getNombrePrimero();

        //obtenemos contenido fichero
        List<String> contenidoFile= super.getContenidoFichero(nombrePrimero);

        // numero nodos y valor alpha
        int numeroNodos= super.numeroNodos(contenidoFile);
        double alpha= super.valorAlpha(contenidoFile);
        contenidoFile.remove(0);

        //creacion instancia
        Instancia instancia= new Instancia(numeroNodos, alpha, contenidoFile);

        for (int i = 0; i < 200; i++) {
            long timeStart= super.getTime();
            int solucion= AlgoritmoVorazSimple.algoritmoVorazSimple(instancia);
            long timeFinish= super.getTime();
            double tiempoEjecucion= super.tiempoEjecucion(timeStart, timeFinish);

            super.generarInformacionCSV("Voraz Simple", nombrePrimero, i, solucion, tiempoEjecucion);
        }
    }
}
