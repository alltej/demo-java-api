package com.alltej.apps;

/**
 * @author Allan Tejano
 * 3/4/2018
 */
public class MultiplicationTable_primitive {
    public static void main( String[] args ) {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
//                System.out.print(i*j + "   ");
                String s = padRight(String.valueOf(i * j), 5, " ");
                System.out.print(s);
            }
            System.out.println();
        }
    }

    private static String padRight(String valueOf, int i, String s) {
        StringBuilder sb = new StringBuilder(valueOf);
        while (sb.length() < i) {
            sb.append(s);
        }
        return  sb.toString();
//        int n = i - valueOf.length();
//        for (int j = 0; j < n; j++) {
//            sb.append(s);
//        }
//        return valueOf + sb.toString();
    }

}


//0   1   2   3   4   5   6   7   8   9

//1   1   2   3   4   5   6   7   8   9
//2   2   4   6   8   10  12  14  16  18
//3   3   6   9   12  15  18  21  24  27
