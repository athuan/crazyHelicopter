package com.me.Helicopter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import sun.java2d.Disposer;

public class Assets extends Disposer {
	
	public static final Assets instance= new Assets();	// single ton
	// khai bao tat ca cac thu can thiet
	TextureAtlas atlas;			// lay tai nguyen ty nguon
	public final Sprite helicopter;			//
	public final Sprite tank;				
	public final Sprite bomb;
	public final Sprite cannon;
	public final Sprite backGround;
	
	
	
	
	
	private Assets(){			// singleton
		atlas = new TextureAtlas(Gdx.files.internal("pack/myImages.atlas"));
		
		helicopter = new Sprite(atlas.findRegion("helicopter1"));
		tank  = new Sprite(atlas.findRegion("tank1"));
		bomb  = new Sprite(atlas.findRegion("bomb12"));
		cannon = new Sprite(atlas.findRegion("cannon1"));
		backGround = new Sprite(atlas.findRegion("background1"));
	}
	
	

}
