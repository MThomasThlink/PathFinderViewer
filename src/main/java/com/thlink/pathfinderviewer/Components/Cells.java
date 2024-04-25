
package com.thlink.pathfinderviewer.Components;

import static com.thlink.pathfinderviewer.Components.Cells.enumDIRS.*;
import com.thlink.pathfinderviewer.engines.entities.GraphNode;
import com.thlink.pathfinderviewer.engines.entities.WPath;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;

public class Cells extends JPanel
{
    public enum enumDIRS {UP, DOWN, LEFT, RIGHT};
    
    private static final int THICKNESS = 0;
    private final int dimension, cellSize;
    private final Cell[][] cell;
    private boolean doPath;
   
    public Cells (int pDimension, int pCellsize)
    {
        this.dimension = pDimension;
        this.cellSize = pCellsize;
        int idCounter = 0;

        cell = new Cell[this.dimension][this.dimension];
        for (int row = 0; row < dimension; row++)
        {
            for (int col = 0; col < dimension; col++)
            {
                cell[row][col] = new Cell(idCounter, col, row);
                idCounter++;
                //home.add(cell[row][col]);
            }
        }
        doPath = false;
    }

    public void setDoPath (boolean doPath) {
        this.doPath = doPath;
    }
    
    public void setSource (int i)
    {
        for (int row = 0; row < dimension; row++)
        {
            for (int col = 0; col < dimension; col++)
            {
                cell[row][col].setSource(false);
            }
        }
        cell[i / dimension][i % dimension].setSource(true);
    }
    
    public void setTarget (int i)
    {
        for (int row = 0; row < dimension; row++)
        {
            for (int col = 0; col < dimension; col++)
            {
                cell[row][col].setTarget(false);
            }
        }
        cell[i / dimension][i % dimension].setTarget(true);
    }
    
    private Cell getNextCell (enumDIRS pDir, int pRow, int pCol)
    {
        switch (pDir) 
        {
            case DOWN -> {
                if (pRow < dimension-1)
                    return cell[pRow+1][pCol];
                else return null;
            }
            case UP -> {
                if (pRow > 0)
                    return cell[pRow-1][pCol];
                else return null;
            }
            case LEFT -> {
                if (pCol  > 0)
                    return cell[pRow][pCol-1];
                else return null;
            }
            case RIGHT -> {
                if (pCol < dimension -1)
                    return cell[pRow][pCol+1];
                else return null;
            }
         
        }
        return null;        
    }
    public int[][] transformCellsIntoMatrix ()
    {
        List<List<Integer>> adj = new ArrayList<>();
        for (int col = 0; col < dimension; col++)
        {
            for (int row = 0; row < dimension; row++)
            {
              //if (row == 0 && col == 1)
              //    System.out.println("");
              //System.out.printf("row = %d. col = %d. \n", row, col);
                Cell c = cell[row][col];
                if (!c.isBlocked())
                {
                    Cell cUp =    getNextCell(UP,    row, col);
                    if (cUp != null)
                    {
                        if (!cUp.isBlocked())
                            adj.add(Arrays.asList(c.getId(), cUp.getId(), cUp.getWeight()));
                        //adj.add(Arrays.asList(cUp.getId(), c.getId()));
                    }
                    Cell cDown =  getNextCell(DOWN,  row, col);
                    if (cDown != null)
                    {
                        if (!cDown.isBlocked())
                            adj.add(Arrays.asList(c.getId(), cDown.getId(), cDown.getWeight()));
                        //adj.add(Arrays.asList(cDown.getId(), c.getId()));
                    }
                    Cell cLeft =  getNextCell(LEFT,  row, col);
                    if (cLeft != null)
                    {
                        if (!cLeft.isBlocked())
                            adj.add(Arrays.asList(c.getId(), cLeft.getId(), cLeft.getWeight()));
                        //adj.add(Arrays.asList(cLeft.getId(), c.getId()));
                    }
                    Cell cRight = getNextCell(RIGHT, row, col);
                    if (cRight != null)
                    {
                        if (!cRight.isBlocked())
                            adj.add(Arrays.asList(c.getId(), cRight.getId(), cRight.getWeight()));
                        //adj.add(Arrays.asList(cRight.getId(), c.getId()));
                    } 
                }
            }
        }
        int [][] array = new int[adj.size()][3];
        for (int i = 0; i < adj.size(); i++)
        {
            array[i][0] = adj.get(i).get(0);
            array[i][1] = adj.get(i).get(1);
            if (adj.get(i).size() > 2)
            {
                array[i][2] = adj.get(i).get(2);
                if (array[i][2] > 1)
                    System.out.println("");
            }
          //System.out.printf("De %d para %d. \n", array[i][0], array[i][1]);
        }
        return array;
    }
    
    public void blockCell(Cell cell, boolean pStatus)
    {
        cell.setBlocked(pStatus);
    }
    
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(50, 50);
    }
    
    @Override
    protected void paintComponent (Graphics g)
    {
      //super.paintComponent(g);
        for (int row = 0; row < dimension; row++)
        {
            for (int col = 0; col < dimension; col++)
            {
                int x = cell[row][col].getPosX()* cellSize;
                int y = cell[row][col].getPosY()* cellSize;
                g.setColor(cell[row][col].getColor());
                g.drawRect(x, y, cellSize, cellSize);
                g.fillRect(x+THICKNESS, y+THICKNESS, cellSize-THICKNESS/2, cellSize-THICKNESS/2);
                Rectangle r = new Rectangle(x, y, cellSize, cellSize);
                int cellFontSize = Math.max(10, cellSize/5);
                printCenteredString(g, r, String.format("%d", cell[row][col].getId()), new Font("Courier New", Font.PLAIN, cellFontSize));
            }
        }
        
        if (doPath)
        {
            for (int row = 0; row < dimension; row++)
            {
                for (int col = 0; col < dimension; col++)
                {
                    int x = cell[row][col].getPosX()* cellSize;
                    int y = cell[row][col].getPosY()* cellSize;
                    if (cell[row][col].getPathColor() == null)
                        continue;
                    g.setColor(cell[row][col].getPathColor());
                    g.drawRect(x, y, cellSize, cellSize);
                    g.fillRect(x+THICKNESS, y+THICKNESS, cellSize-THICKNESS/2, cellSize-THICKNESS/2);
                    Rectangle r = new Rectangle(x, y, cellSize, cellSize);
                    printCenteredString(g, r, String.format("%d", cell[row][col].getId()), new Font("Courier New", Font.PLAIN, cellSize/5));
                }
            }
        }
    }
    
    public void printCenteredString (Graphics g, Rectangle r, String s, Font font) 
    {
        FontRenderContext frc = new FontRenderContext(null, true, true);

        Rectangle2D r2D = font.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(s, r.x + a, r.y + b);
    }
    public Cell transformCoordinates (int pX, int pY)
    {
        int x, y;
        x = pX / cellSize;
        y = pY / cellSize;
        Cell c = cell[y][x];
      //System.out.println("c -> " + c);
        return c;
    }
    
    public void drawPath (GraphNode source, GraphNode target, WPath path, Color color)
    {
        if (path == null || path.path == null || path.path.isEmpty())
            return;
        doPath = true;
        for (GraphNode node : path.path)
        {
            if (node.value != source.value && node.value != target.value)
                cell[node.value / dimension][node.value % dimension].setPathColor(color);
        }
    }
    
}
