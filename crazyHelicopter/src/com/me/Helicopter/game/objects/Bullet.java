package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Bullet extends AbstractObject {

	public Sprite bullet;
	
	public Bullet(){
		bullet = new Sprite(Assets.instance.bullet);
		bullet.rotate(90);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2 );
	}
	
	@Override
	public void render(SpriteBatch batch) {
		bullet.draw(batch);
		
	}

	@Override
	public void update() {
		if(bullet.getY() < 700){
			this.bullet.setPosition(bullet.getX(), bullet.getY() + 15);
			//System.out.println("x: " + bullet.getX() + "y: "+ bullet.getY());
		}
		
	}
	
	public void setPositionBullet(float x, float y){
		this.bullet.setPosition(x, y);
	}

	@Override
	public void afterCollision() {
		bullet.scale(10);
	}
	

}
