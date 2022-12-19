package com.mygdx.game;

public class Player
{
    private Tank tank;
    private Weapon currWeapon;
    private Health health;
    public Player(Tank t)
    {
        this.tank=t;
    }

    //private Tank tank;

    public void adjustHealth(Double percent)
    {
        this.health.reduceHealth(percent);
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Weapon getCurrWeapon() {
        return currWeapon;
    }

    public void setCurrWeapon(Weapon currWeapon) {
        this.currWeapon = currWeapon;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    //    public void moveTank(Double dist)
//    {
//
//    }

    //calc for health red
    //width 80
    //height 60
    public void healthReduction(Float x,Float y,Weapon weapon)
    {
        double damage=0.0;
        if(x>=this.getTank().getx()-40 && x<=this.getTank().getx()+40)
        {
            //take weapon into account..

            if(weapon.equals("1"))
            {
                damage=5;
            }
            else if(weapon.equals("2"))
            {

                damage=10;
            }
            else
            {
                damage=15;
            }
            this.getHealth().reduceHealth(60.00-damage);
            //this.setHealth(80f);
        }
        else if(x<this.getTank().getx()-40 && x>=this.getTank().getx()-80)
        {
            if(weapon.equals("1"))
            {
                damage=5;
            }
            else if(weapon.equals("2"))
            {

                damage=10;
            }
            else
            {
                damage=15;
            }
            this.getHealth().reduceHealth(70.00-damage);
            //this.setHealth(80f);
        }
        else if(x>this.getTank().getx()+40 && x<=this.getTank().getx()+80)
        {
            if(weapon.equals("1"))
            {
                damage=5;
            }
            else if(weapon.equals("2"))
            {

                damage=10;
            }
            else
            {
                damage=15;
            }
            this.getHealth().reduceHealth(70.00-damage);
            //this.setHealth(80f);
        }
        else if(x<this.getTank().getx()-80 && x>=this.getTank().getx()-120)
        {
            if(weapon.equals("1"))
            {
                damage=5;
            }
            else if(weapon.equals("2"))
            {

                damage=10;
            }
            else
            {
                damage=15;
            }
            this.getHealth().reduceHealth(80.00-damage);
            //this.setHealth(80f);
        }
        else if(x>=this.getTank().getx()+80 && x<=this.getTank().getx()+120)
        {
            if(weapon.equals("1"))
            {
                damage=5;
            }
            else if(weapon.equals("2"))
            {

                damage=10;
            }
            else
            {
                damage=15;
            }
            this.getHealth().reduceHealth(80.00-damage);
            //this.setHealth(80f);
        }
        else
        {
            return;

        }
    }

}
