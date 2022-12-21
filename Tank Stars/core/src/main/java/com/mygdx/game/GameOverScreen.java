package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class GameOverScreen implements Screen {
    MainScreen mainScreen;
    MyGdxGame game;
    private Texture gameOver;

    public GameOverScreen(MyGdxGame game,MainScreen mainScreen)
    {
        this.game=game;
        this.mainScreen=mainScreen;
        gameOver=new Texture("game_over.png");

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.getBatch().begin();
        game.getBatch().draw(gameOver,0,0,800,480);
        game.getBatch().end();
        if (Gdx.input.justTouched() && Gdx.input.getX()>=315 && Gdx.input.getX()<=498 && Gdx.input.getY()>=346 && Gdx.input.getY()<=418)
        {
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
