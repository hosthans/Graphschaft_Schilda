package com.hosthans.Graph;

import com.hosthans.Algorithms.Wasserleitung.MaxFlowInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph {
    public Map<Vertex, List<Node>> graph = new HashMap<>();
    public Map<String, Vertex> Knoten = new HashMap<>();

    Vertex ungerade;
    public Vertex startK;
    public Vertex endK;

    Integer nodecount = 0;
    Integer edgecount = 0;

    public Integer needed = 0;


    boolean hasedges;

    public boolean isbidirectional;
    public boolean isweighted;



    public Graph(Boolean isbidirectional, Boolean isweighted) throws IOException {
        this.isbidirectional = isbidirectional;
        this.isweighted = isweighted;
        createGraph();
    }


    public Map<String, Vertex> getKnoten(){
        return this.Knoten;
    }

    public Vertex getSource(String name){
        return this.Knoten.get(name);
    }

    public Vertex getDestination(String name){
        return this.Knoten.get(name);
    }



    public void createGraph() throws IOException {

        //Knotenanzahl eingeben
        System.out.println("Wie viele Knoten soll der Graph haben?");
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
        //Wie viele Kanten soll der Graph besitzen?
        System.out.print("Wie viele Kanten soll der Graph besitzten (genaue Anzahl)?_ ");
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

        System.out.println("Willst du einen maximalen Fluss berechnen? [j/n]");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input.equals("j")){
            System.out.println("Bitte gebe den Startknoten des Graphen ein");
            BufferedReader start = new BufferedReader(new InputStreamReader(System.in));
            String startKString = start.readLine();
            this.startK = getSource(startKString);

            System.out.println("Bitte gebe den Zielknoten des Graphen ein");
            BufferedReader end = new BufferedReader(new InputStreamReader(System.in));
            String EndkString = end.readLine();
            this.endK = getDestination(EndkString);


            System.out.println("Wie viel Kapazität wird benötigt?");
            this.needed = scanner.nextInt();
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

    public Vertex getVertex(String label){
        if (this.Knoten.containsKey(label)){
            return this.Knoten.get(label);
        }
        return null;
    }

}
