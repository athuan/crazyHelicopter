package com.me.Helicopter.Screens;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.Helicopter.MainGame;
import com.me.Helicopter.game.Assets;
import com.me.Helicopter.game.WorldController;
import com.me.Helicopter.game.WorldRenderer;
import com.me.Helicopter.game.objects.Bullet;

public class GamePlayScreen implements Screen {
	// van dung cai bien class kia de ve voi
	final MainGame game;
	WorldController worldController;
	WorldRenderer worldRenderer;

	// khoi tao ban dau cho no
	public GamePlayScreen(final MainGame g) {
		// lay bien
		this.game = g;

		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController, game);

	}
	
	@Override
	public void render(float delta) {
		worldRenderer.render();
		
	}
		@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		
	}

	

	@Override
	public void show() {
		Assets.instance.helicopter_sound.play();
		Assets.instance.helicopter_sound.loop();
		
	}

	@Override
	public void hide() {
		Assets.instance.helicopter_sound.stop();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

}
