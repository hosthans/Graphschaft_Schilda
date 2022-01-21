package com.hosthans.Algorithms.Feuerwerk;

import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

import java.util.*;

public class Dijkstra {

    Graph graph;
    Vertex v;
    DijkstraNode startingNode;


    Map<Vertex ,DijkstraNode> nodeset = new HashMap<>();
    List<DijkstraNode> helper = new ArrayList<>();
    PriorityQueue<DijkstraNode> Q = new PriorityQueue<>();


    List<DijkstraNode> ergebnisListe = new ArrayList<>();




    public Dijkstra(String label, Graph g){
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
            ergebnisListe.add(node);
        }

        //Startknoten auf 0 setzen --> in Queue geben
        nodeset.get(this.v).weight = 0;
        nodeset.get(this.v).v.setKey(0);


        startingNode = nodeset.get(this.v);

        /*for (Vertex v : nodeset.keySet()){
            System.out.println(v.getLabel() + " " + v.getKey());
        }*/

    }




    public void doAlgorithm(){          //O(V^2) * O(E)
        initialize();



        while (Q.size() != 0){                      //O(V^2)*O(E)
            Q.clear();
            for (int i = 0; i < helper.size(); i++){            //O(E)      --> damit Priorität aktualisiert wird
                Q.add(helper.get(i));
            }


            //niedrigster rausnehmen
            DijkstraNode currentNode = Q.poll();
            helper.remove(currentNode);

            List<Node> adjList = graph.graph.get(currentNode.v);

            for (Node v : adjList){                             // O(E)*O(V)         -->alle Nachbarn (können n-1 sein) im Worst Case
                DijkstraNode ref = null;

                for (int i = 0; i<helper.size(); i++){              //O(V)        --> n-1 da ein Knoten schon entnommen werden musste
                    if (helper.get(i).getV() == v.getE().dest){
                        ref = helper.get(i);
                    }
                }
                if (helper.contains(ref)){
                    int alternative = currentNode.getWeight() + v.getE().weight;

                    if (alternative < ref.getWeight()){
                        ref.setWeight(alternative);
                        ref.setPredecessor(currentNode);
                    }
                }
            }



        }

        Collections.sort(ergebnisListe, new Comparator<DijkstraNode>() {            //O(1)
            @Override
            public int compare(DijkstraNode o1, DijkstraNode o2) {
                return o1.weight.compareTo(o2.weight);
            }
        });

        for (int i = 0; i<ergebnisListe.size(); i++){                                  //O(E)

            System.out.print(ergebnisListe.get(i).toString() + "      |      ");
        }



    }




}
