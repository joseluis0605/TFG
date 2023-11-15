package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.HashSet;
import java.util.Set;

public class ComprobarSolucion {

    //En esta clase vamos a comprobar que se cumple la solucion, es decir, que todas las componentes tengan tamaño maximo
    // n * alpha

    public static boolean comprobarSolcion(Instancia instancia) {
        Set<Integer> visitado= new HashSet<>();
        int contador;
        for (int i = 0; i < instancia.getNumeroNodos(); i++) {
            if (!visitado.contains(i)){
                contador= recorrido(instancia.getGrafoCopia(), visitado, i);
                if (contador>instancia.getTamComponenteConexa()){
                    return false;
                }
            }
        }
        return true;
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
