package com.hosthans.Algorithms.Postbote;

import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Graph_NOINPUT;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        //Graph graph = new Graph(true, false);
        //Hierholzer hierholzer = new Hierholzer(graph);

        Graph_NOINPUT graph = new Graph_NOINPUT(true, false);

        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");

        graph.addEdge(a,b,true,0);
        graph.addEdge(a,d,true,0);
        graph.addEdge(b,c,true,0);
        graph.addEdge(b,f,true,0);
        graph.addEdge(b,e,true,0);
        graph.addEdge(d,e,true,0);
        graph.addEdge(d,f,true,0);
        graph.addEdge(d,c,true,0);
        graph.addEdge(c,e,true,0);
        graph.addEdge(c,f,true,0);
        graph.addEdge(e,f,true,0);





        System.out.println(graph.printGraph());


        HierholzerNoInpu hierholzerNoInpu = new HierholzerNoInpu(graph);

    }
}
