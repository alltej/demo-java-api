package com.alltej.algorithms.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {

    public Set<Node> getNodes() {
        return nodes;
    }

    private Set<Node> nodes = new HashSet<>();

    public Set<Node> addNode(Node node) {
        nodes.add(node);
        return nodes;
    }
}
