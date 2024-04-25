
package com.thlink.pathfinderviewer.graph;

import java.awt.Color;
import javax.swing.JPanel;

public class Graph 
{
    private int dimX, dimY;
    private JPanel home;
    private Nodes nodes;
    
    public boolean create (int pX, int pY, JPanel pHome)
    {
        dimX = pX;
        dimY = pY;
        home = pHome;
        int nodeSize = home.getWidth() / dimX;
        nodes = new Nodes(dimX, dimY, nodeSize);
        home.removeAll();
        home.add(nodes);
        return true;
    }
    public void clearNodes ()
    {
        nodes.clearNodes();
    }
    public void setMacroEdge (int pSourceId, int pTargetId, int pWeight)
    {
        setSource(getNodeById(pSourceId));
        setTarget(getNodeById(pTargetId));
        addEdge(pWeight);
    }
    public Node getNodeById (int pId)
    {
        return nodes.getNodeById(pId);
    }
    public void vanish (int id)
    {
        nodes.vanish(getNodeById(id));
    }
    public void vanish (Node n)
    {
        nodes.vanish(n);
    }
    public Node getSource ()
    {
        return nodes.getSource();
    }
    public Node getTarget ()
    {
        return nodes.getTarget();
    }
    
    public void setSource (int id)
    {
        nodes.setSource(getNodeById(id));
    }
    public void setSource (Node n)
    {
        nodes.setSource(n);
    }
    public void setTarget (int id)
    {
        nodes.setTarget(getNodeById(id));
    }
    public void setTarget (Node n)
    {
        nodes.setTarget(n);
    }
    public void drawBoard()
    {
        home.revalidate();
        home.repaint();
    }
    public void drawPath (NodeWeightPath path, Color color)
    {
        nodes.drawPath(path, color);
        home.revalidate();
        home.repaint();
    }
    
    public Node transformCoordinates (int pX, int pY)
    {
        return nodes.transformCoordinates(pX, pY);
    }
    public void addEdge (int weight)
    {
        nodes.addEdge(weight);
    }
}
