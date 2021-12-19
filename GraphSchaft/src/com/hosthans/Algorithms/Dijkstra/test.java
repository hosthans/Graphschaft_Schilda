package com.hosthans.Algorithms.Dijkstra;

import com.hosthans.Graph.Graph_notCapacitive;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_notCapacitive graph = new Graph_notCapacitive(false, true);
        Dijkstra d = new Dijkstra("a",graph);




    }
}
