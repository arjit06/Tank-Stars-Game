package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class HomeScreen implements ApplicationListener, Screen
{
    // Objects used
    private SpriteBatch batch;
    private Texture img;
    private Animation<TextureRegion> loadingAnimation; // Must declare frame type (TextureRegion)


    // A variable for tracking elapsed time for the animation
    private float elapsedTime;
    private final MyGdxGame game; //game only refers to tank stars no other game
    private OrthographicCamera camera; // like a real camera
    private Texture homepage;

    public HomeScreen(MyGdxGame game)
    {
        this.game = game;
        this.homepage=new Texture("homepage.jpg");
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        // Load the sprite sheet as a Texture
        img = new Texture(Gdx.files.internal("homepage_animated.png"));

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(img, img.getWidth() / 4, img.getHeight() /4);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] animationFrames = new TextureRegion[16];
        int index = 0;
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <4; j++) {
                animationFrames[index++] = tmp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        loadingAnimation = new Animation<TextureRegion>(0.25f, animationFrames);

        // Instantiate a SpriteBatch for drawing and reset the elapsed animation
        // time to 0
        //batch = new SpriteBatch();
        elapsedTime = 0f;
    }

    @Override
    public void create() {


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.2f, 0, 1);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().begin();
        game.getBatch().draw(homepage, 0, 0,800,480);
        game.getBatch().end();
        this.render();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render()
    {
        elapsedTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        // Get current frame of animation for the current elapsedTime
        TextureRegion currentFrame = loadingAnimation.getKeyFrame(elapsedTime, true);
        game.getBatch().begin();
        game.getBatch().draw(currentFrame, 0, 0,800,480); // Draw current frame at (0, 0)
        game.getBatch().end();
        if (loadingAnimation.isAnimationFinished(elapsedTime))
        {
            game.setScreen(new MainScreen(game)); /* interface runtime polymorphism*/
        }

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
    public void dispose() { // SpriteBatches and Textures must always be disposed
        batch.dispose();
        img.dispose();
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

    public Animation<TextureRegion> getloadingAnimation() {
        return loadingAnimation;
    }

    public void setloadingAnimation(Animation<TextureRegion> loadingAnimation) {
        this.loadingAnimation = loadingAnimation;
    }

    public float getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(float elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}

