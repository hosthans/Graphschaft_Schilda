package com.hosthans.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_notCapacitive {
    public Map<Vertex, List<Node>> graph = new HashMap<>();
    public Map<String, Vertex> Knoten = new HashMap<>();

    Integer nodecount = 0;

    public boolean isbidirectional;
    public boolean isweighted;



    public Graph_notCapacitive(Boolean isbidirectional, Boolean isweighted) throws IOException {
        this.isbidirectional = isbidirectional;
        this.isweighted = isweighted;
        createGraph();
    }




    public void createGraph() throws IOException {

        //Knotenanzahl eingeben
        System.out.println("Wie viele Knoten soll der Graph_notCapacitive haben?");
        Scanner scanner = new Scanner(System.in);
        //Zur Knotrolle Anzahl ausgeben
        this.nodecount = scanner.nextInt();
        System.out.println(this.nodecount);
        for (int i = 0; i<this.nodecount; i++){
            int j = i+1;
            System.out.println("Bitte gebe den Namen deines " + j + ". Knoten ein");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {

                String vertex = reader.readLine().toString();
                Vertex v = new Vertex(vertex);
                System.out.println(v);
                Knoten.putIfAbsent(vertex, v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Wie viele Kanten soll der Graph_notCapacitive besitzen?
        System.out.print("Wie viele Kanten soll der Graph_notCapacitive besitzten (genaue Anzahl)?_ ");
        Scanner scanner1 = new Scanner(System.in);
        Integer edgecount = scanner1.nextInt();
        if (this.isweighted){
            for (int i = 0; i<edgecount; i++){
                //Hier soll addEdge() ausgeführt werden
                System.out.print("Anfangsknoten: ");
                BufferedReader anfangsk = new BufferedReader(new InputStreamReader(System.in));
                String Anfangsknoten = anfangsk.readLine();

                System.out.print("Zielknoten: ");
                BufferedReader Zielkn = new BufferedReader(new InputStreamReader(System.in));
                String Zielknoten = anfangsk.readLine();


                System.out.print("Gewichtung: ");
                Scanner weightingscan = new Scanner(System.in);
                Integer weight = weightingscan.nextInt();


                addEdge(Knoten.get(Anfangsknoten), Knoten.get(Zielknoten), isbidirectional, weight);





            }
        } else {
            for (int i = 0; i<edgecount; i++){
                //Hier soll addEdge() ausgeführt werden
                System.out.print("Anfangsknoten: ");
                BufferedReader anfangsk = new BufferedReader(new InputStreamReader(System.in));
                String Anfangsknoten = anfangsk.readLine();

                System.out.print("Zielknoten: ");
                BufferedReader Zielkn = new BufferedReader(new InputStreamReader(System.in));
                String Zielknoten = anfangsk.readLine();


                Integer weight = null;


                addEdge(Knoten.get(Anfangsknoten), Knoten.get(Zielknoten), isbidirectional, weight);





            }
        }
    }



    private void addVertex(Vertex vertex) {
        graph.put(vertex, new LinkedList<Node>());
    }

    public void addEdge(Vertex source, Vertex destination, boolean biDirectional, Integer weight) throws IOException {
        //gewichtet
            //nur gebraucht wenn gerichtet
            Edge e = new Edge(source, destination, weight, null);
            //wenn ungerichtet
            Edge e2 = new Edge(destination, source, weight, null);

            Node n1 = new Node(e, destination);
            Node n2 = new Node(e2, source);
            if (!graph.containsKey(source)) {
                addVertex(source);
                System.out.println("Source from Edge:" + source);
            }

            if (!graph.containsKey(destination)) {
                addVertex(destination);
                System.out.println("Destination from Edge:" + destination);
            }



            if (!graph.get(source).contains(n1)){
                graph.get(source).add(n1);
            }


            if(biDirectional) {
                graph.get(destination).add(n2);
            }

    }

    public void addReverseEdge(Vertex v, Vertex dest){
        Edge e = new Edge(v, dest, 0, null);
        Node n = new Node(e, dest);

        graph.get(v).add(n);
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
        //Ausgabe gewichtete Graphen

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
