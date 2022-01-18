package com.hosthans.Algorithms.Straßennetz;

import com.hosthans.Graph.Graph_NOINPUT;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        Graph_NOINPUT graph = new Graph_NOINPUT(false, true);
        Vertex Autobahn = new Vertex("Autobahn");
        Vertex Ampel1 = new Vertex("Ampel1");
        Vertex Ampel2 = new Vertex("Ampel2");
        Vertex Ampel3 = new Vertex("Ampel3");
        Vertex Ampel4 = new Vertex("Ampel4");
        Vertex Parkplatz = new Vertex("Parkplatz");

        graph.addEdge(Autobahn, Ampel1, false, 14);
        graph.addEdge(Autobahn, Ampel2, false, 16);
        graph.addEdge(Ampel2, Ampel1, false, 6);
        graph.addEdge(Ampel2, Ampel4, false, 15);
        graph.addEdge(Ampel1, Ampel3, false, 15);
        graph.addEdge(Ampel3, Ampel2, false, 4);
        graph.addEdge(Ampel3, Ampel4, false, 7);
        graph.addEdge(Ampel3, Parkplatz, false, 10);
        graph.addEdge(Ampel4, Parkplatz, false, 17);

        MaxFlow mf = new MaxFlow(Autobahn, Parkplatz, graph, 0);





    }
}
