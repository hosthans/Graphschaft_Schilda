package com.hosthans.Algorithms.FordFulkersonAlgorithm;

import com.hosthans.Graph.*;

import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class FordFulkerson {

    Graph_notCapacitive graph;
    Vertex Quelle;
    Vertex Senke;

    Graph_notCapacitive residual;






    public FordFulkerson(String Quelle, String Senke, Graph_notCapacitive graph) throws IOException {
        this.graph = graph;
        this.Quelle = graph.Knoten.get(Quelle);
        this.Senke = graph.Knoten.get(Senke);
        this.residual = graph;
        try {
            initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() throws IOException {
        for (Vertex v : graph.graph.keySet()){
            for (Node n : graph.graph.get(v)){
                if (n.getE().weight != 0){
                    residual.addReverseEdge(n.getE().dest, v);
                }
            }
        }


        System.out.println(residual.printGraph());

    }

    public void doAlgorithm(){
        for (Vertex v : graph.graph.keySet()){
            for (Node n : graph.graph.get(v)){
                n.getE().weight = 0;
            }
        }
        //test if it works (every flow set to null)
        /*
        for (Vertex v : graph.graph.keySet()){
            for (Node n : graph.graph.get(v)){
                System.out.println(n.getE().weight);
            }
        }*/
    }

}
