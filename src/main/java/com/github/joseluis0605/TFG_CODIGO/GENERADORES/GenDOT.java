package com.github.joseluis0605.TFG_CODIGO.GENERADORES;

import com.github.joseluis0605.TFG_CODIGO.INSTANCIA.Solucion;
import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizJdkEngine;
import guru.nidi.graphviz.model.Factory;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class GenDOT {

    // metodo con el que llamamos desde experimento
    public static void writeSolutionToDisk(Solucion solucion, String ruta, String nombreFile) {
        byte[] bytes = toDOT(solucion); //pasamos instancia y array de solucion, y obtenemos el array de bytes
        try {
            String nombre= nombreFile+".dot";
            Files.write(Path.of(ruta, nombre), bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] toDOT(Solucion solucion) {
        Graphviz graphviz = buildGraphviz(solucion);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            graphviz.render(Format.DOT).toOutputStream(baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //creamos el grafo con la clase graphviz
    private static Graphviz buildGraphviz(Solucion solucion) {
        MutableGraph graph = Factory.mutGraph();
        graph.setDirected(false);
        graph.graphAttrs().add("layout", "fdp");
        graph.nodeAttrs().add("style", "filled");
        graph.nodeAttrs().add("fillcolor", "white");
        graph.nodeAttrs().add("fixedsize", "true");
        graph.nodeAttrs().add("shape", "circle");
        int nNodes = solucion.getInstanciaOriginal().getNumeroNodos();
        MutableNode[] gNodes = new MutableNode[nNodes];
        // NODOS
        for (int i = 0; i < nNodes; i++) {
            var gNode = Factory.mutNode(String.valueOf(i));
            if (solucion.existElement(i)) {
                gNode.add(Color.RED);
            } else {
                gNode.add(Color.GREEN);
            }
            gNodes[i] = gNode;
            graph.add(gNode);
        }
        // ARISTAS
        int nodoActual= 0;
        for (Set<Integer> listadoAristas : solucion.getInstanciaOriginal().getGrafo()) {
            for (Integer vecino : listadoAristas) {
                if (vecino > nodoActual) {
                    gNodes[nodoActual].addLink(gNodes[vecino]);
                }
            }
            nodoActual++;
        }
        Graphviz.useEngine(new GraphvizJdkEngine());
        return Graphviz.fromGraph(graph);
    }
}