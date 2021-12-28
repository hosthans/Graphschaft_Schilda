package com.hosthans.Algorithms.Wasserleitung;

import com.hosthans.Graph.Edge;
import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Graph_NOINPUT;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        /*Graph graph = new Graph(false, true);
        System.out.println(graph.printGraph());*/
        Graph_NOINPUT graph = new Graph_NOINPUT(false, true);
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");

        graph.addEdge(a, b, false, 7);
        graph.addEdge(a,c,false, 1);
        graph.addEdge(b,d,false,6);
        graph.addEdge(b,f,false,8);
        graph.addEdge(d,f,false,3);
        graph.addEdge(c,e,false,6);
        graph.addEdge(d,g,false,2);
        graph.addEdge(d,e,false,9);
        graph.addEdge(e,g,false,7);
        graph.addEdge(f,g,false,1);



        MaxFlow mf = new MaxFlow(a, g, graph);
    }

}
