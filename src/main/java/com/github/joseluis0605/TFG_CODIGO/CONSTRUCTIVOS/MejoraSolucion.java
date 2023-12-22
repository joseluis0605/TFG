package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.ComprobarSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.HashSet;
import java.util.Set;

public class MejoraSolucion {
/*
Vamos a recibir una solucion de una instancia y vamos a intentar mejorarlo, eliminando las distintas soluciones
 */

    public static Solucion mejorarSolucion (Solucion solucion){

        Set<Integer> nodosSolucion= new HashSet<>();
        nodosSolucion.addAll(solucion.getSeparator());

        Solucion solucionMejorada= new Solucion();
        solucionMejorada.copiarSolucion(solucion);


        for (Integer nodoCandidato : solucion.getSeparator()){
            solucionMejorada.restablecerSolucion();

            //eliminamos el nodo
            nodosSolucion.remove(nodoCandidato);

            //eliminamos del grafo, el resto de nodos, menos el seleccionado
            for (Integer nodoEliminar : nodosSolucion){
                solucionMejorada.eliminarNodo(nodoEliminar);
            }

            //si no es factible, es decir, si es un nodo imprescindible
            if (!ComprobarSolucion.comprobarSolucion(solucionMejorada)){
                nodosSolucion.add(nodoCandidato);
            }
        }
        solucionMejorada.setSeparator(nodosSolucion);
        return solucionMejorada;
    }
}
/*
//////////////////////
      EJEMPLO
//////////////////////

String nombre= FileNameList.getFileNameList().get(0);
        List<String> contenido= CargadorFile.leerFile(nombre);
        Instancia instancia= new Instancia(contenido);
        instancia.eliminarNodo(4);
        instancia.eliminarNodo(6);
        instancia.eliminarNodo(7);

        Solucion solucion= new Solucion();
        solucion.addNodo(4);
        solucion.addNodo(6);
        solucion.addNodo(7);

        Set<Integer> mejorada= MejoraSolucion.mejorarSolucion(solucion, instancia);

        System.out.println(mejorada);
 */