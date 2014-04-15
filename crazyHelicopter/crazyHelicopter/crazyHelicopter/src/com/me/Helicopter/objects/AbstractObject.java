package com.me.Helicopter.objects;

import com.badlogic.gdx.math.Vector2;

public abstract class AbstractObject {
	
	public Vector2 dimension;
	public Vector2 origin;
	public Vector2 position;
	public float rotation;
	public Vector2 scale;
	public boolean xFlip;
	public boolean yFlip;
	
	
	public AbstractObject(){
		dimension = new Vector2();
		origin = new Vector2();
		position = new Vector2();
		rotation = 0;
		
	}
	
	
	public abstract void render();
	public abstract void update();
}
