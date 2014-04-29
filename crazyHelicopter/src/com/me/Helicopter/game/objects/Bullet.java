package com.me.Helicopter.game.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.Helicopter.game.Assets;

public class Bullet extends AbstractObject {

	public Sprite bullet;
	public float time;
	public Random rand = new Random();
	public float angleRotation;
	public float delta;
	
	public Bullet(int face){
		bullet = new Sprite(Assets.instance.bullet);
		bullet.rotate(90);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2 );
		time = 0;
		delta = rand.nextInt(4);
		acceleration = 10;
		if(face == 1){
			velocity = new Vector2(-2.5f, delta + 4.5f);
			angleRotation = 1.3f - delta / 10;
		}else{
			velocity = new Vector2(2.5f, delta + 4.5f);
			angleRotation = -(1.3f - delta/ 10);
		}
	}
	
	@Override
	public void render(SpriteBatch batch) {
		bullet.draw(batch);
	}

	@Override
	public void update() {
		setPathBullet();
	}
	
	public void setPositionBullet(float x, float y){
		this.bullet.setPosition(x, y);
	}
	
	public void setPathBullet(){
		bullet.setPosition(bullet.getX() + velocity.x, bullet.getY() + velocity.y - acceleration * time * time);
		bullet.rotate(angleRotation);
		
		time += 0.01f;
	}

	@Override
	public void afterCollision() {
		bullet.setRegion(Assets.instance.bulletDeath);
		
	}
	

}
