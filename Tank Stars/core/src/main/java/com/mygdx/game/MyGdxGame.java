package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;

public class MyGdxGame extends Game implements Serializable {
	private transient SpriteBatch batch;
	private transient BitmapFont font;
	private transient Texture img; /* encapsulation*/

	private static MyGdxGame game=null;
	public static MyGdxGame getInstance()
	{
		if (game==null) game =new MyGdxGame();
		return game;
	}
	private MyGdxGame(){}


	public void create () {
		batch = new SpriteBatch(); //used to render objects on the screen
		font =new BitmapFont(); // used to render text on the screen
		HomeScreen homeScreen=HomeScreen.getInstance(this); //singleton design pattern
		this.setScreen(homeScreen /* composition relation */ );
		//this.setScreen(new GameScreen(this,new MainScreen(this)));

	}


	public void render () {
		super.render();

	}


	public void dispose () { // helps in cleaning
		batch.dispose();
		font.dispose();
	}


	public SpriteBatch getBatch() {
		try
		{
			return batch;
		}
		catch(NullPointerException e)
		{
			batch = new SpriteBatch();
			return batch;
		}
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public BitmapFont getFont() {

		try
		{
			return font;
		}
		catch(NullPointerException e)
		{
			font =new BitmapFont();
			return font;
		}
	}

	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public Texture getImg() {
		return img;
	}

	public void setImg(Texture img) {
		this.img = img;
	}

}
