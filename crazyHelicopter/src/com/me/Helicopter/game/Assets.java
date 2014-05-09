package com.me.Helicopter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Disposable;

import sun.java2d.Disposer;

public class Assets implements Disposable {
	
	public static final Assets instance= new Assets();	// single ton
	// khai bao tat ca cac thu can thiet
	public TextureAtlas atlas; // lay tai nguyen ty nguon
	public final Sprite helicopter; //
	public final Sprite tank;
	public final Sprite bomb;
	public final Sprite backGround;
	public final Sprite bullet;
	public final Sound boomboom;
	public final Sound helicopter_sound;
	
	public final Sprite bulletDie;
	public final AtlasRegion bulletDeath;
	
	//public final Texture texture;
	
	
	
	public final Sprite bird;
	public final Sprite helper;

	// cannon and rocket
	public final Sprite cannon;
	public final Sprite rocket;
	public final Sprite fire;
	
	public final Sprite blood;
	public final Sprite x;
	public final Sprite buttonFire;
	public final Sprite buttonHelper;
	
	public final Animation birdAnimation;
	public final Texture birds;
	public final TextureRegion[] xbird;
	private Assets() { // singleton
		atlas = new TextureAtlas(Gdx.files.internal("pack/myImages.atlas"));

		helicopter = new Sprite(atlas.findRegion("helicopter1"));

		tank = new Sprite(atlas.findRegion("tank1"));
		bomb = new Sprite(atlas.findRegion("bomb11"));
		backGround = new Sprite(atlas.findRegion("background1"));
		bullet = new Sprite(atlas.findRegion("bomb11"));
		bulletDie = new Sprite(atlas.findRegion("bomb13"));
		bulletDeath = atlas.findRegion("fire");
		boomboom = Gdx.audio.newSound(Gdx.files.internal("sounds/rocket.wav"));
		helicopter_sound = Gdx.audio.newSound(Gdx.files.internal("sounds/heli3.wav"));
		bird = new Sprite(atlas.findRegion("bomb21"));
		helper = new Sprite(atlas.findRegion("helper3"));

		// cannon and rocket
		cannon = new Sprite(atlas.findRegion("cannon1"));
		rocket = new Sprite(atlas.findRegion("bomb21"));
		fire = new Sprite(atlas.findRegion("fire"));
		//button
		
		buttonFire = new Sprite(atlas.findRegion("bomb15"));
		buttonHelper =  new Sprite(atlas.findRegion("buttonHelper"));
		
		
		blood = new Sprite(atlas.findRegion("blood"));
		
		// cho con chim no chuyen dong
		x = new Sprite( atlas.findRegion("bird"));
		birds = x.getTexture();
		TextureRegion[][] tmp = TextureRegion.split(birds,12,1);
		xbird = new TextureRegion[12];
		for(int i=0; i<12; i++){
			xbird[i] = tmp[i][0];
		}
		birdAnimation = new Animation(0.25f , xbird); // nhu vay da co 1 bien chuyen dong roi nhe
		
	}
	@Override
	public void dispose() {
		//atlas.dispose();
		boomboom.dispose();
		helicopter_sound.dispose();
	}

}
