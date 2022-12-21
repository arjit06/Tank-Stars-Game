package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class PauseMenu implements ApplicationListener, Screen
{
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture pausepage,backButton;
    private GameScreen gameScreen;
    public PauseMenu(MyGdxGame game, GameScreen gameScreen)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        pausepage=new Texture("pauseMenu.png");
        backButton=new Texture("back_button.png");
        this.gameScreen=gameScreen;


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
        game.getBatch().draw(pausepage, 0, 0,800,480);
        game.getBatch().end();

//

        if (Gdx.input.isTouched() && (Gdx.input.getX()>=341 && Gdx.input.getX()<=504 && Gdx.input.getY()>=81 && Gdx.input.getY()<=145))
        {
            //resume game
            game.setScreen(gameScreen);

        }
        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=344 && Gdx.input.getX()<=501 && Gdx.input.getY()>=182 && Gdx.input.getY()<=245))
        {
            //save state
           game.setScreen(new SaveScreen(game,this,gameScreen));
        }
        else if (Gdx.input.isTouched() && (Gdx.input.getX()>=342 && Gdx.input.getX()<=508 && Gdx.input.getY()>=280 && Gdx.input.getY()<=342))
        {
            //main menu
            game.setScreen(gameScreen.getMainScreen());
        }


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

    public Texture getPausepage() {
        return pausepage;
    }

    public void setPausepage(Texture pausepage) {
        this.pausepage = pausepage;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }
}
