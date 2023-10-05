package com.github.joseluis0605.TFG_CODIGO.RANDOM;

import com.github.joseluis0605.TFG_CODIGO.CargadorExperimento;
import com.github.joseluis0605.TFG_CODIGO.Instancia;
import com.github.joseluis0605.TFG_CODIGO.Solucion;

import java.util.List;

/*
En esta clase vamos a aplicar el algoritmo random y vamos a ejecutarlo 1000 veces, un par de instancias
y vamos a guardar los tiempos para mostrar en varias gráficas, y comparar los tiempos de ejecucion de cada
instancia
 */

public class CargadorExperimentoRandom extends CargadorExperimento {

    public CargadorExperimentoRandom(){
        super("Experimento Random");
    }

    public void cargadorRandom(){
        //obtenemos el listado con el nombre de todos los fichero
        List<String> listadoFicheros= super.getListadoFicheros();


        // sacamos el nombre del primer fichero
        //String nombrePrimero = super.getNombrePrimero();

        //creamos el contador de tiempo total
        double tiempoTotal=0.0;
        double tiempoEjecucion=0;



        for (String fichero: listadoFicheros) { //recorremos los ficheros
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
                super.generarInformacionCSV("ALGORITMO RANDOM", fichero, i, solucion.size(), tiempoEjecucion);
            }
            //añadimos al tiempo total
            tiempoTotal = tiempoTotal + tiempoEjecucion;

            //creamos imagen
            //GeneradorGrafo crearGrafo = new GeneradorGrafo();
            //crearGrafo.writeSolutionToDisk(instancia, solucionFinal, ruta, nombreFile);
        }


    }


}
