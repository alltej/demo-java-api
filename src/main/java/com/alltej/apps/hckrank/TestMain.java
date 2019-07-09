package com.alltej.apps.hckrank;

import java.util.Calendar;

/**
 * @author atejano
 */
public class TestMain {
    public static void main(String[] args) {
        int i = 3456;
        String s = Integer.toString(i);
        System.out.println(findDay(8, 5, 2015));
//        PriorityQueue todo = new PriorityQueue();
//        todo.add("dishes");
//        todo.add("laundry");
//        todo.add("bills");
//        todo.offer("bills");
//        System.out.print(todo.size() + " " + todo.poll());
//        System.out.print(todo.peek() + " " + todo.poll());
//        System.out.print(todo.poll() + " " + todo.poll());
//        String[] cities = {
//            "ab", "c", "t", "d"};
//
//        System.out.println(Arrays.binarySearch(cities, "t"));
//
//        try {
//            Float f1 = new Float("3.0");
//            byte b = f1.byteValue();
//            int i = f1.intValue();
//            double v = f1.doubleValue();
//            System.out.println(i + b +v);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }



    }
    public static String findDay(int month, int day, int year) {
        Calendar instance = Calendar.getInstance();
        if(month==1){
            instance.set(year,0,day);
        }else{
            instance.set(year,month-1,day);
        }
        int i = instance.get(Calendar.DAY_OF_WEEK);
        switch (i) {
            case 1:
                return "SUNDAY";
            case 2:
                return "MONDAY";
            case 3:
                return "TUESDAY";
            case 4:
                return "WEDNESDAY";
            case 5:
                return "THURSDAY";
            case 6:
                return "FRIDAY";
            case 7:
                return "SATURDAY";
             default:
                 return "";
        }
    }
}
