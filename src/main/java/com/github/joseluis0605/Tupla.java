package com.github.joseluis0605;

public class Tupla {

    private int nodo;
    private int numeroAristas;

    public Tupla(int nodo, int numeroAristas){
        this.nodo=nodo;
        this.numeroAristas= numeroAristas;
    }

    public Tupla(){
        this.nodo=0;
        this.numeroAristas=0;
    }

    @Override
    public String toString() {
        return "nodo--> "+this.nodo+" valor--> "+this.numeroAristas;
    }

    public int getNodo() {
        return nodo;
    }

    public void setNodo(int nodo) {
        this.nodo = nodo;
    }

    public int getNumeroAristas() {
        return numeroAristas;
    }

    public void setNumeroAristas(int numeroAristas) {
        this.numeroAristas = numeroAristas;
    }
}
