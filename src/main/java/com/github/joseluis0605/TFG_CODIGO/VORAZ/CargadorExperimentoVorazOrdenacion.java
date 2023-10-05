package com.github.joseluis0605.TFG_CODIGO.VORAZ;

import com.github.joseluis0605.TFG_CODIGO.CargadorExperimento;
import com.github.joseluis0605.TFG_CODIGO.Instancia;

import java.util.List;

/*
ejecutamos un voraz donde ordenamos las aristas y cada eliminacion, volvemos a ordenar
vamos a generar la solucion de cada una donde medimos con tiempos cada instancia
en cuando a las imagenes, vamos a generar una por cada una de las salidas
 */

public class CargadorExperimentoVorazOrdenacion extends CargadorExperimento {

    public CargadorExperimentoVorazOrdenacion(){
        super("Experimento Voraz Complejo");
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
            int solucion= AlgoritmoVorazOrdenacionTrasEliminacion.algoritmoVorazComplejo(instancia);
            long timeFinish= super.getTime();
            double tiempoEjecucion= super.tiempoEjecucion(timeStart, timeFinish);

            super.generarInformacionCSV("Voraz Ordenacion Tras Eliminacion", nombrePrimero, i, solucion, tiempoEjecucion);
        }
    }
}