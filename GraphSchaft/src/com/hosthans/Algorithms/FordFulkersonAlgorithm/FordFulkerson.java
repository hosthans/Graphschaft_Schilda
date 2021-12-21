package com.hosthans.Algorithms.FordFulkersonAlgorithm;

import com.hosthans.Graph.*;

import java.io.IOException;
import java.util.*;

public class FordFulkerson {

    Graph_notCapacitive graph;
    Vertex Quelle;
    Vertex Senke;
    Graph_notCapacitive residual;





    int maxFlow = 0;







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
        doAlgorithm();

    }

    public void doAlgorithm(){
        //System.out.println(Breitensuche(Quelle, Senke));
    }


    /*public boolean Breitensuche (Vertex start, Vertex ende){
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.push(start);
        ArrayList<Vertex> list2 = new ArrayList<>();
        list2.add(start);
        start.setVisited(true);
        while(!queue.isEmpty()){
            Vertex temp = queue.pop();
            if(temp==ende){
                for (int i = 0; i<list2.size(); i++){
                    System.out.println(list2.get(i).getLabel());
                }
                return true;
            }
            List<Node> list = graph.getNeighbors(temp);
            for(int i=0;i<list.size();i++){
                if(!list.get(i).dest.isVisited()){
                    queue.push(list.get(i).dest);
                    list2.add(list.get(i).dest);
                }
            }
        }

        return false;
    }*/



    public void solve(){

    }
}
