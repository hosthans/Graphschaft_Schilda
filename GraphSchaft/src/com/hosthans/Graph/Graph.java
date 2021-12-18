package com.hosthans.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph {
    public Map<Vertex, List<Node>> graph = new HashMap<>();
    public Map<String, Vertex> Knoten = new HashMap<>();

    Integer nodecount = 0;

    public boolean isbidirectional;
    public boolean isweighted;
    public boolean iscapacitive;


    public Graph(Boolean isbidirectional, Boolean isweighted, Boolean iscapacitive) throws IOException {
        this.isbidirectional = isbidirectional;
        this.isweighted = isweighted;
        this.iscapacitive = iscapacitive;
        if (this.iscapacitive && !this.isbidirectional && !this.isweighted){
            Fluss();
        } else if (!this.iscapacitive){
            keinFluss();
        } else {
            System.out.println("Fail");
        }
    }

    public void Fluss() throws IOException {
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
        final String ANSI_YELLOW = "\u001B[33m";
        //Wie viele Kanten soll der Graph besitzen?
        System.out.print("Wie viele Kanten soll der Graph besitzten (genaue Anzahl)?_ " + ANSI_YELLOW + " (!betrachte: muss gerichtet sein!)");
        Scanner scanner1 = new Scanner(System.in);
        Integer edgecount = scanner1.nextInt();
        for (int i = 0; i<edgecount; i++){
            //Hier soll addEdge() ausgeführt werden
            System.out.print("Anfangsknoten: ");
            BufferedReader anfangsk = new BufferedReader(new InputStreamReader(System.in));
            String Anfangsknoten = anfangsk.readLine();

            System.out.print("Zielknoten: ");
            BufferedReader Zielkn = new BufferedReader(new InputStreamReader(System.in));
            String Zielknoten = anfangsk.readLine();


            System.out.print("Gesamtkapazität: ");
            Scanner cap = new Scanner(System.in);
            Integer capa = cap.nextInt();

            System.out.print("Verbraucht: ");
            Scanner need = new Scanner(System.in);
            Integer needed = need.nextInt();


            addEdge(Knoten.get(Anfangsknoten), Knoten.get(Zielknoten),isbidirectional, needed, capa);





        }
    }

    public void keinFluss() throws IOException {

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


                addEdge(Knoten.get(Anfangsknoten), Knoten.get(Zielknoten), isbidirectional, weight, weight);





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


                addEdge(Knoten.get(Anfangsknoten), Knoten.get(Zielknoten), isbidirectional, weight, weight);





            }
        }
    }



    private void addVertex(Vertex vertex) {
        graph.put(vertex, new LinkedList<Node>());
    }

    public void addEdge(Vertex source, Vertex destination, boolean biDirectional, Integer weight, Integer capacity) throws IOException {
        //gewichtet
        if (isweighted){
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
            if(biDirectional) {
                graph.get(destination).add(n2);
            }

            //ungewichtet
        } else if (!isweighted && !iscapacitive){
            //nur gebraucht wenn gerichtet
            Edge e = new Edge(source, destination, null, null);
            //wenn ungerichtet
            Edge e2 = new Edge(destination, source, null, null);

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
            if(biDirectional) {
                graph.get(destination).add(n2);
            }
        }
        else if(iscapacitive && !isbidirectional){
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
            if(biDirectional) {
                graph.get(destination).add(n2);
            }
        }
        else {
            System.out.println("Fehler");
        }


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
        if (iscapacitive){
            StringBuilder builder = new StringBuilder();

            for (Vertex vertex : graph.keySet()){
                builder.append(vertex.getLabel() + " hat Kanten nach: ");
                for (Node node : graph.get(vertex)){
                    builder.append(node.e.dest.getLabel()+ " " + node.e.weight + "/" + node.e.capacity + "  ");
                }
                builder.append("\n");
            }
            return builder.toString();

        } else {
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




    }

    public Map<Vertex, List<Node>> getGraphMap(){
        return this.graph;
    }

    public List<Node> getNeighbors(Vertex v){
        return graph.get(v);
    }
}
