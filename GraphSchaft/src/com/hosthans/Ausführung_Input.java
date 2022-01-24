package com.hosthans;

import com.hosthans.Algorithms.Aufgabenpakete.MaxFlowInput;
import com.hosthans.Algorithms.Feuerwerk.Dijkstra;
import com.hosthans.Algorithms.Paarzuweisung.maxPairsInput;
import com.hosthans.Algorithms.Postbote.Hierholzer;
import com.hosthans.Algorithms.Straßenbau.PrimAlgorithm;
import com.hosthans.Graph.Graph;
import com.hosthans.Graph.Graph_bipartit_WINPUT;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ausführung_Input {

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_WHITE = "\u001B[37m";




    public static void main(String[] args) throws IOException {

        System.out.println("Das folgende Program stellt verschieden Funktionen dar, mittels welchen diverese Graphprobleme gelöst werden können!");
        System.out.println("Bitte wählen sie im folgenden eine bestimmte Funktion aus [Zahl angeben], mit der ihr Problem zu lösen ist");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(1) Straßennetz planen, bei dem möglichst wenig Kosten entstehen");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(2) Maximaler Fluss eines Netzes bestimmen - inkl. Validierung für vorgegebene Flussgröße");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(3) Explosionsreihenfolge eines Feuerwerks - basierend auf Zündschnurlänge");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(4) Auswahl von möglichen Partnern - basierend auf Interesse der Menschen zueinander");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(5) Kürzester Weg, bei dem jede Straße nur einmal abgelaufen werden muss" + ANSI_RED_BACKGROUND + "!Graph muss zusammenhängend sein und darf maximal 2 ungerade Knoten haben!");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(6) Maximaler Verkehrsfluss in Straßennetz - basierend auf maximalem Fluss jeder Straße");
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + "(7) Optimale Verteilung von Arbeitspakete an Mitarbeiter - basierend auf deren Kompetenzen");

        Scanner scanner = new Scanner(System.in);
        System.out.print(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "Bitte wählen Sie ein Problem, das gelöst werden soll: ");
        int selection = scanner.nextInt();

        switch (selection){
            case 1:
                System.out.println("1 wurde gewählt");
                startStraßenbau();
                break;
            case 2:
                System.out.println("2 wurde gewählt");
                startWasserleitung();
                break;
            case 3:
                System.out.println("3 wurde gewählt");
                startFeuerwerk();
                break;
            case 4:
                System.out.println("4 wurde gewählt");
                startPaarzuweisung();
                break;
            case 5:
                System.out.println("5 wurde gewählt");
                startPostbote();
                break;
            case 6:
                System.out.println("6 wurde gewählt");
                startStraßennetz();
                break;
            case 7:
                System.out.println("7 wurde gewählt");
                startAufgabenpakete();
                break;
            default:
                System.out.println(ANSI_RED_BACKGROUND + "Eingabe Fehlerhaft!");
                break;

        }

    }

    public static void startAufgabenpakete() throws IOException {
        Graph_bipartit_WINPUT graph = new Graph_bipartit_WINPUT(false, true);
        MaxFlowInput mf = new MaxFlowInput(graph, 0);
    }

    public static void startPaarzuweisung() throws IOException {
        Graph_bipartit_WINPUT graph = new Graph_bipartit_WINPUT(false, false);
        maxPairsInput mp = new maxPairsInput(graph);
    }

    public static void startFeuerwerk() throws IOException {
        String start;
        System.out.println("Übergabe Ihres Startknotens !!Muss Anfangsknoten des Graphen sein und muss im Graphen enthalten sein!!");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        start = br.readLine();
        Graph graph = new Graph(false, true, false);
        Dijkstra dijkstra = new Dijkstra(start, graph);
    }

    public static void startPostbote() throws IOException {
        Graph graph = new Graph(true, false, false);
        Hierholzer hierholzer = new Hierholzer(graph);
    }

    public static void startStraßenbau() throws IOException {
        Graph graph = new Graph(true, true, false);
        PrimAlgorithm prim = new PrimAlgorithm(graph);
    }

    public static void startStraßennetz() throws IOException {
        Graph graph = new Graph(false, true, false);
        com.hosthans.Algorithms.Straßennetz.MaxFlowInput maxFlowInput = new com.hosthans.Algorithms.Straßennetz.MaxFlowInput(graph.startK, graph.endK, graph, 0);
    }

    public static void startWasserleitung() throws IOException {
        Graph g = new Graph(false, true, true);
        com.hosthans.Algorithms.Wasserleitung.MaxFlowInput mf = new com.hosthans.Algorithms.Wasserleitung.MaxFlowInput(g.startK, g.endK, g, g.needed);

    }
}
