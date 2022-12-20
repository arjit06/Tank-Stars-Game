package com.mygdx.game;

public class Fuel {
    private double percent=100; //1 unit of fuel = two x coords
    public void reduceFuel(Double percent)
    {
        this.percent-=percent;
    }
    public void resetFuel()
    {
        this.percent=100;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
