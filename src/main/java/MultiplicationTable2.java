import java.util.stream.IntStream;

/**
 * @author Allan Tejano
 * 3/4/2018
 */
public class MultiplicationTable2 {
    public static void main( String[] args ) {
        final int MULTIPLIER_MAX = 9;
        final int PAD_SIZE = 5;

        StringBuilder header = new StringBuilder( padRight( "" , PAD_SIZE, " " ));
        IntStream.rangeClosed( 1, MULTIPLIER_MAX )
                .forEach( c -> {
                    header.append( padRight( String.valueOf( c ) , PAD_SIZE, " " ));
                } );
        System.out.println(header);

        IntStream.rangeClosed( 1, MULTIPLIER_MAX )
                .forEach( row -> {
                    StringBuilder sb = new StringBuilder( padRight( String.valueOf( row ) , PAD_SIZE, " " ) );
                    IntStream.rangeClosed( 1, MULTIPLIER_MAX )
                            .forEach( m -> {
                                final Integer product = row*m;
                                sb.append( padRight( String.valueOf( product ) , PAD_SIZE, " " ));
                            } );
                    System.out.println(sb);
                } );

//        integers.forEach( i -> {
//
//        } );
    }

    private static String padRight( final String s, final int i, final String padChar ) {
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
