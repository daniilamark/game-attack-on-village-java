package com.daniilamark;

public class Village {
    private int iron, clay, corn, water;
    private int [] currentResourcesInVillage;

    public Village(int iron, int clay, int corn, int water){
        this.iron = iron;
        this.clay = clay;
        this.corn = corn;
        this.water = water;
    }

    public int[] getCurrentResourcesInVillage() {
        currentResourcesInVillage = new int[] {getIron(), getClay(), getCorn(), getWater()};
        return currentResourcesInVillage;
    }

    public int getIron() {
        return iron;
    }

    public void setIron(int iron) {
        this.iron = iron;
    }

    public int getClay() {
        return clay;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setClay(int clay) {
        this.clay = clay;
    }

    public int getCorn() {
        return corn;
    }

    public void setCorn(int corn) {
        this.corn = corn;
    }
}
