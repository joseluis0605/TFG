package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoVoraz;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

import java.util.List;

public class CargadorExperimento4 extends CargadorExperimento{
/*
Nuestro experimento 4 va a consistir en ejecutar 1000 veces cada fichero para obtener cada tiempo (4 primeras instancias)
Algoritmo usar: algortimo voraz
tiempo: el tiempo de cada ejecucion
 */

    @Override
    public void cargarExperimento() {

        List<Instancia> listadoInstancias= generarListaInstancia();

        for (int i = 0; i < 4; i++) {
            Instancia instancia= listadoInstancias.get(i);
            TiemposMaximos tiemposMaximos= new TiemposMaximos();
            if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())!=null){
                Constructivo constructivo= new ConstructivoVoraz();
                for (int j = 0; j < 1000; j++) {
                    long inicio= System.nanoTime();
                    Solucion solucion = constructivo.construir(instancia);
                    double tiempoTotal= (System.nanoTime()-inicio)/1e9d;
                    // generamos csv
                    escribirCSV(instancia.getFileName(), j, solucion.size(), tiempoTotal);
                }
            }
        }
    }


    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion,  int mejora, Number tiempoTotal) {}

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {
        String informacion = "Voraz Tiempo" + ";" + nombreFichero + ";" + iteracion + ";" + solucion + ";" + numberToCSV(tiempoEjecucion);
        EscrituraCSV.addCSV(informacion, "experimento4.csv");
    }

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {
        System.out.println("no se puede generar imagen");
    }

    @Override
    protected void generarImagenMejorada(Solucion mejorSolucionArray, String nombreFichero) {}
}