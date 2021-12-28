package com.hosthans.Algorithms.Wasserleitung;

import com.hosthans.Graph.Node;
import com.hosthans.Graph.Vertex;

public class NodeWParent {
    Vertex vertex;
    Vertex parent;

    public NodeWParent(Vertex v){
        this.vertex = v;
        this.parent = null;
    }

    public Vertex getVertex(){
        return this.vertex;
    }

    public Vertex getParent(){
        return this.parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
}
