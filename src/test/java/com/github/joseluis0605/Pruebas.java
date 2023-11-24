package com.github.joseluis0605;

import com.github.joseluis0605.TFG_CODIGO.CARGADORES.CargadorBT;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Pruebas {

    @Test
    public void testMejora(){
        String nombre= FileNameList.getFileNameList().get(0);
        List<String> contenido= CargadorFile.leerFile(nombre);
        Instancia instancia= new Instancia(contenido);
        instancia.eliminarNodo(4);
        instancia.eliminarNodo(6);
        instancia.eliminarNodo(7);

        Solucion solucion= new Solucion();
        solucion.addNodo(4);
        solucion.addNodo(6);
        solucion.addNodo(7);

        Set<Integer> mejorada= MejoraSolucion.mejorarSolucion(solucion, instancia);
        Set<Integer> mejoraSolucion= Set.of(4,5);
        assert mejorada.equals(mejoraSolucion);
    }

    @Test
    public void testOrdenarListaFile(){
        List<String> listado= FileNameList.getFileNameList();
        List<String> ordenado= FileNameList.getFileNameList();
        Collections.sort(ordenado);

        assert listado.equals(ordenado);
        for (String nombre: ordenado){
            System.out.println(nombre);
        }
    }

    @Test
    public void BT_granFichero(){
        CargadorBT cargadorBT= new CargadorBT();
        cargadorBT.resolucion();
    }
}
