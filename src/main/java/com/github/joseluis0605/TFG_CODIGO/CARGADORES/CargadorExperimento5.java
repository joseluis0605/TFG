package com.github.joseluis0605.TFG_CODIGO.CARGADORES;

import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.Constructivo;
import com.github.joseluis0605.TFG_CODIGO.CONSTRUCTIVOS.ConstructivoVorazOrdenacionTrasEliminacion;
import com.github.joseluis0605.TFG_CODIGO.FICHEROS.EscrituraCSV;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Instancia;
import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;

public class CargadorExperimento5 extends CargadorExperimento{
    /*
Experimento para medir la optimización 2
 */
    @Override
    public void cargarExperimento() {

        Instancia instancia= dame_nombre_te_doy_instancia("erdos_renyi_100_0.05_0.2_3.txt");
        TiemposMaximos tiemposMaximos= new TiemposMaximos();

        if (super.esComponenteConexa(instancia) && tiemposMaximos.getDoubleTiempoMaximo(instancia.getFileName())!=null){
            Constructivo constructivo= new ConstructivoVorazOrdenacionTrasEliminacion();
            for (int j = 0; j < 1000; j++) {
                long inicio= System.nanoTime();
                Solucion solucion = constructivo.construir(instancia);
                double tiempoTotal= (System.nanoTime()-inicio)/1e9d;
                // generamos csv
                escribirCSV(instancia.getFileName(), j, solucion.size(), tiempoTotal);
            }
        }

    }

    @Override
    protected void escribirCSV_Mejora(String nombreFichero, int iteracion, int solucion, int mejora, Number tiempoTotal) {}

    @Override
    protected void escribirCSV(String nombreFichero, int iteracion, int solucion, Number tiempoEjecucion) {
        String informacion = "Voraz Ordenado Tras Eliminacion Tiempo" + ";" + nombreFichero + ";" + iteracion + ";" + solucion + ";" + numberToCSV(tiempoEjecucion);
        EscrituraCSV.addCSV(informacion, "experimento5.csv");
    }

    @Override
    protected void generarImagen(Solucion mejorSolucionArray, String nombreFichero) {
        System.out.println("no se puede generar imagen");
    }

    @Override
    protected void generarImagenMejorada(Solucion mejorSolucionArray, String nombreFichero) {}
}
