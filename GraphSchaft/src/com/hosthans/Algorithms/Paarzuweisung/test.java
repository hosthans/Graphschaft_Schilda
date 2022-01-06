package com.hosthans.Algorithms.Paarzuweisung;

import com.hosthans.Graph.Graph_bipartit;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_bipartit graph = new Graph_bipartit();
        Vertex m1 = new Vertex("m1");
        m1.setMembOfA();
        Vertex m2 = new Vertex("m2");
        m2.setMembOfA();
        Vertex m3 = new Vertex("m3");
        m3.setMembOfA();


        Vertex f1 = new Vertex("f1");
        Vertex f2 = new Vertex("f2");
        Vertex f3 = new Vertex("f3");

        graph.addEdge(m1, f3, false, 1);
        graph.addEdge(m1, f2, false,1);
        graph.addEdge(m2, f1, false, 1);

        graph.addEdge(m3, f3, false,1);
        graph.addEdge(m3, f1, false,1);
        graph.addEdge(f1, m3, false,1);
        graph.addEdge(f1, m2, false,1);
        graph.addEdge(f2, m1, false,1);
        graph.addEdge(f2, m2, false,1);
        graph.addEdge(f3, m3, false,1);




        maxFlowBipartite mf = new maxFlowBipartite(graph);



    }
}
