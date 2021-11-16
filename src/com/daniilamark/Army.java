package com.daniilamark;

import java.util.ArrayList;

public class Army {
    private double liftingCapacity;
    private double countAllRes = 0;
    Village village;

    public Army(Village village, int liftingCapacity){
        this.liftingCapacity = liftingCapacity;
        this.village = village;
    }

    public double getCountAllRes() {
        return countAllRes;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        if (liftingCapacity < 1000000){
            this.liftingCapacity = liftingCapacity;
        }
    }

    public int[] takeAwayResourcesFromVillage(int[] awayResources, int liftingCapacityArmy){
        int lenRes = awayResources.length;
        double rate = 0;

        ArrayList<Integer> takeAwayResourcesList = new ArrayList<>(lenRes);
        int[] takeAwayResources = new int[lenRes];

        for (int i : awayResources){
            countAllRes += i;
        }

        for (double i : awayResources){
            if((countAllRes >= liftingCapacityArmy)){
                rate = countAllRes / liftingCapacityArmy;
                takeAwayResourcesList.add((int) (i / rate));
            }
            else {
                rate = 1;
                takeAwayResourcesList.add((int) (i));
            }
        }

        for (int i = 0; i < takeAwayResourcesList.size(); i++) {
            takeAwayResources[i] = takeAwayResourcesList.get(i);
        }

        village.setIron( (int) (village.getIron() - (village.getIron() / rate)) );
        village.setClay( (int) (village.getClay() - (village.getClay() / rate)) );
        village.setCorn( (int) (village.getCorn() - (village.getCorn() / rate)) );
        village.setWater( (int) (village.getWater() - (village.getWater() / rate)) );

        return takeAwayResources;
    }
}
