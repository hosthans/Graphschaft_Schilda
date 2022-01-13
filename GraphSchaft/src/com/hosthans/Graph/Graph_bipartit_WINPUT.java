package com.hosthans.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_bipartit_WINPUT {

    public Map<Vertex, List<Node>> graph = new HashMap<>();
    public Map<String, Vertex> Knoten = new HashMap<>();

    Vertex ungerade;

    Integer nodecount = 0;
    Integer leftcount = 0;
    Integer rightcount = 0;


    boolean hasedges;

    public boolean isbidirectional;
    public boolean isweighted;



    public Graph_bipartit_WINPUT(Boolean isbidirectional, Boolean isweighted) throws IOException {
        this.isbidirectional = isbidirectional;
        this.isweighted = isweighted;
        createGraph();

    }

    public void createGraph() throws IOException {
        //Knotenanzahl eingeben
        System.out.println("Wie viele Knoten existieren?");
        Scanner scanner = new Scanner(System.in);
        //Zur Knotrolle Anzahl ausgeben
        this.nodecount = scanner.nextInt();
        System.out.println(this.nodecount);
        System.out.print("Wie viele Knoten gehören der linken Gruppe des bipartiten Graphes an?");
        this.leftcount = scanner.nextInt();
        System.out.println("Es sollen also " + this.leftcount + " Knoten der linken Seite angehören!");
        for (int i = 0; i<this.leftcount; i++){
            int j = i+1;
            System.out.println("Bitte gebe den Namen deines " + j + ". Knoten der linken Seite ein");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {

                String vertex = reader.readLine().toString();
                Vertex v = new Vertex(vertex);
                v.setMembOfA();
                System.out.println(v);
                Knoten.putIfAbsent(vertex, v);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.rightcount = this.nodecount-this.leftcount;
        for (int i = 0; i<this.rightcount; i++){
            int j = i+1;
            System.out.println("Bitte gebe den Namen deines " + j + ". Knoten der rechten Seite ein");
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
        //Wie viele Kanten soll der Graph besitzen?
        System.out.print("Wie viele Kanten soll der Graph besitzten (genaue Anzahl)?");
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


                Integer weight = 1;


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


                Integer weight = 1;


                addEdge(Knoten.get(Anfangsknoten), Knoten.get(Zielknoten), isbidirectional, weight);





            }
        }
    }

    public void addReverseEdgeBipartite(Vertex v, Vertex dest){
        Edge e = new Edge(v, dest, 0, null);
        Node n = new Node(e, dest);

        graph.get(v).add(n);
    }

    public boolean hasNode(Vertex from, Vertex to){

        for (Node n:graph.get(from)){

            if (n.dest == to){
                return true;
            }

        }
        return false;
    }

    public Map<Vertex, List<Node>> getStartingList(){
        return graph;
    }

    public Map<String, Vertex> getKnoten(){
        return this.Knoten;
    }

    public void getVeriecesFromKnoten(){

    }

    public Vertex getVertex(String label){
        Vertex answer = null;
        if (this.Knoten.containsKey(label)){
            answer = this.Knoten.get(label);
        }
        return answer;
    }

    public void addVertex(Vertex vertex) {
        graph.put(vertex, new LinkedList<Node>());
        Knoten.put(vertex.getLabel(), vertex);
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
        n.setFlussedited(true);

        graph.get(v).add(n);
    }


    public boolean hasEdge(Vertex source, Vertex dest) {
        /*if(graph.get(source).contains(dest)) {
            System.out.println("Graph hat eine Kante zwischen " + source.getLabel() + " und " + dest.getLabel());
        }else {
            System.out.println("Graph hat keine Kante zwischen " + source.getLabel() + " und " + dest.getLabel());
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
            System.out.println("Graph beinhaltet " + v.getLabel() + " als ein Knoten");
        }else {
            System.out.println("Graph beinhaltet nicht " + v.getLabel() + " als ein Knoten");
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

    public List<Edge> getEdgeSet(){
        List<Edge> list = new ArrayList<>();
        for (Vertex v : graph.keySet()){
            for (Node n : graph.get(v)){
                list.add(n.getE());
            }
        }
        return list;
    }


    public void removeEdge(Vertex from, Vertex to, Node n){
        graph.get(from).remove(n);
        graph.get(to).remove(getReverseEdge(from, to));

    }

    public Node getReverseEdge(Vertex from, Vertex to){
        for (Node n : graph.get(to)){
            if (n.dest == from){
                return n;
            }
        }
        return null;
    }

    public Vertex getungeraden(){

        for (Vertex v : graph.keySet()){
            if (graph.get(v).size()%2 != 0){
                ungerade = v;
            }
        }
        return ungerade;
    }


    public boolean hasEdges(){

        int count = 0;
        for (Vertex v : graph.keySet()){
            count = count + graph.get(v).size();
        }
        if (count!=0){
            return true;
        }
        return true;
    }
}
