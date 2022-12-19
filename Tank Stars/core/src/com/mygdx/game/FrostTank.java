package com.mygdx.game;

import java.util.ArrayList;

public class FrostTank extends Tank{
    private ArrayList<Weapon> weapons;
    private ArrayList<Weapon> currWeapons;
    public FrostTank(Float x, Float y, Float width, Float height) {
        super(x, y, width, height,"frost");
    }
    public void fireWeapon()
    {

    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setCurrWeapons(ArrayList<Weapon> currWeapons) {
        this.currWeapons = currWeapons;
    }
}