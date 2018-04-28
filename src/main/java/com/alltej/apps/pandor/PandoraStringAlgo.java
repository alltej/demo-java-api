package com.alltej.apps.pandor;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 4/27/2018
 */
public class PandoraStringAlgo {



    @Test public void max_length_of_non_repeating_string_01() {
        String text = "ABCDEFAGHCIJ";

        Pair<String, Integer> result = getMaxLengthOfWithoutNonRepeatCharacter( text );
        assertEquals( "DEFAGHCIJ", result.getKey() );
        assertEquals( 8, result.getKey().length() );
        assertEquals( Integer.valueOf( 6 ), result.getValue() );
    }

    @Test public void max_length_of_non_repeating_string() {
        String text = "ABCDEFGAHEIJKLCMNOPC";

        Pair<String, Integer> result = getMaxLengthOfWithoutNonRepeatCharacter( text );
        assertEquals( "FGAHEIJKLCMNOP", result.getKey() );
        assertEquals( 14, result.getKey().length() );
        assertEquals( Integer.valueOf( 8 ), result.getValue() );
    }

    private Pair<String, Integer> getMaxLengthOfWithoutNonRepeatCharacter( String text ) {
        int max = 0;
        int loopcount = 0;
        String subStringWithMax = null;
        for (int y =0; y < text.length(); y++) {
            loopcount++;
            int newTextLenth = text.length() - y;
            //System.out.println("newTextLenth::" + newTextLenth);
            if (max  > newTextLenth ) {
                //System.out.println("Break since max is now gt text length");
                break;
            };
            String subStr = text.substring( y, text.length( ));
            //System.out.println("Text to evaluate::" + subStr);
            subStringWithMax = findFirstNoRepeatChar( subStr );
            int pos = subStringWithMax.length();
            if (pos > max) {
                max = pos;
                //System.out.println("Nex Max::" + max);
            }
        }

        return new Pair<>( subStringWithMax, loopcount );
    }

    private String findFirstNoRepeatChar( String text ) {
        char[] arr = text.toCharArray();
        String subString = "";
        int max = 0;
        for(int x =0; x<text.length();x++) {
            if (text.length()-x < max) break;

            subString = text.substring( 0, x );
            //System.out.println(subString);
            char c = arr[x];
            int indexOf = subString.indexOf( c );
            if (indexOf >= 0) {
                if (x > max) {
                    max = x;
                }
                //System.out.println(subString);
                break;
            }

        }
        return subString;
    }
}
