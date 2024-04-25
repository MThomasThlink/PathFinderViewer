
package com.thlink.pathfinderviewer.engines;

import com.thlink.pathfinderviewer.engines.entities.GraphNode;
import com.thlink.pathfinderviewer.engines.entities.WPath;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class GeneralGraphHelper {

    
    public void go ()
    {
        //GraphNode g = createFixedGraph();
      /*boolean[][] m = new boolean[][] { {false, false, false, false, false, false, false, false},
                                          {true, false, false, false, false, false, false, false},
                                          {true, false, false, false, false, false, false, false},
                                          {false, true, false, false, false, false, false, false},
                                          {false, true, false, false, false, false, false, false},
                                          {false, false, true, false, false, false, false, false},
                                          {false, false, false, false, false, true, false, false},
                                          {false, false, false, false, false, true, false, false},
                                        };
        GraphNode g = createGraphFromMatrix(m);*/
        
        GraphNode g = createMapGraphFromExcel();
        /*Set<GraphNode> visited = new HashSet<>();
        if (isThereCycle(g, visited))
        {
            System.out.println("Cycle!");
            dumpVisited(visited);
        }
        else
            System.out.println("No cycle!");*/
        
        GraphNode source = findNodeBasedOnValueCicleTolerant(g, 0, new int[1], new HashSet<GraphNode>());
        GraphNode target = findNodeBasedOnValueCicleTolerant(g, 2, new int[1], new HashSet<GraphNode>());
        
        if (source == null)
        {
            System.out.println("Could not find source.");
            return;
        }

        if (target == null)
        {
            System.out.println("Could not find target.");
            return;
        }

        
        /*System.out.println(
            "Following are all different paths from "
            + source + " to " + source);
        printAllPaths(source, target);*/
        
        //List<List<GraphNode>> result = findAllPaths(g, source, target);
        //dumpPaths(result);
        List<WPath> wpaths = findAllPathsWithWeights(source, target, null);
        WPath.dumpWPaths(wpaths);
    }

    private GraphNode createMapGraphFromExcel ()
    {
        /* Original: all inclusive
        int[][] array = new int[][] {
        { 0, 10 },{ 0, 1 },{ 10, 20 },{ 1, 2 },{ 20, 30 },{ 2, 3 },{ 30, 40 },{ 3, 4 },{ 4, 5 },{ 11, 1 },{ 5, 6 },{ 21, 11 },{ 6, 7 },{ 31, 21 },{ 7, 8 },{ 41, 31 },{ 8, 9 },{ 2, 12 },
        { 12, 22 },{ 1, 0 },{ 22, 32 },{ 2, 1 },{ 32, 42 },{ 3, 2 },{ 4, 3 },{ 13, 3 },{ 5, 4 },{ 23, 13 },{ 6, 5 },{ 33, 23 },{ 7, 6 },{ 43, 33 },{ 8, 7 },{ 9, 8 },{ 4, 14 },{ 14, 24 },{ 20, 21 },
        { 24, 34 },{ 21, 22 },{ 34, 44 },{ 22, 23 },{ 23, 24 },{ 15, 5 },{ 24, 25 },{ 25, 15 },{ 25, 26 },{ 35, 25 },{ 26, 27 },{ 45, 35 },{ 27, 28 },{ 28, 29 },{ 6, 16 },{ 16, 26 },{ 26, 36 },{ 31, 30 },
        { 36, 46 },{ 32, 31 },{ 33, 32 },{ 17, 7 },{ 34, 33 },{ 27, 17 },{ 35, 34 },{ 37, 27 },{ 36, 35 },{ 47, 37 },{ 37, 36 },{ 38, 37 },{ 8, 18 },{ 39, 38 },{ 18, 28 },{ 28, 38 },{ 40, 41 },{ 38, 48 },{ 41, 42 },
        { 42, 43 },{ 19, 9 },{ 43, 44 },{ 29, 19 },{ 44, 45 },{ 39, 29 },{ 45, 46 },{ 49, 39 },{ 46, 47 },{ 47, 48 },{ 48, 49 },
        };*/
        
        //Retira alguns nós: { 20, 30 } e { 31, 30 }
        int[][] array = new int[][] {
        { 0, 10 },{ 0, 1 },{ 10, 20 },{ 1, 2 },{ 20, 30 },{ 2, 3 },{ 30, 40 },{ 3, 4 },{ 4, 5 },{ 11, 1 },{ 5, 6 },{ 21, 11 },{ 6, 7 },{ 31, 21 },{ 7, 8 },{ 41, 31 },{ 8, 9 },{ 2, 12 },
        { 12, 22 },{ 1, 0 },{ 22, 32 },{ 2, 1 },{ 32, 42 },{ 3, 2 },{ 4, 3 },{ 13, 3 },{ 5, 4 },{ 23, 13 },{ 6, 5 },{ 33, 23 },{ 7, 6 },{ 43, 33 },{ 8, 7 },{ 9, 8 },{ 4, 14 },{ 14, 24 },{ 20, 21 },
        { 24, 34 },{ 21, 22 },{ 34, 44 },{ 22, 23 },{ 23, 24 },{ 15, 5 },{ 24, 25 },{ 25, 15 },{ 25, 26 },{ 35, 25 },{ 26, 27 },{ 45, 35 },{ 27, 28 },{ 28, 29 },{ 6, 16 },{ 16, 26 },{ 26, 36 },/*{ 31, 30 },*/
        { 36, 46 },{ 32, 31 },{ 33, 32 },{ 17, 7 },{ 34, 33 },{ 27, 17 },{ 35, 34 },{ 37, 27 },{ 36, 35 },{ 47, 37 },{ 37, 36 },{ 38, 37 },{ 8, 18 },{ 39, 38 },{ 18, 28 },{ 28, 38 },{ 40, 41 },{ 38, 48 },{ 41, 42 },
        { 42, 43 },{ 19, 9 },{ 43, 44 },{ 29, 19 },{ 44, 45 },{ 39, 29 },{ 45, 46 },{ 49, 39 },{ 46, 47 },{ 47, 48 },{ 48, 49 },
        };
        
        return createGraphFromMatrix(array);
    }            
    private GraphNode createFixedGraph ()
    {
        /*int[][] array = new int[][] { { 1,2,1 }, { 1,3,10 },
                                      { 2,4,1 }, { 2,5,10 }, { 5,6,1 },
                                      { 2,7,1 }, { 7,8,1 }, { 8,9,1 }, { 7,10,1 }, { 10 ,6,1 },
                                      { 3,6,1 },
                                      { 10,11,1 }, { 11,12,1 }, { 12,13,1 }, { 12,14,1 }, { 14,6,1 },
                                      { 9,15,1 }, { 15,16,1 }, { 15,17,1 }, { 17,10,1 },
                                      { 1,30,100 }, { 30,16,100 },
                                      { 8,20,1 },{ 8,21,1 }, { 21,22,1 },{ 22,23,1 }, { 23,24,1 }, { 24,17,100 },     
                                    };*/
        
        int[][] array = new int[][] { {1,2,1}, {1,3,10},
                                      {2,4,1}, {2,5,10}, {5,6,1}, {3,6,1},
                                      {4,10,1}, {10,3,1}, {3,2,1}
                                    };
        GraphNode g = null;
        HashMap<Integer, GraphNode> hm = new HashMap<>();
        for (int[] pair : array)
        {
            GraphNode g1 = new GraphNode(pair[0]);
            GraphNode g2 = new GraphNode(pair[1]);
            hm.put(pair[0], g1);
            hm.put(pair[1], g2);
        }
      //System.out.println("hm.size = " + hm.size());
        for (int[] pair : array)
        {
            GraphNode g1 = hm.get(pair[0]);
            GraphNode g2 = hm.get(pair[1]);
            if (g == null)
                g = g1;
            g2.weight = pair[2];
            g1.addEdge(g2);
        }
      //System.out.printf("Number of nodes: %d. \n", countNumberOfNodes(g, new HashSet<>(), new int[1]));
        return g;
    }
    
    public GraphNode createGraphFromMatrix (int [][] array)
    {
        GraphNode g = null;
        HashMap<Integer, GraphNode> hm = new HashMap<>();
        for (int[] pair : array)
        {
            GraphNode g1 = new GraphNode(pair[0]);
            GraphNode g2 = new GraphNode(pair[1]);
            hm.put(pair[0], g1);
            hm.put(pair[1], g2);
        }
        System.out.println("hm.size = " + hm.size());
        for (int[] pair : array)
        {
            GraphNode g1 = hm.get(pair[0]);
            GraphNode g2 = hm.get(pair[1]);
            if (g == null)
                g = g1;
            if (pair.length == 3)
                g2.weight = pair[2];
            g1.addEdge(g2);
        }
        System.out.printf("Number of nodes: %d. \n", countNumberOfNodes(g, new HashSet<>(), new int[1]));
        return g;
    }

    private GraphNode createGraphFromMatrix (boolean [][] m)
    {
        int size = m.length;
        GraphNode root = null;
        GraphNode[] g = new GraphNode[size];
        for (int col = 0; col < size; col++)
            g[col] = new GraphNode(col);
        
        for (int col = 0; col < size; col++)
        {
            for (int row = 0; row < size; row++)
            {
                if (m[row][col])
                {
                    if (root == null)
                    {
                        root = g[col];
                    }
                    g[col].addEdge(g[row]);
                }
            }
        }
        return root;
    }
    
            
    private GraphNode findNodeBasedOnValue (GraphNode node, int pVal, int[] deep)
    {
        deep[0]++;
        if (node.value == pVal)
            return node;
        for (GraphNode child : node.neighbors)
        {
            GraphNode x = findNodeBasedOnValue(child, pVal, deep);
            if (x != null)
                return x;
        }
        return null;
    }
    
    public GraphNode findNodeBasedOnValueCicleTolerant (GraphNode node, int pVal, int[] deep, Set<GraphNode> visited)
    {
      //System.out.printf("findNodeBasedOnValueCicleTolerant(node:%d - %d)\n", node.value, pVal);
        deep[0]++;
        if (visited.contains(node))
            return null;
        if (node.value == pVal)
            return node;
        visited.add(node);
        for (GraphNode child : node.neighbors)
        {
            GraphNode x = findNodeBasedOnValueCicleTolerant(child, pVal, deep, visited);
            if (x != null)
                return x;
        }
        return null;
    }

    private boolean isThereCycle (GraphNode node, Set<GraphNode> set)
    {
        if (set.contains(node))
        {
            System.out.println("Been here before: " + node);
            return true;
        }
      //System.out.println("1st time here: " + node);
        set.add(node);
        for (GraphNode child : node.neighbors)
        {
            if (isThereCycle(child, set))
                return true;
        }
      //System.out.println("Children is over: " + node);
        set.remove(node);
        return false;
    }
    
    private int countNumberOfNodes (GraphNode node, Set<GraphNode> set, int[] count)
    {
        if (!set.contains(node))
        {
            set.add(node);
            count[0]++;
          //System.out.printf("Inc for1 %d: %d. \n", node.value, count[0]);
            for (GraphNode child : node.neighbors)
            {
                countNumberOfNodes(child, set, count);
            }
            return count[0];
        }
        return 0;
    }

    private String dumpPaths (List<List<GraphNode>> result)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Number of paths: ").append(result.size()).append(".\n");

        int number = 0;
        for (List<GraphNode> list : result)
        {
            sb.append(String.format("[%2d] ", number));
            int x = 0;
            for (GraphNode node : list)
            {
                if (x < list.size()-1)
                    sb.append(String.format("%d,", node.value));
                else
                    sb.append(String.format("%d", node.value));
                x++;
            }
            sb.append("\n");
            number++;
            //System.out.printf("\t V: %d. \n", set.getValue());
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
    
    private void dumpVisited(Set<GraphNode> visited)
    {
        System.out.println("Dump visited: ");
        for (GraphNode node : visited)
            System.out.printf("%d ", node.value);
        System.out.println("");
    }
    
   
    
    
    public List<WPath> findAllPathsWithWeights (GraphNode source, GraphNode target, Integer maxDepth)
    {
        Set<GraphNode> isVisited = new HashSet<>();
        List<GraphNode> lPathList = new ArrayList<>();
        List<WPath> gWPathList = new ArrayList<>();
 
        lPathList.add(source);
 
        findAllPathsWithWeightsRec(source, target, isVisited, lPathList, gWPathList, new int[1], maxDepth);
        return gWPathList;
    }
    
    private void findAllPathsWithWeightsRec (GraphNode source, GraphNode target, 
                                             Set<GraphNode>  isVisited,
                                             List<GraphNode> localPathList, 
                                             List<WPath> wPathList, 
                                             int[] acc, Integer maxDepth)
    {
      //System.out.println("findAllPathsWithWeightsRec " + source.value);
        if (source.value == target.value)
        {
            //dont forget to break the link localPathList because its value is going to change but it should remain the same in wPathList
          //System.out.println("findAllPathsWithWeightsRec " + isVisited.size());
            wPathList.add(new WPath(new ArrayList<>(localPathList), acc[0]));
            return;
        }
        isVisited.add(source);
        if (maxDepth != null && isVisited.size() > maxDepth)
        {
            System.out.println("Too big.");
            return;
        }
        for (GraphNode i : source.neighbors) 
        {
            if (!isVisited.contains(i)) 
            {
                localPathList.add(i);
                acc[0] += i.weight;
                findAllPathsWithWeightsRec(i, target, isVisited, localPathList, wPathList, acc, maxDepth);
                //if (wPathList.size() >= 1) por aqui retorna o primeiro, que não necessariamente é o melhor.
                //    return;
                localPathList.remove(i);
                acc[0] -= i.weight;
            }
        }
        isVisited.remove(source);
    }
    //Function that retrieves allPaths. This function is called only once but calls a helper that calls itself reccursively.
    private List<List<GraphNode>> findAllPaths (GraphNode graph, GraphNode source, GraphNode target)
    {
        Set<GraphNode> isVisited = new HashSet<>();
        List<GraphNode> lPathList = new ArrayList<>();
        List<List<GraphNode>> gPathList = new ArrayList<>();
 
        // add source to path[]
        lPathList.add(source);
 
        // Call recursive utility
        findAllPathsUtil (source, target, isVisited, lPathList, gPathList);
        return gPathList;
        
    }
    
    private void findAllPathsUtil (//GraphNode graph, 
                                   GraphNode source, GraphNode target, 
                                   Set<GraphNode>  isVisited,
                                   List<GraphNode> localPathList, 
                                   List<List<GraphNode>> globalPathList)
    {
        if (source.value == target.value)
        {
            globalPathList.add(new ArrayList<>(localPathList));
            return;
        }
        isVisited.add(source);
        for (GraphNode i : source.neighbors) 
        {
            if (!isVisited.contains(i)) 
            {
                localPathList.add(i);
                findAllPathsUtil(i, target, isVisited, localPathList, globalPathList);
 
                localPathList.remove(i);
            }
        }
        isVisited.remove(source);
    }
    
    //Copied functions
    private void printAllPathsUtil (GraphNode u, GraphNode d,
                                   Set<GraphNode>  isVisited,
                                   List<GraphNode> localPathList)
    {
 
        if (u.equals(d)) 
        {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            return;
        }
 
        // Mark the current node
        isVisited.add(u);
 
        // Recur for all the vertices
        // adjacent to current vertex
        for (GraphNode i : u.neighbors) 
        {
            if (!isVisited.contains(i)) 
            {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
 
                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }
 
        // Mark the current node
        isVisited.remove(u);
    }
    
    public void printAllPaths (GraphNode s, GraphNode d)
    {
        //boolean[] isVisited = new boolean[v];
        Set<GraphNode> isVisited = new HashSet<>();
        ArrayList<GraphNode> pathList = new ArrayList<>();
 
        // add source to path[]
        pathList.add(s);
 
        // Call recursive utility
        printAllPathsUtil (s, d, isVisited, pathList);
    }
    
}
