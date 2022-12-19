package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class GameScreen implements Screen
{
    private final MyGdxGame game;
    private static int TURN=1;
    private OrthographicCamera camera;
    private Texture ground;
    private Texture  health_bar_bg;
    private Texture  health_bar;
    private Texture bg;
    private Texture nukeImage;
    private Float next;
    //private World world;
    ///private Box2DDebugRenderer debugRenderer;
    private static ArrayList<ArrayList<Float>> equation=new ArrayList<ArrayList<Float>> ();
    private static Player player1;
    private static Player player2;
    private Weapon weapon;
    private int flag=0;
    private int cnt=0;
    private int nukeFlag=0;
    private static int start=0;


    public GameScreen(MyGdxGame game)
    {
        createSpritesAndTextures();
        this.player1=SetPlayer.getPlayer1();
        this.player2=SetPlayer.getPlayer2();

        initializePlayerTanks();

        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        //create the arraylist containg slopes and constants in (m,c) form for y=mx+c
        createEquationArrayList();
    }

    public void initializePlayerTanks()
    {
        Tank t=player2.getTank();
        t.getTankNozzlesprite().setOrigin(0,0);
        t.getTankNozzlesprite().setPosition(t.getx(),t.gety()+t.getBodyHeight());
        t.getTankNozzlesprite().setSize(t.getWidth(), t.getNozzleHeight());


        t.getTankBodysprite().setOrigin(0,0);
        t.getTankBodysprite().setPosition(t.getx(),t.gety());
        t.getTankBodysprite().setSize(t.getWidth(), t.getBodyHeight());

        t=player1.getTank();
        t.getTankNozzlesprite().setOrigin(0,0);
        t.getTankNozzlesprite().setPosition(t.getx(),t.gety()+t.getBodyHeight());
        t.getTankNozzlesprite().setSize(t.getWidth(), t.getNozzleHeight());


        t.getTankBodysprite().setOrigin(0,0);
        t.getTankBodysprite().setPosition(t.getx(),t.gety());
        t.getTankBodysprite().setSize(t.getWidth(), t.getBodyHeight());


    }

    public void createSpritesAndTextures()
    {

        nukeImage=new Texture("nuke.png");
//        tankCapImage=new Texture("burratino_cap.png");

        ground=new Texture("ground.png");
        bg=new Texture("game_screen_bg.png");
        health_bar_bg=new Texture("health_bar_border.png");
        health_bar=new Texture("blue_health_bar.png");

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

    public static void change_Turn(int t)
    {
        start=0;
        player1.getTank().setFlag(0);
        player2.getTank().setFlag(0);
        if (t==1)
        {
            TURN=2;
        }
        else
        {
            TURN=1;
        }
    }

    public void handleTurns(float delta)
    {
        if (TURN==1) //player one turn
        {
            player1.getTank().update();  //update tank and nozzle sprites position , angles
            player1.getTank().setAngle();  //set angle (aiming mechanism)
            player1.getTank().handle_tank_movement(delta);  //handle movement for tank


            if (Gdx.input.isKeyJustPressed(Input.Keys.T)) change_Turn(TURN); //change turn

            if (Gdx.input.isKeyJustPressed(Input.Keys.F)) //fire
            {
                weapon=new Weapon("missile",50.0,50f,111f,50f,50f);
                start = 1;
            }

            if (start==1)
            {
//                player1.getTank().fireNuke(this.weapon,game,delta,nukeImage);
                if (weapon.isBulletDead==0) {
                    weapon.projectileMotion(delta);
                    if (weapon.isBulletDead==0) nukeFlag=1;
                    //game.getBatch().draw(nukeImage, weapon.getX(), weapon.getY(), weapon.getWidth(), weapon.getHeight());
                }
                else  GameScreen.change_Turn(GameScreen.getTURN());
            }

        }

        else //player two turn
        {
            player2.getTank().update();  //update tank and nozzle sprites position , angles
            player2.getTank().setAngle(); //set angle (aiming mechanism)
            player2.getTank().handle_tank_movement(delta); //handle movement for tank

            if (Gdx.input.isKeyJustPressed(Input.Keys.T)) change_Turn(TURN);

            if (Gdx.input.isKeyJustPressed(Input.Keys.F)) //fire
            {
                weapon=new Weapon("missile",50.0,50f,111f,50f,50f);
                start = 1;
            }

            if (start==1)
            {
//                player2.getTank().fireNuke(this.weapon,game,delta,nukeImage);
                if (weapon.isBulletDead==0) {
                    weapon.projectileMotion(delta);
                    if (weapon.isBulletDead==0) nukeFlag=1;
                    //game.getBatch().draw(nukeImage, weapon.getX(), weapon.getY(), weapon.getWidth(), weapon.getHeight());
                }
                else  GameScreen.change_Turn(GameScreen.getTURN());
            }
        }

    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta)
    {
        nukeFlag=0;
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        handleTurns(delta);

        //render objects on screen
        game.getBatch().begin();
        game.getBatch().draw(bg,0,0,800,480);
        game.getBatch().draw(ground,0,0,800,200);
        game.getBatch().draw(health_bar_bg,135,400,300,50);
        game.getBatch().draw(health_bar,137,402,296,56);

        if (nukeFlag==1) game.getBatch().draw(nukeImage, weapon.getX(), weapon.getY(), weapon.getWidth(), weapon.getHeight());

        player1.getTank().getTankBodysprite().draw(game.getBatch());
        player2.getTank().getTankBodysprite().draw(game.getBatch());
        player1.getTank().getTankNozzlesprite().draw(game.getBatch());
        player2.getTank().getTankNozzlesprite().draw(game.getBatch());

        game.getBatch().end();

//        if (Gdx.input.justTouched())  //used to get x-y coordinates of any point touched
//        {
//            System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
//        }

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

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        GameScreen.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        GameScreen.player2 = player2;
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

}
