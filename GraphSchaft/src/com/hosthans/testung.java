package com.hosthans;

import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class testung {
    public static void main(String[] args) throws IOException {
        Graph graph = new Graph(true, false);
        Vertex v = graph.Knoten.get("a");
        Vertex t = graph.Knoten.get("b");
        for (Node n : graph.graph.get(v)){
            if (n.dest == t){
                graph.removeEdge(v, t, n);
            }
        }
        System.out.println(graph.printGraph());
    }
}
