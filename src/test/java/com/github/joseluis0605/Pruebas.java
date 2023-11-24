package com.github.joseluis0605;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import org.junit.Test;

import java.util.List;

public class Pruebas {

    @Test
    public void generarInstancia(List<String> contenido){
        Instancia instancia= new Instancia(contenido);
        instancia.mostrarInfo();
    }
}
