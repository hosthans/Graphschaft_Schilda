package com.hosthans.Algorithms.Straßennetz;

import com.hosthans.Graph.Graph_NOINPUT;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_NOINPUT graph = new Graph_NOINPUT(false, true);
        /*Vertex Autobahn = new Vertex("Autobahn");
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
        graph.addEdge(Ampel4, Parkplatz, false, 17);*/





        //com.hosthans.Algorithms.Straßennetz.MaxFlow mf = new com.hosthans.Algorithms.Straßennetz.MaxFlow("Autobahn", "Parkplatz", graph, 23);

        Vertex src = new Vertex("Source");
        Vertex dest = new Vertex("Destination");
        Vertex Worker1 = new Vertex("Maier");
        Vertex Worker2 = new Vertex("Müller");
        Vertex Worker3 = new Vertex("Augst");
        Vertex Worker4 = new Vertex("Hof");

        Vertex Task1 = new Vertex("Straßenbau");
        Vertex Task2 = new Vertex("Modeberatung");
        Vertex Task3 = new Vertex("Verkehrsplanung");
        Vertex Task4 = new Vertex("Wasserversorgung");

        graph.addEdge(src, Worker1, false, 1);
        graph.addEdge(src, Worker2, false, 1);
        graph.addEdge(src, Worker3, false, 1);
        graph.addEdge(src, Worker4, false, 1);

        graph.addEdge(Worker1, Task3, false, 1);
        graph.addEdge(Worker1, Task1, false, 1);

        graph.addEdge(Worker2, Task2, false, 1);

        graph.addEdge(Worker3, Task1, false, 1);
        graph.addEdge(Worker3, Task4, false, 1);

        graph.addEdge(Worker4, Task1, false, 1);
        graph.addEdge(Worker4, Task2, false, 1);

        graph.addEdge(Task1, dest, false, 1);
        graph.addEdge(Task2, dest, false, 1);
        graph.addEdge(Task3, dest, false, 1);
        graph.addEdge(Task4, dest, false, 1);

        MaxFlow mf = new MaxFlow(src, dest, graph, 0);
        System.out.println(mf.getFinalGraph().printGraph());

    }
}
