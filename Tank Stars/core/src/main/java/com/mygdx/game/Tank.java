package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Tank implements Serializable
{
    private String name;
    private Float x,x2,xi;
    private Float y,y2,yi;
    private Float width;
    private Float height;
    private Float bodyHeight;
    private Float nozzleHeight;

    private ArrayList<Weapon> weapons=new ArrayList<>();
    private Player player;
    private Fuel fuel;
    private transient Texture tankBodyImage;
    private transient Texture tankNozzleImage;
    private transient Texture tankCapImage;
    private transient Texture nukeImage;

    private transient Sprite tankNozzlesprite;
    private transient Sprite tankBodysprite;
    private transient Sprite tankCapsprite;
    private transient Sprite nukeSprite;

    private int flag=0,angle_flag=0;

    private Float speed=50f,power=50f;
    int number;
    public void necessityTank()
    {
//        String player_Tank=this.getName();
//        String name_body=player_Tank+"_body.png";
//        String name_nozzle=player_Tank+"_nozzle.png";
        String player_Tank=this.getName();
        String name_body=player_Tank+"_body_p"+String.valueOf(this.number)+".png";
        String name_nozzle=player_Tank+"_nozzle_p1.png";//_nozzle_p"+String.valueOf(this.number)+".png";
        String name_cap=player_Tank+"_cap.png";
        this.tankBodyImage=new Texture(name_body);
        this.tankNozzleImage=new Texture(name_nozzle);

        this.tankCapImage=new Texture(name_cap);
        this.nukeImage=new Texture("nuke.png");

        this.tankNozzlesprite = new Sprite(tankNozzleImage);
        this.tankBodysprite = new Sprite(tankBodyImage);

        this.tankCapsprite=new Sprite(tankCapImage);
        this.nukeSprite=new Sprite(nukeImage);



    }
    public Tank(Float x,Float y,Float width,Float height,String name,int number)
    {
        this.x=x;


        this.y=y;
        //this.y2=this.
        this.width=width;
        this.height=height;
        this.x2=this.x+width;
        this.y2=this.y+height;
        this.bodyHeight=0.57f*this.height;
        this.nozzleHeight=this.height-this.bodyHeight;
        this.name=name;
       // this.speed=this.power/2;
        this.fuel=new Fuel();
        this.number=number;

        //change
        String player_Tank=this.getName();
        String name_body=player_Tank+"_body_p"+String.valueOf(this.number)+".png";
        String name_nozzle=player_Tank+"_nozzle_p1.png";//_nozzle_p"+String.valueOf(this.number)+".png";
        String name_cap=player_Tank+"_cap.png";

       // System.out.println(name_body);

        tankBodyImage=new Texture(name_body);
        tankNozzleImage=new Texture(name_nozzle);
        tankCapImage=new Texture(name_cap);
        nukeImage=new Texture("nuke.png");

        tankNozzlesprite = new Sprite(tankNozzleImage);
        tankBodysprite = new Sprite(tankBodyImage);
        tankCapsprite=new Sprite(tankCapImage);
        nukeSprite=new Sprite(nukeImage);
    }

    public void setAngle()//Tank tank,Sprite tankNozzlesprite,Sprite tankBodysprite)
    {

        if (Gdx.input.justTouched())
        {
            flag++;
        }
        //System.out.println(flag);


        if (flag==1 ) //touch aim to set angle, set angle  then touch again  to fix
        {
            //update the position of the mouse cursor
            int mouse_x = Gdx.input.getX();
            int mouse_y = Gdx.input.getY();
            mouse_y=480-mouse_y;
            double num=(mouse_y-this.gety());
            double denom=(mouse_x-this.getx());
            double fraction=num/denom;

            if (this.number==1) {
                double angle = (Math.toDegrees(Math.atan(fraction)));

                if (angle <= 90) tankNozzlesprite.setRotation((int) angle);
//                else if (angle > 90 && angle <= 180) {
//                    tankNozzlesprite.setRotation((int) angle);
//                }
            }
            else
            {
                fraction*=-1;
                double angle = (Math.toDegrees(Math.atan(fraction)));
                if (num>=0 && denom<=0) tankNozzlesprite.setRotation(180-(int) angle);

            }
                //tankBodysprite.setFlip(false,true);
//                tankBodysprite.flip(true, false); ..........
//                tankNozzlesprite.flip(true, false);
                //tankNozzlesprite.setRotation(90-((int)angle-90));

        }
        else GameScreen.angle_flag=0;

    }

    public void update()
    {
        double tank_angle;
        float angle_diff;
        float slope;
        int idx;
        float tank_x=(float) ((this.getx()));
        angle_diff= tankNozzlesprite.getRotation()-tankBodysprite.getRotation();

        if (this.number==1) tankNozzlesprite.setOrigin(0,0);
        else tankNozzlesprite.setOrigin(0,0);

        if (this.number==1) tankNozzlesprite.setPosition(this.x,this.y+this.getBodyHeight());
        else tankNozzlesprite.setPosition(this.getx()+this.width,this.gety()+this.getBodyHeight());



        tankNozzlesprite.setSize(this.getWidth(), this.getNozzleHeight());
       // if (this.player.getNumber()==2) tankNozzlesprite.flip(true, false);



        tankBodysprite.setOrigin(0,0);
        tankBodysprite.setPosition(this.getx(),this.gety());
        tankBodysprite.setSize(this.getWidth(), this.getBodyHeight());
       //if (this.player.getNumber()==2) tankBodysprite.flip(true, false);

//        int offset;
//        if (this.number==1) offset=10;
//        //else offset=

        if (this.name.equals("abrams"))
        {
            if (this.number==1)tankCapsprite.setPosition(this.getTankNozzlesprite().getX() + 10, this.getTankNozzlesprite().getY());
            //else tankCapsprite.setPosition(this.x +this.width-10 , this.getTankBodysprite().getHeight());
        }
        else
        {
            if (this.number==1)tankCapsprite.setPosition(this.getTankNozzlesprite().getX(), this.getTankNozzlesprite().getY());
           // float angle=Math.toDegrees(Math.cos(this.getTankBodysprite().));
            //else  tankCapsprite.setPosition(this.getTankNozzlesprite().getX()-20, this.getTankNozzlesprite().getY());
        }

        //if (this.player.getNumber()==2) this.tankCapsprite.flip(true,false);



       // tankCapsprite

//        int tank_origin=calcIndex(tank.getx());
//        slope=equation.get(tank_origin).get(0);
//        tank_angle=Math.atan(slope);
//        float tank_midpoint= (float) (((tank.getWidth())/(Math.cos(tank_angle))/2)-10);
//        idx=calcIndex((float) ((tank.getx()+tank_midpoint)));

        idx=GameScreen.calcIndex(tank_x);
        if (GameScreen.getTURN()==1)
        {
            if (idx == 2) {
                if (tank_x >= 313) idx++;
            }
            if (idx == 3) {
                if (tank_x >= 447) idx++;
            }
            if (idx == 4) {
                if (tank_x >= 622) idx++;
            }

        }
        slope=GameScreen.getEquation().get(idx).get(0);
        tank_angle=(Math.toDegrees(Math.atan(slope)));
        tankBodysprite.setRotation((int)tank_angle);
        tankNozzlesprite.setRotation(angle_diff+tankBodysprite.getRotation());
        tankCapsprite.setRotation(tankBodysprite.getRotation());

    }

    public void handle_tank_movement(float delta)
    {
        int idx;
        //handle tank movement
        Float x,y;
        this.xi=this.x;this.yi=this.y;
        x=this.getx();
        y=this.gety();
        if (this.getFuel().getPercent()<=0) return;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {      //left
            idx=GameScreen.calcIndex(x);
            this.setx(this.getx() - this.getSpeed()*delta);
            this.sety(GameScreen.getEquation().get(idx).get(0) * this.getx() + GameScreen.getEquation().get(idx).get(1));
            this.getFuel().reduceFuel((double) ((Math.abs(this.x-this.xi))/2));
            //this.setFuel(this.getFuel().getPercent()-(Math.abs(this.x-this.xi))/2);
        }
        if (this.getFuel().getPercent()<=0) return;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) //right
        {
            idx=GameScreen.calcIndex(x);
            this.setx(this.getx() + this.getSpeed()* Gdx.graphics.getDeltaTime());
            this.sety(GameScreen.getEquation().get(idx).get(0) * this.getx() + GameScreen.getEquation().get(idx).get(1));
            this.getFuel().reduceFuel((double) ((Math.abs(this.x-this.xi))/2));

        }

        if (this.getx() < 0)
        {
            this.setx(0f);
        }
        if (this.getx() > 800 - this.getWidth())
        {
            this.setx(800 - this.getWidth());
        }

        this.x2=this.x+width;

    }

    public void fireNuke(Weapon weapon,MyGdxGame game,float delta,Texture nukeImage )
    {
        //game.getBatch().begin();
        //System.out.println((weapon.isBulletDead));
//        if (weapon.isBulletDead==0) {
//            weapon.projectileMotion(delta);
//            game.getBatch().draw(nukeImage, weapon.getX(), weapon.getY(), weapon.getWidth(), weapon.getHeight());
//        }
//        else  GameScreen.change_Turn(GameScreen.getTURN());
//        game.getBatch().end();



    }


    public Float getx() {
        return x;
    }

    public void setx(Float x) {
        this.x = x;
    }

    public Float gety() {
        return y;
    }

    public void sety(Float y) {
        this.y = y;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(Float bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public Float getNozzleHeight() {
        return nozzleHeight;
    }

    public void setNozzleHeight(Float nozzleHeight) {
        this.nozzleHeight = nozzleHeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public Texture getTankBodyImage() {
        return tankBodyImage;
    }

    public void setTankBodyImage(Texture tankBodyImage) {
        this.tankBodyImage = tankBodyImage;
    }

    public Texture getTankNozzleImage() {
        return tankNozzleImage;
    }

    public void setTankNozzleImage(Texture tankNozzleImage) {
        this.tankNozzleImage = tankNozzleImage;
    }

    public Texture getTankCapImage() {
        return tankCapImage;
    }

    public void setTankCapImage(Texture tankCapImage) {
        this.tankCapImage = tankCapImage;
    }

    public Sprite getTankNozzlesprite() {
        return tankNozzlesprite;
    }

    public void setTankNozzlesprite(Sprite tankNozzlesprite) {
        this.tankNozzlesprite = tankNozzlesprite;
    }

    public Sprite getTankBodysprite() {
        return tankBodysprite;
    }

    public void setTankBodysprite(Sprite tankBodysprite) {
        this.tankBodysprite = tankBodysprite;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Texture getNukeImage() {
        return nukeImage;
    }

    public void setNukeImage(Texture nukeImage) {
        this.nukeImage = nukeImage;
    }

    public Sprite getNukeSprite() {
        return nukeSprite;
    }

    public void setNukeSprite(Sprite nukeSprite) {
        this.nukeSprite = nukeSprite;
    }

    public Sprite getTankCapsprite() {
        return tankCapsprite;
    }

    public void setTankCapsprite(Sprite tankCapsprite) {
        this.tankCapsprite = tankCapsprite;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public Float getX2() {
        return x2;
    }

    public void setX2(Float x2) {
        this.x2 = x2;
    }

    public Float getXi() {
        return xi;
    }

    public void setXi(Float xi) {
        this.xi = xi;
    }

    public Float getYi() {
        return yi;
    }

    public void setYi(Float yi) {
        this.yi = yi;
    }

    public Float getY2() {
        return y2;
    }

    public void setY2(Float y2) {
        this.y2 = y2;
    }
}
