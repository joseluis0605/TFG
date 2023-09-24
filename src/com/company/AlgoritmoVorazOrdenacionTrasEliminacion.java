package com.company;

import java.util.List;
import java.util.Set;

public class AlgoritmoVorazOrdenacionTrasEliminacion {

    public static int algoritmoVorazComplejo(Instancia instancia){

        Solucion solucion= new Solucion(); //creamos la solucion
        while (!ComprobarSolucion.comprobarSolcion(instancia)){
            List<Tupla> listado=OrdenacionGrafoVecinos.ordenarMasMenosGrafo(instancia);
            int nextNodo= listado.get(0).getNodo();
            if (!solucion.existElement(nextNodo)){
                solucion.addNodo(nextNodo);
            }
            eliminarNodo(instancia, nextNodo);
            listado.remove(0);
        }
        return solucion.size();
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
