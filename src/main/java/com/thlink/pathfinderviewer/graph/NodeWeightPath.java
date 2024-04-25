
package com.thlink.pathfinderviewer.graph;

import java.util.List;

public class NodeWeightPath {
    public List<Node> path;
    public Integer totalCost;

    public NodeWeightPath (List<Node> pList, Integer pCost) 
    {
        this.path = pList;
        this.totalCost = pCost;
    }

    static public String dumpNodeWeightPaths (List<NodeWeightPath> result)
    {
        NodeWeightPath minCostWPAth = null, maxCostWPAth = null;
        NodeWeightPath minStepsWPAth = null, maxStepsWPAth = null;
        StringBuilder sb = new StringBuilder();
        if (result == null)
            return "--";
        sb.append("Number of paths: ").append(result.size()).append(".\n");                
        sb.append("[    ][Cost][stps] Nodes\n");

        int number = 0;
        int minCost = Integer.MAX_VALUE;
        int maxCost = Integer.MIN_VALUE;
        
        int minSteps = Integer.MAX_VALUE;
        int maxSteps = Integer.MIN_VALUE;
        
        if (result.isEmpty())
        {
            minCost = maxCost = minSteps = maxSteps = 0;
            minCostWPAth = maxCostWPAth = minStepsWPAth = maxStepsWPAth = new NodeWeightPath(null, null);
        }
        for (NodeWeightPath wpath : result)
        {
            sb.append(String.format("[%4d][%4d][%4d] ", number, wpath.totalCost, wpath.path.size()));
            if (wpath.totalCost > maxCost)
            {
                maxCost = wpath.totalCost;
                maxCostWPAth = wpath;

            }
            if (wpath.totalCost < minCost)
            {
                minCost = wpath.totalCost;
                minCostWPAth = wpath;
            }
            
            
            if (wpath.path.size() > maxSteps)
            {
                maxSteps = wpath.path.size();
                maxStepsWPAth = wpath;
            }
            if (wpath.path.size() < minSteps)
            {
                minSteps = wpath.path.size();
                minStepsWPAth = wpath;
            }
            
            int x = 0;
            for (Node node : wpath.path)
            {
                if (x < wpath.path.size()-1)
                    sb.append(String.format("%d,", node.getId()));
                else
                    sb.append(String.format("%d.", node.getId()));
                x++;
            }
            sb.append("\n");
            number++;
            //System.out.printf("\t V: %d. \n", set.getValue());
        }
        
        System.out.println(sb.toString());
        
        dumpNodeWeightPath("MinCost ", minCostWPAth);
        dumpNodeWeightPath("MaxCost ", maxCostWPAth);
        dumpNodeWeightPath("MinSteps", minStepsWPAth);
        dumpNodeWeightPath("MaxSteps", maxStepsWPAth);
        
        
        /*
        sb.append(String.format("MinCost = %d.\n", minCost));
        sb.append(String.format("MaxCost = %d.\n", maxCost));
        
        sb.append(String.format("maxSteps = %d.\n", maxSteps));
        sb.append(String.format("minSteps = %d.\n", minSteps));
        */

        return sb.toString(); 
    }
    
    static public String dumpNodeWeightPath (String pMsg, NodeWeightPath path)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s [%3d][%3d]", pMsg, path.totalCost, path.path.size()));
        for (Node node : path.path)
            sb.append(String.format("%d,", node.getId()));
        
        System.out.println(sb.toString());      
        return sb.toString();
    }
}
