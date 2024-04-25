
package com.thlink.pathfinderviewer.engines.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NodeDist 
{
    public GraphNode node;
    public int level;
    public List<GraphNode> path;
    public Set<Integer> numPath;
    public NodeDist (GraphNode n, int level, List<GraphNode> path, Set<Integer> numPath) 
    {
        this.node = n;
        this.level = level;
        this.path = new ArrayList<>(path);
        this.numPath = new HashSet<>(numPath);
    }

    @Override
    public String toString ()
    {
        return String.format("[%d] %d", level, node.value);
    }
}
