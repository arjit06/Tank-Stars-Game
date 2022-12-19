package com.mygdx.game;

import java.util.ArrayList;

public class Ground {
    private ArrayList<ArrayList<Float>> equation=new ArrayList<ArrayList<Float>> ();
    private ArrayList <Float> i1=new ArrayList<Float>();
    private ArrayList <Float> i2=new ArrayList<Float>();
    private ArrayList <Float> i3=new ArrayList<Float>();
    private ArrayList <Float> i4=new ArrayList<Float>();
    private ArrayList <Float> i5=new ArrayList<Float>();
    private ArrayList <Float> i6=new ArrayList<Float>();
    private ArrayList <Float> i7=new ArrayList<Float>();
    private ArrayList <Float> i8=new ArrayList<Float>();

    public Ground() {
        i1.add(0.67f);
        i1.add(80.0f);
        equation.add(i1);

        i2.add(0,0.23f);
        i2.add(1,127.69f);
        equation.add(i2);

        i3.add(0,-0.97872340425531914893617f);
        i3.add(1,506.31f);
        equation.add(i3);

        i4.add(0,-0.48484848484848484848484f);
        i4.add(1,328.01f);
        equation.add(i4);

        i5.add(0,-0.02604166666666666666666f);
        i5.add(1,116.96f);
        equation.add(i5);

        i6.add(0,0.64f);
        i6.add(1,-317.28f);
        equation.add(i6);

        i7.add(0,-0.64f);
        i7.add(1,583.32f);
        equation.add(i7);

        i8.add(0,0.0f);
        i8.add(1,105.0f);
        equation.add(i8);
    }

    public ArrayList<ArrayList<Float>> getEquation() {
        return equation;
    }
}
