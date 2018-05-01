package com.alltej.apps.hdepot;

import java.util.List;

/**
 * @author Allan Tejano
 * 4/30/2018
 */
public interface ILca {
    List<Integer> findPath( Node n, int a );

    Integer findLcaData( Node n, int a, int b );
}
