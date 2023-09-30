package com.github.joseluis0605;
import java.util.ArrayList;
import java.util.List;

public abstract class CargadorExperimento {
    /*
        en esta clase vamos a hacer todo lo que tiene que ver con los ficheros a la hora de
        mandarselos al metodo que me resuelva el problema
    */

    private String nombreExperimento;
    private List<String> listadoNombresFicheros;

    public CargadorExperimento(String nombreExperimento){
        this.nombreExperimento= nombreExperimento;
        this.listadoNombresFicheros= FileNameList.getFileNameList();
    }
    // retorna lista de string con los nombres de ficheros
    public List<String> getListadoFicheros(){
        return this.listadoNombresFicheros;
    }

    // dado un nombre, coge el contenido del fichero y lo almacena en una lista
    public List<String> getContenidoFichero(String nombreFichero){
        CargadorFile lectura= new CargadorFile(nombreFichero);
        List<String> contenidoFile= new ArrayList<>(lectura.leerFile());
        return contenidoFile;
    }

    // sacamos el nombre del primero fichero
    public String getNombrePrimero(){
        return this.listadoNombresFicheros.get(0);
    }

    // sacamos el nombre del fichero dada la posicion
    public String getNombreDadaPosicion(int posicion){
        return this.listadoNombresFicheros.get(posicion);
    }

    // eliminamos el primer nombre de la lista
    public void eliminarPrimero(){
        this.listadoNombresFicheros.remove(0);
    }

    //eliminamos el nombre de la lista dada la posicion
    public void eliminarDadaPosicion(int posicion){
        this.listadoNombresFicheros.remove(posicion);
    }

    //sacar el tiempo de ejecucion inicial y final
    public long getTime(){
        return System.nanoTime();
    }

    protected static String numberToCSV(Number n){
        return String.valueOf(n).replace(".", ",");
    }

    protected int numeroNodos(List<String> contenidoFile){
        String lineaDatos= contenidoFile.get(0);
        String array[]= lineaDatos.split(" ");
        int nodos= Integer.parseInt(array[0]);
        return nodos;
    }

    protected double valorAlpha(List<String> contenidoFile){
        String lineaDatos= contenidoFile.get(0);
        String array[]= lineaDatos.split(" ");
        double alpha= Double.parseDouble(array[2]);
        return alpha;
    }

    protected double tiempoEjecucion(long inicio, long fin){
        return (fin-inicio) / 1e9;
    }

    protected void generarInformacionCSV(String nombreAlgoritmo, String nombreInstancia, int iteracion, int solucion, Number tiempoEjecucion){
        String informacion = nombreAlgoritmo + ";" + nombreInstancia + ";" + iteracion + ";" + solucion + ";" + numberToCSV(tiempoEjecucion);
        EscrituraCSV.addCSV(informacion, "AlgoritmoRandom.csv");
    }

}
