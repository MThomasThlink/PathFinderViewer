
package com.thlink.pathfinderviewer.graph;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Node 
{
    private final int id;
    private final int posX,  posY;
    private int weight;
    private final List<Node> nexts;
    private Color mapColor, pathColor;
    private boolean bSource, bTarget, absent = false;
    
    public static final Color INITIAL_COLOR = Color.CYAN;
    
    public Node (int pId, int x, int y) 
    {
        this.id = pId;
        this.posX = x;
        this.posY = y;
        this.weight = 0;
        this.mapColor = INITIAL_COLOR;
        this.nexts = new ArrayList<>();
    }
    
    public Node (int pId, int x, int y, int weight) 
    {
        this.id = pId;
        this.posX = x;
        this.posY = y;
        this.weight = weight;
        this.mapColor = INITIAL_COLOR;
        this.nexts = new ArrayList<>();
    }

    public void setMapColor(Color mapColor) {
        this.mapColor = mapColor;
    }
    
    
    public boolean isAbsent ()
    {
        return this.absent;
    }

    public int getWeight() {
        return weight;
    }

    public void setPathColor(Color pathColor) {
        this.pathColor = pathColor;
    }

    public Color getPathColor() {
        return pathColor;
    }
    
    
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Node> getNexts() {
        return nexts;
    }

    public void setAbsent(boolean absent) {
        this.absent = absent;
    }

    public Color getColor() 
    {
        if (!this.bSource && !this.bTarget)
            return mapColor;
        else if (this.bSource)
            return Color.GREEN;
        else if (this.bTarget)
            return Color.RED;
        else 
            return INITIAL_COLOR;
    }
    
    public void setbSource(boolean bSource) {
        this.bSource = bSource;
    }

    public void setbTarget(boolean bTarget) {
        this.bTarget = bTarget;
    }

    public boolean isbSource() {
        return bSource;
    }

    public boolean isbTarget() {
        return bTarget;
    }

    
    public void addNode (Node newNode)
    {
        this.nexts.add(newNode);
    }
    
    public int getId() {
        return id;
    }

    public Color getMapColor() {
        return mapColor;
    }

    
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    
    @Override
    public String toString ()
    {
        return String.format("[%2d]R: %d, C: %d", this.id, this.posY, this.posX);
    }
    
}
