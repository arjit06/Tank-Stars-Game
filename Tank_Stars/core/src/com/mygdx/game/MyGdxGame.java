package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	private SpriteBatch batch;
	private BitmapFont font;
	private Texture img; /* encapsulation*/


	public void create () {
		batch = new SpriteBatch(); //used to render objects on the screen
		font =new BitmapFont(); // used to render text on the screen
		this.setScreen(new HomeScreen(this) /* composition relation */ );

	}


	public void render () {
		super.render();

	}


	public void dispose () { // helps in cleaning
		batch.dispose();
		font.dispose();
	}


	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}

	public BitmapFont getFont() {
		return font;
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
