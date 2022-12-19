package com.mygdx.game;

public class Fuel {
    private double percent=100;
    public void reduceFuel(Double percent)
    {
        this.percent=percent;
    }
    public void resetFuel(Double percent)
    {
        this.percent=100;
    }



}
