package com.me.Helicopter.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.Sprite;

import com.me.Helicopter.MainGame;
import com.me.Helicopter.game.Assets;

public class MenuScreen implements Screen {
	public final MainGame game;
	public Sprite background;

	public MenuScreen(final MainGame g) {
		// gan bien cho no
		this.game = g;
		
		background =  new Sprite(Assets.instance.atlas.findRegion("menu"));
	}

	@Override
	public void render(float delta) {
		// ve voi gi o trong cai man hinh nay la thuc hien ve o day
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		
		game.batch.begin();

		game.font.draw(game.batch, "Tap anywhere to play my funny Game :)",
				0, Gdx.graphics.getHeight() / 2);
		background.draw(game.batch);
		game.batch.end();
		
		// check de chuyen doi man hinh cho game
		if(Gdx.input.isTouched()){
			
			GamePlayScreen gameplay = new GamePlayScreen(game);
			game.setScreen(gameplay);
			gameplay=null;
			
		}
		
		
	}

	@Override
	public void resume() {
		

	}



	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		

	}

	@Override
	public void dispose() {
		
		
	}

}
