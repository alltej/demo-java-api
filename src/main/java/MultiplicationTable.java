import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 3/4/2018
 */
public class MultiplicationTable {
    public static void main( String[] args ) {
        List<Integer> integers = asList( 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 );
        IntStream.rangeClosed( 0,9 )
                .forEach( row -> {
                    if (row == 0) {

                        StringBuilder sb = new StringBuilder( padRight( "" , 5, " " ));
                        //final String s = padRight( String.valueOf( row ), 5, " " );
                        IntStream.rangeClosed( 1,9 )
                                .forEach( c -> {
                                    sb.append( padRight( String.valueOf( c ) , 5, " " ));
                                } );
                        System.out.println(sb);
                    }
                    else{
                        StringBuilder sb = new StringBuilder( padRight( String.valueOf( row ) , 5, " " ) );
                        IntStream.rangeClosed( 1,9 )
                                .forEach( m -> {
                                    final Integer product = row*m;
                                    sb.append( padRight( String.valueOf( product ) , 5, " " ));
                                } );
                        System.out.println(sb);
                    }
                } );

//        integers.forEach( i -> {
//
//        } );
    }

    private static String padRight( String s, int i, String padChar ) {
        StringBuilder sb = new StringBuilder( s );
        while ( sb.length() < i ) {
            sb.append( padChar);
        }
        return sb.toString();
    }
}


//0   1   2   3   4   5   6   7   8   9

//1   1   2   3   4   5   6   7   8   9
//2   2   4   6   8   10  12  14  16  18
//3   3   6   9   12  15  18  21  24  27
