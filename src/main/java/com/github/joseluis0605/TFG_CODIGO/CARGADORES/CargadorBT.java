package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.BT;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ContadorSoluciones;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Tupla;

import java.util.ArrayList;
import java.util.List;

public class CargadorBT extends CargadorExperimento{

    public void cargarExperimento(){
        List<Instancia> listadoInstancias= generarListaInstanciaBT();
        for (Instancia instancia: listadoInstancias){
            //nuestra lista va a ser de tuplas, donde tengamos el numero de nodos y sus aristas
            List<Tupla> listado= new ArrayList<>();
            for (int i = 0; i < instancia.getNumeroNodos(); i++) {
                int nodo= i;
                int numeroAristas= instancia.getGrafo()[i].size();
                Tupla tupla= new Tupla(nodo, numeroAristas);
                listado.add(tupla);
            }

            //la solucion es un array de n posicion de tipo booleano, es true para que podamos ir eliminando los nodos extra
            boolean solucion[]= new boolean[instancia.getNumeroNodos()];
            for (int i = 0; i < instancia.getNumeroNodos(); i++) {
                solucion[i]=true;
            }

            String ruta= RutaImagenes.getRuta()+"BT_grafoPequeño";
            GenDOT.writeSolutionToDisk(new Solucion(instancia), ruta, instancia.getFileName());

            int etapa=0;
            ContadorSoluciones contadorSoluciones= new ContadorSoluciones();
            Solucion solucionGrafo= new Solucion(instancia);

            //medimos el tiempo
            long inicio = System.nanoTime();
            BT.resolucion(solucion, listado, solucionGrafo,etapa, instancia.getNumeroNodos(), contadorSoluciones);
            double tiempoTotal= (System.nanoTime()- inicio)/1e9d;

            //escribimos en su .csv
            String informacion = instancia.getFileName()+" ; "+contadorSoluciones.getContador()+" ; "+tiempoTotal;
            EscrituraCSV.addCSV(informacion, "experimento6_BT.csv");

        }
    }

    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion,  int mejora, Number tiempoTotal) {

    }

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {

    }

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {

    }

    @Override
    protected void generarImagenMejorada(Solucion mejorSolucionArray, String nombreFichero) {}
}
