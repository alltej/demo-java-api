package com.alltej.apps.dijkstras;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Allan Tejano
 * 5/8/2018
 */
public class Graph {

    private Set<Node> nodes;

    public Graph() {
        nodes = new HashSet<>();
    }

    public void addNode( Node node ) {
        nodes.add( node );
    }

    public Set<Node> getNodes() {
        return nodes;
    }
}

