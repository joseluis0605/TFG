package com.github.joseluis0605.TFG_CODIGO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CargadorFile {

    /*
    En esta clase vamos a recibir el nombre del archivo y vamos a abrir el fichero
    para extraer todo el contenido.
    Dicho contenido va a estar almacenado en una lista, en donde cada linea va a ser un elemento
     */

    private String path;

    public CargadorFile(String nombre){
        String ruta="C:\\Users\\USUARIO\\Desktop\\URJC\\4º Ciberseguridad\\TFG\\AlphaSeparatorProblem\\instancias\\"+nombre;
        this.path=ruta; //tenemos la ruta + el nombre del archivo .txt
    }

    public List<String> leerFile(){
        Scanner entrada= null; // puntero tipo Scanner apuntando a null (inicializar)
        File fichero= new File(this.path); //abrimos el fichero cuya ruta esta en path
        try {
            entrada= new Scanner(fichero);
            List<String> listadoAristas= new ArrayList<>();

            // AQUI VA LA LECTURA LINEA A LINEA DEL GRAFO
            while (entrada.hasNextLine()){ //mientras el fichero no termine
                String frase = entrada.nextLine(); //recogemos la frase completa
                listadoAristas.add(frase);
            }
            //***************************

            return listadoAristas;

        }catch (Exception exception){
            System.out.println(exception.getMessage()); //imprimir mensaje de error si hay fallo en el TRY
        }finally {
            try {
                if (entrada != null) {
                    entrada.close();
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
        return null;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
