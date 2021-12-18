package com.hosthans.Graph;


public class Vertex {
    String label;
    Integer key = Integer.MAX_VALUE;

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
