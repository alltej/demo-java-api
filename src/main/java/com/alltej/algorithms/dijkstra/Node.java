package com.alltej.algorithms.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;

public class Node {
    private String name;
    //    associate immediate neighbors with edge length.
    private HashMap<Node, Integer> adjNodes = new HashMap<>();
    //    list of nodes that describes the shortest path calculated from the starting node.
    private LinkedList<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;

    public Node(String name) {
        this.name = name;
    }

    public HashMap<Node, Integer> getAdjacentNodes() {
        return adjNodes;
    }

    public LinkedList<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(LinkedList<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public HashMap<Node, Integer> addDestination(Node node, Integer distance) {
        adjNodes.put(node, distance);
        return adjNodes;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
