package com.alltej.apps.hdepot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Allan Tejano
 * 4/28/2018
 */
public class Lca {

    public List<Integer> findPath( Node n, int a) {
        paths = new ArrayList<>();
        printPath( n, a );
        Collections.reverse(paths);
        return paths;
    }

    public Integer findLcaData( Node n, int a, int b) {

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
    public Boolean printPath(Node root, int data){
        if(root==null) return false;
        if(root.getValue()==data||printPath(root.getLeft(),data)||printPath(root.getRight(),data)){
            //System.out.print("  " + root.data);
            paths.add(root.getValue());
            return true;
        }
        return false;
    }
}
