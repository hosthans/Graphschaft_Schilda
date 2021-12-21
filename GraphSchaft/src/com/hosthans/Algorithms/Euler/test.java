package com.hosthans.Algorithms.Euler;

import com.hosthans.Graph.Graph_notCapacitive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_notCapacitive graph = new Graph_notCapacitive(true, false);
        Euler euler = new Euler(graph);
        euler.searchcyrcles();
        euler.promptResult();

        System.out.println(graph.printGraph());

    }
}
