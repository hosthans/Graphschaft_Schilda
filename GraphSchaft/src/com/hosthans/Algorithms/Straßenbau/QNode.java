package com.hosthans.Algorithms.Straßenbau;

import com.hosthans.Graph.Vertex;

public class QNode implements Comparable<QNode>{
    Vertex v;
    Integer weight;
    QNode predecessor;

    public QNode(Vertex v, Integer weight){
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
    public QNode getPredecessor(){
        return this.predecessor;
    }

    public void setPredecessor(QNode qNode){
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
    public int compareTo(QNode o) {
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
