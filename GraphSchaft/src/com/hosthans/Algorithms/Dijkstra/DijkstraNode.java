package com.hosthans.Algorithms.Dijkstra;

import com.hosthans.Algorithms.PrimAlgorithm.QNode;
import com.hosthans.Graph.Vertex;

public class DijkstraNode implements Comparable<DijkstraNode>{

    Vertex v;
    Integer weight;
    DijkstraNode predecessor;

    public DijkstraNode(Vertex v, Integer weight){
        this.v = v;
        this.weight = weight;
    }

    //Weight
    public Integer getWeight(){
        return this.weight;
    }
    public void setWeight(Integer i){
        this.weight = i;
    }

    //Predecessor
    public DijkstraNode getPredecessor(){
        return this.predecessor;
    }

    public void setPredecessor(DijkstraNode qNode){
        this.predecessor = qNode;
    }

    //Vertex
    public Vertex getV(){
        return this.v;
    }

    public void setV(Vertex v){
        this.v = v;
    }

    @Override
    public int compareTo(DijkstraNode o) {
        if (weight<o.weight){
            return -1;
        } else if (weight>o.weight){
            return 1;
        }
        return 0;
    }

    public String toString(){
        return this.v.getLabel() + "(" + this.weight + ")";
    }
}
