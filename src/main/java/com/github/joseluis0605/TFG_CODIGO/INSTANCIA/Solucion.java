package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
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

    public void mostrarSolucion(){
        System.out.println("separator-> "+separator);
        System.out.println("grafo resultante: ");
        for (Set<Integer> aristas: grafoResuelto){
            System.out.println(aristas);
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


    //getter and setter


    public Set<Integer> getSeparator() {
        return separator;
    }

    public void setSeparator(Set<Integer> separator) {
        this.separator = separator;
    }

    public Instancia getInstanciaOriginal() {
        return instanciaOriginal;
    }

    public void setInstanciaOriginal(Instancia instanciaOriginal) {
        this.instanciaOriginal = instanciaOriginal;
    }

    public Set<Integer>[] getGrafoResuelto() {
        return grafoResuelto;
    }

    public void setGrafoResuelto(Set<Integer>[] grafoResuelto) {
        this.grafoResuelto = grafoResuelto;
    }

    //equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solucion solucion = (Solucion) o;
        return Objects.equals(separator, solucion.separator) && Objects.equals(instanciaOriginal, solucion.instanciaOriginal) && Arrays.equals(grafoResuelto, solucion.grafoResuelto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(separator, instanciaOriginal);
        result = 31 * result + Arrays.hashCode(grafoResuelto);
        return result;
    }
}
