package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.HashSet;
import java.util.Set;

public class Solucion {

/*
    En esta clase vamos a mostrar la solucion de nuestro problema.
    En nuestro caso, la solucion va a ser el tamaño del set que forman los nodos que eliminamos
 */

    private Set<Integer> solucion;
    private Instancia instanciaOriginal;
    private Set[] grafoResuelto;


    public Solucion(Instancia instanciaOriginal){
        this.solucion= new HashSet<>();
        this.instanciaOriginal= instanciaOriginal;

        for (int i = 0; i < instanciaOriginal.getNumeroNodos(); i++) {
            this.grafoResuelto[i]= new HashSet<>();
        }


    }

    public void addNodo(int nodo){
        solucion.add(nodo);
    }

    public boolean existElement(int nodoRandom) {
        return this.solucion.contains(nodoRandom);
    }

    public int size(){
        return this.solucion.size();
    }


}
