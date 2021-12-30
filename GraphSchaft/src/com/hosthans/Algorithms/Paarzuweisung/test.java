package com.hosthans.Algorithms.Paarzuweisung;

import com.hosthans.Graph.Graph;
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
        graph.addEdge(karl, Heidi, false, 3);
        graph.addEdge(dieter, beate, false, 1);
        graph.addEdge(heinz, kunigunde, false, 0);
        graph.addEdge(georg, beate, false, 2);

        for (Vertex v: graph.getMemberofA()){
            System.out.println(v.getLabel());
        }

    }
}
