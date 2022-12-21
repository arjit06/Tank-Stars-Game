package com.mygdx.game;

import java.io.Serializable;
import java.util.ArrayList;

public class BuratinoTank extends Tank implements Serializable {
    private ArrayList<Weapon> weapons;
    private ArrayList<Weapon> currWeapons;
    public BuratinoTank(Float x, Float y, Float width, Float height,int number) {
        super(x, y, width, height,"burratino",number);
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

    /*@Override
    private String getName()
    {
        return this.name;
    }*

     */
    /*private void setName()
    {
        super.setName(this.name);
    }*/
}
