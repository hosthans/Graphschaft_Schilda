package com.hosthans.Algorithms.Euler;

import com.hosthans.Graph.Graph_notCapacitive;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_notCapacitive graph = new Graph_notCapacitive(true, false);
        Hierholzer hierholzer = new Hierholzer(graph);


        System.out.println(graph.printGraph());

    }
}
