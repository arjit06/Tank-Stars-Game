package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class SaveScreen implements Screen
{
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture savepage,backButton;
    private OldGameScreen gameScreen;
    private PauseMenu pauseMenu;

    private GameScreen g;
    public SaveScreen(MyGdxGame game,PauseMenu pauseMenu, GameScreen g)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        savepage=new Texture("save.png");
        backButton=new Texture("back_button.png");
        this.gameScreen=gameScreen;
        this.pauseMenu=pauseMenu;
        this.g=g;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

//        if (Gdx.input.justTouched())  //used to get x-y coordinates of any point touched
//        {
//            System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
//        }

        if (Gdx.input.isTouched() && (Gdx.input.getX()>=51 && Gdx.input.getX()<=168 && Gdx.input.getY()>=17 && Gdx.input.getY()<=69))
        {
            //resume game
            game.setScreen(pauseMenu);

        }

        else
            {
                GameScreen.getDataClass().saveGame(this.g);
            }



        game.getBatch().begin();
        //batch.draw(img, 0, 0);
        game.getBatch().draw(savepage, 0, 0,800,480);
        game.getBatch().draw(backButton,52,410,120,50);
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
