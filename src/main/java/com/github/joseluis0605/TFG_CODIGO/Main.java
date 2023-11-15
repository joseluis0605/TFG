package com.github.joseluis0605.TFG_CODIGO;

import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.NumeroComponentesConexas;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> listado= FileNameList.getFileNameList();
        for (String nombre: listado){
            List<String> contenido= CargadorFile.leerFile(nombre);
            Instancia instancia= new Instancia(contenido);
            int contador= NumeroComponentesConexas.numeroComponentesConexas(instancia);
            String ruta= RutaImagenes.getRuta()+"noComponenteConexa";
            if (contador>1){
                GenDOT.writeSolutionToDisk(instancia, new Solucion(), ruta, nombre);
            }

        }
    }
}