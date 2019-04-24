package com.alltej.algorithms.dijkstra;

import java.util.LinkedList;
import java.util.Set;

public class RoutingApp {

    public static void main(String[] args) {

        Graph graph = new Graph();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");

        a.addDestination(b, 10);
        a.addDestination(c, 15);

        b.addDestination(d, 12);
        b.addDestination(f, 15);

        c.addDestination(e, 10);

        d.addDestination(e, 2);
        d.addDestination(f, 1);

        f.addDestination(e, 5);

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);

        graph = DijkstraAlgorithm.calculateShortestPathFromSource(graph, a);

        Set<Node> nodes = graph.getNodes();
        Integer totalDistance = 0;
        for ( Node n : nodes ) {
            totalDistance = 0;
            System.out.println(n.getName());
            System.out.println("-----------------");
            LinkedList<Node> shortestPath = n.getShortestPath();
            for ( Node s : shortestPath ) {
                System.out.println("--" + s.getName() + "::" + s.getDistance());
                totalDistance += s.getDistance();
            }
            System.out.println("--" + "Total Distance:" + totalDistance);
        }

//
//        B
//                -----------------
//                A::0A
//                -----------------
//                E
//                        -----------------
//                A::0B::10D::22D
//                -----------------
//                A::0B::10C
//                -----------------
//                A::0F
//                -----------------
//                A::0B::10D::22
//        Process finished with exit code 0
    }
}
