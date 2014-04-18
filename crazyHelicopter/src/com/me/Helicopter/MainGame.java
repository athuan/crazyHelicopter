package com.me.Helicopter;

import sun.awt.windows.WWindowPeer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.Helicopter.game.WorldController;
import com.me.Helicopter.game.WorldRenderer;
import com.me.Helicopter.game.objects.Bullet;


public class MainGame implements ApplicationListener {

	WorldController worldController;
	WorldRenderer worldRenderer;
	@Override
	public void create() {
		// khoi tao cho 2 bien
		
		worldController = new WorldController();
		worldRenderer =  new WorldRenderer(worldController);
		
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render() {
		worldRenderer.render();		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {

		
	}

}
