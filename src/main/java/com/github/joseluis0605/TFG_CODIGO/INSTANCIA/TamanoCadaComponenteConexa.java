package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.*;

public class TamanoCadaComponenteConexa {

    public static void comprobarSolucion(Solucion solucion) {
        Set<Integer> visitado= new HashSet<>();
        for (int i = 0; i < solucion.getInstanciaOriginal().getNumeroNodos(); i++) {
            if (!visitado.contains(i)){
                int contador= recorrido(solucion.getGrafoResuelto(), visitado, i);
                System.out.println(contador);
            }
        }

    }

    private static int recorrido(Set<Integer>[] grafo, Set<Integer> visitado, int nodo) {
        visitado.add(nodo);
        int contador = 1;
        for (Integer arista: grafo[nodo]) {
            if (!visitado.contains(arista)){
                contador= contador + recorrido(grafo, visitado, arista);
            }
        }
        return contador;
    }
}
