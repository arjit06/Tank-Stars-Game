package com.mygdx.game;


import com.badlogic.gdx.Game;

public class Weapon {
    private String name;
    private Double maxDamagePercent= Double.valueOf(0);

    private Float x;
    private Float x0;
    private Float y;
    private Float y0;
    private Float width;
    private Float height;
    private Float bodyHeight;

    private Float speed;//=200f;
    private double deltaTime;
    private float ay=9.8f;
    private float ax=0;
    private float angle;
    private float vx;
    private float vy;
    private float ux;
    private float uy;
    private float A ;
    private float B; // y=Ax - Bx^2
    float diff;
    Float limitY;
    int isBulletDead=0;
    int cnt=0;

    public Weapon(String name, Double maxDamagePercent, Float x, Float y, Float width, Float height) {
        this.name = name;
        this.maxDamagePercent = maxDamagePercent;
        this.x = x;
        this.x0=x;
        this.y = y;
        this.y0=y;
        this.speed=85f;
        this.width = width;
        this.height = height;
        this.angle=50f;
        this.A= (float) Math.tan(Math.toRadians(angle));
        this.B= (float) (ay/(2*speed*speed* Math.cos(Math.toRadians(angle)) * Math.cos(Math.toRadians(angle) )));
        ux= (float) (speed*Math.cos(Math.toRadians(angle)));
        uy= (float) (speed*Math.sin(Math.toRadians(angle)));

    }



    public void blast(Float limitY)
    {

        if (cnt>50)
        {
            this.isBulletDead=1;
        }

        //code
    }

    //public

    public void projectileMotion(Float delta)
    {
        delta=delta*4;
        cnt++;

        if (this.isBulletDead==1) return;

        this.x+=ux*delta;
        this.y=A*x-(B*x*x);
        if (cnt==1) diff=this.y0-this.y;
        this.y+=diff;

        if (x>=0 && x<=107)
        {
            limitY=GameScreen.getEquation().get(0).get(0)*this.x + GameScreen.getEquation().get(0).get(1) -5; //y=mx+c of ground at curr x
            if(this.y<(limitY))
            {

                this.blast(limitY);
            }
//            if(GameScreen.getTURN()==1)
//            {
//                Player currPlayer=GameScreen.getPlayer2();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }
//            else
//            {
//                Player currPlayer=GameScreen.getPlayer1();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }
        }
        else if( x>=107 && x<=314) {
            limitY=GameScreen.getEquation().get(1).get(0)*this.x + GameScreen.getEquation().get(1).get(1) -5;
            if(this.y <limitY)
            {
                this.blast(limitY);
            }
//            if(GameScreen.getTURN()==1)
//            {
//                Player currPlayer=GameScreen.getPlayer2();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }
//            else
//            {
//                Player currPlayer=GameScreen.getPlayer1();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }


        }
        else if( x>=314 && x<=361)
        {
            limitY=GameScreen.getEquation().get(2).get(0)*this.x + GameScreen.getEquation().get(2).get(1) -5;
            if(this.y<limitY)
            {
                this.blast(limitY);
            }
//            if(GameScreen.getTURN()==1)
//            {
//                Player currPlayer=GameScreen.getPlayer2();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }
//            else
//            {
//                Player currPlayer=GameScreen.getPlayer1();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }

        }
        else if( x>=361 && x<=460)
        {
            limitY=GameScreen.getEquation().get(3).get(0)*this.x + GameScreen.getEquation().get(3).get(1) -5;
            if(this.y <limitY)
            {
                this.blast(limitY);
//                if(GameScreen.getTURN()==1)
//                {
//                    Player currPlayer=GameScreen.getPlayer2();
//                    currPlayer.healthReduction(this.x,this.y,this);
//                }
//                else
//                {
//                    Player currPlayer=GameScreen.getPlayer1();
//                    currPlayer.healthReduction(this.x,this.y,this);
//                }
            }


        }
        else if( x>=460 && x<=652) {
            limitY=GameScreen.getEquation().get(4).get(0)*this.x + GameScreen.getEquation().get(4).get(1) -5;
            if(this.y<limitY)
            {
                this.blast(limitY);
            }
//            if(GameScreen.getTURN()==1)
//            {
//                Player currPlayer=GameScreen.getPlayer2();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }
//            else
//            {
//                Player currPlayer=GameScreen.getPlayer1();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }

        }
        else if( x>=652 && x<=702) {
            limitY=GameScreen.getEquation().get(5).get(0)*this.x + GameScreen.getEquation().get(5).get(1) -5;
            if(this.y <limitY)
            {
                this.blast(limitY);
            }
//            if(GameScreen.getTURN()==1)
//            {
//                Player currPlayer=GameScreen.getPlayer2();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }
//            else
//            {
//                Player currPlayer=GameScreen.getPlayer1();
//                currPlayer.healthReduction(this.x,this.y,this);
//            }

        }
        else if( x>=702 && x<=744) {
            limitY=GameScreen.getEquation().get(6).get(0)*this.x + GameScreen.getEquation().get(6).get(1)-5;
            if(this.y <limitY)
            {
                this.blast(limitY);
//                if(GameScreen.getTURN()==1)
//                {
//                    Player currPlayer=GameScreen.getPlayer2();
//                    currPlayer.healthReduction(this.x,this.y,this);
//                }
//                else
//                {
//                    Player currPlayer=GameScreen.getPlayer1();
//                    currPlayer.healthReduction(this.x,this.y,this);
//                }

            }


        }
        else if( x>=744 && x<=800) {
            limitY=GameScreen.getEquation().get(7).get(0)*this.x + GameScreen.getEquation().get(7).get(1)-5;
            if(this.y<limitY)
            {
                this.blast(limitY);
            }

        }
    }


    public Float getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(Float bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public Double getMaxDamagePercent() {
        return maxDamagePercent;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public Float getWidth() {
        return width;
    }

    public Float getHeight() {
        return height;
    }

    @Override
    public String toString()
    {
        return this.name;
    }
}