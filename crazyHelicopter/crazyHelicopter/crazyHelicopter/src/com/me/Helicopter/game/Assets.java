package com.me.Helicopter.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import sun.java2d.Disposer;

public class Assets extends Disposer {
	
	public static final Assets instance= new Assets();	// single ton
	// khai bao tat ca cac thu can thiet
	TextureAtlas atlas;			// lay tai nguyen ty nguon
	public final Sprite helicopter;			//
	public final Sprite tank;				
	public final Sprite boom;
	public final Sprite cannon;
	
	
	
	
	private Assets(){			// singleton
		helicopter = new Sprite(atlas.findRegion("pack/myImages.atlas"));
		//tank  = new Sprite(atlas.findRegion("pack/myImages.atlas"));
	}
	
	

}
