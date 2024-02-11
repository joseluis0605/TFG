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

    //solo para BT
    public List<Instancia> generarListaInstanciaBT(){
        List<Instancia> listaInstancias= new ArrayList<>();
        List<String> nombresFicheros= new ArrayList<>();

        nombresFicheros.add("easy_short_5.txt");
        nombresFicheros.add("easy_short_6.txt");
        nombresFicheros.add("easy_short_7.txt");
        nombresFicheros.add("easy_short_8.txt");
        nombresFicheros.add("easy_short_9.txt");
        nombresFicheros.add("easy_short_10.txt");
        nombresFicheros.add("easy_short_11.txt");
        nombresFicheros.add("easy_short_12.txt");
        nombresFicheros.add("easy_short_13.txt");
        nombresFicheros.add("easy_short_14.txt");
        nombresFicheros.add("easy_short_15.txt");
        nombresFicheros.add("easy_short_16.txt");
        nombresFicheros.add("easy_short_17.txt");
        nombresFicheros.add("easy_short_18.txt");
        nombresFicheros.add("easy_short_19.txt");



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

    public double tiempoEjecucion(long inicio, long fin){
        return (fin-inicio) / 1e9;
    }

    protected abstract void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, int mejora, Number tiempoMejora);

    protected abstract void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion);

    protected abstract void generarImagen(Solucion mejorSolucionArray, String nombreFichero);

    protected abstract void generarImagenMejorada(Solucion mejorSolucionArray, String nombreFichero);

    protected boolean esComponenteConexa(Instancia instancia){
        return NumeroComponentesConexas.numeroComponentesConexas(instancia)==1;
    }

}