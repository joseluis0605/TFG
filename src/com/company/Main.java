package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*
        CargadorFile cargar= new CargadorFile("prueba1.txt" );
        cargar.leerFile();
        */

        // CREAR LISTAS DE LISTAS ---> OPCION 1
        List<Integer>aristas= new ArrayList<>();
        aristas.add(1);
        aristas.add(2);
        aristas.add(3);
        List<Integer>aristas2= new ArrayList<>();
        aristas2.add(5);
        aristas2.add(6);
        aristas2.add(7);

        List<List<Integer>> miLista= new ArrayList<>();
        miLista.add(aristas);
        miLista.add(aristas2);

        List<Integer> lista2= null;
        lista2= miLista.get(1);
        System.out.println(lista2);

        miLista.get(0).add(56);
        System.out.println(miLista);

        //CREAR MAPA ---> OPCION 2
    }
}
