package com.hosthans.Algorithms.Paarzuweisung;

import com.hosthans.Graph.*;

import java.util.ArrayList;
import java.util.List;

public class maxFlowBipartite {

    Graph_bipartit graph;
    int numberleft = graph.getNumberofLeft();
    int numberright = graph.getNumberofRight();

    public maxFlowBipartite(Graph_bipartit graph){
        this.graph = graph;
    }

}
