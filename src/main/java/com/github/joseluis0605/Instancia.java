package com.github.joseluis0605;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Instancia {

/*
    En esta clase vamos a almacenar el que seria nuestro grafo y su copia (creacion del grafo).
    Ademas va a contener informacion util: numero Nodos, valor alpha y numero maximo de nodos por componente conexa
 */

    private Set<Integer> grafo[];
    private Set<Integer> grafoCopia[];
    private int numeroNodos;
    private double alpha;
    private double tamComponenteConexa;

    public Instancia(int numeroNodos, double alpha, List<String> aristas){
        this.grafo=new Set[numeroNodos];
        this.grafoCopia= new Set[numeroNodos];
        this.numeroNodos= numeroNodos;
        this.alpha=alpha;
        this.tamComponenteConexa= alpha * numeroNodos;
        iniciarGrafo();
        crearGrafo(aristas);
    }

    // inicializamos el grafo
    private void iniciarGrafo() {
        for (int i = 0; i < this.numeroNodos; i++) {
            grafo[i]= new HashSet<>();
            grafoCopia[i]= new HashSet<>();
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
    private void insertarArista(int inicio, int fin) {
        this.grafo[inicio].add(fin);
        this.grafo[fin].add(inicio);
        this.grafoCopia[fin].add(inicio);
        this.grafoCopia[inicio].add(fin);
    }


    // generamos los getter y los setter por defecto


    public Set<Integer>[] getGrafo() {
        return grafo;
    }

    public void setGrafo(Set<Integer>[] grafo) {
        this.grafo = grafo;
    }

    public Set<Integer>[] getGrafoCopia() {
        return grafoCopia;
    }

    public void setGrafoCopia(Set<Integer>[] grafoCopia) {
        this.grafoCopia = grafoCopia;
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
