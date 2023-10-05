package com.github.joseluis0605.TFG_CODIGO;

import java.util.Comparator;

public class ComparadorNumeroAristas implements Comparator<Tupla> {
    @Override
    public int compare(Tupla o1, Tupla o2) {
        if (o1.getNumeroAristas()< o2.getNumeroAristas()){
            return 1;
        }else if (o1.getNumeroAristas()==(o2.getNumeroAristas())){
            return 0;
        } else {
            return -1;
        }
    }
}
