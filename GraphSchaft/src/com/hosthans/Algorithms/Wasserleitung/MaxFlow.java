package com.hosthans.Algorithms.Wasserleitung;

import com.hosthans.Graph.*;

import java.io.IOException;

public class MaxFlow {

    Graph graph;
    Vertex Quelle;
    Vertex Senke;
    Graph residual;

    int maxFlow = 0;

    public MaxFlow(String Quelle, String Senke, Graph graph) throws IOException {
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

    //erst initialisieren (hier mit residualgraph)
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

    public void doAlgorithm(Graph graph, Vertex QUelle, Vertex Senke) throws IOException {

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
