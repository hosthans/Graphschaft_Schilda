package com.hosthans.Algorithms.Straßenbau;

import com.hosthans.Graph.Graph;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph graph_ = new Graph(true, false);
        PrimAlgorithm prim = new PrimAlgorithm(graph_);
        prim.doalgotithm();
    }
}
