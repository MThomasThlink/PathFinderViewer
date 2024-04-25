
package com.thlink.pathfinderviewer;

public class PathFinderViewer {

    public static void main(String[] args) {
        System.out.println("PathFinderViewer:");
        PathFinder pf = new PathFinder();
        
        if (!pf.createFinder(5))
        {
            System.out.println("Erro");
        }
    }
}
