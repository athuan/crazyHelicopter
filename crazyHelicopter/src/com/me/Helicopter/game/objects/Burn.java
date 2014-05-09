package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Burn extends AbstractObject{
	public Sprite burn;
	public float time;
	
	public Burn(Sprite sprite){
		//burn = new Sprite(Assets.instance.fire);
		burn = new Sprite(sprite);
		burn.setSize(20, 20);
		
		origin.set(dimension.x / 2, dimension.y / 2);
		time = 30;
	}

	@Override
	public void render(SpriteBatch batch) {
		burn.draw(batch);
	}

	@Override
	public void update() {
		time --;
		burn.setColor(1, 1, 1, time/30);
		burn.setPosition(burn.getX() + 0.1f, burn.getY() + 1);
		burn.setSize(30- time + 20, 30 -time +20);
		
	}
	
	public void setPositionBullet(float x, float y){
		this.burn.setPosition(x, y-20);
	}

	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		
	}

}
