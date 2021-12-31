package com.hosthans.Algorithms.Paarzuweisung;

import com.hosthans.Graph.Graph_bipartit;
import com.hosthans.Graph.Vertex;

import java.io.IOException;

public class test {
    public static void main(String[] args) throws IOException {
        Graph_bipartit graph = new Graph_bipartit();
        Vertex karl = new Vertex("Karl");
        karl.setMembOfA();
        Vertex heinz = new Vertex("Heinz");
        heinz.setMembOfA();
        Vertex dieter = new Vertex("Dieter");
        dieter.setMembOfA();
        Vertex georg = new Vertex("Karl");
        georg.setMembOfA();

        Vertex margit = new Vertex("Margit");
        Vertex beate = new Vertex("Beate");
        Vertex Heidi = new Vertex("Heidi");
        Vertex kunigunde = new Vertex("Kunigunde");

        graph.addEdge(karl, margit, false, 0);
        graph.addEdge(margit, karl, false, 3);
        graph.addEdge(dieter, beate, false, 1);
        graph.addEdge(margit, heinz, false, 0);
        graph.addEdge(beate, georg, false, 2);

        for (Vertex v: graph.getMemberleft()){
            System.out.println(v.getLabel());
        }


        System.out.println(graph.getNumberofRight());
        for (Vertex v : graph.getVertiecesof(karl)){
            System.out.println(v.getLabel());
        }

    }
}
