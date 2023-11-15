package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoVoraz;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class CargadorExperimento4 extends CargadorExperimento{
/*
Nuestro experimento 4 va a consistir en ejecutar 1000 veces cada fichero para obtener cada tiempo (4 primeras instancias)
Algoritmo usar: algortimo voraz
tiempo: el tiempo de cada ejecucion
 */
    @Override
    public void resolucion() {

        for (int i = 0; i < 4; i++) {
            String nombreFichero= FileNameList.getFileNameList().get(i);
            double tiempoTotal;

            for (int j = 0; j < 1000; j++) {
                List <String> contenido= CargadorFile.leerFile(nombreFichero);
                if (contenido!=null){
                    Instancia instancia= new Instancia(contenido);

                    long inicio= super.getTime();
                    Solucion solucion = ConstructivoVoraz.algoritmoVorazSimple(instancia);
                    long fin= super.getTime();

                    tiempoTotal= super.tiempoEjecucion(inicio,fin);
                    // generamos csv
                    if (esComponenteConexa(instancia)){
                        escribirCSV(nombreFichero, j, solucion.size(), tiempoTotal);
                    }
                }
            }
        }
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {
        String informacion = "Voraz Tiempo" + ";" + nombreFichero + ";" + iteracion + ";" + solucion + ";" + numberToCSV(tiempoEjecucion);
        EscrituraCSV.addCSV(informacion, "experimento4.csv");
    }

    @Override
    protected void generarImagen(Instancia instanciaPuntero, Solucion mejorSolucionArray, String nombreFichero) {
        System.out.println("En este experimento no se genera imagen");
    }



}
