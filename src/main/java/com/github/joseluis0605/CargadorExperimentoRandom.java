package com.github.joseluis0605;

import java.util.List;

public class CargadorExperimentoRandom extends CargadorExperimento{

    public CargadorExperimentoRandom(){
        super("Experimento random");
    }

    public void cargadorRandom(){
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
            int solucion= AlgoritmoRandom.algoritmoRandom(instancia);
            long timeFinish= super.getTime();
            double tiempoEjecucion= super.tiempoEjecucion(timeStart, timeFinish);

            super.generarInformacionCSV("Random", nombrePrimero, i, solucion, tiempoEjecucion);
        }
    }


}
