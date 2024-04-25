
package com.thlink.pathfinderviewer.Components;

import java.awt.Color;

public class Cell
{
    private final int posX,  posY;
    private int weight;
    private Color mapColor, pathColor;
    private boolean isSource, isTarget, blocked;
    private final int id; 
    
    public Cell (int pId, int x, int y) 
    {
        this.posX = x;
        this.posY = y;

        this.weight = 1;
        this.mapColor = Color.WHITE;
        isSource = isTarget = blocked = false;
        id = pId;
    }
    
    @Override
    public String toString ()
    {
        return String.format("[%2d]R: %d, C: %d", this.id, this.posY, this.posX);
    }

    public Color getColor() 
    {
        if (!this.isSource && !this.isTarget && !this.isBlocked())
            return mapColor;
        else if (this.isSource)
            return Color.RED;
        else if (this.isTarget)
            return Color.BLUE;
        else if (this.isBlocked())
            return Color.BLACK;
        else 
            return Color.cyan;
    }

    public int getWeight() 
    {
        return weight;
    }
    public void incWeight (int pAdd)
    {
        int newValue;
        if (pAdd > 0)
        {
            if (this.weight + pAdd > 255)
                newValue = 255;
            else
                newValue = this.weight + pAdd;
            setWeight(newValue);
        }
        else
        {
            if (this.weight + pAdd < 0)
                newValue = 0;
            else
                newValue = this.weight + pAdd;
            setWeight(newValue);
        }
    }
    public void setWeight (int weight) {
        this.weight = weight;
        this.mapColor = new Color(255 - this.weight, 255 - this.weight, 255 - this.weight);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean isSource() {
        return isSource;
    }

    public void setSource (boolean isSource) {
        this.isSource = isSource;
    }

    public boolean isTarget() {
        return isTarget;
    }

    public void setTarget (boolean isTarget) {
        this.isTarget = isTarget;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public int getId() {
        return id;
    }

    public void setPathColor(Color pathColor) {
        this.pathColor = pathColor;
    }

    public Color getPathColor() {
        return pathColor;
    }

    
    
}
