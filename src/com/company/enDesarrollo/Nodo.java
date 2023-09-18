package com.company.enDesarrollo;

import java.util.*;

public class Nodo {

    private int nodo;
    private Set<Integer> aristas;

    public Nodo(int nodo){
        this.nodo= nodo;
        this.aristas= new HashSet<>();
    }

    public void addNodo(int origen, int fin){
        this.aristas.add(fin);
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "nodo=" + nodo +
                ", aristas=" + aristas +
                '}';
    }

    public void separatorProblemRandom (Nodo [] grafo, int numeroNodos){
        Nodo grafoCopia[]= grafo;

        Random randomSeed= new Random();
        int max= numeroNodos;
        int min= 0;
        int nodoRandom= randomSeed.nextInt(max-min)+min; //incluimos min y excluimos max

        /*
        voy a tener que hacer lo siguiente

        - definimos el numero maximo que va a tener cada componente conexa
        - while hasta que todas las componentes tengan como maximo esa
            - eliminamos el nodo random
            - contamos los nodos que tiene cada componente conexa
         */
    }

    public void recorridoProfundidad(Nodo [] grafo){
        Set<Integer> visitado = new HashSet<>();
        int numeroNodos= grafo.length;
        for (int i=0;i<numeroNodos;i++){
            if (!visitado.contains(i)){
                recorrido(i, grafo, visitado);
                
            }
        }
    }

    private void recorrido(int nodo, Nodo[] grafo, Set<Integer> visitado) {
        visitado.add(nodo);
        System.out.println(nodo);


    }


    public static void main(String[] args) {
        System.out.println("dime numero de nodos");
        Scanner input= new Scanner(System.in);

        //Numero Nodos
        String entrada= input.nextLine();
        int numeroNodos= Integer.parseInt(entrada);

        //Numero Aristas
        entrada= input.nextLine();
        int numeroAristas= Integer.parseInt(entrada);


        //Creamos el grafo
        Nodo grafo[]= new Nodo[numeroNodos]; //array de nodos
        for (int i=0;i<numeroNodos;i++){
            Nodo nodo=new Nodo(i);
            grafo[i]=nodo;
        }

        //Insertamos las aristas
        for (int i=0;i<numeroAristas;i++){
            entrada= input.nextLine();
            String linea[]=entrada.split(" "); //tenemos en el array el nodo y su vecino
            int nodo= Integer.parseInt(linea[0]);
            int vecino= Integer.parseInt(linea[1]);

            grafo[nodo].addNodo(nodo,vecino);
            grafo[vecino].addNodo(vecino,nodo);

        }

        for (Nodo valor: grafo){
            System.out.println(valor);
        }
    }

}


