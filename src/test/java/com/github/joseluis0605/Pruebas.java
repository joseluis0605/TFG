package com.github.joseluis0605;

import com.github.joseluis0605.TFG_CODIGO.CARGADORES.*;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoRandom;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.MejoraSolucion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.*;
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
    public void experimentoBT(){
        CargadorExperimento experimentoBT= new CargadorBT();
        experimentoBT.cargarExperimento();
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
        List<Instancia> listado= cargadorExperimento.generarListaInstancia();
       Solucion instanciaSolucion= null;
        for (Instancia instancia1: listado){
            if (instancia1.getFileName().equals("erdos_renyi_100_0.05_0.2_3.txt")){
                instanciaSolucion= new Solucion(instancia1);
            }
        }
        Constructivo constructivo= new ConstructivoRandom();
        Solucion solucion1= constructivo.construir(instanciaSolucion.getInstanciaOriginal());
        ComprobarComponentesConexas.comprobarComponentesConexas(solucion1);

        Solucion solucionMejor= MejoraSolucion.mejorarSolucion(solucion1);
        ComprobarComponentesConexas.comprobarComponentesConexas(solucionMejor);

    }

    @Test
    public void pruebaComprobarSolucion(){
        CargadorExperimento cargadorExperimento= new CargadorExperimento1();
        List<Instancia> listado= cargadorExperimento.generarListaInstancia();
        for (Instancia instancia: listado){
            Constructivo constructivo= new ConstructivoRandom();
            Solucion solucion= constructivo.construir(instancia);
            ComprobarComponentesConexas.comprobarComponentesConexas(solucion);
            Scanner input= new Scanner(System.in);
            input.nextLine();
        }
    }

    @Test
    public void pruebaComponenteConexa(){

        //lista de instancias
        List<Instancia> listaInstancias= new ArrayList<>();
        List<String> nombresFicheros= FileNameList.getFileNameList();

        for (String nombre: nombresFicheros){
            List<String> contenido= CargadorFile.leerFile(nombre);
            Instancia instancia= new Instancia(contenido, nombre);
            listaInstancias.add(instancia);
        }

        for (Instancia instancia: listaInstancias){
            //variables declaradas
            Solucion solucionActual = null;
            Solucion solucionMejor= new Solucion(instancia);
            int mejorSolucionTam=9999;
            int iteracion=0;
            int mejorIteracion=0;

            if (NumeroComponentesConexas.numeroComponentesConexas(instancia)==1){
                Constructivo constructivo= new ConstructivoRandom();

                System.out.println("**********************");
                System.out.println(instancia.getFileName());
                System.out.println("tamaño componentes conexas, maximo--> "+instancia.getTamComponenteConexa());
                System.out.println("valor alpha--> "+instancia.getAlpha());
                System.out.println("get numero nodos--> "+instancia.getNumeroNodos());


                for (int i = 0; i < 1000; i++) {
                    solucionActual = constructivo.construir(instancia);
                    ComprobarSolucion.comprobarSolucion(solucionActual);
                }
                TamanoCadaComponenteConexa.comprobarSolucion(solucionActual);
                System.out.println("numero de eliminados--> "+ solucionActual.size());
                System.out.println("eliminados: "+solucionActual.getSeparator());
            }
        }
    }

    @Test
    public void generarGrafo(){
        //lista de instancias
        List<String> nombresFicheros= FileNameList.getFileNameList();
        System.out.println(nombresFicheros);
        List<String> contenidoFile= new ArrayList<>();
        for (String nombre : nombresFicheros){
            if (nombre.contains("erdos_renyi_100_0.05_0.8_3.txt")){
                contenidoFile= CargadorFile.leerFile(nombre);
            }
        }

        if (contenidoFile!=null){
            Instancia instancia= new Instancia(contenidoFile, "erdos_renyi_100_0.05_0.8_3.txt");
            Solucion solucion= new Solucion(instancia);
            Set<Integer> listadoEliminados= new HashSet<>();

            listadoEliminados.add(1);
            listadoEliminados.add(88);
            listadoEliminados.add(78);
            listadoEliminados.add(62);
            listadoEliminados.add(84);
            listadoEliminados.add(17);
            listadoEliminados.add(65);
            listadoEliminados.add(20);
            listadoEliminados.add(58);
            listadoEliminados.add(61);
            listadoEliminados.add(56);
            listadoEliminados.add(70);
            listadoEliminados.add(10);

            for (Integer nodoEliminar : listadoEliminados){
                solucion.eliminarNodo(nodoEliminar);
            }
            solucion.setSeparator(listadoEliminados);

            System.out.println("////////////////////////////////////////////////");
            ComprobarComponentesConexas.comprobarComponentesConexas(solucion);
        }
    }
}
