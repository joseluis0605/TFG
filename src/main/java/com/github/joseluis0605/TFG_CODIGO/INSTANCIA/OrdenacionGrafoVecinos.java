package com.github.joseluis0605.TFG_CODIGO.INSTANCIA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacionGrafoVecinos {

    public static List<Tupla> ordenarMasMenosGrafo(Solucion solucion){

        List<Tupla> listado= new ArrayList<>();

        for (int i = 0; i < solucion.getInstanciaOriginal().getNumeroNodos(); i++) {
            int tam= solucion.getGrafoResuelto()[i].size();
            Tupla tupla= new Tupla(i, tam);
            listado.add(tupla);
        }

        Collections.sort(listado, new ComparadorNumeroAristas());
        //System.out.println(listado);
        return listado;
    }


}
