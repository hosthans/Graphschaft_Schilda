package com.hosthans.Algorithms.Paarzuweisung;

import com.hosthans.Algorithms.Aufgabenpakete.NodeWParent;
import com.hosthans.Graph.*;
import com.sun.jdi.request.VMDeathRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class maxFlowBipartite {

    Graph_bipartit graph;

    Vertex src = new Vertex("Source");
    Vertex dest = new Vertex("Destination");


    public maxFlowBipartite(Graph_bipartit graph) throws IOException {
        this.graph = graph;
        initialize();
        getErgebnis();
    }

    public void initialize() throws IOException {
        for (Vertex v : this.graph.graph.keySet()){
            if (v.getMember()){
                for (Node node : this.graph.graph.get(v)){
                    Node node1 = this.graph.getNode(v);
                    if (this.graph.graph.get(node.getDest()).contains(node1)){
                        int index = graph.graph.get(v).indexOf(node);
                        this.graph.graph.get(v).get(index).getE().weight = 2;
                        this.graph.graph.get(node.getDest()).remove(node1);
                    }
                }
            }

        }
        initialize2();
    }

    public void initialize2() throws IOException {
        for (Vertex v : this.graph.graph.keySet()){
            if (!v.getMember()){
                    for (int i = 0; i<this.graph.graph.get(v).size(); i++){
                        this.graph.graph.get(v).remove(i);
                    }
            } else if (v.getMember()){
                for (Node n : this.graph.graph.get(v)){
                    if (n.getE().weight < 2){
                        n.getE().weight = 0;
                    }
                }
            }
        }
        initialize3();
    }

    public void getGraph(){
        for (Vertex v : this.graph.graph.keySet()){
            System.out.print(v.getLabel() + ": ");
            for (Node n : this.graph.graph.get(v)){
                System.out.print(n.dest.getLabel() + "(" + n.getE().weight + ")");

            }
            System.out.println();
        }
    }



    //Algorithmus
    final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    final String ANSI_RED_BACKGROUND = "\u001B[41m";



    int maxFlow = 0;



    //erst initialisieren (hier mit residualgraph)
    public void initialize3() throws IOException {


        for (Vertex v : this.graph.graph.keySet()){
            for (Node n : this.graph.graph.get(v)){
                if (n.getE().weight != 0){
                    this.graph.addReverseEdge(n.getE().dest, v);
                }
            }
        }
        initizalize4();
    }
    List<Vertex> currentVertieces = new ArrayList<>();
    public void initizalize4() throws IOException {
        currentVertieces.addAll(this.graph.graph.keySet());
        for (Vertex v : currentVertieces){
            int counter = 0;
            for (int i = 0; i<this.graph.graph.get(v).size(); i++){
                if (this.graph.graph.get(v).get(i).getE().getWeight() == 2){
                    counter++;
                    Node current = this.graph.graph.get(v).get(i);
                    Node helper = this.graph.getNode(dest);
                    if (!this.graph.graph.get(current.dest).contains(helper)){
                        this.graph.addEdge(current.getDest(), dest, false, 2);
                    }
                }
            }
            if ((counter != 0) && v.getMember()){
                this.graph.addEdge(src, v, false, 2);
            }
        }
        getGraph();
        ford();

    }


    //nachdem PFad existiert --> erstellen
    public LinkedList<Vertex> PfadErstellenBreitensuche(Vertex Quelle, Vertex Senke){
        HashSet<Vertex> visited = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();
        LinkedList<NodeWParent> traversed = new LinkedList<>();

        visited.add(Quelle);
        queue.addLast(Quelle);
        traversed.add(new NodeWParent(Quelle));

        while (!queue.isEmpty()){
            Vertex current = queue.poll();

            for (Node n : graph.getNeighbors(current)){
                if ((!visited.contains(n.dest)) && (n.getE().getWeight() > 0)){
                    if (n.getDest().equals(Senke)){
                        traversed.add(new NodeWParent(n.getDest()));
                        traversed.getLast().setParent(current);
                        queue.clear();
                        break;
                    }
                    queue.addLast(n.getDest());
                    visited.add(n.getDest());
                    traversed.add(new NodeWParent(n.getDest()));
                    traversed.getLast().setParent(current);
                }
            }
        }

        return pfaduebergabe(traversed, Quelle, Senke);
    }

    public LinkedList<Vertex> pfaduebergabe(LinkedList<NodeWParent> currentList, Vertex Quelle, Vertex Senke){
        LinkedList<NodeWParent> list = new LinkedList<>();
        NodeWParent helper = null;
        for (NodeWParent node : currentList){
            if (node.getVertex().equals(Senke)){
                list.add(node);
            } else if (node.getVertex().equals(Quelle)){
                helper = node;
            }
        }

        while (!list.getLast().getParent().equals(Quelle)){
            for (NodeWParent node : currentList){
                if (node.getParent() != null){
                    if (list.getLast().getParent().equals(node.getVertex())){
                        list.add(node);
                    }
                }
            }

        }
        list.add(helper);

        LinkedList<Vertex> listRueckgabe = new LinkedList<>();
        for (NodeWParent node : list){
            listRueckgabe.addFirst(node.getVertex());
        }
        return listRueckgabe;
    }


    //Breitensuche
    public boolean PfadExistent(Vertex Quelle, Vertex Senke){
        HashSet<Vertex> visited = new HashSet<>();
        LinkedList<Vertex> queue = new LinkedList<>();
        LinkedList<NodeWParent> traversed = new LinkedList<>();

        visited.add(Quelle);
        queue.addLast(Quelle);
        traversed.add(new NodeWParent(Quelle));

        while (!queue.isEmpty()){
            Vertex current = queue.poll();

            for (Node n : graph.getNeighbors(current)){
                if ((!visited.contains(n.dest)) && (n.getE().getWeight() > 0)){
                    //wenn Knoten gleich Endknoten
                    if (n.dest.equals(Senke)){
                        traversed.add(new NodeWParent(n.dest));
                        traversed.getLast().setParent(current);
                        return true;
                    }
                    //Knoten == gesehen --> wird hinzugefügt um diesen in der Liste vorzufinden
                    queue.addLast(n.getDest());
                    visited.add(n.getDest());
                    traversed.add(new NodeWParent(n.getDest()));
                    traversed.getLast().setParent(current);
                }
            }
        }
        return false;
    }

    public int ford() throws IOException {

        while (PfadExistent(src, dest)){
            int flow = Integer.MAX_VALUE;
            LinkedList<Vertex> pfad = PfadErstellenBreitensuche(this.src, this.dest);
            int counter = 0;

            for (Vertex v : pfad) {
                LinkedList<Node> nodes = (LinkedList<Node>) graph.getNeighbors(v);
                // wir gehen alle knoten des paths bis auf den endknoten ab und speichern seine nachbarn
                // dann müssen wir den destination-Vertex vom aktuellen knoten vom path in der nodes liste finden
                // dann weisen wir restcapacity die minimale kantengewichtung zu
                //System.out.println(v + " - " + nodes);
                Vertex destVertex = pfad.get((pfad.indexOf(v)) + 1);
                for (Node n : nodes) {
                    if (n.getDest() == destVertex) {
                        if (n.getE().getWeight() < flow) {
                            flow = n.getE().getWeight();
                        }
                    }
                }
                // counter, damit für die Senke / Endknoten nicht mehr nach dem nachbar geschaut wird.
                counter++;
                if (counter == pfad.size()-1) {
                    // counter zurücksetzen auf 0
                    counter = 0;
                    break;
                }
            }

            for (Vertex v : pfad) {
                LinkedList<Node> nodes = (LinkedList<Node>) graph.getNeighbors(v);
                Vertex destVertex = pfad.get((pfad.indexOf(v)) + 1);
                for (Node n : nodes) {
                    if (n.getDest() == destVertex) {
                        n.getE().weight = n.getE().weight - flow;
                    }
                }

                //System.out.println(v + " - " + nodes);

                counter++;
                if (counter == pfad.size()-1) {
                    break;
                }
            }


            for (int i = pfad.size()-1; i > 0; i--) {

                Vertex v = pfad.get(i);

                // nachbarn von v
                LinkedList<Node> nodes = (LinkedList<Node>) graph.getNeighbors(v);
                Vertex destVertex = pfad.get((pfad.indexOf(v)) - 1);

                for (Node n : nodes) {
                    if (n.getDest() == destVertex) {
                        n.getE().weight = n.getE().weight + flow;
                    }
                }




            }

            this.maxFlow = this.maxFlow + flow;

        }

        System.out.println(this.maxFlow);
        return this.maxFlow;
    }

    public boolean GenugPlatz(int needed){
        if (this.maxFlow >= needed){
            return true;
        }else {
            return false;
        }
    }

    public void getErgebnis(){

        System.out.println(" Folgende Paare können heiraten: ");

        for (Vertex v : getFinalGraph().graph.keySet()){
            if (!v.getMember()){
                for (Node n : getFinalGraph().graph.get(v)){
                    if (n.getE().getWeight() > 0 && n.getDest().getLabel()!="Source" && n.getE().src.getLabel() != "Destination"){
                        System.out.println( ANSI_WHITE_BACKGROUND + ANSI_BLACK + "Mann " + n.getDest().getLabel() + " heiratet folgende Frau: " + v.getLabel());
                    }
                }
            }
        }
        System.out.println(ANSI_WHITE_BACKGROUND+"Somit hat jeder eine geile Frau die ihm gefällt");

        getGraph();
    }


    public Graph_bipartit getFinalGraph(){
        for (Vertex v : this.graph.graph.keySet()){
            //Alle Kanten, die keine Reversekanten sind - auslöschen
            //this.graph.graph.get(v).removeIf(n -> !n.getFlussedited());
            for (int i = 0; i<this.graph.graph.get(v).size(); i++){
                if (this.graph.graph.get(v).get(i).getE().weight != 2){
                    this.graph.graph.get(v).remove(i);
                }
            }
        }
        return this.graph;
    }


}
