package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainScreen implements Screen
{
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture mainpage;

    public MainScreen(final MyGdxGame game)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        mainpage=new Texture("mainpage.png");
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

        if (Gdx.input.isTouched() && Gdx.input.getX()>=570 && Gdx.input.getX()<=720 && Gdx.input.getY()>=285 && Gdx.input.getY()<=345)
        {
            //this.dispose();
            game.dispose();                   //exit button pressed
        }

       else if (Gdx.input.isTouched() && Gdx.input.getX()>=570 && Gdx.input.getX()<=720 && Gdx.input.getY()>=190 && Gdx.input.getY()<=245)
        {
            game.setScreen(new SavedScreen(game));                 //resume game button pressed
        }

        else if (Gdx.input.isTouched() && Gdx.input.getX()>=575 && Gdx.input.getX()<=725 && Gdx.input.getY()>=90 && Gdx.input.getY()<=150)
        {
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

        //rainMusic.play();
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

