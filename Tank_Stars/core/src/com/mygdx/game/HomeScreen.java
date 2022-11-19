package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class HomeScreen implements Screen /* interface implemented */
{
    private final MyGdxGame game; //game only refers to tank stars no other game
    private OrthographicCamera camera; // like a real camera
    private Texture homepage;
    private float time=0;
    public HomeScreen(MyGdxGame game)
    {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        homepage=new Texture("homepage.jpg");
    }
    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        //batch.draw(img, 0, 0);
        game.getBatch().draw(homepage, 0, 0,800,480);
        game.getBatch().end();

        time += Gdx.graphics.getDeltaTime(); //check this
        if (time>4)
        {
            game.setScreen(new MainScreen(game)); /* interface runtime polymorphism*/
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

}
