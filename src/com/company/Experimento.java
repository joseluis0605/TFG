package com.company;

import java.util.List;

public class Experimento {

/*
    En esta clase vamos a realizar los experimentos, es decir, va a ser donde se llame a la ejecucion de los algoritmos
 */

    public static void main(String[] args) {

        List<String> listado= FileNameList.getFileNameList();
        System.out.println(listado.size());
    }
}
