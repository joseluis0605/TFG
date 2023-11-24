package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.*;

import java.util.List;
import java.util.Set;

public class ConstructivoVorazOrdenacionTrasEliminacion extends Constructivo{

    public Solucion construir(Instancia instancia){
        Solucion solucion= new Solucion(instancia); //creamos la solucion
        while (!ComprobarSolucion.comprobarSolcion(solucion)){
            List<Tupla> listado= OrdenacionGrafoVecinos.ordenarMasMenosGrafo(solucion);
            int nextNodo= listado.get(0).getNodo();
            if (!solucion.existElement(nextNodo)){
                solucion.addNodo(nextNodo);
            }
            eliminarNodo(solucion, nextNodo);
            listado.remove(0);
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
