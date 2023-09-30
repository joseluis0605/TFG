package com.github.joseluis0605;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphToDot {
    public static void main(String[] args) {
        // Ejemplo de grafo representado como un array de listas
        List<Integer>[] graph = new ArrayList[6]; // Aquí creamos un grafo con 6 nodos
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(1); // Nodo 0 está conectado con Nodo 1
        graph[0].add(2); // Nodo 0 está conectado con Nodo 2
        graph[1].add(3); // Nodo 1 está conectado con Nodo 3
        graph[2].add(4); // Nodo 2 está conectado con Nodo 4
        graph[3].add(5); // Nodo 3 está conectado con Nodo 5

        // Crear un archivo DOT
        String dotFileName = "grafo.dot";
        try (FileWriter writer = new FileWriter(dotFileName)) {
            writer.write("graph G {\n");

            for (int node = 0; node < graph.length; node++) {
                for (int neighbor : graph[node]) {
                    if (node < neighbor) {
                        writer.write("  " + node + " -- " + neighbor + ";\n");
                    }
                }
            }

            writer.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

