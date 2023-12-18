package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaTiempos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TiemposMaximos {

    private Map<String, Double> mapaTiemposMaximo;

    public TiemposMaximos (){
        this.mapaTiemposMaximo= new HashMap<>();
        leerTiemposMaximos();
    }

    private void leerTiemposMaximos(){
        Scanner entrada= null; // puntero tipo Scanner apuntando a null (inicializar)
        String ruta= RutaTiempos.getTiemposMaximos()+"tiemposSergio.txt";
        File fichero= new File(ruta); //abrimos el fichero cuya ruta esta en path
        try {
            entrada= new Scanner(fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (entrada.hasNextLine()){ //mientras el fichero no termine
            String frase = entrada.nextLine(); //recogemos la frase completa
            String [] array= frase.split(" ");
            String fileName= array[0];
            String valor= array[1];
            Double tiempoSegundos = Double.parseDouble(valor);

            this.mapaTiemposMaximo.put(fileName, tiempoSegundos);
        }
    }

    public Map<String, Double> getMapaTiemposMaximo() {
        return mapaTiemposMaximo;
    }

    public Double getDoubleTiempoMaximo (String filename){
        return this.mapaTiemposMaximo.get(filename);
    }
}
