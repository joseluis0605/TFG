package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.ComprobarSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.Set;

public class ConstructivoRandom extends Constructivo{

/*
    Esta es la clase constructivo, donde vamos a recibir la instancia, que en nuestro caso seria un grafo (array de set)
    y vamos a sacar una salida

    El algoritmo que vamos a usar va a ser el RANDOM, donde vamos a coger los nodos al azar
 */

    public Solucion construir(Instancia instancia){
        Solucion solucion= new Solucion(instancia); //creamos la solucion
        while (!ComprobarSolucion.comprobarSolcion(solucion)){
            java.util.Random random= new java.util.Random();
            int nodoRandom= random.nextInt(instancia.getNumeroNodos());
            if (!solucion.existElement(nodoRandom)){
                solucion.addNodo(nodoRandom);
            }
            eliminarNodo(solucion, nodoRandom);
        }
        return solucion;
    }

    private static void eliminarNodo(Solucion solucion, int nodoEliminado) {
        for (Set<Integer> aristas: solucion.getGrafoResuelto()) {
            if (aristas.contains(nodoEliminado)){
                aristas.remove(nodoEliminado);
            }
        }
        solucion.getGrafoResuelto()[nodoEliminado].clear();
    }
}
