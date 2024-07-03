package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.HashSet;
import java.util.Set;

public class ComprobarComponentesConexas {

    public static void comprobarComponentesConexas(Solucion solucion){

        System.out.println("/////////////// INFORMACION SOLUCION "+ solucion.getInstanciaOriginal().getFileName()+ "///////////");
        System.out.println("numero de nodos ----> "+solucion.getInstanciaOriginal().getNumeroNodos());
        System.out.println("tamaño maximo por componente ----> "+solucion.getInstanciaOriginal().getTamComponenteConexa());
        System.out.println("Nodos eliminados---> "+solucion.getSeparator());
        System.out.println("tamaño solucion--> "+solucion.getSeparator().size());


        Set<Integer> visitados= new HashSet<>();
        visitados.addAll(solucion.getSeparator());

        for (int i = 0; i < solucion.getInstanciaOriginal().getNumeroNodos(); i++) {
            Set<Integer> nuevosIntegrantes= new HashSet<>();
            if (!visitados.contains(i)){
                recorrido(solucion, visitados, nuevosIntegrantes, i);
                System.out.println("tamaño componente ---> "+nuevosIntegrantes.size()+" contenido---> "+nuevosIntegrantes);
            }
        }
    }

    private static void recorrido(Solucion solucion, Set<Integer> visitados, Set<Integer> nuevosIntegrantes, int nodo) {
        visitados.add(nodo);
        nuevosIntegrantes.add(nodo);
        for (Integer nodoHijo: solucion.getGrafoResuelto()[nodo]) {
            if (!visitados.contains(nodoHijo)){
                recorrido(solucion,visitados,nuevosIntegrantes, nodoHijo);
            }
        }
    }
}
