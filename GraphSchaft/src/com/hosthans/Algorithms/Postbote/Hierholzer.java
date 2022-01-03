package com.hosthans.Algorithms.Postbote;

import com.hosthans.Graph.Edge;
import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

import java.util.*;

public class Hierholzer {
    Graph graph;
    int EulerTest = 0;
    List<List<Vertex>> cyclesVertex = new LinkedList<>();
    List<List<Edge>> cyclesEdges = new LinkedList<>();
    Random random = new Random();

    List<Edge> eulercircuitedges = new ArrayList<>();
    List<Vertex> eulerCircuitVertieces = new ArrayList<>();

    public Hierholzer(Graph graph){
        this.graph = graph;
        checkEuler();
    }

    public void checkEuler(){
        for (Vertex v : graph.graph.keySet()){
            int ergebnis = graph.graph.get(v).size()%2;
            EulerTest = EulerTest+ergebnis;
        }
        if (EulerTest>0 && EulerTest<=2){
            EulerWeg();
            EulerWegBerechnen();
            promptResult();
        } else if (EulerTest == 0){
            Euler();
        } else {
            System.out.println("Fail");
        }

    }

    public void EulerWeg(){
        //System.out.println("Muss gemacht werden - nicht alle Knoten Geraden Grad");
            int counter = 0;
            //Zufallsknoten als Startknoten wählen (muss ungeraden Grad haben)

            Vertex start = graph.getungeraden();
            //Testausgabe
            System.out.println(start.getLabel());

            Vertex currentcycleStartAEnd = start;
            Vertex currentVertex = currentcycleStartAEnd;

            while (!graph.getEdgeSet().isEmpty()){
                LinkedList<Vertex> currentCycleNodes = new LinkedList<Vertex>();
                LinkedList<Edge> currentCycleEdges = new LinkedList<Edge>();
                do {

                    //aktuellen Knoten dem Zyklus hinzufügen
                    currentCycleNodes.add(currentVertex);


                    //Alle Kanten des Aktuellen Knotens ermitteln
                    List<Node> edges = graph.getNeighbors(currentVertex);


                    //falls keine Kante mehr vorhanden __> Graph nicht zusammenhängend
                /*if (edges.isEmpty()){
                    throw new IllegalArgumentException("graph muss zusammenhängend sein");
                }*/

                    //Zufälliger Kntoen aus Kantenliste
                    int randomNumber;
                    if (edges.size()>0){
                        randomNumber = new Random().nextInt(edges.size());
                    } else {
                        break;
                    }

                    Node n = edges.get(randomNumber);
                    Vertex from = n.getE().src;
                    Vertex to = n.getDest();
                    Edge nextEdge = n.getE();

                    //Kante dem Zyklus anhöngen
                    currentCycleEdges.add(nextEdge);

                    //Kante gesehen (löschen)
                    graph.removeEdge(from, to, n);

                    //nächsten Kntoen herausfinden
                    if (nextEdge.src != currentVertex){
                        currentVertex = nextEdge.src;
                    } else {
                        currentVertex = nextEdge.getDest();
                    }




                    //Geht solange bis Zyklus wieder am Startknoten ist


                    //wird benötigt, da Ergebnis sonst falsch (Bricht ab und fängt neuen Zyklus bei Startknoten an)
                } while (graph.hasEdges());
                //Brauch letzten JKnoten nicht hinzufügen, da dieser ja dem ersten entspricht


                currentCycleNodes.add(currentcycleStartAEnd);

                //Zyklus zu Zyklusliste adden
                this.cyclesVertex.add(currentCycleNodes);
                this.cyclesEdges.add(currentCycleEdges);

                //Durch alle Knoten iterieren, ob man noch Knoten mit Kanten hat, die nicht verwendet wurden
                if (!this.graph.getEdgeSet().isEmpty()){
                    for (Vertex v : graph.graph.keySet()){
                        if (graph.graph.get(v).size() > 0){
                            currentcycleStartAEnd = v;
                            currentVertex = currentcycleStartAEnd;
                            break;
                        }
                    }
                }
            }

    }

