package com.hosthans.Algorithms.Feuerwerk;

import com.hosthans.Graph.Graph;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(false, true);
        Dijkstra d = new Dijkstra("f",graph);
    }
}
