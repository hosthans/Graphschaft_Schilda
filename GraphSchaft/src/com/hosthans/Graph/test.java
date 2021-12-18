package com.hosthans.Graph;

import com.hosthans.Algorithms.PrimAlgorithm.PrimAlgorithm;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        testGraphwoutInput graph = new testGraphwoutInput();
        Vertex v1 = new Vertex("a");
        Vertex v2 = new Vertex("b");
        System.out.println(graph.printGraph());

        Graph g = new Graph(false, false, true);
        System.out.println(g.printGraph());


    }
}
