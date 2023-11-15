package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.NumeroComponentesConexas;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

public abstract class CargadorExperimento {

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

    protected abstract void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion);

    protected abstract void generarImagen(Instancia instanciaPuntero, Solucion mejorSolucionArray, String nombreFichero);

    public abstract void resolucion();

    protected boolean esComponenteConexa(Instancia instancia){
        return NumeroComponentesConexas.numeroComponentesConexas(instancia)==1;
    }
}