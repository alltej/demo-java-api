package com.alltej.apps.hckrank;

import java.util.Scanner;

/**
 * @author atejano
 */
public class TowScanner {


    public static void main(String[] args) {
        String input ="Hello world\n" +
                "I am a file\n" +
                "Read me until end-of-file.";
        Scanner s = new Scanner(input);
        int i=0;
        while (s.hasNext()) {
            System.out.println(++i + s.nextLine());
        }
        s.close();
    }
}