    public void EulerWegBerechnen(){
        System.out.println("EulerWeg");
        //erst ersten Zyklus hinzufügen
        this.eulerCircuitVertieces.addAll(this.cyclesVertex.get(0));
        eulercircuitedges.addAll(this.cyclesEdges.get(0));

        //alle anderen Zyklen hinzufügen
        for (int i  = 1; i<this.cyclesVertex.size(); i++){
            int index = this.eulerCircuitVertieces.indexOf(this.cyclesVertex.get(i).get(0));

            this.eulerCircuitVertieces.remove(index);
            this.eulerCircuitVertieces.addAll(index, this.cyclesVertex.get(i));

            this.eulercircuitedges.addAll(index, this.cyclesEdges.get(i));
        }
    }

    public void Euler(){
        System.out.println("Perfekt - alle  Knoten gerader Grad");
        //hier EulerAlgorithmus
        searchcyrcles();
        EulerKreisBerechnen();
        promptResult();

    }

    public void searchcyrcles(){

        //Zufallsknoten als Startknoten wählen
        Vertex[] list = graph.graph.keySet().toArray(new Vertex[0]);
        int randomIndex = new Random().nextInt(list.length);
        Vertex start = list[randomIndex];
        //Testausgabe
        System.out.println(start.getLabel());

        Vertex currentcycleStartAEnd = start;
        Vertex currentVertex = currentcycleStartAEnd;

        while (!graph.getEdgeSet().isEmpty()){
            LinkedList<Vertex> currentCycleNodes = new LinkedList<Vertex>();
            LinkedList<Edge> currentCycleEdges = new LinkedList<Edge>();
            do {

                //aktuellen Knoten dem Zyklus hinzufügen
                currentCycleNodes.add(currentVertex);


                //Alle Kanten des Aktuellen Knotens ermitteln
                List<Node> edges = graph.getNeighbors(currentVertex);


                //falls keine Kante mehr vorhanden __> Graph nicht zusammenhängend
                /*if (edges.isEmpty()){
                    throw new IllegalArgumentException("graph muss zusammenhängend sein");
                }*/

                //Zufälliger Kntoen aus Kantenliste
                int randomNumber = new Random().nextInt(edges.size());

                Node n = edges.get(randomNumber);
                Vertex from = n.getE().src;
                Vertex to = n.getDest();
                Edge nextEdge = n.getE();

                //Kante dem Zyklus anhöngen
                currentCycleEdges.add(nextEdge);

                //Kante gesehen (löschen)
                graph.removeEdge(from, to, n);

                //nächsten Kntoen herausfinden
                if (nextEdge.src != currentVertex){
                    currentVertex = nextEdge.src;
                } else {
                    currentVertex = nextEdge.getDest();
                }


                //Geht solange bis Zyklus wieder am Startknoten ist

            } while ( currentVertex != currentcycleStartAEnd);
            //Brauch letzten JKnoten nicht hinzufügen, da dieser ja dem ersten entspricht


            currentCycleNodes.add(currentcycleStartAEnd);

            //Zyklus zu Zyklusliste adden
            this.cyclesVertex.add(currentCycleNodes);
            this.cyclesEdges.add(currentCycleEdges);

            //Durch alle Knoten iterieren, ob man noch Knoten mit Kanten hat, die nicht verwendet wurden
            if (!this.graph.getEdgeSet().isEmpty()){
                for (Vertex v : graph.graph.keySet()){
                    if (graph.graph.get(v).size() > 0){
                        currentcycleStartAEnd = v;
                        currentVertex = currentcycleStartAEnd;
                        break;
                    }
                }
            }
        }
    }


    //Eulerkreis berechnen
    public void EulerKreisBerechnen(){
        System.out.println("Euler-Tour");
        //erst ersten Zyklus hinzufügen
        this.eulerCircuitVertieces.addAll(this.cyclesVertex.get(0));
        eulercircuitedges.addAll(this.cyclesEdges.get(0));

        //alle anderen Zyklen hinzufügen
        for (int i  = 1; i<this.cyclesVertex.size(); i++){
            int index = this.eulerCircuitVertieces.indexOf(this.cyclesVertex.get(i).get(0));

            //this.eulerCircuitVertieces.remove(index);
            this.eulerCircuitVertieces.addAll(index, this.cyclesVertex.get(i));

            this.eulercircuitedges.addAll(index, this.cyclesEdges.get(i));
        }
    }

    public void promptResult(){

        System.out.println("Finaler Weg: \t");
        for (int i = 0; i<eulercircuitedges.size(); i++){
            System.out.println(eulercircuitedges.get(i).src.getLabel() + " ---> " + eulercircuitedges.get(i).dest.getLabel());
        }
    }




}
