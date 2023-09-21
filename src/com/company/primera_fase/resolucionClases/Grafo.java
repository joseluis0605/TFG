package com.company.primera_fase.resolucionClases;

import java.util.*;

public class Grafo {

    private Nodo grafo[];
    private Nodo grafoResultante[]; //con este nos quitamos hacer una copia del grafo
    private int numeroNodos;
    private double valorAlpha;
    private double maxNodosComponente;

    public Grafo(){
        Scanner input= new Scanner(System.in);
        String primeraLinea= input.nextLine();
        String vectorPrimeraLinea[]= primeraLinea.split(" ");
        int numeroNodos= Integer.parseInt(vectorPrimeraLinea[0]);
        int numeroAristas= Integer.parseInt(vectorPrimeraLinea[1]);
        double alpha= Double.parseDouble(vectorPrimeraLinea[2]);
        this.numeroNodos= numeroNodos;
        this.valorAlpha= alpha;

        this.grafo= new Nodo[numeroNodos]; //todos apuntan a null
        this.grafoResultante= new Nodo[numeroNodos];
        for (int i = 0; i < numeroNodos; i++) {
            this.grafo[i]= new Nodo();
            this.grafoResultante[i]= new Nodo();
        }


        for (int i = 0; i < numeroAristas; i++) {
            String linea= input.nextLine();
            String vectorLinea[]= linea.split(" ");
            int nodo= Integer.parseInt(vectorLinea[0]);
            int vecino= Integer.parseInt(vectorLinea[1]);

            grafo[nodo].addNodo(vecino);
            grafo[vecino].addNodo(nodo);

            grafoResultante[nodo].addNodo(vecino);
            grafoResultante[vecino].addNodo(nodo);
        }

        this.maxNodosComponente= this.valorAlpha*this.numeroNodos;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////SEPARATOR PROBLEM////////////////////////////////////////////////////////
    //////////////////////////////////////////////RANDOM///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void separatorProblemRANDOM(){
        Set<Integer> solucion= new HashSet<>();
        List<Integer> solucionSinOrdenar= new ArrayList<>();

        while (!encontradaSolcuion()){
            //elegimos nodo random
            Random nodoRandom = new Random();
            int numeroRandom= nodoRandom.nextInt(this.numeroNodos);

            //eliminamos nodo
            eliminamosNodo(numeroRandom);

            //añadimos a la solucion
            solucion.add(numeroRandom);
            if (!solucionSinOrdenar.contains(numeroRandom)){
                solucionSinOrdenar.add(numeroRandom);
            }

        }
        System.out.println("nodos--> "+numeroNodos);
        System.out.println("alpha--> "+this.valorAlpha);
        System.out.println("max por componente--> "+this.maxNodosComponente);
        System.out.println(solucion);
        System.out.println(solucionSinOrdenar);
        System.out.println(solucionSinOrdenar.size());
    }

    private void eliminamosNodo(int numeroRandom) {
        for (int i = 0; i < this.numeroNodos; i++) {
            grafoResultante[i].deleteNodo(numeroRandom);
        }

        grafoResultante[numeroRandom].destruir();
    }


    private boolean encontradaSolcuion(){
        Set<Integer> visitado= new HashSet<>();
        int contador;
        for (int i = 0; i < numeroNodos; i++) {
            if ((!visitado.contains(i))){
                contador= recorrido(visitado,i);
                if (contador>this.maxNodosComponente){
                    return false;
                }
            }
        }
        return true;
    }

    private int recorrido(Set<Integer> visitado,int nodo){
        visitado.add(nodo);
        int contador=1;
        for (Integer nodoHijo: this.grafoResultante[nodo].getAristas()){
            if (!visitado.contains(nodoHijo)){
                contador= contador+ recorrido(visitado, nodoHijo);
            }
        }
        return contador;
    }


}
