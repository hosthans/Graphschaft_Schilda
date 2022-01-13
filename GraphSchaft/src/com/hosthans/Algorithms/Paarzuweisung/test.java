package com.hosthans.Algorithms.Paarzuweisung;

import com.hosthans.Graph.Graph_bipartit;
import com.hosthans.Graph.Graph_bipartit_WINPUT;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        /*Graph_bipartit graph = new Graph_bipartit();
        Vertex m1 = new Vertex("Peter");
        m1.setMembOfA();
        Vertex m2 = new Vertex("Jonas");
        m2.setMembOfA();
        Vertex m3 = new Vertex("Felix");
        m3.setMembOfA();
        Vertex m4 = new Vertex("Mats");
        m4.setMembOfA();
        Vertex m5 = new Vertex("Aaron");
        m5.setMembOfA();
        Vertex m6 = new Vertex("Tom");
        m6.setMembOfA();

        Vertex f1 = new Vertex("Marie");
        Vertex f2 = new Vertex("Susanne");
        Vertex f3 = new Vertex("Antonie");
        Vertex f4 = new Vertex("Lena");
        Vertex f5 = new Vertex("Ida");
        Vertex f6 = new Vertex("Anna");

        graph.addEdge(m1, f3, false, 0); //Peter --> Antonie
        graph.addEdge(m1, f4, false,0); //Peter --> Susanne
        graph.addEdge(m1, f6, false, 0); //Peter --> Anna
        graph.addEdge(m2, f1, false,0); //Jonas --> Marie
        graph.addEdge(m2, f2, false,0); //Jonas --> Susanne
        graph.addEdge(m2, f5, false,0); //Jonas --> Ida
        graph.addEdge(m3, f1, false,0); //Felix --> Marie
        graph.addEdge(m3, f3, false,0); //Felix -_> Antonie
        graph.addEdge(m4, f1, false,0); //Mats --> Marie
        graph.addEdge(m4, f3, false,0); //Mats --> Antonie
        graph.addEdge(m4, f6, false,0); //Mats --> Anna
        graph.addEdge(m4, f4, false,0); //Mats --> Lena
        graph.addEdge(m5, f1, false,0); //Aaron --> Marie
        graph.addEdge(m6, f3, false,0); //Tom --> Antonie
        graph.addEdge(m6, f2, false,0); //Tom --> Susanne
        graph.addEdge(m6, f5, false,0); //Tom --> Ida

        graph.addEdge(f1, m1, false, 0); //Marie --> Peter
        graph.addEdge(f1, m5, false, 0); //Marie --> Aaron
        graph.addEdge(f1, m6, false, 0); //Marie --> Tom
        graph.addEdge(f2, m2, false, 0); //Susanne --> Jonas
        graph.addEdge(f2, m3, false, 0); //Susanne --> Felix
        graph.addEdge(f2, m4, false, 0); //Susanne --> Mats
        graph.addEdge(f3, m1, false, 0); //Antonie --> Peter
        graph.addEdge(f3, m3, false, 0); //Antonie --> Felix
        graph.addEdge(f4, m3, false, 0); //Lena --> Felix
        graph.addEdge(f4, m4, false, 0); //Lena --> Mats
        graph.addEdge(f5, m1, false, 0); //Ida --> Peter
        graph.addEdge(f5, m5, false, 0); //Ida --> Aaron
        graph.addEdge(f5, m4, false, 0); //Ida --> Mats
        graph.addEdge(f6, m3, false, 0); //Anna --> Felix
        graph.addEdge(f6, m2, false, 0); //Anna --> Jonas
        graph.addEdge(f6, m1, false, 0); //Anna --> Peter
        graph.addEdge(f5, m6, false, 0); //Ida --> Tom






        maxPairs mp = new maxPairs(graph);*/

        Graph_bipartit_WINPUT graph = new Graph_bipartit_WINPUT(false, true);
        maxPairsInput mp = new maxPairsInput(graph);







    }
}
