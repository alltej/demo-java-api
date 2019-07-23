package com.alltej.apps.smsra;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Trailer trailer = new Trailer();

        Date d1 = new Date(2019, 1,1);

        trailer.load(new Pallet(1, 10D), d1);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date d2 = new Date(2019, 2,1);
        trailer.load(new Pallet(2, 20D), d2);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trailer.load(new Pallet(22, 22D), new Date(2019, 2, 15));
        Date d3 = new Date(2019, 3,1);
        trailer.load(new Pallet(3, 30D), d3);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trailer.load(new Pallet(12, 12D), new Date(2019, 1, 12));
        Date d4 = new Date(2019, 4,1);
        trailer.unload(1, d4);

        System.out.println("total weight:" + trailer.getWeight());


        Long timeMilli = new Date().getTime();
        Double weightAt = trailer.getWeightAt(d3);
        System.out.println("Get weightAt " + d3 + ":" + weightAt);
        Double weightAt2 = trailer.getWeightAt(new Date(2019, 1, 13));
        System.out.println("Get weightAt " + "d-1-12" + ":" + weightAt2);
    }
}





class Pallet {

    private final int id;
    private final Double weight;
    public Pallet(int id, Double weight){
        this.id = id;
        this.weight = weight;
    }

    public int getId(){
        return id;
    }


    public Double getWeight(){
        return this.weight;
    }
}

class Trailer{
//    Map<Date, Integer> dateMap = new TreeMap<Date, Integer>(new Comparator<Date>() {
//        public int compare(Date date1, Date date2) {
//            return date2.compareTo(date1);
//        }
//    });

    private TreeMap<Date, Double> weightHistory;
    private HashMap<Integer, Pallet> pallets;

    public Trailer(){
        pallets = new HashMap<>();
//        weightHistory = new TreeMap<>(new Comparator<Date>() {
//            public int compare(Date date1, Date date2) {
//                return date1.compareTo(date2);
//            }
//        });
        weightHistory = new TreeMap<>(Comparator.naturalOrder());
    }


    public void load(Pallet pallet, Date on){
        pallets.put(pallet.getId(), pallet);


        Double lastWeight = 0D;

        if (!weightHistory.isEmpty()) {
            //Long tsKey = weightHistory.lastKey();
            //System.out.println("Last key: "+tsKey);
            //if (weightHistory.lastEntry()== null) return;
            lastWeight = weightHistory.lastEntry().getValue();
            //System.out.println("Last weight: " + lastWeight);

        };
        Double newWeight = new Double(lastWeight + pallet.getWeight());
//        Long timeMilli = new Date().getTime();
        weightHistory.put(on, newWeight);
        System.out.println("Loading new pallet: lastWeight " + lastWeight + ". Adding pallet " + pallet.getId() + " on " +  on + " with pallet.weighhing " + pallet.getWeight() + " and New Weight: " + newWeight);
    }

    //unload returns the pallet
    public Pallet unload(int id, Date on){
        Pallet toUnload = pallets.get(id);
        if (toUnload == null) return null;
        pallets.remove(id);

        if (!weightHistory.isEmpty()) {
//            Long tsKey = weightHistory.lastKey();
            //System.out.println("unloading Last key: "+tsKey);
            Double lastWeight = weightHistory.lastEntry().getValue();
 //           System.out.println("Last weight: " + lastWeight);

            Double newWeight = new Double(lastWeight - toUnload.getWeight());
//            Long timeMilli = new Date().getTime();

            weightHistory.put(on, newWeight);
//            System.out.println("unLoading:" + timeMilli + "," + newWeight);
            System.out.println("unLoading  pallet: lastWeight " + lastWeight + ". unloading pallet " + toUnload.getId() + " on " +  on + " with pallet.weighhing " + toUnload.getWeight() + " and New Weight: " + newWeight);
        }

        return toUnload;
    }

    public Double getWeight(){
        return pallets.values().stream().mapToDouble(Pallet::getWeight).sum();
    }

    public Double getWeightAt(Date timestamp ){
        Optional<Map.Entry<Date, Double>> first = weightHistory.entrySet().stream().filter(k -> k.getKey().before(timestamp)).findFirst();
        if (first.isPresent())
            return first.get().getValue();
        else
            return 0D;
    }
}