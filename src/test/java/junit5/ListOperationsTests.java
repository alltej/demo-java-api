package junit5;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 4/15/2018
 */
public class ListOperationsTests {

    @Test public void reverse_a_list() {
        List<String> list = asList( "A", "B", "C", "D", "E" );
        Collections.reverse( list ) ;
        list.forEach( System.out::println );
    }

    @Test public void sort_a_list_using_collections() {
        List<String> list = asList( "Abc", "Cde", "Bcd", "Efg", "Def" );
        Collections.sort( list ); ;
        list.forEach( System.out::println );
    }

    @Test public void sort_a_list_using_stream() {
        List<String> list = asList( "Tyu", "Ert", "Vbn", "Heki", "Sdf" );
        list.stream().sorted( Comparator.comparing( String::toString ) ).forEach( System.out::println );
    }

    @Test public void reverse_a_list_using_stream() {
        List<String> list = asList( "Tyu", "Ert", "Vbn", "Heki", "Sdf" );
        list.stream().collect( Collectors.collectingAndThen( Collectors.toList(), l -> {
            Collections.reverse(l);
            return l;
        }) ).forEach( System.out::println );
}
}
