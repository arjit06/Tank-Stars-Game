package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class ChooseTankScreen implements Screen//, ApplicationListener
{
    private SpriteBatch batch;
    private Texture img;
    private Animation<TextureRegion> changeTankAnimation; // Must declare frame type (TextureRegion)


    // A variable for tracking elapsed time for the animation
    private Float time=0f;
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

//        SetPlayer.getPlayer1().setTank(new FrostTank(50f,111f,80f,60f));
//        SetPlayer.getPlayer2().setTank(new FrostTank(565f,103f,80f,60f));



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
//



        if (Gdx.input.isTouched() && (Gdx.input.getX()>=73 && Gdx.input.getX()<=255 && Gdx.input.getY()>=163 && Gdx.input.getY()<=328))
        {
            String nextPagePath="";
            if (currPlayer==1) nextPagePath= "tank_screen_p1_1.png";
            else if (currPlayer==2) nextPagePath="tank_screen_p2_1.png";

            //first tank selected
            if (!currpagePath.equals(nextPagePath))
            {
                if (currPlayer==1){
                    Player player=SetPlayer.getPlayer1();
                    player.setTank(new FrostTank(50f,111f,80f,60f,1));
                    player.getTank().setPlayer(player);
                }
                else
                {
                    Player player=SetPlayer.getPlayer2();
                    player.setTank(new FrostTank(565f,103f,80f,60f,2));
                    player.getTank().setPlayer(player);
                }

                game.setScreen(new ChooseTankScreen(game,nextPagePath,this.currPlayer,this.currpagePath,this.mainScreen));
            }

        }

        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=339 && Gdx.input.getX()<=503 && Gdx.input.getY()>=163 && Gdx.input.getY()<=313))
        {
            String nextPagePath="";
            if (currPlayer==1)nextPagePath= "tank_screen_p1_2.png";
            else if (currPlayer==2) nextPagePath="tank_screen_p2_2.png";

            //second tank selected
            if (!currpagePath.equals(nextPagePath))
            {
                if (currPlayer==1){
                    Player player=SetPlayer.getPlayer1();
                    player.setTank(new BuratinoTank(50f,111f,80f,60f,1));
                    player.getTank().setPlayer(player);
                }
                else
                {
                    Player player=SetPlayer.getPlayer2();
                    player.setTank(new BuratinoTank(565f,103f,80f,60f,2));
                    player.getTank().setPlayer(player);
                }

                game.setScreen(new ChooseTankScreen(game,nextPagePath,this.currPlayer,this.currpagePath,this.mainScreen));
            }
        }
        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=584 && Gdx.input.getX()<=725 && Gdx.input.getY()>=175 && Gdx.input.getY()<=304))
        {
            String nextPagePath="";
            if (currPlayer==1)nextPagePath= "tank_screen_p1_3.png";
            else if (currPlayer==2) nextPagePath="tank_screen_p2_3.png";
            //third tank selected
            if (!currpagePath.equals(nextPagePath))
            {
                if (currPlayer==1){
                    Player player=SetPlayer.getPlayer1();
                    player.setTank(new AbramsTank(50f,111f,80f,60f,1));
                    player.getTank().setPlayer(player);
                }
                else
                {
                    Player player=SetPlayer.getPlayer2();
                    player.setTank(new AbramsTank(565f,103f,80f,60f,2));
                    player.getTank().setPlayer(player);
                }

                game.setScreen(new ChooseTankScreen(game,nextPagePath,this.currPlayer,this.currpagePath,this.mainScreen));
            }
        }

        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=566 && Gdx.input.getX()<=739 && Gdx.input.getY()>=378 && Gdx.input.getY()<=458))
        {
            //next button pressed
            if (this.currPlayer==1)  game.setScreen(new ChooseTankScreen(game,"tank_screen_p2_1.png",2,currpagePath,this.mainScreen));
            else
            {

                //if (Gdx.input.getX()>=630 && Gdx.input.getX()<=739) game.setScreen(new OldGameScreen(game,this.mainScreen));
                if (Gdx.input.getX()>=630 && Gdx.input.getX()<=739){ game.setScreen(new GameScreen(game,mainScreen)); MainScreen.mainSound.stop();}
            }

        }

        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=81 && Gdx.input.getX()<=231 && Gdx.input.getY()>=402 && Gdx.input.getY()<=451))
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

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
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
