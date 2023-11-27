package com.github.joseluis0605;

import com.github.joseluis0605.TFG_CODIGO.CARGADORES.*;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class Pruebas {

    @Test
    public void BT(){
        CargadorBT cargadorBT= new CargadorBT();
        cargadorBT.cargarExperimento();
    }

    @Test
    public void generarListaInstancias(){
        CargadorExperimento1 cargadorExperimento1= new CargadorExperimento1();
        List<Instancia> listado= cargadorExperimento1.generarListaInstancia();
        for (Instancia instancia: listado){
            instancia.mostrarInfo();
            System.out.println("///////////////////////////////");
        }
    }

    @Test
    public void pruebaMejora(){
        CargadorExperimento cargadorExperimento= new CargadorExperimento1();
        Instancia instancia1= cargadorExperimento.generarListaInstancia().get(0);

        Solucion solucion= new Solucion(instancia1);
        solucion.eliminarNodo(4);
        solucion.eliminarNodo(6);
        solucion.eliminarNodo(7);

        Set<Integer> conjunto= Set.of(4,6,7);
        solucion.setSeparator(conjunto);

        Solucion mejora= MejoraSolucion.mejorarSolucion(solucion);
        System.out.println(mejora.getSeparator());
    }

    @Test
    public void experimentoRandom(){
        CargadorExperimento cargadorExperimento= new CargadorExperimento1();
        cargadorExperimento.cargarExperimento();
    }

    @Test
    public void experimentoVoraz(){
        CargadorExperimento cargadorExperimento= new CargadorExperimento2();
        cargadorExperimento.cargarExperimento();
    }

    @Test
    public void experimentoVorazOrdenacion(){
        CargadorExperimento cargadorExperimento= new CargadorExperimento3();
        cargadorExperimento.cargarExperimento();
    }

}
