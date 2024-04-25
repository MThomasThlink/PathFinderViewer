
package com.thlink.pathfinderviewer.engines.entities;

import java.util.List;

public class WPath 
{
    public List<GraphNode> path;
    public Integer cost;

    public WPath (List<GraphNode> pList, Integer pCost) 
    {
        this.path = pList;
        this.cost = pCost;
    }

    static public String dumpWPaths (List<WPath> result)
    {
        WPath minCostWPAth = null, maxCostWPAth = null;
        WPath minStepsWPAth = null, maxStepsWPAth = null;
        StringBuilder sb = new StringBuilder();
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
            minCostWPAth = maxCostWPAth = minStepsWPAth = maxStepsWPAth = new WPath(null, null);
        }
        for (WPath wpath : result)
        {
            sb.append(String.format("[%4d][%4d][%4d] ", number, wpath.cost, wpath.path.size()));
            if (wpath.cost > maxCost)
            {
                maxCost = wpath.cost;
                maxCostWPAth = wpath;

            }
            if (wpath.cost < minCost)
            {
                minCost = wpath.cost;
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
            for (GraphNode node : wpath.path)
            {
                if (x < wpath.path.size()-1)
                    sb.append(String.format("%d,", node.value));
                else
                    sb.append(String.format("%d.", node.value));
                x++;
            }
            sb.append("\n");
            number++;
            //System.out.printf("\t V: %d. \n", set.getValue());
        }
        
        System.out.println(sb.toString());
        
        dumpWPAth("MinCost ", minCostWPAth);
        dumpWPAth("MaxCost ", maxCostWPAth);
        dumpWPAth("MinSteps", minStepsWPAth);
        dumpWPAth("MaxSteps", maxStepsWPAth);
        
        
        /*
        sb.append(String.format("MinCost = %d.\n", minCost));
        sb.append(String.format("MaxCost = %d.\n", maxCost));
        
        sb.append(String.format("maxSteps = %d.\n", maxSteps));
        sb.append(String.format("minSteps = %d.\n", minSteps));
        */
        
                
        
        return sb.toString();
        
    }
    
    static public String dumpWPAth (String pMsg, WPath path)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s [%3d][%3d]", pMsg, path.cost, path.path.size()));
        for (GraphNode node : path.path)
            sb.append(String.format("%d,", node.value));
        
        System.out.println(sb.toString());
                
        return sb.toString();
    }
}
