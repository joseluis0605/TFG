package com.github.joseluis0605.practicasAlgoritmos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeteccionComponentesConexas {

    // primero eliminamos nodo
    // contamos las componentes conexas
    // reponemos el grafo

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        int numeroNodos= Integer.parseInt(input.nextLine());
        int numeroAristas= Integer.parseInt(input.nextLine());

        Set<Integer> grafo[]= new Set[numeroNodos];
        for (int i=0;i<numeroNodos;i++){
            grafo[i]=new HashSet<>();
        }

        for (int i=0;i<numeroAristas;i++){
            String entrada= input.nextLine();;
            String vector[]= entrada.split(" ");

            int nodo= Integer.parseInt(vector[0]);
            int vecino= Integer.parseInt(vector[1]);

            grafo[nodo].add(vecino);
            grafo[vecino].add(nodo);
        }
        for (int i = 0; i < numeroNodos; i++) {
            int contador;
            Set<Integer> copia[]= copiarGrafo(grafo, numeroNodos);
            Set<Integer>[] eliminado= eliminarNodo(copia, numeroNodos, i);

            contador= numeroComponentesConexas(eliminado, numeroNodos);
            if (contador>2){
                System.out.println("el nodo "+i+" es critico");
            }
        }

    }

    public static Set<Integer>[] eliminarNodo(Set<Integer>[] copia, int numeroNodos, int i) {
        for (int j = 0; j < numeroNodos; j++) {
            if (copia[j].contains(i)) {
                copia[j].remove(i);
            }
        }
        copia[i].clear();
        return copia;
    }

    private static Set<Integer>[] copiarGrafo(Set<Integer>[] grafo, int numeroNodos) {
        Set<Integer> copia[]= new Set[numeroNodos];
        for (int i = 0; i < numeroNodos; i++) {
            copia[i]= new HashSet<>(grafo[i]);

        }
        return copia;
    }

    private static int numeroComponentesConexas(Set<Integer>[] grafo, int numeroNodos) {
        Set<Integer> visitado= new HashSet<>();
        int contador=0;
        for (int i = 0; i < numeroNodos; i++) {
            if (!visitado.contains(i)){
                recorrido(grafo,i,visitado);
                contador++;
            }
        }
        return contador;
    }

    private static void recorrido(Set<Integer>[] grafo, int nodo, Set<Integer> visitado) {
        visitado.add(nodo);
        //imprimir nodo
        for (Integer nodoHijo: grafo[nodo]) {
            if (!visitado.contains(nodoHijo)){
                recorrido(grafo,nodoHijo,visitado);
            }
        }

    }

}
/*
6
5
0 1
1 2
2 3
3 4
4 5
 */