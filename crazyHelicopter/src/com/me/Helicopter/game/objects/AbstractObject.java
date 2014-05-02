package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

public abstract class AbstractObject {
	
	public Vector2 dimension;
	public Vector2 origin;
	public Vector2 position;
	public float rotation;
	public Vector2 scale;
	public boolean xFlip;
	public boolean yFlip;
	public Rectangle bound; //cai nay set 1 hinh chu nhat bao quanh de phat hien collision
	
	// bo sung cac bien cho cac doi tuong
	
	public Vector2 velocity;		// bien van toc
	public float acceleration;			// bien gai toc
	public int blood;					// luong mau
	public Pixmap pixmap;
	public Texture texture;
	public int boundBloodX;
	public int boundBloodY = 5;
	
	public AbstractObject(){
		dimension = new Vector2();
		origin = new Vector2();
		position = new Vector2();
		rotation = 0;
		xFlip = false;
		xFlip = false;
		velocity= new Vector2(0,0);
		acceleration = 0;
	}
	
	
	public abstract void render(SpriteBatch batch);	// ham nay de ma ve 
	public abstract void update();	// ham nay de cap xac dinh tao do moi
	public abstract void afterCollision();
}
