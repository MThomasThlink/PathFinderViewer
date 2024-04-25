
package com.thlink.pathfinderviewer.engines.entities;

import com.thlink.pathfinderviewer.graph.Node;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class NodePath {
    public Node node;
    public int level;
    public List<Node> path;
    public Set<Integer> numPath;
    public int cost;
    public NodePath (Node n, int level, List<Node> path, Set<Integer> numPath) 
    {
        this.node = n;
        this.level = level;
        this.path = new ArrayList<>(path);
        this.numPath = new HashSet<>(numPath);
    }
    
    public NodePath (Node n, int level, List<Node> path, Set<Integer> numPath, int pCost) 
    {
        this.node = n;
        this.level = level;
        this.path = new ArrayList<>(path);
        this.numPath = new HashSet<>(numPath);
        this.cost = pCost;
    }

    @Override
    public String toString ()
    {
        return String.format("[%d] %d", level, node.getId());
    }
    
        
}
