package com.hosthans.Algorithms.Feuerwerk;

import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Graph_NOINPUT;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        //Graph graph = new Graph(false, true);

        Graph_NOINPUT graph = new Graph_NOINPUT(false, true);

        Vertex f = new Vertex("f");
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex g = new Vertex("g");
        Vertex h = new Vertex("h");


        graph.addEdge(f,a,false,3);
        graph.addEdge(a, b, false, 2);
        graph.addEdge(a, c, false, 2);
        graph.addEdge(a,d,false,1);
        graph.addEdge(a,e,false,3);
        graph.addEdge(d,e,false,6);
        graph.addEdge(b,c,false,3);
        graph.addEdge(c,d,false,7);
        graph.addEdge(b,d,false,2);
        graph.addEdge(g,h,false,35);
        graph.addEdge(d,g,false,4);

        DijkstraNoInput dijkstraNoInput = new DijkstraNoInput("f",graph);
    }
}
