package com.github.joseluis0605.PRUEBAS_INICIALES.practicasAlgoritmos;

import java.util.HashSet;
import java.util.Set;

public class TamañoComponenteConexa {

    public static int tamComponenteConexa(Set<Integer>[] grafo, int numeroNodos) {
        Set<Integer> visitado= new HashSet<>();
        int contador=1;
        for (int i = 0; i < numeroNodos; i++) {
            if (!visitado.contains(i)){
                contador= recorrido(grafo,i,visitado);
            }
        }
        return contador;
    }

    private static int recorrido(Set<Integer>[] grafo, int nodo, Set<Integer> visitado) {
        int contador=1;
        visitado.add(nodo);
        //imprimir nodo
        for (Integer nodoHijo: grafo[nodo]) {
            if (!visitado.contains(nodoHijo)){
                contador= contador+ recorrido(grafo,nodoHijo,visitado);
            }
        }
        return contador;
    }
}
