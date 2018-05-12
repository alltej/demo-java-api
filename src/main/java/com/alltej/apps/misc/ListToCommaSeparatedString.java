package com.alltej.apps.misc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 5/11/2018
 */
public class ListToCommaSeparatedString {

    @Test public void list_to_comma_separated() {
        List<String> list = asList( "A", "B", "C", "D", "E" );
        String join = String.join( ",", list );
        assertEquals( "A,B,C,D,E", join );
    }
}
