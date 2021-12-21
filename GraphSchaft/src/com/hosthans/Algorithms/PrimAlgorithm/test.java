package com.hosthans.Algorithms.PrimAlgorithm;

import com.hosthans.Graph.Graph_notCapacitive;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_notCapacitive graph_notCapacitive = new Graph_notCapacitive(true, false);
        PrimAlgorithm prim = new PrimAlgorithm(graph_notCapacitive);
        prim.doalgotithm();
    }
}
