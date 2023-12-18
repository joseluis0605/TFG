package com.github.joseluis0605;

import com.github.joseluis0605.TFG_CODIGO.CARGADORES.*;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Pruebas {

    @Test
    public void experimento1(){
        CargadorExperimento experimento1= new CargadorExperimento1();
        experimento1.cargarExperimento();
    }

    @Test
    public void experimento2(){
        CargadorExperimento experimento2= new CargadorExperimento2();
        experimento2.cargarExperimento();
    }

    @Test
    public void experimento3(){
        CargadorExperimento experimento3= new CargadorExperimento3();
        experimento3.cargarExperimento();
    }

    @Test
    public void experimento4(){
        CargadorExperimento experimento4= new CargadorExperimento4();
        experimento4.cargarExperimento();
    }

    @Test
    public void experimento5(){
        CargadorExperimento experimento5= new CargadorExperimento5();
        experimento5.cargarExperimento();
    }

    @Test
    public void comprobarComponentes() throws FileNotFoundException {

        List<String> listadoNoComponentesConexas= new ArrayList<>();
        listadoNoComponentesConexas.add("erdos_renyi_100_0.05_0.2_0.txt");
        listadoNoComponentesConexas.add("erdos_renyi_100_0.05_0.2_2.txt");
        listadoNoComponentesConexas.add("erdos_renyi_100_0.05_0.5_0.txt");
        listadoNoComponentesConexas.add("erdos_renyi_100_0.06_0.8_4.txt");

        String ruta= "instanciasExperimentoSergio.txt";
        Scanner entrada= null; // puntero tipo Scanner apuntando a null (inicializar)
        File fichero= new File(ruta); //abrimos el fichero cuya ruta esta en path
        entrada= new Scanner(fichero);
        List<String> listadoAristas= new ArrayList<>();
        while (entrada.hasNextLine()){ //mientras el fichero no termine
            String frase = entrada.nextLine(); //recogemos la frase completa
            listadoAristas.add(frase);
        }

        System.out.println("listado de sergio");
        for (String nombre: listadoAristas){
            if (listadoNoComponentesConexas.contains(nombre)){
                System.out.println("esta-->"+nombre);
            }
        }
    }

    @Test
    public void comprobarContrario(){
        List<String> listadoFicheros= FileNameList.getFileNameList();
        String ruta= "instanciasExperimentoSergio.txt";
        Scanner entrada= null; // puntero tipo Scanner apuntando a null (inicializar)
        File fichero= new File(ruta); //abrimos el fichero cuya ruta esta en path
        try {
            entrada= new Scanner(fichero);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> listadoAristas= new ArrayList<>();
        while (entrada.hasNextLine()){ //mientras el fichero no termine
            String frase = entrada.nextLine(); //recogemos la frase completa
            listadoAristas.add(frase);
        }
        System.out.println("tam sergio: "+listadoAristas.size());

        for (String nombre: listadoFicheros){
            if (!listadoAristas.contains(nombre)){
                System.out.println("no contiene-->"+nombre);
            }
        }
        System.out.println("tam-->"+listadoFicheros.size());
    }

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
