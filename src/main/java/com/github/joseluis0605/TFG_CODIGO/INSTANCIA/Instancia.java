package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.*;

public class Instancia {

    private String fileName;
    private Set<Integer>[] grafo;
    private int numeroNodos;
    private double alpha;
    private double tamComponenteConexa;

    public Instancia(List<String> contenidoFichero, String fileName){
        this.fileName= fileName;
        primeraLinea(contenidoFichero.get(0));
        contenidoFichero.remove(0);
        this.grafo=new Set[numeroNodos];
        this.tamComponenteConexa= alpha * numeroNodos;
        iniciarGrafo();
        crearGrafo(contenidoFichero);
    }

    private void primeraLinea(String linea){
        String array[]= linea.split(" ");
        int nodos= Integer.parseInt(array[0]);
        double alpha= Double.parseDouble(array[2]);
        setNumeroNodos(nodos);
        setAlpha(alpha);
    }

    private void iniciarGrafo() {
        for (int i = 0; i < this.numeroNodos; i++) {
            grafo[i]= new HashSet<>();
        }
    }

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

    public String getFileName() {
        return fileName;
    }

    public void setTamComponenteConexa(double tamComponenteConexa) {
        this.tamComponenteConexa = tamComponenteConexa;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //equals and hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instancia instancia = (Instancia) o;
        return numeroNodos == instancia.numeroNodos && Double.compare(instancia.alpha, alpha) == 0 && Double.compare(instancia.tamComponenteConexa, tamComponenteConexa) == 0 && Arrays.equals(grafo, instancia.grafo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numeroNodos, alpha, tamComponenteConexa);
        result = 31 * result + Arrays.hashCode(grafo);
        return result;
    }

    //mostrar grafo
    public void mostrarInfo(){
        System.out.println("numero nodos-> "+this.numeroNodos);
        System.out.println("alpha-> "+this.alpha);
        System.out.println("tamaño componente conexa-> "+this.tamComponenteConexa);
        System.out.println("mostramos grafo....");
        for (int i = 0; i < this.numeroNodos; i++) {
            System.out.println(i+"->"+this.grafo[i]);
        }
    }

    @Override
    public String toString() {
        return "Instancia{" +
                "fileName='" + fileName + '\'' +
                ", grafo=" + Arrays.toString(grafo) +
                ", numeroNodos=" + numeroNodos +
                ", alpha=" + alpha +
                ", tamComponenteConexa=" + tamComponenteConexa +
                '}';
    }
}
