package com.github.joseluis0605.TFG_CODIGO.FICHEROS;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargadorFile {

    public static List<String> leerFile(String nombre){
        String ruta=RutaInstancias.getRuta()+nombre;
        Scanner entrada= null; // puntero tipo Scanner apuntando a null (inicializar)
        File fichero= new File(ruta); //abrimos el fichero cuya ruta esta en path
        try {
            entrada= new Scanner(fichero);
            List<String> listadoAristas= new ArrayList<>();
            while (entrada.hasNextLine()){ //mientras el fichero no termine
                String frase = entrada.nextLine(); //recogemos la frase completa
                listadoAristas.add(frase);
            }
            return listadoAristas;
        }catch (Exception exception){
            System.out.println(exception.getMessage()); //imprimir mensaje de error si hay fallo en el TRY
        }finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }
}
