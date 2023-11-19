package com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS;

public class ContadorSoluciones {

    private int contador;

    public ContadorSoluciones(){
        this.contador=0;
    }

    public void aumentarUnidad(){
        setContador(getContador()+1);
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return contador;
    }
}
