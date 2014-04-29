package com.me.Helicopter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import sun.java2d.Disposer;

public class Assets {
	
	public static final Assets instance= new Assets();	// single ton
	// khai bao tat ca cac thu can thiet
	TextureAtlas atlas; // lay tai nguyen ty nguon
	public final Sprite helicopter; //
	public final Sprite tank;
	public final Sprite bomb;
	public final Sprite backGround;
	public final Sprite bullet;
	public final Sound boomboom;
	public final Sound heli;
	
	public final Sprite bulletDie;
	public final AtlasRegion bulletDeath;
	
	
	
	public final Sprite bird;
	public final Sprite helper;

	// cannon and rocket
	public final Sprite cannon;
	public final Sprite rocket;
	public final Sprite fire;
	
	public final Sprite buttonFire;
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
		heli = Gdx.audio.newSound(Gdx.files.internal("sounds/heli3.wav"));
		bird = new Sprite(atlas.findRegion("bomb21"));
		helper = new Sprite(atlas.findRegion("helicopter1"));

		// cannon and rocket
		cannon = new Sprite(atlas.findRegion("cannon1"));
		rocket = new Sprite(atlas.findRegion("bomb21"));
		fire = new Sprite(atlas.findRegion("fire"));
		//button
		
		buttonFire = new Sprite(atlas.findRegion("bomb15"));
	}

}
