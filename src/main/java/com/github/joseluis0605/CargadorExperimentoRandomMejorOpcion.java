package com.github.joseluis0605;

import java.util.List;

public class CargadorExperimentoRandomMejorOpcion extends CargadorExperimento{

    public CargadorExperimentoRandomMejorOpcion(){
        super("Experimento Random Mejor Opcion");
    }

    public void CargadorRandomMejorOpcion (){
        //obtenemos el listado con el nombre de todos los fichero
        List<String> listadoFicheros= super.getListadoFicheros();


        // sacamos el nombre del primer fichero
        //String nombrePrimero = super.getNombrePrimero();

        //creamos el contador de tiempo total
        double tiempoTotal=0.0;
        double tiempoEjecucion=0;



        for (String fichero: listadoFicheros) { //recorremos cada fichero
            for (int i = 0; i < 1000; i++) {
                //obtenemos contenido fichero
                List<String> contenidoFile = super.getContenidoFichero(fichero);

                // numero nodos y valor alpha
                int numeroNodos = super.numeroNodos(contenidoFile);
                double alpha = super.valorAlpha(contenidoFile);
                contenidoFile.remove(0);

                //creacion instancia
                Instancia instancia = new Instancia(numeroNodos, alpha, contenidoFile);

                long timeStart = super.getTime();
                Solucion solucion = AlgoritmoRandom.algoritmoRandom(instancia);
                long timeFinish = super.getTime();

                tiempoEjecucion = super.tiempoEjecucion(timeStart, timeFinish);
                super.generarInformacionCSV("ALGORITMO RANDOM MEJOR OPCION", fichero, i, solucion.size(), tiempoEjecucion);
            }
            //añadimos al tiempo total
            tiempoTotal = tiempoTotal + tiempoEjecucion;

            //creamos imagen
            //GeneradorGrafo crearGrafo = new GeneradorGrafo();
            //crearGrafo.writeSolutionToDisk(instancia, solucionFinal, ruta, nombreFile);
            //ruta --> C:\Users\USUARIO\Desktop\URJC\4º Ciberseguridad\TFG\AlphaSeparatorProblem\
        }
    }
}
