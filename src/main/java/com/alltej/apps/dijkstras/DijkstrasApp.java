package com.alltej.apps.dijkstras;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author Allan Tejano
 * 5/8/2018
 */
public class DijkstrasApp {
    public static void main( String[] args ) {
        Node a = new Node( "A" );
        Node b = new Node( "B" );
        Node c = new Node( "C" );
        Node d = new Node( "D" );
        Node e = new Node( "E" );
        Node f = new Node( "F" );

        a.addDestination( b, 10 );
        a.addDestination( c, 15 );

        b.addDestination( d, 12 );
        b.addDestination( f, 15 );

        c.addDestination( e, 10 );

        d.addDestination( e, 2 );
        d.addDestination( f, 1 );
        f.addDestination( e, 5 );

        Graph g = new Graph();
        g.addNode( a );
        g.addNode( b );
        g.addNode( c );
        g.addNode( d );
        g.addNode( e );
        g.addNode( f );

        g = calculateShortestPathFromSource(g, a);
        Set<Node> nodes = g.getNodes();
        for ( Node n : nodes ) {
            System.out.println(n.getId());
            System.out.println("-----------------");
            LinkedList<Node> shortestPath = n.getShortestPath();
            for ( Node s : shortestPath ) {
                System.out.println(s.getId() + "::" + s.getDistance() );
            }
            System.out.println();
        }
    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry< Node, Integer> adjacencyPair:
                    currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }


    private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode,
            Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
