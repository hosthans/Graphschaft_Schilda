package com.hosthans;

import com.hosthans.Algorithms.Aufgabenpakete.MaxFlow;
import com.hosthans.Algorithms.Paarzuweisung.maxPairs;
import com.hosthans.Algorithms.Paarzuweisung.maxPairsInput;
import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Graph_bipartit_NOINPUT;
import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class testung {
    public static void main(String[] args) throws IOException {
        /*Graph graph = new Graph(true, false);
        Vertex v = graph.Knoten.get("a");
        Vertex t = graph.Knoten.get("b");
        for (Node n : graph.graph.get(v)){
            if (n.dest == t){
                graph.removeEdge(v, t, n);
            }
        }
        System.out.println(graph.printGraph());*/
        Graph_bipartit_NOINPUT graph = new Graph_bipartit_NOINPUT(false, true);
        maxPairsInput mp = new maxPairsInput(graph);
        System.out.println(graph.printGraph());
    }
}
