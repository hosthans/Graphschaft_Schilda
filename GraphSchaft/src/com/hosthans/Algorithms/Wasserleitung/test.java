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
        Vertex Wasserwerk = new Vertex("Wasserwerk");
        Vertex Thoma = new Vertex("Thoma");
        Vertex Dogan = new Vertex("Dogan");
        Vertex Ilona = new Vertex("Ilona");
        Vertex Club = new Vertex("Club");
        Vertex Holler = new Vertex("Holler");
        Vertex Bogart = new Vertex("Bogart");
        Vertex Adler = new Vertex("Adler");
        Vertex Supermarkt = new Vertex("Supermarkt");

        graph.addEdge(Wasserwerk, Thoma, false, 15);
        graph.addEdge(Wasserwerk,Ilona,false, 6);
        graph.addEdge(Wasserwerk,Club,false,12);
        graph.addEdge(Dogan,Adler,false,5);
        graph.addEdge(Dogan,Bogart,false,6);
        graph.addEdge(Ilona,Bogart,false,3);
        graph.addEdge(Ilona,Holler,false,1);
        graph.addEdge(Club,Adler,false,5);
        graph.addEdge(Club,Holler,false,5);
        graph.addEdge(Adler,Supermarkt,false,10);
        graph.addEdge(Bogart,Supermarkt,false,10);
        graph.addEdge(Holler,Supermarkt,false,7);
        graph.addEdge(Thoma,Dogan,false,8);





        MaxFlow mf = new MaxFlow("Wasserwerk", "Supermarkt", graph, 23);
        System.out.println();
    }

}
