package com.github.joseluis0605;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class FileNameList {
     public static List<String> getFileNameList(){

         // generamos una lista con el nombre de los archivos del directorio y va a hacer un return

        // Especifica la ruta del directorio que deseas listar
        String directorioPath = "C:\\Users\\USUARIO\\Desktop\\URJC\\4º Ciberseguridad\\TFG\\AlphaSeparatorProblem\\instancias";

        try {
            Path directorio = Paths.get(directorioPath);

            if (Files.exists(directorio) && Files.isDirectory(directorio)) {
                List<String> nombresDeArchivos = new ArrayList<>();

                try (DirectoryStream<Path> directorioStream = Files.newDirectoryStream(directorio)) {//se usa para cerrar el fichero
                    for (Path archivo : directorioStream) {
                        if (Files.isRegularFile(archivo)) {
                            nombresDeArchivos.add(archivo.getFileName().toString());
                        }
                    }
                }
                return nombresDeArchivos;
            } else {
                System.out.println("El directorio no existe o no es válido.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}






