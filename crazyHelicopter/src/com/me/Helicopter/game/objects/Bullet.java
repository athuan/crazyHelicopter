package com.me.Helicopter.game.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.Helicopter.game.Assets;

public class Bullet extends AbstractObject {

	public Sprite bullet;
	
	private float pathBulletX;
	private float pathBulletY;
	
	private float destination;
	public Random rand = new Random();
	
	public Bullet(){
		bullet = new Sprite(Assets.instance.bullet);
		bullet.rotate(90);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2 );
		pathBulletX = 1;
		pathBulletY = 2.5f;
		
		destination = rand.nextInt(150) + 500;
	}
	
	@Override
	public void render(SpriteBatch batch) {
		bullet.draw(batch);
		
	}

	@Override
	public void update() {
		
		setPathBullet(this.destination);
	}
	
	public void setPositionBullet(float x, float y){
		this.bullet.setPosition(x, y);
	}
	
	public void setPathBullet(float destination){
		bullet.setPosition(bullet.getX() + pathBulletX, bullet.getY() + pathBulletY);
		bullet.rotate(-0.5f);
		
		if(bullet.getY() >= destination ) {
			pathBulletY = - pathBulletY;
		}
	}

	@Override
	public void afterCollision() {
		bullet.setRegion(Assets.instance.bulletDeath);
		
	}
	

}
