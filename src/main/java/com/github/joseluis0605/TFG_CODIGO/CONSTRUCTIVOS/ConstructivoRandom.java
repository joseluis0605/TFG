package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.ComprobarSolucion;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.Set;

public class ConstructivoRandom extends Constructivo{

    public Solucion construir(Instancia instancia){
        Solucion solucion= new Solucion(instancia); //creamos la solucion
        while (!ComprobarSolucion.comprobarSolucion(solucion)){
            java.util.Random random= new java.util.Random();
            int nodoRandom= random.nextInt(instancia.getNumeroNodos());
            if (!solucion.existElement(nodoRandom)){
                solucion.addNodo(nodoRandom);
            }
            eliminarNodo(solucion, nodoRandom);
        }
        return solucion;
    }

    private static void eliminarNodo(Solucion solucion, int nodoEliminado) {
        for (Set<Integer> aristas: solucion.getGrafoResuelto()) {
            if (aristas.contains(nodoEliminado)){
                aristas.remove(nodoEliminado);
            }
        }
        solucion.getGrafoResuelto()[nodoEliminado].clear();
    }
}
