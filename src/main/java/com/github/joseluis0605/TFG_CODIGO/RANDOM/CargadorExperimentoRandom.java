package com.github.joseluis0605.TFG_CODIGO.RANDOM;

import com.github.joseluis0605.TFG_CODIGO.CargadorExperimento;
import com.github.joseluis0605.TFG_CODIGO.GeneradorGrafo;
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
        String ruta= "C:\\Users\\USUARIO\\Desktop\\URJC\\4º Ciberseguridad\\TFG\\AlphaSeparatorProblem\\imagenesGrafo\\experimentoRandom\\";

        //creamos el contador de tiempo total
        double tiempoTotal=0.0; //tenemos el tiempo total, sumatorio de tiempos

        //variables mejor opciones
        Solucion mejorSolucion=null;
        Instancia mejorInstancia= null;
        int mejorSolucionTam=999999;
        int mejorIteracion=-1;


        for (String fichero : listadoFicheros){
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
                double tiempoEjecucion = super.tiempoEjecucion(timeStart, timeFinish);
                tiempoTotal= tiempoTotal+tiempoEjecucion;

                //si es mejor solucion, cambiamos ---> tamaño del set sea menor
                if (solucion.size()<mejorSolucionTam){
                    mejorSolucionTam= solucion.size();
                    mejorInstancia= instancia;
                    mejorSolucion= solucion;
                    mejorIteracion=i;
                }

            }
            super.generarInformacionCSV("ALGORITMO RANDOM", fichero, mejorIteracion, mejorSolucionTam, tiempoTotal);
            GeneradorGrafo generadorGrafo= new GeneradorGrafo();
            generadorGrafo.writeSolutionToDisk(mejorInstancia, mejorSolucion, ruta, fichero);

            //inicializamos
            mejorSolucionTam= 999999;
            mejorInstancia= null;
            mejorSolucion= null;
            mejorIteracion=0;
            tiempoTotal=0;
        }
    }
}

