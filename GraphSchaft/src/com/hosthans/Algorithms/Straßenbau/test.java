package com.hosthans.Algorithms.Straßenbau;

import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Graph_NOINPUT;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        //Graph graph = new Graph(true, true);


        Graph_NOINPUT graph = new Graph_NOINPUT(true, true);
        Vertex v1 = new Vertex("a");
        Vertex v2 = new Vertex("b");
        Vertex v3 = new Vertex("c");
        Vertex v4 = new Vertex("d");

        graph.addEdge(v1, v2, true, 3);
        graph.addEdge(v2, v3, true, 5);
        graph.addEdge(v3, v4, true, 8);
        graph.addEdge(v2, v4, true, 4);

        PrimAlgorithm prim = new PrimAlgorithm(graph);

    }
}
