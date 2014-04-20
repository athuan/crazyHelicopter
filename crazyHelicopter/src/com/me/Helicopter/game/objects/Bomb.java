package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Bomb extends AbstractObject {
	
	public Sprite bomb;
	public float time;
	public Bomb(){
		bomb = new Sprite(Assets.instance.bomb);
		velocity.y = 1;
		acceleration = 10;
		time = 0;
	}


	@Override
	public void update() {		// ham nay de tinh toan qua boom khi duoc goi thi no se roi(cap nhat vi tri roi)
		bomb.setPosition(bomb.getX() ,bomb.getY() - (velocity.y + acceleration * time) );
		time += 0.01f;
	}
	

	@Override
	public void render(SpriteBatch batch) {
		bomb.draw(batch);
		
	}
	
	public void setPosition(float x, float y){			// set vi tri cua sprite boom
		bomb.setPosition(x, y);	
	}


	public boolean isLive() {
		if( bomb.getY() <10 ){	
			return false;
		}
			
		return true;
	}


	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		
	}



}
