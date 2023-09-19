package com.company.resolucionClases;

import java.util.HashSet;
import java.util.Set;

public class Nodo {

    private Set<Integer> aristas;
    
    Nodo(){
        this.aristas= new HashSet<>();
    }

    Nodo(Set<Integer> aristas){
        this.aristas= new HashSet<>(aristas);
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "aristas=" + aristas +
                '}';
    }

    public void addNodo(int nodo){
        this.aristas.add(nodo);
    }

    public void deleteNodo(int nodo){
        this.aristas.remove(nodo);
    }

    public void destruir(){
        this.aristas.clear();
    }

    public Set<Integer> getAristas() {
        return aristas;
    }

    public void setAristas(Set<Integer> aristas) {
        this.aristas = aristas;
    }
}


