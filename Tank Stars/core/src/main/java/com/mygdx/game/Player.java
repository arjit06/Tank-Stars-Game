package com.mygdx.game;

import java.io.Serializable;

public class Player implements Serializable
{
   private int number;
    private Tank tank;
    private Weapon currWeapon;
    private Health health;
    public Player(Tank t,int no)
    {
        this.tank=t;
        this.health=new Health();
        this.number=no;
        //this.tank.setPlayer(this);
       // this.number=number;
    }

    public void maxImpact(Weapon weapon)
    {
        this.health.reduceHealth(weapon.getMaxDamagePercent());
    }
    public void submaxImpact(Weapon weapon)
    {
        this.health.reduceHealth(0.5* weapon.getMaxDamagePercent());
    }
    public void minImpact(Weapon weapon)
    {
        this.health.reduceHealth(0.25* weapon.getMaxDamagePercent());
    }

    //calc for health red .tank range: 100% of max damage, +-10: 50% , +-20: 25%
    //width 80
    //height 60
    public void healthReduction(Float x,Float y,Weapon weapon)
    {
        x=x+40;
        if (x>=this.tank.getx() && x<=this.tank.getX2()) maxImpact(weapon);
        else if ( (x>=(this.tank.getx()-20) && x<=(this.tank.getx())) || (x>=(this.tank.getX2()) && x<=(this.tank.getX2() +20))) submaxImpact(weapon);
        else if ( (x>=(this.tank.getx()-40) && x<=(this.tank.getx())-20) || (x>=(this.tank.getX2()+20) && x<=(this.tank.getX2() +40))) minImpact(weapon);
        //System.out.println(this.tank.getx()+" "+ (this.tank.getx()-30));
        System.out.println(x);


//        double damage=0.0;
//        if(x>=this.getTank().getx()-40 && x<=this.getTank().getx()+40)
//        {
//            //take weapon into account..
//
//            if(weapon.equals("1"))
//            {
//                damage=5;
//            }
//            else if(weapon.equals("2"))
//            {
//
//                damage=10;
//            }
//            else
//            {
//                damage=15;
//            }
//            this.getHealth().reduceHealth(60.00-damage);
//            //this.setHealth(80f);
//        }
//        else if(x<this.getTank().getx()-40 && x>=this.getTank().getx()-80)
//        {
//            if(weapon.equals("1"))
//            {
//                damage=5;
//            }
//            else if(weapon.equals("2"))
//            {
//
//                damage=10;
//            }
//            else
//            {
//                damage=15;
//            }
//            this.getHealth().reduceHealth(70.00-damage);
//            //this.setHealth(80f);
//        }
//        else if(x>this.getTank().getx()+40 && x<=this.getTank().getx()+80)
//        {
//            if(weapon.equals("1"))
//            {
//                damage=5;
//            }
//            else if(weapon.equals("2"))
//            {
//
//                damage=10;
//            }
//            else
//            {
//                damage=15;
//            }
//            this.getHealth().reduceHealth(70.00-damage);
//            //this.setHealth(80f);
//        }
//        else if(x<this.getTank().getx()-80 && x>=this.getTank().getx()-120)
//        {
//            if(weapon.equals("1"))
//            {
//                damage=5;
//            }
//            else if(weapon.equals("2"))
//            {
//
//                damage=10;
//            }
//            else
//            {
//                damage=15;
//            }
//
//
//            this.getHealth().reduceHealth(80.00-damage);
//            //this.setHealth(80f);
//        }
//        else if(x>=this.getTank().getx()+80 && x<=this.getTank().getx()+120)
//        {
//            if(weapon.equals("1"))
//            {
//                damage=5;
//            }
//            else if(weapon.equals("2"))
//            {
//
//                damage=10;
//            }
//            else
//            {
//                damage=15;
//            }
//            this.getHealth().reduceHealth(80.00-damage);
//            //this.setHealth(80f);
//        }
//        else
//        {
//            return;
//
//        }
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //    public void moveTank(Double dist)
//    {
//
//    }


}
