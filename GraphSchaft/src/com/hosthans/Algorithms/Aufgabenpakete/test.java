package com.hosthans.Algorithms.Aufgabenpakete;

import com.hosthans.Graph.Graph_bipartit;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {

        Graph_bipartit graph = new Graph_bipartit();



        Vertex Worker1 = new Vertex("Maier");
        Vertex Worker2 = new Vertex("Müller");
        Vertex Worker3 = new Vertex("Augst");
        Vertex Worker4 = new Vertex("Hof");
        Vertex Worker5 = new Vertex("Hansi");

        Worker1.setMembOfA();
        Worker2.setMembOfA();
        Worker3.setMembOfA();
        Worker4.setMembOfA();

        Vertex Task1 = new Vertex("Straßenbau");
        Vertex Task2 = new Vertex("Modeberatung");
        Vertex Task3 = new Vertex("Verkehrsplanung");
        Vertex Task4 = new Vertex("Wasserversorgung");
        Vertex Task5 = new Vertex("Gülle");



        graph.addEdge(Worker1, Task3, false, 1);
        graph.addEdge(Worker1, Task1, false, 1);

        graph.addEdge(Worker2, Task2, false, 1);

        graph.addEdge(Worker3, Task1, false, 1);
        graph.addEdge(Worker3, Task4, false, 1);

        graph.addEdge(Worker4, Task1, false, 1);
        graph.addEdge(Worker4, Task2, false, 1);
        graph.addEdge(Worker4, Task5, false, 1);

        //graph.addEdge(Worker5, Task1, false, 1);
        graph.addEdge(Worker5, Task5, false, 1);


        Vertex src = new Vertex("Source");
        Vertex dest = new Vertex("Destination");

        graph.addEdge(src, Worker5, false, 1);
        graph.addEdge(src, Worker1, false, 1);
        graph.addEdge(src, Worker2, false, 1);
        graph.addEdge(src, Worker3, false, 1);
        graph.addEdge(src, Worker4, false, 1);


        graph.addEdge(Task1, dest, false, 1);
        graph.addEdge(Task2, dest, false, 1);
        graph.addEdge(Task3, dest, false, 1);
        graph.addEdge(Task4, dest, false, 1);
        graph.addEdge(Task5, dest, false, 1);

        System.out.println(graph.printGraph());


        MaxFlow mf = new MaxFlow("Source","Destination",graph, 0);
        //System.out.println(mf.getFinalGraph().printGraph());
    }
}
