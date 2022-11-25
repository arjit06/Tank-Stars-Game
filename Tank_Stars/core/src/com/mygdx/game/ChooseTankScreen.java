package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.tools.jmod.Main;

public class ChooseTankScreen implements Screen//, ApplicationListener
{
    private SpriteBatch batch;
    private Texture img;
    private Animation<TextureRegion> changeTankAnimation; // Must declare frame type (TextureRegion)


    // A variable for tracking elapsed time for the animation
    private float time=0;
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture tankpage;
    private String currpagePath;
    private String prevpagePath;
    private int currPlayer;
    private MainScreen mainScreen;
    public ChooseTankScreen(MyGdxGame game,String currpath,int currPlayer,String prevpagePath,MainScreen mainScreen)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        tankpage=new Texture(currpath);
        this.currpagePath=currpath;
        this.prevpagePath=prevpagePath;
        this.currPlayer=currPlayer;
        this.mainScreen=mainScreen;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        game.getBatch().draw(tankpage, 0, 0,800,480);
        game.getBatch().end();
        //this.render();


        if (Gdx.input.isTouched() && (Gdx.input.getX()>=502 && Gdx.input.getX()<=584 && Gdx.input.getY()>=133 && Gdx.input.getY()<=232))
        {
            String nextPagePath="";
            if (currPlayer==1) nextPagePath= "tank_screen_p1_1.png";
            else if (currPlayer==2) nextPagePath="tank_screen_p2_1.png";

            //first tank selected
            if (!currpagePath.equals(nextPagePath))
            {
                game.setScreen(new ChooseTankScreen(game,nextPagePath,this.currPlayer,this.currpagePath,this.mainScreen));
            }

        }

        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=604 && Gdx.input.getX()<=678 && Gdx.input.getY()>=142 && Gdx.input.getY()<=226))
        {
            String nextPagePath="";
            if (currPlayer==1)nextPagePath= "tank_screen_p1_2.png";
            else if (currPlayer==2) nextPagePath="tank_screen_p2_2.png";

            //second tank selected
            if (!currpagePath.equals(nextPagePath))
            {
                game.setScreen(new ChooseTankScreen(game,nextPagePath,this.currPlayer,this.currpagePath,this.mainScreen));
            }
        }
        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=694 && Gdx.input.getX()<=780 && Gdx.input.getY()>=140 && Gdx.input.getY()<=232))
        {
            String nextPagePath="";
            if (currPlayer==1)nextPagePath= "tank_screen_p1_3.png";
            else if (currPlayer==2) nextPagePath="tank_screen_p2_3.png";
            //third tank selected
            if (!currpagePath.equals(nextPagePath))
            {
                game.setScreen(new ChooseTankScreen(game,nextPagePath,this.currPlayer,this.currpagePath,this.mainScreen));
            }
        }

        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=571 && Gdx.input.getX()<=729 && Gdx.input.getY()>=299 && Gdx.input.getY()<=355))
        {
            //next button pressed
            if (this.currPlayer==1)  game.setScreen(new ChooseTankScreen(game,"tank_screen_p2_1.png",2,currpagePath,this.mainScreen));
            else
            {
                if (Gdx.input.getX()>=620 && Gdx.input.getX()<=729) game.setScreen(new GameScreen(game,this.mainScreen));
            }

        }

        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=19 && Gdx.input.getX()<=61 && Gdx.input.getY()>=14 && Gdx.input.getY()<=63))
        {
            //back button pressed
            game.setScreen(new MainScreen(game));
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

    public SpriteBatch getBatch() {
        return batch;
    }

    public void setBatch(SpriteBatch batch) {
        this.batch = batch;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public Animation<TextureRegion> getChangeTankAnimation() {
        return changeTankAnimation;
    }

    public void setChangeTankAnimation(Animation<TextureRegion> changeTankAnimation) {
        this.changeTankAnimation = changeTankAnimation;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public MyGdxGame getGame() {
        return game;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Texture getTankpage() {
        return tankpage;
    }

    public void setTankpage(Texture tankpage) {
        this.tankpage = tankpage;
    }

    public String getCurrpagePath() {
        return currpagePath;
    }

    public void setCurrpagePath(String currpagePath) {
        this.currpagePath = currpagePath;
    }

    public String getPrevpagePath() {
        return prevpagePath;
    }

    public void setPrevpagePath(String prevpagePath) {
        this.prevpagePath = prevpagePath;
    }

    public int getCurrPlayer() {
        return currPlayer;
    }

    public void setCurrPlayer(int currPlayer) {
        this.currPlayer = currPlayer;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }
}
