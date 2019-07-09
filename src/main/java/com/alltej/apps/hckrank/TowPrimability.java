package com.alltej.apps.hckrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author atejano
 */
public class TowPrimability {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String n = scanner.nextLine();
            BigInteger i = new BigInteger(n);
            System.out.println(i.isProbablePrime(0)?"prime":"not prime");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
