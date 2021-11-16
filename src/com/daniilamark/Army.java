package com.daniilamark;

public class Army {
    private int liftingCapacity;
    Village village;

    public Army(Village village, int liftingCapacity){
        this.liftingCapacity = liftingCapacity;
        this.village = village;
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        if (liftingCapacity < 1000000){
            this.liftingCapacity = liftingCapacity;
        }
    }

    public int[] takeAwayResourcesFromVillage(int[] awayResources, int liftingCapacityArmy){
        int lenRes = awayResources.length;
        int countAllRes = 0;
        int rate = 0;

        for (int i : awayResources){
            countAllRes += i;
        }
        rate = countAllRes / liftingCapacityArmy;

        int[] takeAwayResources = new int[] {village.getIron() / rate,village.getClay() / rate,
                village.getCorn() / rate, village.getWater() / rate};

        village.setIron(village.getIron() - (village.getIron() / rate));
        village.setClay(village.getClay() - (village.getClay() / rate));
        village.setCorn(village.getCorn() - (village.getCorn() / rate));
        village.setWater(village.getWater() - (village.getWater() / rate));

        return takeAwayResources;
    }
}
