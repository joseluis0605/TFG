package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.HashSet;
import java.util.Set;

public class NumeroComponentesConexas {

    public static int numeroComponentesConexas(Instancia grafo) {
        Set<Integer> visitado= new HashSet<>();
        int contador=0;

        for (int i = 0; i < grafo.getNumeroNodos(); i++) {
            if (!visitado.contains(i)){
                recorrido(grafo.getGrafo(), i,visitado);
                contador++;
            }
        }
        return contador;
    }

    private static void recorrido(Set<Integer>[] grafo, int nodo, Set<Integer> visitado) {
        visitado.add(nodo);
        for (Integer nodoHijo: grafo[nodo]) {
            if (!visitado.contains(nodoHijo)){
                recorrido(grafo,nodoHijo,visitado);
            }
        }
    }
}
