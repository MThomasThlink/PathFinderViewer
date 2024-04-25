
package com.thlink.pathfinderviewer.engines.entities;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public int value, weight;
    public List<GraphNode> neighbors;

    public GraphNode(int value) 
    {
        this.value = value;
        this.weight = 1;
        this.neighbors = new ArrayList<>();
    }
    public GraphNode (int value, int weight) 
    {
        this.value = value;
        this.weight = weight;
        neighbors = new ArrayList<>();
    }
    @Override
    public String toString ()
    {
        String s = String.format("V: %d, w - %d, qtdNeig: %d. ", this.value, this.weight, this.neighbors.size()); 
        if (!this.neighbors.isEmpty())
        {
            s = s.concat("[");
            for(int i = 0; i < this.neighbors.size(); i++)
                s = s.concat(String.format("%d, ", this.neighbors.get(i).value));
            s = s.concat("]");
        }
        return s;
    }
    public void addEdge (GraphNode to) 
    {
        this.neighbors.add(to);
        //System.out.printf("addEdge(from '%d' to '%d'. \n", this.value, to.value);
        //Add this for undirected graphs
        //to.neighbors.add(this);

    }
    public void addNode (GraphNode to) 
    {
        this.neighbors.add(0, to);
    }
}
