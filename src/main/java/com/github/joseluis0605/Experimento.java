package com.github.joseluis0605;

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
        double tiempoStartPrograma= System.nanoTime();

        switch (opcion){
            case 1: //algoritmo random
                CargadorExperimentoRandom cargadorExperimentoRandom= new CargadorExperimentoRandom();
                cargadorExperimentoRandom.cargadorRandom();
            break;

            case 2: //algoritmo voraz simple
                CargadorExperimentoVorazSimple cargadorExperimentoVoraz= new CargadorExperimentoVorazSimple();
                cargadorExperimentoVoraz.cargadorVoraz();
            break;

            case 3: //algoritmo voraz con ordenacion en cada iteracion
                CargadorExperimentoVorazOrdenacion cargadorExperimentoVorazOrdenacion= new CargadorExperimentoVorazOrdenacion();
                cargadorExperimentoVorazOrdenacion.cargadorVoraz();
            break;

            default:
                System.out.println("error al introducir el id del algoritmo");

        }
        double tiempoEndPrograma= System.nanoTime();
        System.out.println("tiempo ejecucion total--> "+ (tiempoEndPrograma-tiempoStartPrograma));

    }
}
