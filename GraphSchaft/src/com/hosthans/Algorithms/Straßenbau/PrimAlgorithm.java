package com.hosthans.Algorithms.Straßenbau;

import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Graph_NOINPUT;
import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    final String ANSI_BLACK = "\u001B[30m";


    Graph g;
    Graph_NOINPUT gni;
    //Datentyp für die priorisierte Abarbeitung der Einträge
    PriorityQueue<QNode> priorityQueue = new PriorityQueue<>();
    //Hilfliste --> speichert alle Knoten zwischen (für Größe usw benötigt)
    List<QNode> Helper = new ArrayList<QNode>();
    List<QNode> visited = new ArrayList<>();

    public PrimAlgorithm(Graph g){
        this.g = g;
        doalgotithm();
    }

    public PrimAlgorithm(Graph_NOINPUT g){
        this.gni = g;
        doalgotithmwoutI();
    }

    public void doalgotithm(){
        int counter = 0;
        for (Vertex v : g.getGraphMap().keySet()) {
            //allen den maximalen (quasi unendlich für Integer) Wert geben
            QNode node = new QNode(v, Integer.MAX_VALUE);
            //Vorgänger (Predecessor) wird auf Null gesetzt
            node.setPredecessor(null);
            //Diesen Node in Helfer und Priorisoerte Warteschlange fügen
            priorityQueue.add(node);
            Helper.add(node);
        }
        //r.key - queue.peek.weight = 0
        priorityQueue.peek().weight=0;
        System.out.println(priorityQueue.peek());

        //während die Menge Q (priorityQueue) nicht leer ist
        while (!priorityQueue.isEmpty()) {
            //Counter für Iterationen
            counter++;

            System.out.println(counter + ". Durchlauf: " + priorityQueue);
            //Um die Priotitätswarteschlange sortieren zu können, müssen alle Elemente vorerst gelöscht, und wieder eingefügt werdem
            priorityQueue.clear();
            for (int i = 0; i < Helper.size(); i++) {
                priorityQueue.add(Helper.get(i));
            }
            //

            //Einen Node aus der Prioritätswarteschlange nehmen
            QNode u = priorityQueue.poll();
            visited.add(u);
            //Diesen in der Hilfliste entfernen
            Helper.remove(u);

            //in diese Liste alle Knoten, die mit Node u adjazent sind, einfügen
            List<Node> adjList = g.getNeighbors(u.getV());

            //durch alle Knoten der neuen Liste iterieren
            for (Node v : adjList) {
                QNode vReference = null;
                for (int i = 0; i < Helper.size(); i++) {
                    if (Helper.get(i).getV() == v.getE().dest) {
                        vReference = Helper.get(i);
                    }
                }

                //Key aktualisieren
                if (Helper.contains(vReference) && (v.getE().weight < vReference.weight)) {
                    vReference.setPredecessor(u);
                    vReference.setWeight(v.getE().weight);
                }
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        int lengthcounter = 0;
        for (int i = 0; i<this.visited.size(); i++){
            lengthcounter = lengthcounter + this.visited.get(i).weight;
            if (i < 1){
                System.out.println( ANSI_YELLOW + "Startknoten: " + visited.get(i).getV().getLabel().toString() + " " + visited.get(i).weight);
            } else {
                System.out.println(ANSI_YELLOW + visited.get(i).weight + " " + visited.get(i).v.getLabel().toString() + " ------ " + visited.get(i).predecessor.v.getLabel().toString());
            }
        }

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "Die Länge des MST beträgt: " + lengthcounter);





    }

    public void doalgotithmwoutI(){
        int counter = 0;
        for (Vertex v : gni.getGraphMap().keySet()) {
            //allen den maximalen (quasi unendlich für Integer) Wert geben
            QNode node = new QNode(v, Integer.MAX_VALUE);
            //Vorgänger (Predecessor) wird auf Null gesetzt
            node.setPredecessor(null);
            //Diesen Node in Helfer und Priorisoerte Warteschlange fügen
            priorityQueue.add(node);
            Helper.add(node);
        }
        //r.key - queue.peek.weight = 0
        priorityQueue.peek().weight=0;
        System.out.println(priorityQueue.peek());

        //während die Menge Q (priorityQueue) nicht leer ist
        while (!priorityQueue.isEmpty()) {
            //Counter für Iterationen
            counter++;

            System.out.println(counter + ". Durchlauf: " + priorityQueue);
            //Um die Priotitätswarteschlange sortieren zu können, müssen alle Elemente vorerst gelöscht, und wieder eingefügt werdem
            priorityQueue.clear();
            for (int i = 0; i < Helper.size(); i++) {
                priorityQueue.add(Helper.get(i));
            }
            //

            //Einen Node aus der Prioritätswarteschlange nehmen
            QNode u = priorityQueue.poll();
            visited.add(u);
            //Diesen in der Hilfliste entfernen
            Helper.remove(u);

            //in diese Liste alle Knoten, die mit Node u adjazent sind, einfügen
            List<Node> adjList = gni.getNeighbors(u.getV());

            //durch alle Knoten der neuen Liste iterieren
            for (Node v : adjList) {
                QNode vReference = null;
                for (int i = 0; i < Helper.size(); i++) {
                    if (Helper.get(i).getV() == v.getE().dest) {
                        vReference = Helper.get(i);
                    }
                }

                //Key aktualisieren
                if (Helper.contains(vReference) && (v.getE().weight < vReference.weight)) {
                    vReference.setPredecessor(u);
                    vReference.setWeight(v.getE().weight);
                }
            }
        }

        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
        int lengthcounter = 0;
        for (int i = 0; i<this.visited.size(); i++){
            lengthcounter = lengthcounter + this.visited.get(i).weight;
            if (i < 1){
                System.out.println( ANSI_YELLOW + "Startknoten: " + visited.get(i).getV().getLabel().toString() + " " + visited.get(i).weight);
            } else {
                System.out.println(ANSI_YELLOW + visited.get(i).weight + " " + visited.get(i).v.getLabel().toString() + " ------ " + visited.get(i).predecessor.v.getLabel().toString());
            }
        }

        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + "Die Länge des MST beträgt: " + lengthcounter);





    }
}
