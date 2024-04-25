
package com.thlink.pathfinderviewer.graph.engines;

import com.thlink.pathfinderviewer.engines.entities.NodePath;
import com.thlink.pathfinderviewer.graph.Node;
import com.thlink.pathfinderviewer.graph.NodeWeightPath;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphBFS 
{
    public NodeWeightPath findShortestPathWithBFS (Node source, Node target)
    {
        int queueMaxSize = 0;
        Set<Node> visited = new HashSet<>();
        Queue<NodePath> queue = new LinkedList<>();
        List<Node> list0 = new ArrayList<>();
        list0.add(source);
        Set<Integer> set0 = new HashSet<>();
        set0.add(source.getId());
        queue.add(new NodePath(source, 0, list0, set0));
        int loops = 0;
        long tIni = Calendar.getInstance().getTimeInMillis();
        while (!queue.isEmpty())
        {
            NodePath n = queue.poll();
            if (n.node.equals(target))
            {
              //dumpPath(source, target, n);
                NodeWeightPath result = new NodeWeightPath(new ArrayList<>(), 0);
                int cost= 0;
                for (Node node : n.path)
                {
                    result.path.add(node);
                    cost += node.getWeight();
                }
                result.totalCost = cost;
                System.out.printf("[%4dms] Final loops = %d. queueMaxSize = %d. \n", Calendar.getInstance().getTimeInMillis() - tIni,
                                                                                     loops, queueMaxSize);
                System.out.println("result.totalCost = " + result.totalCost);
                return result;
            }
            
            for (Node child : n.node.getNexts())
            {
                if (!visited.contains(child))
                {
                    loops++;
                    if (loops % 10000 == 0)
                        System.out.println("loops = " + loops);
                    NodePath newNode = new NodePath(child, n.level+1, n.path, n.numPath);
                    newNode.path.add(child);
                    queue.add(newNode);
                    queueMaxSize = Math.max(queueMaxSize, queue.size());
                    visited.add(n.node);
                }
            }
        }
        return null;
    }
    
    public List<NodeWeightPath> findNShortestPathWithBFS (Node source, Node target, int number)
    {
        List<NodeWeightPath> listWPath = new ArrayList<>();
        int queueMaxSize = 0;
      //Set<GraphNode> visited = new HashSet<>();
        Queue<NodePath> queue = new LinkedList<>();
        List<Node> list0 = new ArrayList<>();
        list0.add(source);
        Set<Integer> set0 = new HashSet<>();
        set0.add(source.getId());
        queue.add(new NodePath(source, 0, list0, set0, source.getWeight()));
        int loops = 0;
        long tIni = Calendar.getInstance().getTimeInMillis();
        while (!queue.isEmpty())
        {
            NodePath n = queue.poll();
            if (n.node.equals(target))
            {
                NodeWeightPath result = new NodeWeightPath(new ArrayList<>(), 0);
                int cost = 0;
                for (Node node : n.path)
                {
                    result.path.add(node);
                    cost += node.getWeight();
                }
                result.totalCost = cost;
                System.out.printf("[%4dms] Final loops = %d. queueMaxSize = %d. \n", Calendar.getInstance().getTimeInMillis() - tIni,
                                                                                     loops, queueMaxSize);
                listWPath.add(result);
                NodeWeightPath.dumpNodeWeightPath("R ", result);
                if (listWPath.size() == number)
                    return listWPath;
                continue;
            }
            
            for (Node child : n.node.getNexts())
            {
                //if (!visited.contains(child))
                if (!n.numPath.contains(child.getId()))
                {
                    loops++;
                    if (loops % 10000 == 0)
                        System.out.println("loops = " + loops);
                    NodePath newNode = new NodePath(child, n.level+1, n.path, n.numPath, n.node.getWeight() + child.getWeight());
                    newNode.path.add(child);
                    
                    newNode.numPath.add(child.getId());

                    queue.add(newNode);
                    queueMaxSize = Math.max(queueMaxSize, queue.size());
                  //visited.add(n.node);
                }
                //else
                //    System.out.println("Been there. No backsies. child = " + child + " and n = " + n);
            }
        }
        return listWPath;
    }
    
}
