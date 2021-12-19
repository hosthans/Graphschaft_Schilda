package com.hosthans.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_Capacitive {

    public Map<Vertex, List<Node>> graph = new HashMap<>();
    public Map<String, Vertex> Knoten = new HashMap<>();

    Integer nodecount = 0;

    public boolean isbidirectional;
    public boolean isweighted;



    public Graph_Capacitive() throws IOException {
        this.isbidirectional = false;
        this.isweighted = true;
        createGraph();
    }





    private void addVertex(Vertex vertex) {
        graph.put(vertex, new LinkedList<Node>());
    }

    public void addEdge(Vertex source, Vertex destination, boolean biDirectional, Integer weight, Integer capacity) throws IOException {


        //nur gebraucht wenn gerichtet
        Edge e = new Edge(source, destination, weight, capacity);
        //wenn ungerichtet
        Edge e2 = new Edge(destination, source, weight, capacity);

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

        graph.get(source).add(n1);
        if (biDirectional) {
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
        //Ausgabe gewichtete Graphen

            StringBuilder builder = new StringBuilder();

            for (Vertex vertex : graph.keySet()){
                builder.append(vertex.getLabel() + " hat Kanten nach: ");
                for (Node node : graph.get(vertex)){
                    builder.append(node.e.dest.getLabel()+ " " + node.e.weight + "/" + node.e.capacity + "  ");
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
        final String ANSI_YELLOW = "\u001B[33m";
        //Wie viele Kanten soll der Graph_notCapacitive besitzen?
        System.out.print("Wie viele Kanten soll der Graph_notCapacitive besitzten (genaue Anzahl)?_ " + ANSI_YELLOW + " (!betrachte: muss gerichtet sein!)");
        Scanner scanner1 = new Scanner(System.in);
        Integer edgecount = scanner1.nextInt();
        for (int i = 0; i<edgecount; i++){
            //Hier soll addEdge() ausgeführt werden
            System.out.print("Anfangsknoten: ");
            BufferedReader anfangsk = new BufferedReader(new InputStreamReader(System.in));
            String Anfangsknoten = anfangsk.readLine();

            System.out.print("Zielknoten: ");
            BufferedReader Zielkn = new BufferedReader(new InputStreamReader(System.in));
            String Zielknoten = Zielkn.readLine();


            System.out.print("Gesamtkapazität: ");
            Scanner cap = new Scanner(System.in);
            Integer capa = cap.nextInt();

            System.out.print("Verbraucht: ");
            Scanner need = new Scanner(System.in);
            Integer needed = need.nextInt();


            addEdge(Knoten.get(Anfangsknoten), Knoten.get(Zielknoten),isbidirectional, needed, capa);
        }
    }
}
