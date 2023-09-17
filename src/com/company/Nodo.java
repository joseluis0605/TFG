package com.company;

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













    public static void main(String[] args) {
        System.out.println("dime numero de nodos");
        Scanner input= new Scanner(System.in);

        String entrada= input.nextLine();
        int numeroNodos= Integer.parseInt(entrada);

        Nodo grafo[]= new Nodo[numeroNodos]; //array de nodos

        for (int i=0;i<numeroNodos;i++){
            Nodo nodo=new Nodo(i);
            grafo[i]=nodo;
        }


        for (int i=0;i<numeroNodos;i++){
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


