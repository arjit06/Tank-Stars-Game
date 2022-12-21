package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class OldGameScreen implements ApplicationListener, Screen
{
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture gamepage;
    private MainScreen mainScreen;
    public OldGameScreen(MyGdxGame game, MainScreen mainScreen)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        gamepage=new Texture("ingameScreen.png");
        this.mainScreen=mainScreen;

    }

    @Override
    public void create() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);

        game.getBatch().begin();
        //batch.draw(img, 0, 0);
        game.getBatch().draw(gamepage, 0, 0,800,480);
        game.getBatch().end();

//        if (Gdx.input.justTouched())  //used to get x-y coordinates of any point touched
//        {
//            System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
//        }

//        if (Gdx.input.isTouched() && Gdx.input.getX()>=13 && Gdx.input.getX()<=52 && Gdx.input.getY()>=11 && Gdx.input.getY()<=66)
//        {
//               game.setScreen(new PauseMenu(game,this));               //pause menu pressed
//        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

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

    public MyGdxGame getGame() {
        return game;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public Texture getGamepage() {
        return gamepage;
    }

    public void setGamepage(Texture gamepage) {
        this.gamepage = gamepage;
    }

    public MainScreen getMainScreen() {
        return mainScreen;
    }

    public void setMainScreen(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }
}
