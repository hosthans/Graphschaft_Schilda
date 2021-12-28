package com.hosthans.Algorithms.Wasserleitung;

import com.hosthans.Graph.Graph;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(false, true);
        System.out.println(graph.printGraph());
        MaxFlow ford = new MaxFlow("a", "c", graph);
    }
}
