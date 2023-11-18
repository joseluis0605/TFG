package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.ComprobarSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.HashSet;
import java.util.Set;

public class MejoraSolucion {
/*
Vamos a recibir una solucion de una instancia y vamos a intentar mejorarlo, eliminando las distintas soluciones
 */

    public static Set<Integer> mejorarSolucion (Solucion solucion, Instancia instancia){

        //copiamos Solucion forma manual
        Set<Integer> solucionCopia= new HashSet<>();
        solucionCopia.addAll(solucion.getSolucion());

        for (Integer nodoCandidato : solucion.getSolucion()){
            instancia.restablecerGrafo();
            //eliminamos el nodo
            solucionCopia.remove(nodoCandidato);
            //eliminamos del grafo, el resto de nodos, menos el seleccionado
            for (Integer nodoEliminar : solucionCopia){
                instancia.eliminarNodo(nodoEliminar);
            }
            //si no es factible, es decir, si es un nodo imprescindible
            if (!ComprobarSolucion.comprobarSolcion(instancia)){
                solucionCopia.add(nodoCandidato);
            }
        }
        return solucionCopia;
    }
}
