package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.NumeroComponentesConexas;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class CargadorDetectorGrafosMasComponentesConexas {
/*
Vamos a generar imagenes de los grafos que no son componentes conexas, por lo tanto, no validos para hacer experimentos
 */

    public static void detectorComponentesConexas(){
        List<String> listadoFicheros= FileNameList.getFileNameList();

        for (String nombreFichero : listadoFicheros){
            List<String> contenido = CargadorFile.leerFile(nombreFichero);
            Instancia instancia= new Instancia(contenido);
            if (NumeroComponentesConexas.numeroComponentesConexas(instancia)>1){
                String ruta= RutaImagenes.getRuta()+"noComponenteConexa";
                GenDOT.writeSolutionToDisk(instancia, new Solucion(), ruta, nombreFichero);
            }
        }
    }
}
