package com.github.joseluis0605.practicasAlgoritmos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumeroComponentesConexas {

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

        numeroComponentesConexas(grafo, numeroNodos);
    }

    private static void numeroComponentesConexas(Set<Integer>[] grafo, int numeroNodos) {
        Set<Integer> visitado= new HashSet<>();
        int contador=0;
        for (int i = 0; i < numeroNodos; i++) {
            if (!visitado.contains(i)){
                recorrido(grafo,i,visitado);
            }else {
                contador++;
            }
        }
        System.out.println(contador);
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
