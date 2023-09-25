package com.company;

import java.util.Scanner;

public class Experimento {

/*
    En esta clase vamos a realizar los experimentos, es decir, va a ser donde se llame a la ejecucion de los algoritmos
 */

    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        //mostramos las opciones
        Menu.mostrarMenu();

        //introducion del algoritmo que queremos ejecutar
        int opcion= input.nextInt();


        switch (opcion){
            case 1: //algoritmo random
                CargadorExperimentoRandom.cargadorRandom();
            break;

            case 2: //algoritmo voraz simple
                CargadorExperimentoVorazSimple.cargarVorazSimple();
            break;

            case 3: //algoritmo voraz con ordenacion en cada iteracion
                CargadorExperimentoVorazOrdenacion.cargarVorazOrdenacion();
            break;

            default:
                System.out.println("error al introducir el id del algoritmo");

        }

    }
}
