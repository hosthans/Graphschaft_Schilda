package com.hosthans.Graph;

public class Edge {
    public Vertex src;
    public Vertex dest;
    public Integer weight;
    public Integer capacity;

    public Edge(Vertex src, Vertex dest, Integer weight, Integer capacity){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
        this.capacity = capacity;
    }

    public String getDest(){
        return this.dest.getLabel();
    }

    public Integer getWeight(){
        return this.weight;
    }

    public Integer getCapacity(){
        return this.capacity;
    }
}
