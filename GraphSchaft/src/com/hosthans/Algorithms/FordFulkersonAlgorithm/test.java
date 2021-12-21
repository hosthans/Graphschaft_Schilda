package com.hosthans.Algorithms.FordFulkersonAlgorithm;

import com.hosthans.Graph.Graph_notCapacitive;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_notCapacitive graph = new Graph_notCapacitive(false, true);
        System.out.println(graph.printGraph());
        System.out.println(graph.getGraphMap());
        FordFulkerson ford = new FordFulkerson("a", "c", graph);
    }
}
