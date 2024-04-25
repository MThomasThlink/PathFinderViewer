
package com.thlink.pathfinderviewer.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class Nodes extends JPanel
{
    private final int dimX, dimY, nodeSize;
    private final Node[][] node;
    private static final int THICKNESS = 0;
    private Node source, target;
    private boolean doPath = false;

    public Nodes (int pDimX, int pDimY, int pCellsize)
    {
        this.dimX = pDimX;
        this.dimY = pDimY;
        
        this.nodeSize = pCellsize;
        int idCounter = 0;

        node = new Node[this.dimY][this.dimX];
        for (int row = 0; row < this.dimY; row++)
        {
            for (int col = 0; col < this.dimX; col++)
            {
                node[row][col] = new Node(idCounter, col, row);
                idCounter++;
                //home.add(cell[row][col]);
            }
        }
    }
    public void clearNodes ()
    {
        for (int row = 0; row < this.dimY; row++)
        {
            for (int col = 0; col < this.dimX; col++)
            {
                node[row][col].setMapColor(Node.INITIAL_COLOR);
                node[row][col].setPathColor(Node.INITIAL_COLOR);
            }
        }
        doPath = false;
    }
    
    public boolean addEdge (int weight)
    {
        if (source != null && target != null)
        {
            target.setWeight(weight);
            source.addNode(target);
            
            //source = target = null;
            //nobodyIsSourceOrtaget();
            return true;
        }
        return false;
    }
    public void vanish (Node n)
    {
        n.setAbsent(true);
    }
    
    public Node getSource ()
    {
        return source;
    }
    public Node getTarget ()
    {
        return target;
    }
    private void nobodyIsSourceOrTarget ()
    {
        for (int r = 0; r < this.dimY; r++)
        {
            for (int c = 0; c < this.dimX; c++)
            {
                node[r][c].setbSource(false);
                node[r][c].setbTarget(false);
            }
        }
    }
    private void nobodyIsTarget ()
    {
        for (int r = 0; r < this.dimY; r++)
        {
            for (int c = 0; c < this.dimX; c++)
            {
                node[r][c].setbTarget(false);
            }
        }
    }
    public void setSource (Node source) 
    {
        for (int r = 0; r < this.dimY; r++)
        {
            for (int c = 0; c < this.dimX; c++)
            {
                node[r][c].setbSource(false);
                node[r][c].setbTarget(false);
            }
        }
        this.source = source;
        this.target = null;
        node[source.getPosY()][source.getPosX()].setbSource(true);
    }

    public void setTarget (Node target) {
        this.target = target;
        nobodyIsTarget();
        node[target.getPosY()][target.getPosX()].setbTarget(true);
    }
    
    public void drawPath (NodeWeightPath path, Color color)
    {
        if (path == null || path.path == null || path.path.isEmpty())
            return;
        doPath = true;
        for (Node n : path.path)
        {
            if (n.getId() != source.getId() && n.getId() != target.getId())
                node[n.getId() / dimX][n.getId() % dimY].setPathColor(color);
        }
    }
    @Override
    protected void paintComponent (Graphics g)
    {
        Color startColor = Color.WHITE;
        Color endColor = Color.BLACK;
        //Draw Edges
        Graphics2D g2 = (Graphics2D) g;

        for (int row = 0; row < this.dimY; row++)
        {
            for (int col = 0; col < this.dimX; col++)
            {
                if (!node[row][col].isAbsent())
                {
                    int x = node[row][col].getPosX()* nodeSize;
                    int y = node[row][col].getPosY()* nodeSize;
                    
                    for (Node child : node[row][col].getNexts())
                    {
                        int xChild = child.getPosX()* nodeSize;
                        int yChild = child.getPosY()* nodeSize;
                        g.setColor(Color.black);
                        g2.setStroke(new BasicStroke(5.0f));
                        GradientPaint gradient = new GradientPaint(x+nodeSize/2, y+nodeSize/2, startColor, xChild+nodeSize/2, yChild+nodeSize/2, endColor);
                        g2.setPaint(gradient);
    
                        g.drawLine(x+nodeSize/2, y+nodeSize/2, xChild+nodeSize/2, yChild+nodeSize/2);

                        int cx = (x + xChild)/2;
                        int cy = (y  +yChild)/2;
                        /*int k = 25;
                        double beta = Math.PI/4;
                        double h = Math.sqrt(Math.pow(x - xChild, 2) + Math.pow(y - yChild, 2)); 
                        System.out.println("h = " + h);
                        double alfa = Math.atan((double)(y - yChild) / (double)(x - xChild));
                      //System.out.printf("[%s][%s]y = %3d, x = %3d, yChild = %3d, xChild = %3d. alfa = %f. \n", node[row][col], child,  y, x, yChild, xChild, alfa);

                        int cx = x + (int)(h/2*Math.cos(alfa));
                        int cy = y + (int)(h/2*Math.sin(alfa));
                        System.out.printf("cx = %d, cy = %d. \n", cx, cy);
                        
                        int c0x = cx - (int)(k*Math.cos(alfa));
                        int c0y = cy - (int)(k*Math.sin(alfa));
                        System.out.printf("c0x = %d, c0y = %d. \n", c0x, c0y);
                        
                        //int c1x = cx + (int)(k*Math.cos(beta+alfa));
                        //int c1y = cy - (int)(k*Math.sin(beta+alfa));
                        
                        int c1x = cx + (int)(Math.tan(beta) * k * Math.cos(alfa));
                        int c1y = cy - (int)(Math.tan(beta) * k * Math.sin(alfa));
                        System.out.printf("c1x = %d, c1y = %d. \n", c1x, c1y);
                        
                        int c2x = cx + (int)(k*Math.cos(-2*alfa));
                        int c2y = cy - (int)(k*Math.sin(-2*alfa));
                        System.out.printf("c2x = %d, c2y = %d. \n", c2x, c2y);
                        
                        g.setColor(Color.red);
                        g.drawLine(cx+nodeSize/2, cy+nodeSize/2, c0x+nodeSize/2, c0y+nodeSize/2);
                        
                        g.drawLine(c1x+nodeSize/2, c1y+nodeSize/2, cx+nodeSize/2, cy+nodeSize/2);
                        //g.drawLine(c2x+nodeSize/2, c2y+nodeSize/2, cx+nodeSize/2, cy+nodeSize/2);*/
                        int size = 7;
                        Rectangle r = new Rectangle(cx+nodeSize/2-size, cy+nodeSize/2-size, size*2, size*2);
                        int cellFontSize = Math.max(10, nodeSize/10);
                        g2.setStroke(new BasicStroke(2.0f));
                        printCenteredString(g, r, String.format("%d", child.getWeight()), new Font("Courier New", Font.PLAIN, cellFontSize), true);
                        
                    }
                }
            }
        }
        g2.setStroke(new BasicStroke(2.0f));

        //Draw nodes
        for (int row = 0; row < this.dimY; row++)
        {
            for (int col = 0; col < this.dimX; col++)
            {
                if (!node[row][col].isAbsent())
                {
                    int x = node[row][col].getPosX()* nodeSize;
                    int y = node[row][col].getPosY()* nodeSize;
                    g.setColor(node[row][col].getColor());
                    g.drawOval(x+nodeSize/4, y+nodeSize/4, nodeSize/2, nodeSize/2);
                    g.fillOval(x+nodeSize/4, y+nodeSize/4, nodeSize/2, nodeSize/2);
                    Rectangle r = new Rectangle(x, y, nodeSize, nodeSize);
                    int cellFontSize = Math.max(10, nodeSize/5);
                    printCenteredString(g, r, String.format("%d", node[row][col].getId()), new Font("Courier New", Font.PLAIN, cellFontSize), false);
                }
            }
        }
        //nobodyIsSourceOrTarget();
        if (doPath)
        {
            for (int row = 0; row < dimY; row++)
            {
                for (int col = 0; col < dimX; col++)
                {
                    if (!node[row][col].isAbsent() && !node[row][col].isbSource()&& !node[row][col].isbTarget())
                    {
                        int x = node[row][col].getPosX()* nodeSize;
                        int y = node[row][col].getPosY()* nodeSize;
                        if (node[row][col].getPathColor() == null)
                            continue;
                        g.setColor(node[row][col].getPathColor());
                        g.drawOval(x+nodeSize/4, y+nodeSize/4, nodeSize/2, nodeSize/2);
                        g.fillOval(x+nodeSize/4, y+nodeSize/4, nodeSize/2, nodeSize/2);
                      //g.fillRect(x+THICKNESS, y+THICKNESS, nodeSize-THICKNESS/2, nodeSize-THICKNESS/2);
                        Rectangle r = new Rectangle(x, y, nodeSize, nodeSize);
                        printCenteredString(g, r, String.format("%d", node[row][col].getId()), new Font("Courier New", Font.PLAIN, nodeSize/5), false);
                    }
                }
            }
        }
    }
    
    public Node getNodeById (int pId)
    {
        for (int row = 0; row < this.dimY; row++)
        {
            for (int col = 0; col < this.dimY; col++)
            {
                if (node[row][col].getId() == pId)
                    return node[row][col];
            }
        }
        return null;
    }
    
    public void printCenteredString (Graphics g, Rectangle r, String s, Font font, boolean fillRectangle) 
    {
        FontRenderContext frc = new FontRenderContext(null, true, true);

        Rectangle2D r2D = font.getStringBounds(s, frc);
        int rWidth = (int) Math.round(r2D.getWidth());
        int rHeight = (int) Math.round(r2D.getHeight());
        int rX = (int) Math.round(r2D.getX());
        int rY = (int) Math.round(r2D.getY());

        int a = (r.width / 2) - (rWidth / 2) - rX;
        int b = (r.height / 2) - (rHeight / 2) - rY;
        if (fillRectangle)
        {
            int archSize = 6;
            g.setColor(Color.WHITE);
            g.fillRoundRect(r.x, r.y, r.width, r.width, archSize, archSize);
            g.setColor(Color.BLACK);
            g.drawRoundRect(r.x, r.y, r.width, r.width, archSize, archSize);
            //g.fi
        }
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString(s, r.x + a, r.y + b);
    }
    
    public Node transformCoordinates (int pX, int pY)
    {
        int x, y;
        x = pX / nodeSize;
        y = pY / nodeSize;
        Node c = node[y][x];
      //System.out.println("c -> " + c);
        return c;
    }
    
}
