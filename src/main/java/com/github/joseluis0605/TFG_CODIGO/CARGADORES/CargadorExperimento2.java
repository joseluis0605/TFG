package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoVoraz;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CargadorExperimento2 extends CargadorExperimento {

/*
Nuestro experimento 2 va a consistir en ejecutar 1 vez cada fichero para obtener la solucion
Algoritmo usar: algortimo voraz
tiempo: tiempo que tarda cada ejecucion del algoritmo
 */

    public void resolucion(){
        List<String> listadoNombreFichero = new ArrayList<>(FileNameList.getFileNameList());

        for (String nombreFichero : listadoNombreFichero){
            //comprobamos que es una unica componente conexa
            List<String> informacionGrafo= CargadorFile.leerFile(nombreFichero);
            Instancia comprobadora= new Instancia(informacionGrafo);

            if (super.esComponenteConexa(comprobadora)){
                double tiempoTotal;
                List <String> contenido= CargadorFile.leerFile(nombreFichero);
                if (contenido!=null){
                    Instancia instancia= new Instancia(contenido);

                    long inicio= super.getTime();
                    Solucion solucion = ConstructivoVoraz.algoritmoVorazSimple(instancia);
                    long fin= super.getTime();

                    tiempoTotal= super.tiempoEjecucion(inicio,fin);
                    //aplicamos mejora
                    Set<Integer> mejora= MejoraSolucion.mejorarSolucion(solucion, instancia);
                    int tamMejora= mejora.size();

                    // generamos imagenes y csv
                    escribirCSV_Mejora(nombreFichero, 1, solucion.size(), tiempoTotal, tamMejora);
                    generarImagen(instancia, solucion ,nombreFichero);
                }
            }
        }
    }
    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion, int tamMejora) {
        String informacion = "Voraz" + ";" + nombreFichero + ";" + iteracion + ";" + solucion + ";" + numberToCSV(tiempoEjecucion)+";"+tamMejora;
        EscrituraCSV.addCSV(informacion, "experimento2.csv");
    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {}

    @Override
    protected void generarImagen(Instancia instanciaPuntero, Solucion mejorSolucionArray, String nombreFichero) {
        String ruta= RutaImagenes.getRuta()+"experimento2";
        GenDOT.writeSolutionToDisk(instanciaPuntero, mejorSolucionArray, ruta, nombreFichero);
    }
}