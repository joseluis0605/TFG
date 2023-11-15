package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.*;

import java.util.List;
import java.util.Set;

public class ConstructivoVoraz {

    public static Solucion algoritmoVorazSimple(Instancia instancia){
        List<Tupla> listado= OrdenacionGrafoVecinos.ordenarMasMenosGrafo(instancia);
        Solucion solucion= new Solucion(); //creamos la solucion
        while (!ComprobarSolucion.comprobarSolcion(instancia)){
            int nextNodo= listado.get(0).getNodo();
            if (!solucion.existElement(nextNodo)){
                solucion.addNodo(nextNodo);
            }
            eliminarNodo(instancia, nextNodo);
            listado.remove(0);
        }
        return solucion;
    }

    private static void eliminarNodo(Instancia instancia, int nodoEliminado) {
        for (Set<Integer> aristas: instancia.getGrafoCopia()) {
            if (aristas.contains(nodoEliminado)){
                aristas.remove(nodoEliminado);
            }
        }
        instancia.getGrafoCopia()[nodoEliminado].clear();
    }
}
