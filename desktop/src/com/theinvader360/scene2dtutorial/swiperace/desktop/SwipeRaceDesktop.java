package com.theinvader360.scene2dtutorial.swiperace.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.theinvader360.scene2dtutorial.swiperace.SwipeRace;

public class SwipeRaceDesktop {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new SwipeRace(), config);
	}
}
