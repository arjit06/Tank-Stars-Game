package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		//This class lets one specify various configuration settings, such as the initial screen resolution
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("TankStars");   //set the title
		config.setWindowedMode(800, 480); //game window size
		config.useVsync(true);
		config.setForegroundFPS(60); //fps used by the game when in focus
		MyGdxGame game =MyGdxGame.getInstance();
		new Lwjgl3Application(game, config);
	}
}
