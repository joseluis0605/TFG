package com.github.joseluis0605.TFG_CODIGO;

import java.io.FileWriter;

public class EscrituraCSV {

    /*
    esta clase va a ser la encargada de generar el fichero csv, el cual exportaremos a excel despues
     */

    public static void addCSV(String prueba, String fileName){
        String ruta= "C:\\Users\\USUARIO\\Desktop\\URJC\\4º Ciberseguridad\\TFG\\AlphaSeparatorProblem\\archivosCSV\\"+fileName;

        try{
            FileWriter escritura= new FileWriter(ruta, true);
            escritura.append(prueba);
            escritura.append("\n");
            escritura.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
