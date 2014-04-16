package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Bomb extends AbstractObject {
	
	public Sprite bomb;
	
	public Bomb(){
		bomb = new Sprite(Assets.instance.bomb);
	}


	@Override
	public void update() {		// ham nay de tinh toan qua boom khi duoc goi thi no se roi(cap nhat vi tri roi)
		if( this.bomb.getY() >0 ){
			bomb.setPosition(bomb.getX() ,bomb.getY() - 1);
			
		}
		
	}
	

	@Override
	public void render(SpriteBatch batch) {
		bomb.draw(batch);
		
	}
	
	public void setPosition(float x, float y){			// set vi tri cua sprite boom
		this.bomb.setPosition(x, y);	
	}



}
