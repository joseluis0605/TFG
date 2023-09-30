package com.github.joseluis0605;

import java.util.HashSet;
import java.util.Set;

public class Solucion {

/*
    En esta clase vamos a mostrar la solucion de nuestro problema.
    En nuestro caso, la solucion va a ser el tamaño del set que forman los nodos que eliminamos
 */

    private Set<Integer> solucion;

    public Solucion(){
        this.solucion= new HashSet<>();
    }

    public void addNodo(int nodo){
        solucion.add(nodo);
    }

    public void mostrarSolcion(){
        System.out.println(solucion.size());
    }

    public boolean existElement(int nodoRandom) {
        return this.solucion.contains(nodoRandom);
    }

    public int size(){
        return this.solucion.size();
    }

    public void mostrar(){
        System.out.println(solucion);
    }
}
