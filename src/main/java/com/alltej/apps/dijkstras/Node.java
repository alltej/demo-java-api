package com.alltej.apps.dijkstras;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Node {
    private LinkedList<Node> shortestPath;
    private final String id;
    private Integer distance = Integer.MAX_VALUE;

    public Node( String id ) {
        this.id = id;
        adjacentNodes = new HashMap<>();
        shortestPath = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    private Map<Node, Integer> adjacentNodes;

    public void addDestination( Node destination, int distance ) {
        adjacentNodes.put( destination, distance );
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance( Integer distance ) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath( LinkedList<Node> shortestPath ) {
        this.shortestPath = shortestPath;
    }
}
