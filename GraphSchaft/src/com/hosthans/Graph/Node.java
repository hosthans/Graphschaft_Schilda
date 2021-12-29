package com.hosthans.Graph;

public class Node {
    Edge e;
    public Vertex dest;

    Boolean isreverse = false;

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

    public Vertex getDest(){
        return this.dest;
    }

    public Boolean getFlussedited(){
        return this.isreverse;
    }

    public void setFlussedited(Boolean l){
        this.isreverse = l;
    }
}
