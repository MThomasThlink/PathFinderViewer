
package com.thlink.pathfinderviewer.Components;


import com.thlink.pathfinderviewer.engines.entities.GraphNode;
import com.thlink.pathfinderviewer.engines.entities.WPath;
import java.awt.Color;
import javax.swing.JPanel;

public class Board {

    private int dimension;
    private JPanel home;
    private Cells cells;
    private Cell source, target = null;
    
    public boolean create (int pN, JPanel pHome)
    {
        dimension = pN;
        home = pHome;
        int cellSize = home.getWidth() / dimension;
        cells = new Cells(dimension, cellSize);
        source = target = null;
        home.removeAll();
        home.add(cells);
        return true;
    }
    public void incWeight (Cell c, int pAdd)
    {
        c.incWeight(pAdd);
    }
    
    public int[][] transformCellsIntoMatrix ()
    {
        return cells.transformCellsIntoMatrix();
    }
    
    public void drawBoard()
    {
        home.revalidate();
        home.repaint();
    }
    
    public void blockCell (Cell cell, boolean pStatus)
    {
        /*if (pStatus)
            System.out.println("block " + cell);
        else
            System.out.println("Unblock " + cell);*/
        cells.blockCell(cell, pStatus);
    }
    public Cell transformCoordinates (int pX, int pY)
    {
        return cells.transformCoordinates(pX, pY);
    }

    public Cell getSource() {
        return source;
    }

    public Cell getTarget() {
        return target;
    }
    public void setSource (int i) 
    {
        cells.setSource(i);
    }
    public void setSource (Cell source) {
        this.source = source;
        source.setSource(true);
    }

    public void setTarget (int i) 
    {
        cells.setTarget(i);
    }
    public void setTarget (Cell target) {
        this.target = target;
        target.setTarget(true);
    }

    public void drawPath (GraphNode source, GraphNode target, WPath path, Color color)
    {
        cells.drawPath(source, target, path, color);
    }

    public int getDimension() {
        return dimension;
    }
    
}
