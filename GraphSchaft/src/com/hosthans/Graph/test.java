package com.hosthans.Graph;

import com.hosthans.Algorithms.Straßenbau.PrimAlgorithm;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        //Graph g = new Graph(true, true);
        /*Graph gr = new Graph(true, true);
        System.out.println(gr.printGraph());

        PrimAlgorithm prim = new PrimAlgorithm(gr);
        prim.doalgotithm();*/

        //MaxFlow ford = new MaxFlow("a", "c", g);



        Graph_NOINPUT graph = new Graph_NOINPUT(true, true);
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");

        graph.addEdge(b, d, true, 8);
        graph.addEdge(a, c, true, 6);
        graph.addEdge(a, d, true, 33);
        graph.addEdge(c, d, true, 1);
        graph.addEdge(b, a, true, 3);

        System.out.println(graph.printGraph());

        PrimAlgorithm prim = new PrimAlgorithm(graph);
    }
}
