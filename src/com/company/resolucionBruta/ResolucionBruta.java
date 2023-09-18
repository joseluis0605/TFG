package com.company.resolucionBruta;
import java.util.*;

public class ResolucionBruta {

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        //numero nodos
        int numeroNodos = Integer.parseInt(input.nextLine());
        int numeroAristas = Integer.parseInt(input.nextLine());

        //creamos  el grafo
        Set<Integer> grafo[]= new Set[numeroNodos];
        for (int i = 0; i < numeroNodos; i++) {
            grafo[i]= new HashSet<>();
        }

        //introducimos datos
        for (int i = 0; i < numeroAristas; i++) {
            String linea= input.nextLine();
            String array[]= linea.split(" ");
            int nodo = Integer.parseInt(array[0]);
            int vecino = Integer.parseInt(array[1]);

            grafo[nodo].add(vecino);
            grafo[vecino].add(nodo);
        }

        ResolucionBruta.resolucionProblema(grafo, numeroNodos, 3);

    }

    public static void resolucionProblema(Set<Integer> grafo[], int numeroNodos, int tamComponenteConexa){

        //generamos solucion --> set
        Set<Integer> solucion= new HashSet<>();

        Set<Integer> copiaGrafo[]= copiarGrafo(grafo, numeroNodos);


        while (!encontradaSolcuion(copiaGrafo, numeroNodos, tamComponenteConexa)){
            Random random= new Random();
            int nodoRandom= random.nextInt(numeroNodos);
            copiaGrafo= eliminarNodo(copiaGrafo, nodoRandom, numeroNodos);
            solucion.add(nodoRandom);
        }

        System.out.println(solucion);
        
    }

    ///////////COPIA DE NODOS
    private static Set<Integer>[] copiarGrafo(Set<Integer>[] grafo, int numeroNodos) {
        Set<Integer> copia[]= new Set[numeroNodos];
        for (int i = 0; i < numeroNodos; i++) {
            copia[i]= new HashSet<>(grafo[i]);

        }
        return copia;
    }



    /////////// COMPROBAR QUE TODAS LAS COMPONENTES CONEXAS TENGAN MAXIMO N NODOS
     public static boolean encontradaSolcuion(Set<Integer>[] grafo, int numeroNodos, int tamComponenteConexa) {
        Set<Integer> visitado= new HashSet<>();
        int contador;
        for (int i = 0; i < numeroNodos; i++) {
            if (!visitado.contains(i)){
                contador= recorrido(grafo, visitado, i);
                if (contador>tamComponenteConexa){
                    return false;
                }
            }
        }
        return true;
    }
    private static int recorrido(Set<Integer>[] grafo, Set<Integer> visitado, int nodo) {
        visitado.add(nodo);
        int contador = 1;
        for (Integer arista: grafo[nodo]) {
            if (!visitado.contains(arista)){
                contador= contador + recorrido(grafo, visitado, arista);
            }
        }
        return contador;
    }



    /////////// ELIMINAR NODO RANDOM DADO
    private static Set<Integer>[] eliminarNodo(Set<Integer>[] grafo, int nodoRandom, int numeroNodos) {
        for (Set<Integer> aristas: grafo) {
            if (aristas.contains(nodoRandom)){
                aristas.remove(nodoRandom);
            }
        }
        grafo[nodoRandom].clear();
        return grafo;
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