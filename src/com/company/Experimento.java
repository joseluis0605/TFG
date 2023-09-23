package com.company;

import java.util.ArrayList;
import java.util.List;

public class Experimento {

/*
    En esta clase vamos a realizar los experimentos, es decir, va a ser donde se llame a la ejecucion de los algoritmos
 */

    public static void main(String[] args) {


        for (int i = 0; i < 500; i++) {
            long timeStart= System.currentTimeMillis();
            //obtenemos el listado con el nombre de todos los fichero
            List<String> listadoFicheros= FileNameList.getFileNameList();


            // sacamos el nombre del primer fichero
            String nombrePrimero= listadoFicheros.get(0);

            //obtenemos contenido fichero
            CargadorFile lectura= new CargadorFile(nombrePrimero);
            List<String> contenidoFile= new ArrayList<>(lectura.leerFile());

            // sacamos la primera linea de datos, numeroNodos, numeroAristas, valor alpha
            String lineaDatos= contenidoFile.get(0);
            String array[]= lineaDatos.split(" ");

            int numeroNodos= Integer.parseInt(array[0]);
            double alpha= Double.parseDouble(array[2]);
            contenidoFile.remove(0);


            Instancia instancia= new Instancia(numeroNodos, alpha, contenidoFile);
            AlgoritmoRandom.AlgoritmoRandom(instancia);

            long timeFinish= System.currentTimeMillis();

            double tiempoEjecucion= (double)( (timeFinish-timeStart) / 1000.0);
            System.out.println(tiempoEjecucion);
        }






    }
}
