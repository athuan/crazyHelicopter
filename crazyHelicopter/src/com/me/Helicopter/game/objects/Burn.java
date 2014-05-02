package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Burn extends AbstractObject{
	public Sprite burn;
	public float time;
	
	public Burn(Sprite sprite){
		//burn = new Sprite(Assets.instance.fire);
		burn = new Sprite(sprite);
		burn.setSize(20, 20);
		dimension.set(1f, 1f);
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
