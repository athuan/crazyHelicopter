package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Burn extends AbstractObject{
	public Sprite burn;
	public float time;
	
	public Burn(){
		burn = new Sprite(Assets.instance.fire);
		burn.setSize(20, 20);
		dimension.set(0.1f, 0.1f);
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
		
	}
	
	public void setPositionBullet(float x, float y){
		this.burn.setPosition(x, y);
	}

	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		
	}

}
