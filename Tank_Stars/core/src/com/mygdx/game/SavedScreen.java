package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class SavedScreen implements Screen
{
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture savedpage;
    public SavedScreen(MyGdxGame game)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        savedpage=new Texture("save_game.png");

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
