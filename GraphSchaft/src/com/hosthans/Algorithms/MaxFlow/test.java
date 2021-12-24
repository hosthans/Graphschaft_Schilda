package com.hosthans.Algorithms.MaxFlow;

import com.hosthans.Graph.Graph_notCapacitive;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_notCapacitive graph = new Graph_notCapacitive(false, true);
        System.out.println(graph.printGraph());
        MaxFlow ford = new MaxFlow("a", "c", graph);
    }
}
