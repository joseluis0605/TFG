package com.github.joseluis0605.PRUEBAS_INICIALES.practicasAlgoritmos;

import java.util.*;

public class RecorridoProfundidad {

    public static void main(String[] args) {
        // write your code here
        long tiempoInicio= System.nanoTime();

        Scanner input= new Scanner(System.in);
        int numeroNodos= Integer.parseInt(input.nextLine());
        int numeroAristas= Integer.parseInt(input.nextLine());

        List<Integer> grafo[]=new ArrayList[numeroNodos]; //creamos un array de listas
        for (int i=0;i<numeroNodos;i++){
            grafo[i]= new ArrayList<>();
        }

        for (int i=0;i<numeroAristas;i++){
            String entrada= input.nextLine();
            String array []= entrada.split(" ");

            int nodo= Integer.parseInt(array[0]);
            int vecino= Integer.parseInt(array[1]);

            grafo[nodo].add(vecino);
            grafo[vecino].add(nodo);
        }
        RecorridoProfundidad.profundidad(grafo, numeroNodos);

        long tiempoFin= System.nanoTime();
        long resultado= tiempoFin-tiempoInicio;

        System.out.println("el resultado es: "+resultado);
    }
    public static void profundidad(List<Integer> grafo[], int numeroNodos){
        Set<Integer> visitado= new HashSet<>();
        for (int i=0;i<numeroNodos;i++){
            if (!visitado.contains(i)){
                recorrido(grafo, visitado, i);
            }
        }
    }

    private static void recorrido(List<Integer>[] grafo, Set<Integer> visitado, int nodo) {
        visitado.add(nodo);
        System.out.println(nodo);
        for (Integer adyacente : grafo[nodo]){
            if (!visitado.contains(adyacente)){
                recorrido(grafo, visitado, adyacente);
            }
        }
    }
}
/*
10
5
0 1
1 5
2 4
4 9
3 9
 */
