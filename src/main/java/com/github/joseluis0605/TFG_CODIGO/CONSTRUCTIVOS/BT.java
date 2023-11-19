package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.ComprobarSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Tupla;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BT {
/*
Vamos a aplicar BT para encontrar soluciones ante grafos mas pequeños, debido a que si no, el tiempo de ejecucion es infinito
 */

    public static void resolucion(boolean[] solucion, List<Tupla> listado, Instancia instancia, int etapa, int numeroNodos) {

        int intento= 1;
        while (intento>=0){
            //comprobamos que sea factible
            //es factible si sigue la solucion es TRUE
            if (esFactible(solucion, listado, instancia, etapa, numeroNodos, intento)){
                //restauramos el grafo
                instancia.restablecerGrafo();
                //marcamos
                if (intento==0){
                    solucion[etapa]=false;
                }

                if (etapa==instancia.getNumeroNodos()-1){
                    Set<Integer> posibleSolucion= new HashSet<>();
                    for (int i = 0; i < instancia.getNumeroNodos(); i++) {
                        if (solucion[i]){
                            posibleSolucion.add(i);
                        }
                    }
                    System.out.println("posible solucion: "+posibleSolucion);
                }else {
                    resolucion(solucion, listado, instancia, etapa+1, numeroNodos);
                }
                //desmarcamos
                if (intento==0){
                    solucion[etapa]=true;
                }
            }
            intento--;
        }
    }

    private static boolean esFactible(boolean[] solucion, List<Tupla> listado, Instancia instancia, int etapa, int numeroNodos, int intento) {
        for (int i = 0; i < numeroNodos; i++) {
            if (solucion[i]){
                instancia.eliminarNodo(i);
            }
        }
        return ComprobarSolucion.comprobarSolcion(instancia);
    }
}
