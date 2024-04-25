
package com.thlink.pathfinderviewer;

import com.thlink.pathfinderviewer.Components.Board;
import com.thlink.pathfinderviewer.Components.Cell;
import com.thlink.pathfinderviewer.engines.BFS;
import com.thlink.pathfinderviewer.engines.GeneralGraphHelper;
import com.thlink.pathfinderviewer.engines.entities.GraphNode;
import com.thlink.pathfinderviewer.engines.entities.WPath;
import java.awt.Color;
import static java.awt.Color.GREEN;
import static java.awt.Color.YELLOW;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PathFrame extends javax.swing.JFrame {

    private Board board;
    private static final int DELTA_GRAY = 5;
    private final GeneralGraphHelper gh = new GeneralGraphHelper();
    public PathFrame() {
        initComponents();
    }

    public void go ()
    {
        setTitle("Path Visualizator");
        setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panBoard = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jEnd = new javax.swing.JButton();
        jCreate = new javax.swing.JButton();
        tNumber = new javax.swing.JTextField();
        jFind = new javax.swing.JButton();
        tSource = new javax.swing.JTextField();
        tTarget = new javax.swing.JTextField();
        tNumberPaths = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panBoard.setBackground(new java.awt.Color(255, 255, 204));
        panBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panBoard.setForeground(new java.awt.Color(255, 255, 204));
        panBoard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panBoardMouseDragged(evt);
            }
        });
        panBoard.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                panBoardMouseWheelMoved(evt);
            }
        });
        panBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panBoardMouseClicked(evt);
            }
        });
        panBoard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panBoardKeyPressed(evt);
            }
        });
        panBoard.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jEnd.setText("End");
        jEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEndActionPerformed(evt);
            }
        });

        jCreate.setText("Create");
        jCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateActionPerformed(evt);
            }
        });

        tNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNumber.setText("5");

        jFind.setText("Find!");
        jFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFindActionPerformed(evt);
            }
        });

        tSource.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tSource.setText("0");
        tSource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSourceActionPerformed(evt);
            }
        });
        tSource.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tSourcePropertyChange(evt);
            }
        });
        tSource.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tSourceKeyPressed(evt);
            }
        });

        tTarget.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tTarget.setText("24");
        tTarget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTargetActionPerformed(evt);
            }
        });
        tTarget.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tTargetKeyPressed(evt);
            }
        });

        tNumberPaths.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNumberPaths.setText("2");
        tNumberPaths.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNumberPathsActionPerformed(evt);
            }
        });
        tNumberPaths.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tNumberPathsPropertyChange(evt);
            }
        });
        tNumberPaths.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tNumberPathsKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jCreate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addGap(37, 37, 37)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jFind, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNumberPaths, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tSource, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCreate)
                    .addComponent(tNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFind)
                    .addComponent(tSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tTarget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNumberPaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jEnd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEndActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jEndActionPerformed

    private void jCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateActionPerformed
        Integer n = Integer.parseInt(tNumber.getText());
        board = new Board();
        board.create(n, panBoard);
        createSource();
        createTarget();
        board.drawBoard();
    }//GEN-LAST:event_jCreateActionPerformed

    private void panBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panBoardMouseClicked
      //System.out.printf("panBoardMouseClicked @ %dx%d. \n", evt.getX(), evt.getY());
        if (board == null)
        {
            System.out.println("No board yet!");
            return;
        }
        /*if (evt.getClickCount() == 2)
        {
          //System.out.println("DOUBLE Click");
            if (board.getSource() == null)
            {
                board.setSource(board.transformCoordinates(evt.getX(), evt.getY()));
                board.drawBoard();
            }
            else if (board.getTarget() == null)
            {
                board.setTarget(board.transformCoordinates(evt.getX(), evt.getY()));
                board.drawBoard();
            }
            else
                System.out.println("Source AND target already set!");
            
        }
        else*/
        {
            Cell c = board.transformCoordinates(evt.getX(), evt.getY());
            if (c != null)
            {
                if (evt.getButton() == MouseEvent.BUTTON1)
                {
                  //System.out.println("Single LEFT Click");
                    board.incWeight(c, DELTA_GRAY);
                }
                else
                {
                  //System.out.println("Single RIGHT Click");
                    board.incWeight(c, -DELTA_GRAY);
                }
                board.drawBoard();
            }
        }
    }//GEN-LAST:event_panBoardMouseClicked

    private void panBoardMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panBoardMouseDragged
        if (board == null)
        {
            System.out.println("No board yet!");
            return;
        }
      //System.out.println("panBoardMouseDragged button " + evt.getButton());
        Cell c = board.transformCoordinates(evt.getX(), evt.getY());
        if (c != null)
        {
            board.blockCell(c, true);
            board.drawBoard();
        }
    }//GEN-LAST:event_panBoardMouseDragged

    private void jFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFindActionPerformed
        if (board != null)
        {
            if (!tSource.getText().isEmpty() && !tTarget.getText().isEmpty())
            {
                Integer iSource = Integer.parseInt(tSource.getText());
                Integer iTarget = Integer.parseInt(tTarget.getText());
                Integer iNumber = Integer.parseInt(tNumberPaths.getText());
                findNShortestSolutionBFS(iSource, iTarget, iNumber);
            }
            else
                System.out.println("Source or Target not defined. ");
        }
        else
            System.out.println("No board defined!");
        
    }//GEN-LAST:event_jFindActionPerformed

    private void panBoardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panBoardKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panBoardKeyPressed

    private void panBoardMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_panBoardMouseWheelMoved
        System.out.println("panBoardMouseWheelMoved " + evt.getX());
    }//GEN-LAST:event_panBoardMouseWheelMoved

    private void tSourceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSourceKeyPressed
       
    }//GEN-LAST:event_tSourceKeyPressed

    private void tSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSourceActionPerformed
        createSource();
    }//GEN-LAST:event_tSourceActionPerformed

    private void createSource ()
    {
        if (!tSource.getText().isEmpty())
        {
            System.out.println("createSource = " + tSource.getText());
            Integer iSource = Integer.parseInt(tSource.getText());
            board.setSource(iSource);
            board.drawBoard();
        }
    }
    
    private void createTarget ()
    {
        if (!tTarget.getText().isEmpty())
        {
            System.out.println("createTarget = " + tTarget.getText());
            Integer iTarget = Integer.parseInt(tTarget.getText());
            board.setTarget(iTarget);
            board.drawBoard();
        }
    }
    
    private void tSourcePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tSourcePropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_tSourcePropertyChange

    private void tTargetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTargetKeyPressed
        // TODO add your handling code here:
        createTarget();
    }//GEN-LAST:event_tTargetKeyPressed

    private void tTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTargetActionPerformed
        
    }//GEN-LAST:event_tTargetActionPerformed

    private void tNumberPathsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNumberPathsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNumberPathsActionPerformed

    private void tNumberPathsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tNumberPathsPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tNumberPathsPropertyChange

    private void tNumberPathsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNumberPathsKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNumberPathsKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCreate;
    private javax.swing.JButton jEnd;
    private javax.swing.JButton jFind;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panBoard;
    private javax.swing.JTextField tNumber;
    private javax.swing.JTextField tNumberPaths;
    private javax.swing.JTextField tSource;
    private javax.swing.JTextField tTarget;
    // End of variables declaration//GEN-END:variables

    private void findShortestSolutionBFS (int iSource, int iTarget)
    {
        BFS bfs = new BFS();
        if (board == null)
        {
            System.out.println("No board");
            return;
        }
        int[][] array = board.transformCellsIntoMatrix();
        GraphNode g = gh.createGraphFromMatrix(array);
        GraphNode source = gh.findNodeBasedOnValueCicleTolerant (g, iSource, new int[1], new HashSet<>());
        if (source == null)
        {
            System.out.println("Graph Source not defined");
            return;
        }
        System.out.println("findNodeBasedOnValueCicleTolerant SOURCE DONE");
        GraphNode target = gh.findNodeBasedOnValueCicleTolerant (g, iTarget, new int[1], new HashSet<>());
        if (target == null)
        {
             System.out.println("Graph Target not found");
             return;
        }
        System.out.println("findNodeBasedOnValueCicleTolerant TARGET DONE");
      //List<GeneralGraphHelper.WPath> listWPaths = gh.findAllPathsWithWeights(source, target, null);
        
        System.out.println("go findShortestPathWithBFS()");
              
        WPath path = bfs.findShortestPathWithBFS(source, target);
        
        System.out.println("back from findShortestPathWithBFS");
        /*gh.dumpWPaths(listWPaths);
        if (listWPaths.isEmpty())
        {
            System.out.println("No paths found!");
            return;
        }*/
            
        /*GeneralGraphHelper.WPath cheapest = filterPathsBasedonCost(listWPaths);
        if (cheapest == null )
        {
            System.out.println("No cheapest path found!");
            return;
        }
        System.out.println("filterPathsBasedonCost DONE");*/
        board.drawPath(source, target, path, YELLOW);
        board.drawBoard();
        
    }
    
    private void findNShortestSolutionBFS (int iSource, int iTarget, int number)
    {
        BFS bfs = new BFS();
        if (board == null)
        {
            System.out.println("No board");
            return;
        }
        int[][] array = board.transformCellsIntoMatrix();
        GraphNode g = gh.createGraphFromMatrix(array);
        GraphNode source = gh.findNodeBasedOnValueCicleTolerant (g, iSource, new int[1], new HashSet<>());
        if (source == null)
        {
            System.out.println("Graph Source not defined");
            return;
        }
        System.out.println("findNodeBasedOnValueCicleTolerant SOURCE DONE");
        GraphNode target = gh.findNodeBasedOnValueCicleTolerant (g, iTarget, new int[1], new HashSet<>());
        if (target == null)
        {
             System.out.println("Graph Target not found");
             return;
        }
        System.out.println("findNodeBasedOnValueCicleTolerant TARGET DONE");
      //List<GeneralGraphHelper.WPath> listWPaths = gh.findAllPathsWithWeights(source, target, null);
        
      //System.out.println("go findShortestPathWithBFS()");
              
        List<WPath> path = bfs.findNShortestPathWithBFS(source, target, number);
        
        System.out.println("back from findShortestPathWithBFS");
        /*gh.dumpWPaths(listWPaths);
        if (listWPaths.isEmpty())
        {
            System.out.println("No paths found!");
            return;
        }*/
            
        /*GeneralGraphHelper.WPath cheapest = filterPathsBasedonCost(listWPaths);
        if (cheapest == null )
        {
            System.out.println("No cheapest path found!");
            return;
        }
        System.out.println("filterPathsBasedonCost DONE");*/
        List<Color> colors = new ArrayList<>();
        colors.add(YELLOW);
        colors.add(GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.ORANGE);
        for (int i = 0; i < path.size(); i++)
        {
            board.drawPath(source, target, path.get(i), colors.get(i % 4));
        }
        board.drawBoard();
        
    }
    
    private void findShortestSolution (int iSource, int iTarget)
    {
        if (board == null)
        {
            System.out.println("No board");
            return;
        }
        System.out.println("transformCellsIntoMatrix GO");
        int[][] array = board.transformCellsIntoMatrix();
        System.out.println("transformCellsIntoMatrix DONE");
        
        GraphNode g = gh.createGraphFromMatrix(array);
        System.out.println("createGraphFromMatrix DONE");
        
        GraphNode source = gh.findNodeBasedOnValueCicleTolerant (g, iSource, new int[1], new HashSet<>());
        if (source == null)
        {
            System.out.println("Graph Source not defined");
            return;
        }
        System.out.println("findNodeBasedOnValueCicleTolerant SOURCE DONE");
        GraphNode target = gh.findNodeBasedOnValueCicleTolerant (g, iTarget, new int[1], new HashSet<>());
        if (target == null)
        {
             System.out.println("Graph Target not found");
             return;
        }
        System.out.println("findNodeBasedOnValueCicleTolerant TARGET DONE");
        List<WPath> listWPaths = gh.findAllPathsWithWeights(source, target, null);
        System.out.println("findAllPathsWithWeights DONE");
        WPath.dumpWPaths(listWPaths);
        if (listWPaths.isEmpty())
        {
            System.out.println("No paths found!");
            return;
        }
            
        WPath cheapest = filterPathsBasedonCost(listWPaths);
        if (cheapest == null )
        {
            System.out.println("No cheapest path found!");
            return;
        }
        System.out.println("filterPathsBasedonCost DONE");
        board.drawPath(source, target, cheapest, YELLOW);
        board.drawBoard();
    }
    
    private WPath filterPathsBasedonCost (List<WPath> result)
    {
        int minCost = Integer.MAX_VALUE;
        WPath minCostWPAth = null;
        
        for (WPath wpath : result)
        {
            if (wpath.cost < minCost)
            {
                minCost = wpath.cost;
                minCostWPAth = wpath;
            }
        }
        return minCostWPAth;
    }
}
