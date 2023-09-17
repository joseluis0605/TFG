package com.company.practicasAlgoritmos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TamañoComponenteConexa {
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

        tamComponenteConexa(grafo, numeroNodos);
    }

    private static void tamComponenteConexa(Set<Integer>[] grafo, int numeroNodos) {
        Set<Integer> visitado= new HashSet<>();
        int contador;
        for (int i = 0; i < numeroNodos; i++) {
            if (!visitado.contains(i)){
                contador= recorrido(grafo,i,visitado);
                System.out.println(contador);
            }
        }
    }

    private static int recorrido(Set<Integer>[] grafo, int nodo, Set<Integer> visitado) {
        int contador=1;
        visitado.add(nodo);
        //imprimir nodo
        for (Integer nodoHijo: grafo[nodo]) {
            if (!visitado.contains(nodoHijo)){
                contador= contador+ recorrido(grafo,nodoHijo,visitado);
            }
        }

        return contador;
    }
}
