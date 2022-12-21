package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.Serializable;
import java.util.ArrayList;

public class GameScreen implements Screen, Serializable
{
    private MyGdxGame game;
    private transient BitmapFont font;
    private static int TURN=1;
    private transient OrthographicCamera camera;

    private transient Texture ground;
    private transient Texture  health_bar_bg;
    private transient Texture  health_bar;
    private transient Texture  vs;
    private transient Texture medal,fire,aim,power_red,power_black,chance,pauseButton;
    private transient Texture bg;
    private transient Texture nukeImage;
    private Float next;
    transient Music  gamebgmusic;
    transient Sound shoot;
    //private World world;
    ///private Box2DDebugRenderer debugRenderer;
    private static ArrayList<ArrayList<Float>> equation=new ArrayList<ArrayList<Float>> ();
    private Player player1;
    private Player player2;
    private  Weapon weapon;
    private int flag=0;
    private int cnt=0;
    private int nukeFlag=0;
    public static int angle_flag=0;
    private static int start=0;
    float weapon_x,weapon_y;
    private transient MainScreen mainScreen;
    float power_red_Width_p1=75,power_red_Width_p2=75,weapon_speed_p1=85f,weapon_speed_p2=85f;
    float health_width_p1=200,health_width_p2=200;

    //added for saving game..
    private static DataClass dataClass;
    public void necessity()
    {
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 800, 480);
        this.ground=new Texture("ground.png");
        this.bg=new Texture("game_screen_bg.png");
        this.health_bar_bg=new Texture("health_bar_border.png");
        this.health_bar=new Texture("blue_health_bar.png");
        this.nukeImage=new Texture("nuke.png");
        this.player1.getTank().necessityTank();
        this.player2.getTank().necessityTank();

        //Sound explosion=Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));
        this.weapon.necessityWeapon();
        this.game=MyGdxGame.getInstance();
        this.vs=new Texture("vs.png");
        this.medal=new Texture("medal.png");
        this.fire=new Texture("fire.png");
        this.aim=new Texture("aim.png");
        this.power_red=new Texture("power_red.png");
        this.power_black=new Texture("power_black.png");
        this.chance=new Texture("chance.png");
        this.pauseButton=new Texture("pause_button.png");
        this.font = new BitmapFont();
        this.font.setColor(Color.WHITE);
        this.gamebgmusic=Gdx.audio.newMusic(Gdx.files.internal("gameScreenBgSound.mp3"));
        this.gamebgmusic.setLooping(true);
        this.shoot=Gdx.audio.newSound(Gdx.files.internal("shoot.mp3"));
        this.mainScreen=new MainScreen(this.game);
        //this.chance=
        createEquationArrayList();
        setEquation(this.equation);
        this.dataClass=setDataClass();


