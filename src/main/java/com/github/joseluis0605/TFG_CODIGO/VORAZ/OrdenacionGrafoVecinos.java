package com.github.joseluis0605.TFG_CODIGO.VORAZ;

import com.github.joseluis0605.TFG_CODIGO.ComparadorNumeroAristas;
import com.github.joseluis0605.TFG_CODIGO.Instancia;
import com.github.joseluis0605.TFG_CODIGO.Tupla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacionGrafoVecinos {

    /*
    en esta clase se va a ordenar el grafo por aristas, es decir, como un voraz
    de mas aristas que lleguen a un nodo a menos aristas
     */

    public static List<Tupla> ordenarMasMenosGrafo(Instancia instancia){

        List<Tupla> listado= new ArrayList<>();

        for (int i = 0; i < instancia.getNumeroNodos(); i++) {
            int tam= instancia.getGrafoCopia()[i].size();
            Tupla tupla= new Tupla(i, tam);
            listado.add(tupla);
        }

        Collections.sort(listado, new ComparadorNumeroAristas());
        //System.out.println(listado);
        return listado;
    }


}
