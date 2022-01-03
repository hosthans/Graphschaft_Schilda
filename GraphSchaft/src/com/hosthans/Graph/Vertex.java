package com.hosthans.Graph;


public class Vertex {
    String label;
    Integer key = Integer.MAX_VALUE;

    Boolean isMembOfA = false;

    Vertex predecessor;
    boolean isVisited;

    public void setMembOfA(){
        this.isMembOfA = true;
    }

    public void setMembOfB(){
        this.isMembOfA = false;
    }

    public boolean getMember(){
        return this.isMembOfA;
    }

    public void setVisited(boolean visited) {
        this.isVisited = visited;
    }

    public boolean isVisited(){
        return this.isVisited;
    }

    public void setPredecessor(Vertex v){
        this.predecessor = v;
    }

    public Vertex getPredecessor(){
        return this.predecessor;
    }

    public Vertex(String labelinput){
        this.label = labelinput;
    }

    public String getLabel(){
        return this.label;
    }

    public void setKey(Integer i){
        this.key = i;
    }

    public Integer getKey(){
        return this.key;
    }

}
