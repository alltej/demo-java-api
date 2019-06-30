package com.alltej.apps.hckrank;

import java.util.Scanner;

/**
 * @author atejano
 */
public class TowStaticBlock {
    static boolean flag;
    static int B, H;
    static Scanner s = new Scanner(System.in);

    static {
        B = s.nextInt();
        H = s.nextInt();
        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        }else{
            flag = true;
        }
    }

    public static void main(String[] args) {
        if(flag){
            int area=B*H;
            System.out.print(area);
        }
    }
}
