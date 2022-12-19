package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class Tank
{
    private String name;
    private Float x;
    private Float y;
    private Float width;
    private Float height;
    private Float bodyHeight;
    private Float nozzleHeight;

    private ArrayList<Weapon> weapons=new ArrayList<>();
    private Player player;
    private Fuel fuel;
    private Texture tankBodyImage;
    private Texture tankNozzleImage;
    private Texture tankCapImage;

    private Sprite tankNozzlesprite;
    private Sprite tankBodysprite;

    private int flag=0,angle_flag=0;

    private Float speed=50f;
    public Tank(Float x,Float y,Float width,Float height,String name)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.bodyHeight=0.57f*this.height;
        this.nozzleHeight=this.height-this.bodyHeight;
        this.name=name;
        this.fuel=new Fuel();

        //change
        String player_Tank=this.getName();
        String name_body=player_Tank+"_body.png";
        String name_nozzle=player_Tank+"_nozzle.png";

        tankBodyImage=new Texture(name_body);
        tankNozzleImage=new Texture(name_nozzle);

        tankNozzlesprite = new Sprite(tankNozzleImage);
        tankBodysprite = new Sprite(tankBodyImage);
    }

    public void setAngle()//Tank tank,Sprite tankNozzlesprite,Sprite tankBodysprite)
    {
        if (Gdx.input.justTouched())
        {
            flag++;
//            tankBodysprite.flip(true,false);
//            tankNozzlesprite.flip(true,false);
        }

        if (flag==1 ) //touch aim to set angle, set angle  then touch again  to fix
        {
            //update the position of the mouse cursor
            int mouse_x = Gdx.input.getX();
            int mouse_y = Gdx.input.getY();
            mouse_y=480-mouse_y;
            double angle =(Math.toDegrees(Math.atan(((mouse_y-this.gety())/(mouse_x-this.getx())))));

            if ( angle <= 90) tankNozzlesprite.setRotation((int)angle);
            else if (angle > 90 && angle <= 180) {
                tankNozzlesprite.setRotation((int)angle);
                //tankBodysprite.setFlip(false,true);
//                tankBodysprite.flip(true, false);
//                tankNozzlesprite.flip(true, false);
                //tankNozzlesprite.setRotation(90-((int)angle-90));
            }
        }
    }

    public void update()
    {
        double tank_angle;
        float angle_diff;
        float slope;
        int idx;
        float tank_x=(float) ((this.getx()));
        angle_diff= tankNozzlesprite.getRotation()-tankBodysprite.getRotation();

        tankNozzlesprite.setOrigin(0,0);
        tankNozzlesprite.setPosition(this.getx(),this.gety()+this.getBodyHeight());
        tankNozzlesprite.setSize(this.getWidth(), this.getNozzleHeight());


        tankBodysprite.setOrigin(0,0);
        tankBodysprite.setPosition(this.getx(),this.gety());
        tankBodysprite.setSize(this.getWidth(), this.getBodyHeight());

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

    }

    public void handle_tank_movement(float delta)
    {
        int idx;
        //handle tank movement
        Float x,y;
        x=this.getx();
        y=this.gety();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {      //left
            idx=GameScreen.calcIndex(x);
            this.setx(this.getx() - this.getSpeed()*delta);
            this.sety(GameScreen.getEquation().get(idx).get(0) * this.getx() + GameScreen.getEquation().get(idx).get(1));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) //right
        {
            idx=GameScreen.calcIndex(x);
            this.setx(this.getx() + this.getSpeed()* Gdx.graphics.getDeltaTime());
            this.sety(GameScreen.getEquation().get(idx).get(0) * this.getx() + GameScreen.getEquation().get(idx).get(1));

        }

        if (this.getx() < 0)
        {
            this.setx(0f);
        }
        if (this.getx() > 800 - this.getWidth())
        {
            this.setx(800 - this.getWidth());
        }

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
}
