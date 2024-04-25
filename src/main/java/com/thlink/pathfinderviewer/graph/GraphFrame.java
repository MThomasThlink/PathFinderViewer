
package com.thlink.pathfinderviewer.graph;

import com.thlink.pathfinderviewer.graph.engines.GraphBFS;
import java.awt.Color;
import static java.awt.Color.MAGENTA;
import static java.awt.Color.ORANGE;
import static java.awt.Color.YELLOW;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.swing.JOptionPane;

public class GraphFrame extends javax.swing.JFrame {

    private Graph graph;
    public GraphFrame() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panGraph = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jCreate = new javax.swing.JButton();
        tDimX = new javax.swing.JTextField();
        tDimY = new javax.swing.JTextField();
        bDeal = new javax.swing.JButton();
        tShortBFS = new javax.swing.JButton();
        tNShortBFS = new javax.swing.JButton();
        tNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tSource = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tTarget = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tCustoRota0 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tCustoRota1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tCustoRota2 = new javax.swing.JTextField();
        jEnd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tCustoRota3 = new javax.swing.JTextField();
        btClearNodes = new javax.swing.JButton();
        jCboDeals = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);

        panGraph.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panGraph.setMaximumSize(new java.awt.Dimension(700, 700));
        panGraph.setMinimumSize(new java.awt.Dimension(700, 700));
        panGraph.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panGraphMouseDragged(evt);
            }
        });
        panGraph.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panGraphMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panGraphMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panGraphMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panGraphMouseReleased(evt);
            }
        });
        panGraph.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 204, 204));

        jCreate.setText("Create");
        jCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateActionPerformed(evt);
            }
        });

        tDimX.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tDimX.setText("20");

        tDimY.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tDimY.setText("20");

        bDeal.setText("Deal!");
        bDeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDealActionPerformed(evt);
            }
        });

        tShortBFS.setText("Shortest BFS!");
        tShortBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tShortBFSActionPerformed(evt);
            }
        });

        tNShortBFS.setText("N Short BFS!");
        tNShortBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNShortBFSActionPerformed(evt);
            }
        });

        tNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tNumber.setText("3");

        jLabel1.setText("Source");

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

        jLabel2.setText("Target");

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

        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("Rota 0:");

        tCustoRota0.setForeground(new java.awt.Color(255, 255, 51));
        tCustoRota0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tCustoRota0.setText("-");
        tCustoRota0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCustoRota0ActionPerformed(evt);
            }
        });
        tCustoRota0.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCustoRota0KeyPressed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 102, 255));
        jLabel4.setText("Rota 1:");

        tCustoRota1.setForeground(new java.awt.Color(255, 204, 102));
        tCustoRota1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tCustoRota1.setText("-");
        tCustoRota1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCustoRota1ActionPerformed(evt);
            }
        });
        tCustoRota1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCustoRota1KeyPressed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("Rota 3:");

        tCustoRota2.setForeground(new java.awt.Color(255, 102, 255));
        tCustoRota2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tCustoRota2.setText("-");
        tCustoRota2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCustoRota2ActionPerformed(evt);
            }
        });
        tCustoRota2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCustoRota2KeyPressed(evt);
            }
        });

        jEnd.setText("End");
        jEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEndActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 204, 102));
        jLabel6.setText("Rota 2:");

        tCustoRota3.setForeground(new java.awt.Color(255, 0, 0));
        tCustoRota3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tCustoRota3.setText("-");
        tCustoRota3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCustoRota3ActionPerformed(evt);
            }
        });
        tCustoRota3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCustoRota3KeyPressed(evt);
            }
        });

        btClearNodes.setText("Clear Nodes");
        btClearNodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearNodesActionPerformed(evt);
            }
        });

        jCboDeals.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jCboDeals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboDealsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bDeal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tShortBFS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tDimX, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tDimY, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(tNShortBFS, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(5, 5, 5)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(tNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(tSource, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tCustoRota0, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tCustoRota1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tCustoRota2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tCustoRota3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18))
                            .addComponent(btClearNodes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCboDeals, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tDimX, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tDimY, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCboDeals, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDeal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btClearNodes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tShortBFS)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tNShortBFS, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(tNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tSource, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tTarget, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(tCustoRota0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCustoRota1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCustoRota2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCustoRota3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(jEnd)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateActionPerformed
        Integer x = Integer.parseInt(tDimX.getText());
        Integer y = Integer.parseInt(tDimY.getText());
        
        graph = new Graph();
        graph.create(x, y, panGraph);
        graph.drawBoard();
    }//GEN-LAST:event_jCreateActionPerformed

    private void jEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEndActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jEndActionPerformed
    
    private void panGraphMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panGraphMouseClicked
        System.out.println("Graph mouse click.");
        if (graph == null)
        {
            System.out.println("No graph yet.");
            return;
        }
        Node n = graph.transformCoordinates(evt.getX(), evt.getY());
        if (n != null)
        {
            /*if (evt.getButton() == MouseEvent.BUTTON1)
            {
                System.out.println("Source");
                graph.setSource(n);
            }
            else */if (evt.getButton() == MouseEvent.BUTTON2)
            {
                System.out.println("BUTTON2");
              //graph.vanish(n);
               //Request Weight
              //int weight = Integer.parseInt(JOptionPane.showInputDialog("Weight: " ));
              //graph.addEdge(weight);
            }
            /*else if (evt.getButton() == MouseEvent.BUTTON3)
            {
                System.out.println("Target");
                graph.setTarget(n);
                graph.addEdge(2);
            }*/
            graph.drawBoard();
        }
    }//GEN-LAST:event_panGraphMouseClicked

    private void bDealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDealActionPerformed
        
        /*{
            //5 x 5
            tDimX.setText("5"); tDimY.setText("5");
            jCreateActionPerformed(null);
            int [][] adj = createAdjacentcyListSmall();
            for (int[] set : adj)
            {
                graph.setMacroEdge(set[0], set[1], set[2]);
            }
            //graph.setMacroEdge(set[0], set[1], set[2]);
            
            tSource.setText("0");
            graph.setSource(0);
            tTarget.setText("23");
            graph.setTarget(23);
        }*/
        {
            //Large graph
            int [][] adj = createAdjacentcyListBig();
            for (int[] set : adj)
            {
                graph.setMacroEdge(set[0], set[1], set[2]);
            }
            tSource.setText("10");
            graph.setSource(10);
            tTarget.setText("381");
            graph.setTarget(381);
             
        }
        
        /*for (int i = 0; i < 25; i++)
        {
            if (i != 0 && i != 12)
                graph.vanish(i);
        }
        graph.setMacroEdge(0, 12, 5);*/
          
        /*{
            graph.vanish(6); graph.vanish(7);
            graph.vanish(9); graph.vanish(10); graph.vanish(12); graph.vanish(14);
            graph.vanish(15); graph.vanish(18); graph.vanish(19);
            graph.vanish(20); graph.vanish(21); graph.vanish(22); graph.vanish(23); graph.vanish(24);

            graph.setMacroEdge(0, 1, 7);
            graph.setMacroEdge(1, 2, 8);
           graph.setMacroEdge(2, 3, 2);
            graph.setMacroEdge(3, 4, 1);
            graph.setMacroEdge(4, 8, 4);
            graph.setMacroEdge(8, 13, 1);
            graph.setMacroEdge(13, 17, 5);
            graph.setMacroEdge(17, 11, 1);

            graph.setMacroEdge(0, 5, 6);
            graph.setMacroEdge(5, 11, 1);

            graph.setMacroEdge(11, 16, 1);

            graph.setSource(0);
            graph.setTarget(11);
        }*/
        /*{
            int p = 0;
            graph.setMacroEdge(p, ++p, 1); graph.setMacroEdge(p, ++p, 1); graph.setMacroEdge(p, ++p, 1); graph.setMacroEdge(p, ++p, 1); graph.setMacroEdge(p, ++p, 1); graph.setMacroEdge(p, ++p, 1);
            graph.setMacroEdge(6, 14, 1); graph.setMacroEdge(14, 22, 1); graph.setMacroEdge(22, 30, 1); graph.setMacroEdge(30, 38, 1);  graph.setMacroEdge(38, 46, 1);  graph.setMacroEdge(46, 52, 1);  
            graph.setMacroEdge(2, 11, 1); graph.setMacroEdge(11, 20, 1); graph.setMacroEdge(20, 29, 1); graph.setMacroEdge(20, 29, 1); graph.setMacroEdge(29, 37, 1); graph.setMacroEdge(37, 45, 1); graph.setMacroEdge(45, 52, 1); 
            
            
            graph.setSource(2);
            graph.setTarget(52);
            
        }*/
        /*{
            int nodesPerLine = 8;
            int lines = 8;
            int p;
            int row = 0;
            while (row < lines)
            {
                if (row %2 == 0)
                {
                  //while (p < nodesPerLine-1)
                    for (p = 0; p < nodesPerLine-1; p++ )
                    {
                        graph.setMacroEdge(row*nodesPerLine+p, row*nodesPerLine+p+1, 1+p/2); 
                    }
                }
                else
                {
                    for (p = nodesPerLine-1; p > 0; p--)
                    {
                        graph.setMacroEdge(row*nodesPerLine+p, row*nodesPerLine+p-1, nodesPerLine-p); 
                    }
                    break;
                }                
                p++;
                row++;
                
            }
            
            //Verticals dows
            int col = 2;
            for (row = 0; row < lines-1; row++)
            {
                graph.setMacroEdge(row*nodesPerLine+col, (row+1)*nodesPerLine+col, 1+row); 
            }
            /*col = 5;
            for (row = 0; row < lines-1; row++)
            {
                graph.setMacroEdge(row*nodesPerLine+col, (row+1)*nodesPerLine+col, 1+row); 
            }
            
            col = 7;
            for (row = 0; row < lines-1; row++)
            {
                graph.setMacroEdge(row*nodesPerLine+col, (row+1)*nodesPerLine+col, 1+row); 
            }
            
            //Verticals ups
            /*col = 0;
            for (row = lines-1; row > 0; row--)
            {
                graph.setMacroEdge((row)*nodesPerLine+col, (row-1)*nodesPerLine+col, lines-row); 
            }
            
            col = 3;
            for (row = lines-1; row > 0; row--)
            {
                graph.setMacroEdge((row)*nodesPerLine+col, (row-1)*nodesPerLine+col, lines-row); 
            }
            tSource.setText("0");
            graph.setSource(0);
            tTarget.setText("63");
            graph.setTarget(63);
            graph.drawBoard();
        }*/
            
        /*{
            for (int i = 0; i < 7; i++)
                graph.setMacroEdge(i, i+1, i);
            graph.setMacroEdge(7, 15, 10);
            graph.setMacroEdge(0,  8, 10);
            graph.setMacroEdge(4, 12, 10);
            
            for (int i = 1; i < 6; i++)
                graph.setMacroEdge(15-i, 15-i-1, i);
            graph.setMacroEdge(8, 16, 10);
            graph.setMacroEdge(9, 17, 10);
            graph.setMacroEdge(17, 16, 10);
            
            graph.setMacroEdge(15, 22, 10);
            graph.setMacroEdge(22, 29, 10);
            graph.setMacroEdge(29, 28, 10);
            graph.setMacroEdge(28, 27, 10);
            graph.setMacroEdge(27, 26, 10);
            graph.setMacroEdge(26, 25, 10);
            
            graph.setMacroEdge(25, 16, 10);
            
            graph.setSource(0);
            graph.setTarget(16);
            
            
        }*/
        graph.drawBoard();
        
    }//GEN-LAST:event_bDealActionPerformed

    private void tShortBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tShortBFSActionPerformed
        // TODO add your handling code here:
        if (graph == null)
        {
            System.out.println("No graph yet");
            return;
        }
        if (graph.getSource() == null || graph.getTarget() == null)
        {
            System.out.println("Source or target not defined.");
            return;
        }
        GraphBFS bfs = new GraphBFS();
        NodeWeightPath shortest = bfs.findShortestPathWithBFS(graph.getSource(), graph.getTarget());
        if (shortest == null)
        {
            System.out.println("No path");
            return;
        }
        NodeWeightPath.dumpNodeWeightPath("Short", shortest);
        graph.drawPath(shortest, YELLOW);
        tCustoRota0.setText(String.format("%d", shortest.totalCost));
    }//GEN-LAST:event_tShortBFSActionPerformed

    private void tNShortBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNShortBFSActionPerformed
        if (graph == null)
        {
            System.out.println("No graph yet");
            return;
        }
        if (graph.getSource() == null || graph.getTarget() == null)
        {
            System.out.println("Source or target not defined.");
            return;
        }
        Integer number = Integer.parseInt(tNumber.getText());
        GraphBFS bfs = new GraphBFS();
        List<NodeWeightPath> shortests = bfs.findNShortestPathWithBFS(graph.getSource(), graph.getTarget(), number);
        if (shortests == null)
        {
            System.out.println("shortest = null;");
            return;
        }
        NodeWeightPath.dumpNodeWeightPaths(shortests);
        
        List<Color> colors = new ArrayList<>();
        colors.add(YELLOW);
        colors.add(Color.pink);
        colors.add(ORANGE);
        colors.add(MAGENTA);
        for (int i = 0; i < shortests.size(); i++)
        {
            graph.drawPath(shortests.get(i), colors.get(i % 4));
            switch (i) 
            {
                case 0 -> tCustoRota0.setText(String.format("%d", shortests.get(i).totalCost));
                case 1 -> tCustoRota1.setText(String.format("%d", shortests.get(i).totalCost));
                case 2 -> tCustoRota2.setText(String.format("%d", shortests.get(i).totalCost));
                case 3 -> tCustoRota3.setText(String.format("%d", shortests.get(i).totalCost));
                default -> { }
            }
        }
    }//GEN-LAST:event_tNShortBFSActionPerformed

    private void panGraphMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panGraphMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_panGraphMouseDragged

    private void panGraphMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panGraphMouseReleased
        // TODO add your handling code here:
        if (graph == null)
        {
            System.out.println("No graph yet");
            return;
        }
        //System.out.println("Released");
        Node n = graph.transformCoordinates(evt.getX(), evt.getY());
        if (n != null)
        {
            if (!graph.getSource().equals(n))
            {
              //System.out.printf("From [%s] to [%s]. \n", graph.getSource(), n);
                graph.setTarget(n);
                int weight = Integer.parseInt(JOptionPane.showInputDialog("Weight: ", "1" ));
                System.out.printf("{ %d, %d, %d } ,\n", graph.getSource().getId(), graph.getTarget().getId(), weight);
                graph.addEdge(weight);
                graph.drawBoard();
            }
            else
            {
                System.out.println("Source equals target: " + n);
                graph.setTarget(n);
                graph.drawBoard();
            }
        }
    }//GEN-LAST:event_panGraphMouseReleased

    private void panGraphMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panGraphMouseEntered
        
    }//GEN-LAST:event_panGraphMouseEntered

    private void panGraphMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panGraphMousePressed
        if (graph == null)
        {
            System.out.println("No graph yet");
            return;
        }
      //System.out.println("Pressed");
        Node n = graph.transformCoordinates(evt.getX(), evt.getY());
        if (n != null)
        {
            graph.setSource(n);
            graph.drawBoard();
        }

    }//GEN-LAST:event_panGraphMousePressed

    private void tSourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSourceActionPerformed
        createSource();
    }//GEN-LAST:event_tSourceActionPerformed

    private void tSourcePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tSourcePropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_tSourcePropertyChange

    private void tSourceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tSourceKeyPressed

    }//GEN-LAST:event_tSourceKeyPressed

    private void tTargetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTargetActionPerformed

    }//GEN-LAST:event_tTargetActionPerformed

    private void tTargetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tTargetKeyPressed
        // TODO add your handling code here:
        createTarget();
    }//GEN-LAST:event_tTargetKeyPressed

    private void tCustoRota0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCustoRota0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota0ActionPerformed

    private void tCustoRota0KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCustoRota0KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota0KeyPressed

    private void tCustoRota1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCustoRota1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota1ActionPerformed

    private void tCustoRota1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCustoRota1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota1KeyPressed

    private void tCustoRota2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCustoRota2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota2ActionPerformed

    private void tCustoRota2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCustoRota2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota2KeyPressed

    private void tCustoRota3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCustoRota3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota3ActionPerformed

    private void tCustoRota3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCustoRota3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCustoRota3KeyPressed

    private void btClearNodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearNodesActionPerformed
        if (graph == null)
        {
            System.out.println("No graph yet");
            return;
        }
        graph.clearNodes();
        graph.drawBoard();
    }//GEN-LAST:event_btClearNodesActionPerformed

    private void jCboDealsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboDealsActionPerformed
      //System.out.println("Deal selected");
        switch (jCboDeals.getSelectedIndex())
        {
            case 0 -> {
                tDimX.setText("5"); tDimY.setText("5");
                jCreateActionPerformed(null);
                int [][] adj = createAdjacentcyListSmall();
                for (int[] set : adj)
                {
                    graph.setMacroEdge(set[0], set[1], set[2]);
                }

                tSource.setText("0");
                graph.setSource(0);
                tTarget.setText("23");
                graph.setTarget(23);
            }
            
            case 1 -> {
                tDimX.setText("20"); tDimY.setText("20");
                jCreateActionPerformed(null);
                int [][] adj = createAdjacentcyListBig();
                for (int[] set : adj)
                {
                    graph.setMacroEdge(set[0], set[1], set[2]);
                }

                tSource.setText("10");
                graph.setSource(10);
                tTarget.setText("381");
                graph.setTarget(381);
            }
            
            case 2 -> {
                tDimX.setText("30"); tDimY.setText("30");
                jCreateActionPerformed(null);
                int [][] adj = createAdjacentcyListExtraBig();
                for (int[] set : adj)
                {
                    graph.setMacroEdge(set[0], set[1], set[2]);
                }

                tSource.setText("20");
                graph.setSource(20);
                tTarget.setText("877");
                graph.setTarget(877);
            }
            
            case 3 -> {
                int cols = 20;
                int[] delta = new int[] { -1, /*0,*/ +2 };
                String strCols = String.format("%d", cols);
                tDimX.setText(strCols); tDimY.setText(strCols);
                jCreateActionPerformed(null);
                int curr = 10;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(curr);
                int level = 0;
                while (!queue.isEmpty() && level < 150)
                {
                    curr = queue.poll();
                    /*if (curr > 60)
                        break;*/
                    for (int d : delta)
                    {
                        graph.setMacroEdge(curr, curr+cols+d, Math.abs(d));
                        queue.add(curr+cols+d);
                    }
                    level++;
                    graph.drawBoard();
                }
               // maxLevel++;
                
                tSource.setText("10");
                graph.setSource(10);
                tTarget.setText("171");
                graph.setTarget(171);
            }
            default -> {
                  //System.out.printf("Default DEAL.\n");
                    return;
                }
        }
        graph.drawBoard();
    }//GEN-LAST:event_jCboDealsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDeal;
    private javax.swing.JButton btClearNodes;
    private javax.swing.JComboBox<String> jCboDeals;
    private javax.swing.JButton jCreate;
    private javax.swing.JButton jEnd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panGraph;
    private javax.swing.JTextField tCustoRota0;
    private javax.swing.JTextField tCustoRota1;
    private javax.swing.JTextField tCustoRota2;
    private javax.swing.JTextField tCustoRota3;
    private javax.swing.JTextField tDimX;
    private javax.swing.JTextField tDimY;
    private javax.swing.JButton tNShortBFS;
    private javax.swing.JTextField tNumber;
    private javax.swing.JButton tShortBFS;
    private javax.swing.JTextField tSource;
    private javax.swing.JTextField tTarget;
    // End of variables declaration//GEN-END:variables

    private void createDealOptions ()
    {
        jCboDeals.removeAllItems();
        
        jCboDeals.insertItemAt("Small 5x5", 0);
        jCboDeals.insertItemAt("Big 20x20", 1);
        jCboDeals.insertItemAt("XXX 30x30", 2);
        jCboDeals.insertItemAt("Auto 10x10", 3);
        
        
    }
    public void go ()
    {
        setTitle("GraphFrame");
        setVisible(true);
        createDealOptions();
        //jCreateActionPerformed(null);
        //bDealActionPerformed(null);
    }
    
    
    private void createSource ()
    {
        if (!tSource.getText().isEmpty())
        {
            System.out.println("createSource = " + tSource.getText());
            Integer iSource = Integer.parseInt(tSource.getText());
            graph.setSource(iSource);
            graph.drawBoard();
        }
    }
    
    private void createTarget ()
    {
        if (!tTarget.getText().isEmpty())
        {
            System.out.println("createTarget = " + tTarget.getText());
            Integer iTarget = Integer.parseInt(tTarget.getText());
            graph.setTarget(iTarget);
            graph.drawBoard();
        }
    }
    private int[][] createAdjacentcyListSmall ()
    {
        return new int[][] {
        { 0, 5, 1 } ,
        { 5, 10, 1 } ,
        { 10, 16, 1 } ,
        { 16, 21, 1 } ,
        { 21, 22, 1 } ,
        { 22, 23, 1 } ,
        { 0, 1, 1 } ,
        { 1, 6, 1 } ,
        { 6, 7, 1 } ,
        { 7, 12, 1 } ,
        { 12, 11, 1 } ,
        { 11, 17, 1 } ,
        { 17, 18, 1 } ,
        { 18, 23, 1 } ,
        { 0, 7, 1 } ,
        { 7, 2, 1 } ,
        { 2, 8, 1 } ,
        { 8, 13, 1 } ,
        { 13, 4, 1 } ,
        { 4, 9, 1 } ,
        { 9, 14, 1 } ,
        { 14, 19, 1 } ,
        { 19, 23, 1 }  };
    }
    private int[][] createAdjacentcyListBig ()
    {
        int [][] adj = new int[][] {
{ 10, 24, 1 } ,
{ 10, 27, 2 } ,
{ 10, 30, 1 } ,
{ 10, 32, 2 } ,
{ 10, 34, 1 } ,
{ 10, 37, 1 } ,
{ 24, 62, 3 } ,
{ 24, 64, 2 } ,
{ 24, 65, 1 } ,
{ 27, 47, 1 } ,
{ 47, 67, 2 } ,
{ 67, 87, 1 } ,
{ 87, 106, 1 } ,
{ 87, 107, 2 } ,
{ 87, 108, 1 } ,
{ 107, 127, 1 } ,
{ 107, 128, 1 } ,
{ 106, 126, 1 } ,
{ 126, 145, 2 } ,
{ 126, 146, 3 } ,
{ 126, 147, 1 } ,
{ 147, 167, 1 } ,
{ 167, 187, 2 } ,
{ 187, 207, 1 } ,
{ 207, 226, 1 } ,
{ 226, 245, 2 } ,
{ 226, 246, 1 } ,
{ 226, 247, 3 } ,
{ 226, 248, 3 } ,
{ 247, 267, 2 } ,
{ 267, 286, 1 } ,
{ 267, 288, 1 } ,
{ 267, 287, 3 } ,
{ 287, 306, 2 } ,
{ 306, 326, 3 } ,
{ 326, 345, 1 } ,
{ 345, 365, 1 } ,
{ 365, 367, 2 } ,
{ 62, 82, 1 } ,
{ 82, 101, 2 } ,
{ 82, 103, 1 } ,
{ 103, 123, 1 } ,
{ 123, 142, 1 } ,
{ 123, 143, 2 } ,
{ 123, 144, 1 } ,
{ 144, 164, 1 } ,
{ 144, 163, 1 } ,
{ 142, 162, 3 } ,
{ 101, 121, 3 } ,
{ 101, 140, 2 } ,
{ 140, 160, 1 } ,
{ 101, 141, 1 } ,
{ 163, 183, 1 } ,
{ 144, 165, 3 } ,
{ 145, 166, 2 } ,
{ 166, 185, 1 } ,
{ 166, 186, 2 } ,
{ 141, 161, 1 } ,
{ 161, 181, 3 } ,
{ 181, 200, 2 } ,
{ 181, 201, 2 } ,
{ 181, 202, 1 } ,
{ 183, 204, 2 } ,
{ 183, 203, 1 } ,
{ 65, 85, 2 } ,
{ 62, 61, 2 } ,
{ 61, 60, 2 } ,
{ 181, 221, 2 } ,
{ 203, 222, 1 } ,
{ 204, 224, 1 } ,
{ 204, 223, 2 } ,
{ 245, 265, 2 } ,
{ 224, 244, 3 } ,
{ 222, 242, 2 } ,
{ 221, 241, 1 } ,
{ 200, 240, 1 } ,
{ 244, 264, 1 } ,
{ 265, 285, 1 } ,
{ 285, 305, 1 } ,
{ 285, 304, 2 } ,
{ 264, 283, 1 } ,
{ 223, 243, 1 } ,
{ 243, 262, 1 } ,
{ 242, 261, 2 } ,
{ 241, 260, 3 } ,
{ 240, 260, 2 } ,
{ 260, 280, 1 } ,
{ 283, 302, 3 } ,
{ 262, 302, 1 } ,
{ 261, 301, 1 } ,
{ 280, 320, 1 } ,
{ 304, 324, 2 } ,
{ 304, 323, 3 } ,
{ 323, 342, 1 } ,
{ 323, 343, 2 } ,
{ 323, 344, 1 } ,
{ 324, 344, 3 } ,
{ 342, 361, 1 } ,
{ 320, 341, 3 } ,
{ 341, 361, 3 } ,
{ 342, 362, 3 } ,
{ 342, 363, 2 } ,
{ 344, 364, 1 } ,
{ 364, 385, 1 } ,
{ 361, 381, 2 } ,
{ 363, 381, 1 } ,
{ 385, 381, 1 } ,
{ 288, 308, 1 } ,
{ 308, 329, 1 } ,
{ 329, 370, 1 } ,
{ 128, 169, 1 } ,
{ 108, 171, 2 } ,
{ 169, 229, 1 } ,
{ 171, 231, 1 } ,
{ 231, 250, 1 } ,
{ 231, 251, 3 } ,
{ 231, 252, 1 } ,
{ 231, 253, 2 } ,
{ 231, 254, 1 } ,
{ 253, 273, 1 } ,
{ 253, 272, 2 } ,
{ 253, 274, 1 } ,
{ 254, 275, 1 } ,
{ 274, 294, 1 } ,
{ 274, 312, 3 } ,
{ 275, 295, 1 } ,
{ 275, 296, 1 } ,
{ 295, 315, 1 } ,
{ 295, 314, 1 } ,
{ 314, 333, 1 } ,
{ 296, 316, 1 } ,
{ 316, 336, 1 } ,
{ 229, 249, 1 } ,
{ 249, 269, 1 } ,
{ 250, 270, 1 } ,
{ 270, 289, 1 } ,
{ 289, 308, 5 } ,
{ 251, 271, 1 } ,
{ 271, 291, 1 } ,
{ 291, 311, 5 } ,
{ 311, 332, 1 } ,
{ 312, 332, 2 } ,
{ 333, 352, 1 } ,
{ 332, 352, 1 } ,
{ 336, 355, 5 } ,
{ 336, 356, 1 } ,
{ 336, 357, 1 } ,
{ 336, 358, 2 } ,
{ 356, 375, 1 } ,
{ 356, 376, 1 } ,
{ 356, 377, 2 } ,
{ 357, 378, 1 } ,
{ 358, 379, 1 } ,
{ 379, 399, 1 } ,
{ 370, 390, 5 } ,
{ 37, 58, 1 } ,
{ 58, 79, 1 } ,
{ 58, 77, 1 } ,
{ 37, 56, 5 } ,
{ 56, 75, 1 } ,
{ 56, 76, 1 } ,
{ 56, 77, 2 } ,
{ 34, 74, 5 } ,
{ 54, 75, 1 } ,
{ 54, 73, 1 } ,
{ 32, 52, 2 } ,
{ 32, 53, 2 } ,
{ 32, 51, 2 },
{ 79, 98, 2 } ,
{ 98, 118, 1 } ,
{ 98, 117, 1 } ,
{ 98, 116, 1 } ,
{ 98, 119, 1 } ,
{ 118, 138, 1 } ,
{ 118, 139, 1 } ,
{ 118, 137, 1 } ,
{ 137, 156, 1 } ,
{ 138, 136, 1 } ,
{ 138, 157, 1 } ,
{ 138, 158, 2 } ,
{ 138, 159, 1 } ,
{ 157, 177, 1 } ,
{ 157, 176, 5 } ,
{ 157, 178, 2 } ,
{ 157, 179, 1 } ,
{ 179, 199, 1 } ,
{ 177, 197, 1 } ,
{ 197, 218, 1 } ,
{ 197, 216, 2 } ,
{ 197, 217, 1 } ,
{ 197, 215, 1 } ,
{ 217, 237, 7 } ,
{ 217, 238, 6 } ,
{ 217, 239, 5 } ,
{ 237, 257, 1 } ,
{ 237, 258, 1 } ,
{ 237, 259, 1 } ,
{ 257, 277, 2 } ,
{ 257, 278, 2 } ,
{ 278, 297, 2 } ,
{ 297, 317, 1 } ,
{ 297, 318, 1 } ,
{ 297, 319, 2 } ,
{ 319, 339, 1 } ,
{ 339, 359, 1 }
};

        return adj;
    }
    private int[][] createAdjacentcyListExtraBig ()
    {
        return new int[][] {
        { 26, 55, 1 } ,  { 55, 52, 1 } ,  { 52, 20, 1 } ,  { 20, 49, 1 } ,  { 49, 78, 1 } ,  { 78, 107, 1 } ,  { 107, 137, 1 } ,  { 137, 167, 1 } ,  { 167, 198, 1 } ,  { 198, 226, 1 } ,  { 226, 194, 1 } ,  { 194, 222, 1 } ,  { 222, 160, 1 } ,  { 160, 189, 1 } ,  { 189, 249, 1 } ,  { 249, 278, 1 } ,  { 278, 309, 1 } ,  { 309, 338, 1 } ,  { 338, 367, 1 } ,  { 367, 396, 1 } ,  { 396, 427, 1 } ,  { 427, 456, 1 } ,  { 456, 487, 1 } ,  { 487, 518, 1 } ,  { 518, 547, 1 } ,  { 547, 515, 1 } ,  { 515, 453, 1 } ,  { 453, 482, 1 } ,  { 482, 542, 1 } ,  { 542, 571, 1 } ,  { 571, 631, 1 } ,  { 631, 662, 1 } ,  { 662, 691, 1 } ,  { 691, 722, 1 } ,  { 722, 754, 1 } ,  { 754, 696, 1 } ,  { 696, 726, 1 } ,  { 726, 757, 1 } ,  { 757, 698, 1 } ,  { 698, 788, 1 } ,  { 788, 816, 1 } ,  { 816, 846, 1 } ,  { 846, 877, 1 } ,  { 26, 86, 1 } ,  { 86, 114, 1 } ,  { 114, 173, 1 } ,  { 173, 233, 1 } ,  { 233, 260, 1 } ,  { 260, 286, 1 } ,  { 286, 283, 1 } ,  { 283, 343, 1 } ,  { 343, 345, 1 } ,  { 345, 375, 1 } ,  { 375, 404, 1 } ,  { 404, 463, 1 } ,  { 463, 524, 1 } ,  { 524, 553, 1 } ,  { 553, 581, 1 } ,  { 581, 641, 1 } ,  { 641, 642, 1 } ,              
        { 642, 672, 1 } ,  { 672, 701, 1 } ,  { 701, 761, 1 } ,  { 761, 792, 1 } ,  { 792, 850, 1 } ,  { 850, 876, 1 } ,  { 233, 264, 1 } ,  { 264, 293, 1 } ,  { 293, 384, 1 } ,  { 384, 444, 1 } ,  { 444, 589, 1 } ,  { 589, 677, 1 } ,  { 677, 796, 1 } ,  { 796, 824, 1 } ,  { 824, 881, 1 } ,  { 881, 883, 1 } ,  { 115, 116, 1 } ,  { 116, 146, 1 } ,  { 146, 177, 1 } ,  { 177, 236, 1 } ,  { 236, 267, 1 } ,  { 236, 265, 1 } ,  { 265, 325, 1 } ,  { 325, 385, 1 } ,  { 385, 412, 1 } ,  { 412, 505, 1 } ,  { 505, 564, 1 } ,  { 564, 623, 1 } ,  
        { 564, 595, 1 } ,  { 595, 626, 1 } ,  { 626, 685, 1 } ,  { 685, 716, 1 } ,  { 564, 597, 1 } ,  { 505, 538, 1 } ,  { 623, 653, 1 } ,  { 623, 651, 1 } ,  { 651, 681, 1 } ,  
        { 651, 682, 1 } ,  { 682, 770, 1 } ,  { 770, 885, 1 } ,  { 885, 876, 1 } ,  { 538, 629, 1 } ,  { 538, 658, 1 } ,  { 538, 657, 1 } ,  { 657, 687, 1 } ,  { 657, 688, 1 } ,  { 657, 689, 1 } ,  { 685, 714, 1 } ,  { 685, 715, 1 } ,  { 715, 745, 1 } ,  { 745, 775, 1 } ,  { 745, 774, 1 } ,  { 745, 773, 1 } ,  { 745, 776, 1 } ,  { 745, 777, 1 } ,  { 745, 778, 1 } ,  { 745, 779, 1 } ,  { 773, 803, 1 } ,  { 773, 804, 1 } ,  { 773, 802, 1 } ,  { 773, 801, 1 } ,  { 773, 831, 1 } ,  { 773, 832, 1 } ,  { 773, 833, 1 } ,  
        { 804, 835, 1 } ,  { 779, 807, 1 } ,  { 779, 808, 1 } ,  { 779, 809, 1 } ,  { 779, 838, 1 } ,  { 807, 837, 1 } ,  { 838, 869, 1 } ,  { 832, 862, 1 } ,  { 862, 764, 1 } ,  { 764, 644, 1 } ,  { 644, 676, 1 } ,  { 676, 876, 1 } ,  { 0, 1, 1 } ,  { 1, 2, 1 } ,  { 2, 32, 1 } ,  { 32, 33, 1 } ,  { 33, 34, 1 } ,  { 34, 35, 1 } ,  { 35, 36, 1 } ,  { 36, 37, 1 } ,  { 37, 38, 1 } ,  { 38, 68, 1 } ,  { 68, 98, 1 } ,  { 98, 128, 1 } ,  { 33, 63, 1 } ,  { 63, 93, 1 } ,  { 93, 124, 1 } ,  { 93, 122, 1 } ,  { 122, 151, 1 } ,  { 122, 152, 1 } ,  
        { 122, 153, 1 } ,  { 124, 154, 1 } ,  { 124, 155, 1 } ,  { 124, 156, 1 } ,  { 124, 157, 1 } ,  { 128, 158, 1 } ,  { 158, 188, 1 } ,  { 188, 311, 1 } ,  { 311, 401, 1 } ,  { 401, 460, 1 } ,  { 151, 211, 1 } ,  { 151, 212, 1 } ,  { 212, 213, 1 } ,  { 212, 243, 1 } ,  { 211, 241, 1 } ,  { 157, 217, 1 } ,  { 217, 246, 1 } ,  { 217, 247, 1 } ,  { 243, 273, 1 } ,  { 243, 274, 1 } ,  { 243, 275, 1 } ,  { 273, 272, 1 } ,  { 273, 302, 1 } ,  { 273, 303, 1 } ,  { 273, 304, 1 } ,  { 274, 305, 1 } ,  { 275, 306, 1 } ,  { 241, 271, 1 } ,  { 271, 301, 1 } ,  { 302, 331, 1 } ,  { 303, 334, 1 } ,  { 303, 333, 1 } ,  { 306, 336, 1 } ,  { 336, 365, 1 } ,  { 332, 362, 1 } ,  { 362, 393, 1 } ,  { 393, 422, 1 } ,  { 422, 574, 1 } ,  { 574, 635, 1 } ,  { 635, 663, 1 } ,  { 663, 751, 1 } ,  { 751, 843, 1 } ,  { 843, 876, 1 } ,  
        };
    }
    
}
