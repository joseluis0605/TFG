package com.github.joseluis0605.TFG_CODIGO.FICHEROS;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class FileNameList {
     public static List<String> getFileNameList(){
        String directorioPath = RutaInstancias.getRuta();
        try {
            Path directorio = Paths.get(directorioPath);
            if (Files.exists(directorio) && Files.isDirectory(directorio)) {
                List<String> nombresDeArchivos = new ArrayList<>();

                try (DirectoryStream<Path> directorioStream = Files.newDirectoryStream(directorio)) {
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