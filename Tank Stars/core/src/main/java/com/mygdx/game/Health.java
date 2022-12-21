package com.mygdx.game;

import java.io.Serializable;

public class Health implements Serializable {
    private double percent=100;
    public void reduceHealth(Double percent)
    {
        this.percent-=percent;
    }

    public double getPercent() {
        return percent;
    }
}
