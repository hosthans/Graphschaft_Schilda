package com.hosthans.Graph;

import com.hosthans.Algorithms.FordFulkersonAlgorithm.FordFulkerson;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        //Graph_notCapacitive g = new Graph_notCapacitive(true, true);
        Graph_Capacitive gr = new Graph_Capacitive();
        System.out.println(gr.printGraph());
        /*
        PrimAlgorithm prim = new PrimAlgorithm(g);
        prim.doalgotithm();*/

        //FordFulkerson ford = new FordFulkerson("a", "c", g);

    }
}
