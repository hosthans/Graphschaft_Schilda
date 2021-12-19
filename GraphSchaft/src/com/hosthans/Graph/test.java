package com.hosthans.Graph;

import com.hosthans.Algorithms.FordFulkersonAlgorithm.FordFulkerson;
import com.hosthans.Algorithms.PrimAlgorithm.PrimAlgorithm;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        Graph g = new Graph(false, false, true);
        System.out.println(g.printGraph());
        /*
        PrimAlgorithm prim = new PrimAlgorithm(g);
        prim.doalgotithm();*/

        FordFulkerson ford = new FordFulkerson("a", "c", g);

    }
}
