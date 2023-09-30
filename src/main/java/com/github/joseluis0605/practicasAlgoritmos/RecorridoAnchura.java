package com.github.joseluis0605.practicasAlgoritmos;

import java.util.*;

public class RecorridoAnchura {

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        int numeroNodos= Integer.parseInt(input.nextLine());
        int numeroAristas= Integer.parseInt(input.nextLine());

        List<Integer> grafo[]= new ArrayList[numeroNodos];
        for (int i=0;i<numeroNodos;i++){
            grafo[i]=new ArrayList<>();
        }

        for (int i=0;i<numeroAristas;i++){
            String entrada= input.nextLine();
            String vector[]= entrada.split(" ");
            int nodo= Integer.parseInt(vector[0]);
            int vecino= Integer.parseInt(vector[1]);

            grafo[nodo].add(vecino);
            grafo[vecino].add(nodo);
        }

        anchura(grafo, numeroNodos);
    }

    private static void anchura(List<Integer>[] grafo, int numeroNodos) {
        Set<Integer> visitado= new HashSet<>();
        for (int i=0;i<numeroNodos;i++){
            if (!visitado.contains(i)){
                recorrido(grafo,visitado,i);
            }
        }
    }

    private static void recorrido(List<Integer>[] grafo, Set<Integer> visitado, int nodo) {
        Queue<Integer> cola= new ArrayDeque<>();
        System.out.println(nodo);
        cola.add(nodo);
        visitado.add(nodo);
        while (!cola.isEmpty()){
            int nodoHijo= cola.poll();
            for (Integer numero : grafo[nodoHijo]){
                if (!visitado.contains(numero)){
                    cola.add(numero);
                    visitado.add(numero);
                    System.out.println(numero);
                }

            }
        }
    }
}
