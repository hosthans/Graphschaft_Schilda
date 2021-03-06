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
        Vertex Worker5 = new Vertex("Schmidt");
        Vertex Worker6 = new Vertex("Kunze");
        Vertex Worker7 = new Vertex("Lustig");

        Worker1.setMembOfA();
        Worker2.setMembOfA();
        Worker3.setMembOfA();
        Worker4.setMembOfA();
        Worker5.setMembOfA();
        Worker6.setMembOfA();
        Worker7.setMembOfA();

        Vertex Task1 = new Vertex("Straßenbau");
        Vertex Task2 = new Vertex("Modeberatung");
        Vertex Task3 = new Vertex("Verkehrsplanung");
        Vertex Task4 = new Vertex("Wasserversorgung");
        Vertex Task5 = new Vertex("Archaeologie");
        Vertex Task6 = new Vertex("Wettkampfausrichtung");
        Vertex Task7 = new Vertex("Hochzeitsplanung");


        graph.addEdge(Worker1, Task1, false, 1);
        graph.addEdge(Worker1, Task3, false, 1);
        graph.addEdge(Worker1, Task5, false, 1);

        graph.addEdge(Worker2, Task1, false, 1);
        graph.addEdge(Worker2, Task4, false, 1);

        graph.addEdge(Worker3, Task1, false, 1);
        graph.addEdge(Worker3, Task2, false, 1);

        graph.addEdge(Worker4, Task5, false, 1);
        graph.addEdge(Worker4, Task4, false, 1);

        //graph.addEdge(Worker5, Task1, false, 1);
        graph.addEdge(Worker5, Task6, false, 1);
        graph.addEdge(Worker5, Task7, false, 1);
        graph.addEdge(Worker5, Task5, false, 1);

        graph.addEdge(Worker6, Task4, false, 1);
        graph.addEdge(Worker6, Task6, false, 1);

        graph.addEdge(Worker7, Task5, false, 1);
        graph.addEdge(Worker7, Task7, false, 1);

        System.out.println(graph.printGraph());

        MaxFlow mf = new MaxFlow(graph, 0);




    }
}
