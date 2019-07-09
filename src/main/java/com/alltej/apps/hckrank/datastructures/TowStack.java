package com.alltej.apps.hckrank.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author atejano
 */
public class TowStack {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        List<String> stringList = new ArrayList<>();
        while (sc.hasNext()) {
            String input=sc.nextLine();
            System.out.println(input);
            stringList.add(input);
        }
        sc.close();
        System.out.println("******");
        for (String b : stringList) {
            System.out.println(isBalance(b));
        }

    }

//    {}()
//            ({()})
//    {}(
//            []

    private static Boolean isBalance(String input) {

        Stack<Character> set = new Stack<>();
        for (char c : input.toCharArray()) {
            switch(c) {
                case '{':
                case '(':
                case '[':
                    set.push(c);
                    break;

                case ']':
                    if(set.isEmpty() || set.pop() != '[')
                        return false;
                    break;
                case ')':
                    if(set.isEmpty() || set.pop() != '(')
                        return false;
                    break;
                case '}':
                    if(set.isEmpty() || set.pop() != '{')
                        return false;
                    break;
            }
        }

        return set.isEmpty();
    }
}
