package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.NumeroComponentesConexas;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.ArrayList;
import java.util.List;

public abstract class CargadorExperimento {

    public List<Instancia> generarListaInstancia(){
        List<Instancia> listaInstancias= new ArrayList<>();
        List<String> nombresFicheros= FileNameList.getFileNameList();

        for (String nombre: nombresFicheros){
            List<String> contenido= CargadorFile.leerFile(nombre);
            Instancia instancia= new Instancia(contenido, nombre);
            listaInstancias.add(instancia);
        }
        return listaInstancias;
    }

    public abstract void cargarExperimento();

    //sacar el tiempo de ejecucion inicial y final
    public long getTime(){
        return System.nanoTime();
    }

    protected static String numberToCSV(Number n){
        return String.valueOf(n).replace(".", ",");
    }

    protected double tiempoEjecucion(long inicio, long fin){
        return (fin-inicio) / 1e9;
    }

    protected abstract void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion, int mejora, Number tiempoMejora);

    protected abstract void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion);

    protected abstract void generarImagen(Solucion mejorSolucionArray, String nombreFichero);

    protected boolean esComponenteConexa(Instancia instancia){
        return NumeroComponentesConexas.numeroComponentesConexas(instancia)==1;
    }
}