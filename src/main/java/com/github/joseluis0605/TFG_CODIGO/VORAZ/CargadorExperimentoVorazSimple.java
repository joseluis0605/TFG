package com.github.joseluis0605.TFG_CODIGO.VORAZ;

import com.github.joseluis0605.TFG_CODIGO.*;

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

        for (String fichero : listadoFicheros){
            //obtenemos contenido fichero
            List<String> contenidoFile= super.getContenidoFichero(fichero);

            // numero nodos y valor alpha
            int numeroNodos= super.numeroNodos(contenidoFile);
            double alpha= super.valorAlpha(contenidoFile);
            contenidoFile.remove(0);

            //creacion instancia
            Instancia instancia= new Instancia(numeroNodos, alpha, contenidoFile);

            long timeStart= super.getTime();
            Solucion solucion= AlgoritmoVorazSimple.algoritmoVorazSimple(instancia);
            long timeFinish= super.getTime();
            double tiempoEjecucion= super.tiempoEjecucion(timeStart, timeFinish);

            super.generarInformacionCSV("Voraz Simple", fichero, 0, solucion.size(), tiempoEjecucion);

            //generamos imagen grafo
            GeneradorGrafo imagenGrafo= new GeneradorGrafo();
            String rutaCompleta= Ruta.getRuta()+"experimentoVorazSimple";
            imagenGrafo.writeSolutionToDisk(instancia, solucion, rutaCompleta, fichero);
        }
    }
}
