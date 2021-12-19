package com.hosthans.Algorithms.Dijkstra;

import com.hosthans.Graph.Graph_notCapacitive;
import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

import java.util.*;

public class Dijkstra {

    Graph_notCapacitive graph;
    Vertex v;
    DijkstraNode startingNode;


    Map<Vertex ,DijkstraNode> nodeset = new HashMap<>();
    List<DijkstraNode> helper = new ArrayList<>();
    PriorityQueue<DijkstraNode> Q = new PriorityQueue<>();
    PriorityQueue<DijkstraNode> NodeQueue = new PriorityQueue<>();


    List<DijkstraNode> ergebnisListe = new ArrayList<>();




    public Dijkstra(String label, Graph_notCapacitive g){
        this.graph = g;
        this.v = graph.Knoten.get(label);
        doAlgorithm();
    }

    public void initialize(){

        for (Vertex v : graph.getGraphMap().keySet()){
            DijkstraNode node = new DijkstraNode(v, Integer.MAX_VALUE);
            nodeset.put(v, node);
            Q.add(node);
            helper.add(node);
        }

        //Startknoten auf 0 setzen --> in Queue geben
        nodeset.get(this.v).weight = 0;
        nodeset.get(this.v).v.setKey(0);


        startingNode = nodeset.get(this.v);

        for (Vertex v : nodeset.keySet()){
            System.out.println(v.getLabel() + " " + v.getKey());
        }

    }




    public void doAlgorithm(){
        initialize();

        while (Q.size() != 0){
            Q.clear();
            for (int i = 0; i < helper.size(); i++){
                Q.add(helper.get(i));
            }


            //niedrigster rausnehmen
            DijkstraNode currentNode = Q.poll();

            //testausgabe
            System.out.println("Der Knoten mit dem niedrigsten Wert is : " + currentNode.toString());


            List<DijkstraNode> currentNeighbours = new ArrayList<>();


            //alle Nachbarn des niedrigsten
            for (int i = 0; i<graph.graph.get(currentNode.v).size(); i++){
                Node current = graph.graph.get(currentNode.v).get(i);
                System.out.println("Ein Nachbar von " + currentNode.v.getLabel() + "  ist : "  + graph.graph.get(currentNode.v).get(i));
                currentNeighbours.add(nodeset.get(current.dest));

            }


            //Hinzufügen in NodeQueue
            NodeQueue.add(currentNode);

            //löschen aus Hilfe
            helper.remove(currentNode);
            nodeset.remove(currentNode.v);



        }



    }




}
