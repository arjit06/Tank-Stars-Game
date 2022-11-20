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

public class ChooseTankScreen implements Screen, ApplicationListener
{
    private SpriteBatch batch;
    private Texture img;
    private Animation<TextureRegion> changeTankAnimation; // Must declare frame type (TextureRegion)


    // A variable for tracking elapsed time for the animation
    private float elapsedTime;
    private float time=0;
    private final MyGdxGame game;
    private OrthographicCamera camera;
    private Texture tankpage;
    private int cnt=0;
    private String pagePath;
    private int direction=0;
    public ChooseTankScreen(MyGdxGame game,String path)
    {
        this.game=game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        tankpage=new Texture(path);
        this.pagePath=path;


        // Load the sprite sheet as a Texture
        img = new Texture(Gdx.files.internal("tank_animation_1.png"));

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(img, img.getWidth() / 4, img.getHeight());

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] animationFrames = new TextureRegion[4];
        int index = 0;
        for (int i = 0; i <1; i++) { //rows
            for (int j = 0; j <4; j++) { //columns
                animationFrames[index++] = tmp[i][j];
            }
        }

        // Initialize the Animation with the frame interval and array of frames
        changeTankAnimation = new Animation<TextureRegion>(0.125f, animationFrames);

        // Instantiate a SpriteBatch for drawing and reset the elapsed animation
        // time to 0
        elapsedTime = 0f;
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
        game.getBatch().draw(tankpage, 0, 0,800,480);
        game.getBatch().end();
        //this.render();

//        if (Gdx.input.justTouched())  //used to get x-y coordinates of any point touched
//        {
//            System.out.println("X= "+Gdx.input.getX()+"Y= "+Gdx.input.getY());
//        }

//        if (Gdx.input.isTouched() && ((Gdx.input.getX()>=772 && Gdx.input.getX()<=789 && Gdx.input.getY()>=210 && Gdx.input.getY()<=247) ||(Gdx.input.getX()>=700 && Gdx.input.getX()<=757 && Gdx.input.getY()>=191 && Gdx.input.getY()<=264)))
//        {
//            //touched next arrow or next tank resp
//            direction=1;
//            System.out.println("next tank");
//            this.render();
//        }

        if (Gdx.input.isTouched() && (Gdx.input.getX()>=583 && Gdx.input.getX()<=702 && Gdx.input.getY()>=307 && Gdx.input.getY()<=366))
        {
            //play game button clicked
            game.setScreen(new GameScreen(game));
        }



    }

    @Override
    public void create() {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
//        elapsedTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
//
//        // Get current frame of animation for the current elapsedTime
//        TextureRegion currentFrame = changeTankAnimation.getKeyFrame(elapsedTime, true);
//        game.getBatch().begin();
//        game.getBatch().draw(currentFrame, 0, 0,800,480); // Draw current frame at (0, 0)
//        game.getBatch().end();
//        if (changeTankAnimation.isAnimationFinished(elapsedTime))
//        {
//            String nextPath;
//            if (this.pagePath.equals("choose_tank_screen_default.png") && direction==1)
//            {
//                nextPath="tank_screen_2.png";
//                game.setScreen(new ChooseTankScreen(game,nextPath)); /* interface runtime polymorphism*/
//            }
//            else if (this.pagePath.equals("tank_screen_2.png") && direction==1)
//            {
//                nextPath="tank_screen_3.png";
//                game.setScreen(new ChooseTankScreen(game,nextPath)); /* interface runtime polymorphism*/
//
//            }
//
//        }

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
