package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.HashSet;
import java.util.Set;

public class Solucion {

/*
    En esta clase vamos a mostrar la separator de nuestro problema.
    En nuestro caso, la separator va a ser el tamaño del set que forman los nodos que eliminamos
 */

    private Set<Integer> separator;
    private Instancia instanciaOriginal;
    private Set<Integer>[] grafoResuelto;


    public Solucion(Instancia instanciaOriginal){
        this.separator = new HashSet<>();
        this.instanciaOriginal= instanciaOriginal;

        for (int i = 0; i < instanciaOriginal.getNumeroNodos(); i++) {
            this.grafoResuelto[i]= new HashSet<>();
            this.grafoResuelto[i].addAll(this.instanciaOriginal.getGrafo()[i]);
        }



    }

    public void addNodo(int nodo){
        separator.add(nodo);
    }

    public boolean existElement(int nodoRandom) {
        return this.separator.contains(nodoRandom);
    }

    public int size(){
        return this.separator.size();
    }


}
