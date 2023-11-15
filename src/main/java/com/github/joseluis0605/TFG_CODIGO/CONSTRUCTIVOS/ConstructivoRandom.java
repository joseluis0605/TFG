package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.ComprobarSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.Set;

public class ConstructivoRandom {

/*
    Esta es la clase constructivo, donde vamos a recibir la instancia, que en nuestro caso seria un grafo (array de set)
    y vamos a sacar una salida

    El algoritmo que vamos a usar va a ser el RANDOM, donde vamos a coger los nodos al azar
 */

    public static Solucion algoritmoRandom(Instancia instancia){
        Solucion solucion= new Solucion(); //creamos la solucion
        while (!ComprobarSolucion.comprobarSolcion(instancia)){
            java.util.Random random= new java.util.Random();
            int nodoRandom= random.nextInt(instancia.getNumeroNodos());
            if (!solucion.existElement(nodoRandom)){
                solucion.addNodo(nodoRandom);
            }
            eliminarNodo(instancia, nodoRandom);
        }
        return solucion;
    }

    private static void eliminarNodo(Instancia instancia, int nodoEliminado) {
        for (Set<Integer> aristas: instancia.getGrafoCopia()) {
            if (aristas.contains(nodoEliminado)){
                aristas.remove(nodoEliminado);
            }
        }
        instancia.getGrafoCopia()[nodoEliminado].clear();
    }
}
