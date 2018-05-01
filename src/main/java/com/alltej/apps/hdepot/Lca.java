package com.alltej.apps.hdepot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Allan Tejano
 * 4/28/2018
 */
public class Lca implements ILca {

    @Override public List<Integer> findPath( Node n, int a ) {
        paths = new ArrayList<>();
        printPath( n, a );
        Collections.reverse(paths);
        return paths;
    }

    @Override public Integer findLcaData( Node n, int a, int b ) {

        List<Integer> pathA = findPath( n, a );
        List<Integer> pathB = findPath( n, b );
        System.out.println(pathA);
        System.out.println(pathB);
        //Collections.reverse( pathA );
        //Collections.reverse( pathB );
        int max = 0;
        for ( Integer aData : pathA ) {
            int indexOf = pathB.indexOf( aData );
            if (indexOf > 0 && indexOf > max) {
                max = indexOf;
            }
        }
        return pathA.get( max );
    }

    private List<Integer> paths;
    public Boolean printPath(Node node, int data){
        if(node==null) return false;
        if(node.getValue()==data||printPath(node.getLeft(),data)||printPath(node.getRight(),data)){
            //System.out.print("  " + root.data);
            paths.add(node.getValue());
            return true;
        }
        return false;
    }

    public Boolean printPath2(Node node, int data){
        if(node==null) return false;
        paths.add(node.getValue());
        if(( node.getValue() == data ) ){
            return true;
        }
        if (printPath( node.getLeft(), data )) {
            return true;
        }
        if (printPath( node.getRight(), data )) {
            return true;
        }
        return false;
    }


//    public List<Integer> findPath( Node n, int a) {
//        paths = new ArrayList<>();
//        printPath( n, a );
//        Collections.reverse(paths);
//        return paths;
//    }

    private List<Node> nodePath;
    public List<Node> printPath3(Node node, int data){
        nodePath = new ArrayList<>();

        findPathFromNodeToData( node, data );

        return nodePath;

    }

    private boolean findPathFromNodeToData( Node node, int data ) {

        if (node == null) return false;

        if (node.getValue() == data || findPathFromNodeToData( node.getLeft(), data ) || findPathFromNodeToData( node.getRight(), data )) {
            nodePath.add( node );
            return true;
        }
        return false;
    }

//    public Boolean printPath(Node node, int data){
//        if(node==null) return false;
//        if(node.getValue()==data||printPath(node.getLeft(),data)||printPath(node.getRight(),data)){
//            //System.out.print("  " + root.data);
//            paths.add(node.getValue());
//            return true;
//        }
//        return false;
//    }
}
