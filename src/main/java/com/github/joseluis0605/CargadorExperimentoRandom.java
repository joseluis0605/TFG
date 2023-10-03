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



        for (int i = 0; i < 1; i++) {
            //creacion instancia
            Instancia instancia= new Instancia(numeroNodos, alpha, contenidoFile);
            Solucion solucionFinal= new Solucion();

            long timeStart= super.getTime();
            Solucion solucion= AlgoritmoRandom.algoritmoRandom(instancia);
            long timeFinish= super.getTime();
            solucionFinal= solucion;

            //instancia.mostrarGrafo();

            double tiempoEjecucion= super.tiempoEjecucion(timeStart, timeFinish);
            //solucionFinal.mostrar();
            super.generarInformacionCSV("Random", nombrePrimero, i, solucion.size(), tiempoEjecucion);

            GeneradorGrafo crearGrafo = new GeneradorGrafo();
            crearGrafo.writeSolutionToDisk(instancia, solucionFinal);
        }


    }


}
