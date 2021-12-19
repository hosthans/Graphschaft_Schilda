package com.hosthans.Graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class testGraphwoutInput {

    public Map<Vertex, List<Node>> graph = new HashMap<>();



    private void addVertex(Vertex vertex) {
        graph.put(vertex, new LinkedList<Node>());
    }

    public void addEdge(Vertex source, Vertex destination, boolean biDirectional, Integer weight) throws IOException {
        //nur gebraucht wenn gerichtet
        Edge e = new Edge(source, destination, weight, weight);
        //wenn ungerichtet
        Edge e2 = new Edge(destination, source, weight, weight);

        Node n1 = new Node(e, destination);
        Node n2 = new Node(e2, source);

        if (!graph.containsKey(source)) {
            addVertex(source);
        }

        if (!graph.containsKey(destination)) {
            addVertex(destination);
        }

        graph.get(source).add(n1);
        if(biDirectional == true) {
            graph.get(destination).add(n2);
        }
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        /*if(graph.get(source).contains(dest)) {
            System.out.println("Graph_notCapacitive hat eine Kante zwischen " + source.getLabel() + " und " + dest.getLabel());
        }else {
            System.out.println("Graph_notCapacitive hat keine Kante zwischen " + source.getLabel() + " und " + dest.getLabel());
        }*/
        //durch Liste aller Knoten interieren
        for (Vertex v : graph.keySet()){
            for (Node n : graph.get(v)){
                if (source == n.e.src && dest == n.e.dest){
                    return true;
                }
            }
        } return false;
    }

    public void hasVertex(Vertex v){
        if(graph.containsKey(v)) {
            System.out.println("Graph_notCapacitive beinhaltet " + v.getLabel() + " als ein Knoten");
        }else {
            System.out.println("Graph_notCapacitive beinhaltet nicht " + v.getLabel() + " als ein Knoten");
        }
    }

    public String printGraph() {
        StringBuilder builder = new StringBuilder();

        for(Vertex vertex : graph.keySet()) {
            builder.append(vertex.getLabel().toString() + " hat Kanten nach: ");
            for(Node edge: graph.get(vertex)) {
                builder.append(edge.toString() + " ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public Map<Vertex, List<Node>> getGraphMap(){
        return this.graph;
    }

    public List<Node> getNeighbors(Vertex v){
        return graph.get(v);
    }
}
