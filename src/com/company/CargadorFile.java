package com.company;

import java.io.File;
import java.util.Scanner;

public class CargadorFile {

    private String path;

    public CargadorFile(String nombre){
        String ruta="C:\\Users\\USUARIO\\Desktop\\URJC\\4º Ciberseguridad\\TFG\\AlphaSeparatorProblem\\src\\com\\company\\pruebasFiles\\"+nombre;
        this.path=ruta;
    }

    public void leerFile(){
        Scanner entrada= null;
        File fichero= new File(this.path);
        try {
            entrada= new Scanner(fichero);
            while (entrada.hasNextLine()){
                String frase = entrada.nextLine();
                System.out.println(frase);
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }finally {
            try {
                if (entrada!=null) {
                    entrada.close();
                }
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
            }

    }
}
