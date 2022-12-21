package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import jdk.tools.jmod.Main;

public class MainScreen implements Screen
{
    private final MyGdxGame game;
    static Music mainSound;
    private OrthographicCamera camera;
    private Texture mainpage;

    public MainScreen(final MyGdxGame game)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        mainpage=new Texture("mainpage.png");
        mainSound=Gdx.audio.newMusic(Gdx.files.internal("mainmusic.mp3"));
        mainSound.setLooping(true);
    }

    @Override
    public void render (float delta)
    {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        //batch.draw(img, 0, 0);
        game.getBatch().draw(mainpage, 0, 0,800,480);
        game.getBatch().end();

//

        if (Gdx.input.isTouched() && Gdx.input.getX()>=562 && Gdx.input.getX()<=740 && Gdx.input.getY()>=332 && Gdx.input.getY()<=394)
        {

            //this.dispose();
            game.dispose();                   //exit button pressed
        }

       else if (Gdx.input.isTouched() && Gdx.input.getX()>=562 && Gdx.input.getX()<=736 && Gdx.input.getY()>=240 && Gdx.input.getY()<=314)
        {

            mainSound.stop();
            game.setScreen(new LoadScreen(game,this));                 //resume game button pressed
        }

        else if (Gdx.input.isTouched() && Gdx.input.getX()>=568 && Gdx.input.getX()<=740 && Gdx.input.getY()>=142 && Gdx.input.getY()<=210)
        {
           // mainSound.stop();
            game.setScreen(new ChooseTankScreen(game,"tank_screen_p1_1.png",1,"mainpage.png",this));          //vs game button pressed
        }

    }


    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown

        mainSound.play();
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
//        dropImage.dispose();
//        bucketImage.dispose();
//        dropSound.dispose();
//        rainMusic.dispose();
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

    public Texture getMainpage() {
        return mainpage;
    }

    public void setMainpage(Texture mainpage) {
        this.mainpage = mainpage;
    }
}

