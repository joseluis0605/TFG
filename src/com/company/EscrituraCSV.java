package com.company;

import java.io.FileWriter;

public class EscrituraCSV {

    /*
    esta clase va a ser la encargada de generar el fichero csv, el cual exportaremos a excel despues
     */

    public static void addCSV(String prueba){
        String ruta= "C:\\Users\\USUARIO\\Desktop\\URJC\\4º Ciberseguridad\\TFG\\AlphaSeparatorProblem\\archivosCSV\\AlgoritmoRandom.csv";

        try{
            FileWriter escritura= new FileWriter(ruta);
            escritura.append(prueba);
            escritura.append("\n");
            escritura.close();
            System.out.println("escrito correctamente");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
