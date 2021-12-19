package com.hosthans.Algorithms.FordFulkersonAlgorithm;

import com.hosthans.Graph.Graph_notCapacitive;
import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

public class FordFulkerson {

    Graph_notCapacitive graph;
    Vertex Quelle;
    Vertex Senke;



    public FordFulkerson(String Quelle, String Senke, Graph_notCapacitive graph){
        this.graph = graph;
        this.Quelle = graph.Knoten.get(Quelle);
        this.Senke = graph.Knoten.get(Senke);
        doAlgorithm();
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
