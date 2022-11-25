package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class LoadScreen implements Screen
{
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture savedpage;
    private MainScreen mainScreen;
    public LoadScreen(MyGdxGame game, MainScreen mainScreen)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        savedpage=new Texture("savedScreen.png");
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
        //batch.draw(img, 0, 0);
        game.getBatch().draw(savedpage, 0, 0,800,480);
        game.getBatch().end();

//        if (Gdx.input.justTouched())  //used to get x-y coordinates of any point touched
//        {
//            System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
//        }

        if (Gdx.input.isTouched() && (Gdx.input.getX()>=42 && Gdx.input.getX()<=190 && Gdx.input.getY()>=24 && Gdx.input.getY()<=87))
        {
            //resume game
            game.setScreen(mainScreen);

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
}
