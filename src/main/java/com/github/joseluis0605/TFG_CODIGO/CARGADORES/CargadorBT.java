package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.BT;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ContadorSoluciones;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.CargadorFile;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.FileNameList;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.RutaImagenes;
import com.github.joseluis0605.TFG_CODIGO.GENERADORES.GenDOT;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Tupla;

import java.util.ArrayList;
import java.util.List;

public class CargadorBT {

    public void resolucion(){
        String primero= FileNameList.getFileNameList().get(0);
        List<String> contenido= CargadorFile.leerFile(primero);

        //creamos la instancia
        Instancia instancia= new Instancia(contenido);

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
        GenDOT.writeSolutionToDisk(instancia, new Solucion(), ruta, primero);

        int etapa=0;
        ContadorSoluciones contadorSoluciones= new ContadorSoluciones();
        BT.resolucion(solucion, listado, instancia,etapa, instancia.getNumeroNodos(), contadorSoluciones);
        System.out.println("soluciones generadas: "+contadorSoluciones.getContador());

    }
}