        //ground=new Texture("ground.png");
        //bg=new Texture("game_screen_bg.png");
        //health_bar_bg=new Texture("health_bar_border.png");
        //health_bar=new Texture("blue_health_bar.png");
        //vs=new Texture("vs.png");
        medal=new Texture("medal.png");
        fire=new Texture("fire.png");
        aim=new Texture("aim.png");
        power_red=new Texture("power_red.png");
        power_black=new Texture("power_black.png");
        chance=new Texture("chance.png");
        pauseButton=new Texture("pause_button.png");
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        gamebgmusic=Gdx.audio.newMusic(Gdx.files.internal("gameScreenBgSound.mp3"));
        gamebgmusic.setLooping(true);
        shoot=Gdx.audio.newSound(Gdx.files.internal("shoot.mp3"));
        initializePlayerTanks();
    }

    public GameScreen(MyGdxGame game,MainScreen mainScreen)
    {
        createSpritesAndTextures();
        this.player1=SetPlayer.getPlayer1();
        this.player1.getTank().setPlayer(this.player1);
        this.player2=SetPlayer.getPlayer2();
        this.player2.getTank().setPlayer(this.player2);

        initializePlayerTanks();

        this.game=game;
        this.mainScreen=mainScreen;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        //create the arraylist containg slopes and constants in (m,c) form for y=mx+c
        createEquationArrayList();

        //added for saving game..
        this.dataClass=setDataClass();
    }

    public void initializePlayerTanks()
    {
        Tank t=player2.getTank();
        t.getTankNozzlesprite().setOrigin(0,0);
        t.getTankNozzlesprite().setPosition(t.getx()+t.getWidth(),t.gety()+t.getBodyHeight());
        t.getTankNozzlesprite().setSize(t.getWidth(), t.getNozzleHeight());
        t.getTankNozzlesprite().setRotation(150);
        //t.getTankNozzlesprite().flip(true, false);


        t.getTankBodysprite().setOrigin(0,0);
        t.getTankBodysprite().setPosition(t.getx(),t.gety());
        t.getTankBodysprite().setSize(t.getWidth(), t.getBodyHeight());
        //t.getTankBodysprite().flip(true, false);

        t.getTankCapsprite().setOrigin(0,0);
        //t.getTankCapsprite().setPosition(t.getTankNozzlesprite().getX()-20, t.getTankNozzlesprite().getY());
        t.getTankCapsprite().setSize(10, 20);
       // t.getTankCapsprite().flip(true,false);



        t=player1.getTank();
        t.getTankNozzlesprite().setOrigin(0,0);
        t.getTankNozzlesprite().setPosition(t.getx(),t.gety()+t.getBodyHeight());
        t.getTankNozzlesprite().setSize(t.getWidth(), t.getNozzleHeight());


        t.getTankBodysprite().setOrigin(0,0);
        t.getTankBodysprite().setPosition(t.getx(),t.gety());
        t.getTankBodysprite().setSize(t.getWidth(), t.getBodyHeight());

        t.getTankCapsprite().setOrigin(0,0);
        //t.getTankCapsprite().setPosition(t.getTankNozzlesprite().getX(), t.getTankNozzlesprite().getY());
        if (t.getName().equals("abrams")) t.getTankCapsprite().setPosition(t.getTankNozzlesprite().getX()+10, t.getTankNozzlesprite().getY());
        else  t.getTankCapsprite().setPosition(t.getTankNozzlesprite().getX(), t.getTankNozzlesprite().getY());
        t.getTankCapsprite().setSize(10, 20);


        player1.getTank().setXi(player1.getTank().getx());
        player2.getTank().setXi(player2.getTank().getx());


    }

    public void createSpritesAndTextures()
    {
        ground=new Texture("ground.png");
        bg=new Texture("game_screen_bg.png");
        health_bar_bg=new Texture("health_bar_border.png");
        health_bar=new Texture("blue_health_bar.png");
        vs=new Texture("vs.png");
        medal=new Texture("medal.png");
        fire=new Texture("fire.png");
        aim=new Texture("aim.png");
        power_red=new Texture("power_red.png");
        power_black=new Texture("power_black.png");
        chance=new Texture("chance.png");
        pauseButton=new Texture("pause_button.png");
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        gamebgmusic=Gdx.audio.newMusic(Gdx.files.internal("gameScreenBgSound.mp3"));
        gamebgmusic.setLooping(true);
        shoot=Gdx.audio.newSound(Gdx.files.internal("shoot.mp3"));

        //font.getData().setScale(1.3F, 1.3F);


    }


    public static  int calcIndex(Float x)
    {
        if (x>=0 && x<=107) return 0;
        else if( x>=107 && x<=314) return 1;
        else if( x>=314 && x<=361) return 2;
        else if( x>=361 && x<=460) return 3;
        else if( x>=460 && x<=652) return 4;
        else if( x>=652 && x<=702) return 5;
        else if( x>=702 && x<=744) return 6;
        else if( x>=744 && x<=800) return 7;
        else return -1;
    }


    public void box2d()
    {
       // world = new World(new Vector2(0, -10), true);
//        debugRenderer = new Box2DDebugRenderer();
//        world.step(1/60f, 6, 2);
//
//        BodyDef bdef=new BodyDef();
//        PolygonShape shape=new PolygonShape();
//        FixtureDef fdef= new FixtureDef();
//        Body body;
//
//        bdef.type= BodyDef.BodyType.DynamicBody;
//        bdef.position.set(0,0);
//
//        body=world.createBody(bdef);
//        shape.setAsBox(0,0);
//        fdef.shape=shape;
//        body.createFixture(fdef);

    }


    public Float pixels_to_metres(Float p)
    {
        Float MULTIPLIER=0.0002645833f;
        return p* MULTIPLIER;

    }

    public void createEquationArrayList()
    {
        ArrayList <Float> i1=new ArrayList<Float>();
        ArrayList <Float> i2=new ArrayList<Float>();
        ArrayList <Float> i3=new ArrayList<Float>();
        ArrayList <Float> i4=new ArrayList<Float>();
        ArrayList <Float> i5=new ArrayList<Float>();
        ArrayList <Float> i6=new ArrayList<Float>();
        ArrayList <Float> i7=new ArrayList<Float>();
        ArrayList <Float> i8=new ArrayList<Float>();

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

    public void change_Turn(int t)
    {
        start=0;
        player1.getTank().setFlag(0);
        player2.getTank().setFlag(0);
//        player1.getCurrWeapon().isBulletDead=0;
//        if (player2!=null)player2.getCurrWeapon().isBulletDead=0;

        if (t==1)
        {
            TURN=2;
            player2.getTank().getFuel().resetFuel();
            player2.getTank().setXi(player2.getTank().getx());
        }
        else
        {
            TURN=1;
            player1.getTank().getFuel().resetFuel();
            player1.getTank().setXi(player1.getTank().getx());
        }
    }

    public void handleTurns(float delta)
    {
        if (TURN==1) //player one turn
        {
            if (Gdx.input.justTouched() && Gdx.input.getX()>=29 && Gdx.input.getX()<=78 && Gdx.input.getY()>=15 && Gdx.input.getY()<=57)
            {
                gamebgmusic.stop();
                game.setScreen(new PauseMenu(game,this));
            }

            if (Gdx.input.justTouched() && Gdx.input.getX()>=78 && Gdx.input.getX()<=224 && Gdx.input.getY()>=405 && Gdx.input.getY()<=449)
            { //power button
                power_red_Width_p1=Gdx.input.getX()-74;
                float p=(power_red_Width_p1*2)/3;
                player1.getTank().setPower(p);

//                player1.getCurrWeapon().setSpeed(p);
//                System.out.println(player1.getCurrWeapon().getSpeed());
            }
            weapon_speed_p1= player1.getTank().getPower();



            Tank t=player1.getTank();
            player1.getTank().update();  //update tank and nozzle sprites position , angles

            //set angle (aiming mechanism)
            if (Gdx.input.justTouched() && Gdx.input.getX()>=548 && Gdx.input.getX()<=620 && Gdx.input.getY()>=391 && Gdx.input.getY()<=461)
            {
                angle_flag=1;
            }
            if(angle_flag==1) player1.getTank().setAngle();


            player1.getTank().handle_tank_movement(delta);  //handle movement for tank


            //fire button pressed
            if (Gdx.input.justTouched() && Gdx.input.getX()>=316 && Gdx.input.getX()<=455 && Gdx.input.getY()>=402 && Gdx.input.getY()<=452)
            {
                float w=t.getWidth();
                float a=t.getTankNozzlesprite().getRotation();//-t.getTankNozzlesprite().getRotation();
                weapon_x= (float) ((t.getx()) + w*(Math.cos(a)));
                weapon_y= (float) ((t.gety()+t.getBodyHeight())+w*(Math.sin(a)));

                weapon_x= (float) (t.getx()+20);
                weapon_y= (float) (t.gety()+20);

                t.getNukeSprite().setOrigin(0,0);
                t.getNukeSprite().setPosition(weapon_x,weapon_y);
                t.getNukeSprite().setSize(80f,80f);

                //System.out.println(weapon_speed_p1);
                weapon=new Weapon("missile",30.0,weapon_x,weapon_y,80f,80f,player1.getTank().getTankNozzlesprite().getRotation(),weapon_speed_p1,this);
                player1.setCurrWeapon(weapon);
                shoot.play();
                //player1.getCurrWeapon().setSpeed(weapon_speed_p1);
                //t.getNukeSprite().setRotation(weapon.getAngle());

                start = 1;
            }

            if (start==1)
            {
//                player1.getTank().fireNuke(this.weapon,game,delta,nukeImage);
                if (player1.getCurrWeapon().isBulletDead==0) {
                    player1.getCurrWeapon().projectileMotion(delta,player2.getTank());
                    t.getNukeSprite().setPosition(weapon.getX(),weapon.getY());
                    t.getNukeSprite().setRotation(weapon.getAngle_with_ground());
                   // System.out.println(weapon.getAngle());
                    //t.getNukeSprite().setRotation(weapon.getAngle());
                    if (weapon.isBulletDead==0) nukeFlag=1;
                    else nukeFlag=0;
                    //game.getBatch().draw(nukeImage, weapon.getX(), weapon.getY(), weapon.getWidth(), weapon.getHeight());
                }
                else  this.change_Turn(GameScreen.getTURN());
            }
            health_width_p2= (float) player2.getHealth().getPercent()*2;

        }

        else //player two turn
        {
            if (Gdx.input.justTouched() && Gdx.input.getX()>=29 && Gdx.input.getX()<=78 && Gdx.input.getY()>=15 && Gdx.input.getY()<=57)
            {
                gamebgmusic.stop();
                game.setScreen(new PauseMenu(game,this));
            }

            Tank t=player2.getTank();
            player2.getTank().update();  //update tank and nozzle sprites position , angles

            if (Gdx.input.justTouched() && Gdx.input.getX()>=78 && Gdx.input.getX()<=224 && Gdx.input.getY()>=405 && Gdx.input.getY()<=449)
            { //power button
                power_red_Width_p2=Gdx.input.getX()-74;
                float p=(power_red_Width_p2*2)/3;
                player2.getTank().setPower(p);
//                player2.getCurrWeapon().setSpeed(p);
//                System.out.println(player2.getCurrWeapon().getSpeed());
            }

            weapon_speed_p2= player2.getTank().getPower();



            if (Gdx.input.justTouched() && Gdx.input.getX()>=548 && Gdx.input.getX()<=620 && Gdx.input.getY()>=391 && Gdx.input.getY()<=461)
            {
                angle_flag=1;
                //set angle (aiming mechanism)
            }
            if(angle_flag==1) player2.getTank().setAngle();

            player2.getTank().handle_tank_movement(delta); //handle movement for tank
            if (Gdx.input.justTouched() && Gdx.input.getX()>=316 && Gdx.input.getX()<=455 && Gdx.input.getY()>=402 && Gdx.input.getY()<=452)
            {
                    //fire button pressed
                float w=t.getWidth();
                float a=t.getTankNozzlesprite().getRotation();//-t.getTankBodysprite().getRotation();
                weapon_x= (float) ((t.getx()) + w*(Math.cos(a)));
                weapon_y= (float) ((t.gety()+t.getBodyHeight())+w*(Math.sin(a)));

                weapon_x= (float) (t.getx()+20);
                weapon_y= (float) (t.gety()+20);



                t.getNukeSprite().setOrigin(0,0);
                t.getNukeSprite().setPosition(weapon_x,weapon_y);
                t.getNukeSprite().setSize(80f,80f);

                weapon=new Weapon("missile",30.0,weapon_x,weapon_y,80f,80f,player2.getTank().getTankNozzlesprite().getRotation(),weapon_speed_p2,this);
                shoot.play();
                //t.getNukeSprite().setRotation(weapon.getAngle());
                player2.setCurrWeapon(weapon);
                //player2.getCurrWeapon().setSpeed(weapon_speed_p2);


                start = 1;
            }

            if (start==1)
            {
                //System.out.println(1);
//                player2.getTank().fireNuke(this.weapon,game,delta,nukeImage);
                if (weapon.isBulletDead==0) {
                    weapon.projectileMotion(delta,player1.getTank());
                   // System.out.println((getWeapon().isBulletDead));
                    t.getNukeSprite().setPosition(weapon.getX(),weapon.getY());
                    t.getNukeSprite().setRotation(weapon.getAngle_with_ground());
                    if (weapon.isBulletDead==0) nukeFlag=1;
                    else nukeFlag=0;
                    //game.getBatch().draw(nukeImage, weapon.getX(), weapon.getY(), weapon.getWidth(), weapon.getHeight());
                }
                else  this.change_Turn(GameScreen.getTURN());
            }
            health_width_p1= (float) player1.getHealth().getPercent()*2;

        }

    }

    @Override
    public void show() {
        gamebgmusic.play();

    }


    @Override
    public void render(float delta)
    {


        nukeFlag=0;
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        game.getBatch().draw(bg,0,0,800,480);
        if (TURN==1)
        {

            game.getBatch().draw(chance,65,340,30,30);
        }
        else
        {
            game.getBatch().draw(chance,688,340,30,30);
        }

        handleTurns(delta);

        //System.out.println(player2.getHealth().getPercent());

        if (player1.getHealth().getPercent()<=0 || player2.getHealth().getPercent()<=0) game.setScreen(new GameOverScreen(game,mainScreen));

        //render objects on screen



        game.getBatch().draw(ground,0,0,800,200);
        game.getBatch().draw(pauseButton,21,412,60,60);

        game.getBatch().draw(health_bar_bg,167,416,212,52);
        game.getBatch().draw(health_bar,173,422,health_width_p1,40);
        game.getBatch().draw(medal,142,412,51,58);
        font.draw(game.getBatch(), String.valueOf(player1.getHealth().getPercent()), 237, 450);

        game.getBatch().draw(vs,390,412,56,52);

        game.getBatch().draw(health_bar_bg,488,416,212,52);
        game.getBatch().draw(health_bar,494,422,health_width_p2,40);
        game.getBatch().draw(medal,463,412,51,58);
        font.draw(game.getBatch(), String.valueOf(player2.getHealth().getPercent()), 237+321, 450);

        game.getBatch().draw(fire,314,20,150,60);
        game.getBatch().draw(aim,552,17,70,70);

        game.getBatch().draw(power_black,70,20,158,60); //power bg
        if (TURN==1)
        {
            game.getBatch().draw(power_red, 74, 24, power_red_Width_p1, 52);
            font.draw(game.getBatch(), String.valueOf(player1.getTank().getPower()), 125, 55);
            font.draw(game.getBatch(), "FUEL: "+String.valueOf((int)player1.getTank().getFuel().getPercent()+" %"), 155, 380);
        }//power
        else
        {
            game.getBatch().draw(power_red,74,24,power_red_Width_p2,52); //power
            font.draw(game.getBatch(), String.valueOf(player2.getTank().getPower()), 125, 55);
            font.draw(game.getBatch(), "FUEL: "+String.valueOf((int)player2.getTank().getFuel().getPercent()+" %"), 603, 380);
        }


        if (nukeFlag==1 && TURN==1) player1.getTank().getNukeSprite().draw(game.getBatch());//nukeImage, weapon.getX(), weapon.getY(), weapon.getWidth(), weapon.getHeight());
        else if (nukeFlag==1 && TURN==2) player2.getTank().getNukeSprite().draw(game.getBatch());

        player1.getTank().getTankBodysprite().draw(game.getBatch());
        player2.getTank().getTankBodysprite().draw(game.getBatch());
        player1.getTank().getTankNozzlesprite().draw(game.getBatch());
        player2.getTank().getTankNozzlesprite().draw(game.getBatch());
        player1.getTank().getTankCapsprite().draw(game.getBatch());
        //player2.getTank().getTankCapsprite().draw(game.getBatch());

        game.getBatch().end();

        if (Gdx.input.justTouched())  //used to get x-y coordinates of any point touched
        {
            System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void pauseGame()
    {

    }

    public void chooseWeapon(Player player)
    {

    }

    public void spawnAirDrop(Player player)
    {

    }

    public void computeDamage(Player player)
    {

    }

    public static int getTURN() {
        return TURN;
    }

    public MyGdxGame getGame() {
        return game;
    }

    public static void setTURN(int TURN) {
        GameScreen.TURN = TURN;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Texture getGround() {
        return ground;
    }

    public void setGround(Texture ground) {
        this.ground = ground;
    }

    public Texture getHealth_bar_bg() {
        return health_bar_bg;
    }

    public void setHealth_bar_bg(Texture health_bar_bg) {
        this.health_bar_bg = health_bar_bg;
    }

    public Texture getHealth_bar() {
        return health_bar;
    }

    public void setHealth_bar(Texture health_bar) {
        this.health_bar = health_bar;
    }

    public Texture getBg() {
        return bg;
    }

    public void setBg(Texture bg) {
        this.bg = bg;
    }

    public Texture getNukeImage() {
        return nukeImage;
    }

    public void setNukeImage(Texture nukeImage) {
        this.nukeImage = nukeImage;
    }

    public Float getNext() {
        return next;
    }

    public void setNext(Float next) {
        this.next = next;
    }

    public static void setEquation(ArrayList<ArrayList<Float>> equation) {
        GameScreen.equation = equation;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public static ArrayList<ArrayList<Float>> getEquation() {
        return equation;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }


    //added for saving game..

    public DataClass setDataClass()
    {
        DataClass d=new DataClass();
        d.setData();
        //System.out.println();
        return d;
    }

    public static DataClass getDataClass() {
        return dataClass;
    }
}
