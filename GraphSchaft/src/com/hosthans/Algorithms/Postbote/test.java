package com.hosthans.Algorithms.Postbote;

import com.hosthans.Graph.Graph;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(true, false);
        Hierholzer hierholzer = new Hierholzer(graph);


        System.out.println(graph.printGraph());

    }
}
