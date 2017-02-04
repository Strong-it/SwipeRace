package com.theinvader360.scene2dtutorial.swiperace;

import com.badlogic.gdx.Game;

/**
 * 游戏开始界面
 */
public class SwipeRace extends Game {
	private GameScreen gameScreen;

	@Override
	public void create() {
		Assets.load();
		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
		/** 游戏结束后注销不使用的资源 **/
		Assets.dispose();
		gameScreen.dispose();
	}
}
