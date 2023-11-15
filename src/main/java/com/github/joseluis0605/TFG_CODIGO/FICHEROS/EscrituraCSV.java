package com.github.joseluis0605.TFG_CODIGO.FICHEROS;
import java.io.FileWriter;

public class EscrituraCSV {
    public static void addCSV(String informacion, String experimento){
        String ruta= RutaCSV.getRuta()+ experimento;
        try{
            FileWriter escritura= new FileWriter(ruta, true);
            escritura.append(informacion);
            escritura.append("\n");
            escritura.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}