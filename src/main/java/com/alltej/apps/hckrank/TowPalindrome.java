package com.alltej.apps.hckrank;

import java.util.Scanner;

/**
 * @author atejano
 */
public class TowPalindrome {


    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        char[] chars = A.toCharArray();
        int lenHalf = chars.length/2;
        int indexMax = chars.length-1;
        boolean isPalindrome = true;
        for (int i = 0; i < lenHalf; i++)
            if (chars[i] != chars[indexMax - i]) {
                isPalindrome = false;
                break;
            }
        System.out.println(isPalindrome?"Yes":"No");
    }


}
