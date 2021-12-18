package com.hosthans.Graph;

public class Node {
    Edge e;
    Vertex dest;

    public Node(Edge e, Vertex v){
        this.e = e;
        this.dest = v;
    }

    public String toString(){
        return this.dest.getLabel() + "(" + this.e.getWeight() + ")";
    }

    public Edge getE(){
        return this.e;
    }
}
