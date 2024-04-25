
package com.thlink.pathfinderviewer.engines;

import com.thlink.pathfinderviewer.engines.entities.GraphNode;
import com.thlink.pathfinderviewer.engines.entities.NodeDist;
import com.thlink.pathfinderviewer.engines.entities.WPath;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {
    public WPath findShortestPathWithBFS (GraphNode source, GraphNode target)
    {
        int queueMaxSize = 0;
        Set<GraphNode> visited = new HashSet<>();
        Queue<NodeDist> queue = new LinkedList<>();
        List<GraphNode> list0 = new ArrayList<>();
        list0.add(source);
        Set<Integer> set0 = new HashSet<>();
        set0.add(source.value);
        queue.add(new NodeDist(source, 0, list0, set0));
        int loops = 0;
        long tIni = Calendar.getInstance().getTimeInMillis();
        while (!queue.isEmpty())
        {
            NodeDist n = queue.poll();
            if (n.node.equals(target))
            {
              //dumpPath(source, target, n);
                WPath result = new WPath(new ArrayList<>(), 0);
                for (GraphNode node : n.path)
                    result.path.add(node);
                System.out.printf("[%4dms] Final loops = %d. queueMaxSize = %d. \n", Calendar.getInstance().getTimeInMillis() - tIni,
                                                                                     loops, queueMaxSize);
                return result;
            }
            
            for (GraphNode child : n.node.neighbors)
            {
                if (!visited.contains(child))
                {
                    loops++;
                    if (loops % 10000 == 0)
                        System.out.println("loops = " + loops);
                    NodeDist newNode = new NodeDist(child, n.level+1, n.path, n.numPath);
                    newNode.path.add(child);
                    queue.add(newNode);
                    queueMaxSize = Math.max(queueMaxSize, queue.size());
                    visited.add(n.node);
                }
            }
        }
        return null;
    }
    
    public List<WPath> findNShortestPathWithBFS (GraphNode source, GraphNode target, int number)
    {
        List<WPath> listWPath = new ArrayList<>();
        int queueMaxSize = 0;
      //Set<GraphNode> visited = new HashSet<>();
        Queue<NodeDist> queue = new LinkedList<>();
        List<GraphNode> list0 = new ArrayList<>();
        list0.add(source);
        Set<Integer> set0 = new HashSet<>();
        set0.add(source.value);
        queue.add(new NodeDist(source, 0, list0, set0));
        int loops = 0;
        long tIni = Calendar.getInstance().getTimeInMillis();
        while (!queue.isEmpty())
        {
            NodeDist n = queue.poll();
            if (n.node.equals(target))
            {
                WPath result = new WPath(new ArrayList<>(), 0);
                for (GraphNode node : n.path)
                    result.path.add(node);
                System.out.printf("[%4dms] Final loops = %d. queueMaxSize = %d. \n", Calendar.getInstance().getTimeInMillis() - tIni,
                                                                                     loops, queueMaxSize);
                listWPath.add(result);
                WPath.dumpWPAth("R ", result);
                if (listWPath.size() == number)
                    return listWPath;
                continue;
            }
            
            for (GraphNode child : n.node.neighbors)
            {
                //if (!visited.contains(child))
                if (!n.numPath.contains(child.value))
                {
                    loops++;
                    if (loops % 10000 == 0)
                        System.out.println("loops = " + loops);
                    NodeDist newNode = new NodeDist(child, n.level+1, n.path, n.numPath);
                    newNode.path.add(child);
                    newNode.numPath.add(child.value);

                    queue.add(newNode);
                    queueMaxSize = Math.max(queueMaxSize, queue.size());
                  //visited.add(n.node);
                }
                //else
                //    System.out.println("Been there. No backsies. child = " + child + " and n = " + n);
            }
        }
        return null;
    }
    
}
