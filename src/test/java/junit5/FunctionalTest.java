package junit5;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/15/2018
 */
public class FunctionalTest {

    Function<Integer, Integer> increment = a -> a+1;

    @Test public void f1_increment() {
        Integer nextVal = increment.apply( 4 );
        assertEquals( Integer.valueOf( 5 ), nextVal );
    }

    BiFunction<Integer, Integer, Integer> sum = ( a, b ) -> a + b;

    @Test public void f1_sum() {
        Integer sumVal = sum.apply( 4, 5 );
        assertEquals( Integer.valueOf( 9 ), sumVal );
    }

    @Test public void f1_plus10() {
        assertEquals( 19, plus10.apply( 9 ).intValue() );
    }

    Function<Integer, Integer> plus10 = a ->{
        return a+10;
    };

    @Test public void f_as_args() {
        hello( plus10);
    }

    private void hello( Function<Integer, Integer> plus10 ) {
        System.out.println(plus10);
    }
}
