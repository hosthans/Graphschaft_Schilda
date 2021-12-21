package com.hosthans.Graph;

import com.hosthans.Algorithms.FordFulkersonAlgorithm.FordFulkerson;
import com.hosthans.Algorithms.PrimAlgorithm.PrimAlgorithm;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        //Graph_notCapacitive g = new Graph_notCapacitive(true, true);
        Graph_notCapacitive gr = new Graph_notCapacitive(true, true);
        System.out.println(gr.printGraph());

        PrimAlgorithm prim = new PrimAlgorithm(gr);
        prim.doalgotithm();

        //FordFulkerson ford = new FordFulkerson("a", "c", g);

    }
}
