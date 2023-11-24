package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;

import java.util.ArrayList;
import java.util.List;

public abstract class Cargador {

    protected List<Instancia> generarListaInstancia(){
        List<Instancia> listaInstancias= new ArrayList<>();
        List<String> nombresFicheros= FileNameList.getFileNameList();

        for (String nombre: nombresFicheros){
            List<String> contenido= CargadorFile.leerFile(nombre);
            Instancia instancia= new Instancia(contenido);
            listaInstancias.add(instancia);
        }
        return listaInstancias;
    }

    public abstract void cargarExperimento();
}
