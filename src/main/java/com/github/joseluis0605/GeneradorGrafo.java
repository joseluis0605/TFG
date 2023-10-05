package com.github.joseluis0605;

import guru.nidi.graphviz.attribute.Color;
import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.engine.GraphvizJdkEngine;
import guru.nidi.graphviz.model.Factory;
import guru.nidi.graphviz.model.MutableGraph;
import guru.nidi.graphviz.model.MutableNode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class GeneradorGrafo {

    // metodo con el que llamamos desde experimento
    public void writeSolutionToDisk(Instancia instanciaSolucion, Solucion arrayEliminados) {
        byte[] bytes = toPNG(instanciaSolucion, arrayEliminados); //pasamos instancia y array de solucion, y obtenemos el array de bytes
        try {
            Files.write(Path.of("C:\\Users\\USUARIO\\Desktop\\URJC\\4º Ciberseguridad\\TFG\\AlphaSeparatorProblem\\imagenesGrafo", "imagenRandom.png"), bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] toPNG(Instancia instanciaResultado, Solucion arrayEliminados) {
        Graphviz graphviz = buildGraphviz(instanciaResultado, arrayEliminados);
        BufferedImage image = graphviz.render(Format.PNG).toImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", baos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return baos.toByteArray();
    }

    //creamos el grafo con la clase graphviz
    public Graphviz buildGraphviz(Instancia instanciaSolucion, Solucion arrayEliminados) {
        MutableGraph graph = Factory.mutGraph();
        graph.setDirected(false);
        graph.graphAttrs().add("layout", "fdp");
        graph.nodeAttrs().add("style", "filled");
        graph.nodeAttrs().add("fillcolor", "white");
        graph.nodeAttrs().add("fixedsize", "true");
        graph.nodeAttrs().add("shape", "circle");
        //var instance = instanciaSolucion.getGrafoCopia();

        int nNodes = instanciaSolucion.getNumeroNodos();
        MutableNode[] gNodes = new MutableNode[nNodes];

        // NODOS
        for (int i = 0; i < nNodes; i++) {
            var gNode = Factory.mutNode(String.valueOf(i));
            if (arrayEliminados .existElement(i)) {
                gNode.add(Color.RED);
            } else {
                gNode.add(Color.GREEN);
            }
            gNodes[i] = gNode;
            graph.add(gNode);
        }

        // ARISTAS
        int nodoActual= 0;
        for (Set<Integer> listadoAristas : instanciaSolucion.getGrafo()) {
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