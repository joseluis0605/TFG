package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Instancia {

/*
    En esta clase vamos a almacenar el que seria nuestro grafo y su copia (creacion del grafo).
    Ademas va a contener informacion util: numero Nodos, valor alpha y numero maximo de nodos por componente conexa
    ELEMENTOS INMUTABLES-> LOS QUE NO SE PUEDEN TOCAR
 */

    private Set<Integer> grafo[];
    private int numeroNodos;
    private double alpha;
    private double tamComponenteConexa;

    public Instancia(List<String> contenidoFichero){
        primeraLinea(contenidoFichero.get(0));
        contenidoFichero.remove(0);
        this.grafo=new Set[numeroNodos];
        this.tamComponenteConexa= alpha * numeroNodos;
        iniciarGrafo();
        crearGrafo(contenidoFichero);
    }

    //COPIAMOS UN GRAFO EN OTRO GRAFO
   public Instancia (Instancia otraInstancia){
       this.numeroNodos= otraInstancia.numeroNodos;
       this.alpha= otraInstancia.alpha;
       this.tamComponenteConexa= otraInstancia.tamComponenteConexa;
       this.grafo=new Set[numeroNodos];
       iniciarGrafo();
       for (int i = 0; i < this.numeroNodos; i++) {
           this.grafo[i].addAll(otraInstancia.getGrafo()[i]);
       }
   }

    private void primeraLinea(String linea){
        String array[]= linea.split(" ");
        int nodos= Integer.parseInt(array[0]);
        double alpha= Double.parseDouble(array[2]);
        setNumeroNodos(nodos);
        setAlpha(alpha);
    }

    // inicializamos el grafo
    private void iniciarGrafo() {
        for (int i = 0; i < this.numeroNodos; i++) {
            grafo[i]= new HashSet<>();
        }
    }

    // creamos el grafo pasandole una lista de string que son las aristas
    private void crearGrafo(List<String> aristas) {
        for (String pareja: aristas ) {
            String array[]= pareja.split(" ");
            int inicio= Integer.parseInt(array[0]);
            int fin= Integer.parseInt(array[1]);
            insertarArista(inicio, fin);
        }
    }

    // insertamos aristas en el grafo
    public void insertarArista(int inicio, int fin) {
        this.grafo[inicio].add(fin);
        this.grafo[fin].add(inicio);;
    }

    public void mostrarGrafoOriginal(){
        int nodo=0;
        for (Set<Integer> aristas : grafo){
            System.out.println(nodo+"-->"+aristas);
            nodo++;
        }
    }

    // generamos los getter y los setter por defecto
    public Set<Integer>[] getGrafo() {
        return grafo;
    }

    public void setGrafo(Set<Integer>[] grafo) {
        this.grafo = grafo;
    }

    public int getNumeroNodos() {
        return numeroNodos;
    }

    public void setNumeroNodos(int numeroNodos) {
        this.numeroNodos = numeroNodos;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getTamComponenteConexa() {
        return tamComponenteConexa;
    }

    public void setTamComponenteConexa(double tamComponenteConexa) {
        this.tamComponenteConexa = tamComponenteConexa;
    }
}
