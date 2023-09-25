package com.company;

import java.util.ArrayList;
import java.util.List;

public class CargadorExperimentoVorazSimple {

    public static void cargarVorazSimple(){
        for (int i = 0; i < 200; i++) {
            //obtenemos el listado con el nombre de todos los fichero
            List<String> listadoFicheros= FileNameList.getFileNameList();


            // sacamos el nombre del primer fichero
            String nombrePrimero = listadoFicheros.get(0);

            //obtenemos contenido fichero
            CargadorFile lectura= new CargadorFile(nombrePrimero);
            List<String> contenidoFile= new ArrayList<>(lectura.leerFile());

            // sacamos la primera linea de datos, numeroNodos, numeroAristas, valor alpha
            String lineaDatos= contenidoFile.get(0);
            String array[]= lineaDatos.split(" ");

            int numeroNodos= Integer.parseInt(array[0]);
            double alpha= Double.parseDouble(array[2]);
            contenidoFile.remove(0);

            //CAMBIAR!!!!!!!!!
            Instancia instancia= new Instancia(numeroNodos, alpha, contenidoFile);

            long timeStart= System.currentTimeMillis();
            int solucion= AlgoritmoVorazSimple.algoritmoVorazSimple(instancia);
            long timeFinish= System.currentTimeMillis();
            double tiempoEjecucion= (double)( (timeFinish-timeStart) / 1000.0);

            // ALGORITMO VORAZ SIMPLE
            String informacion= "Algoritmo vorazSimple,"+nombrePrimero+","+i+","+solucion+","+tiempoEjecucion;
            EscrituraCSV.addCSV(informacion, "AlgoritmoVorazSimple.csv");

        }
    }
}
