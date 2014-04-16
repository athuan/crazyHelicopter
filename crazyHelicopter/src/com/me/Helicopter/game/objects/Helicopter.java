package com.me.Helicopter.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Helicopter extends AbstractObject{
	public Sprite heli;
	
	
	public Helicopter(){
		heli = new Sprite(Assets.instance.helicopter);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2);
		this.position.set(0,100);
		heli.setPosition(0, 100);
		
	}
	


	@Override
	public void update() {
		if( Gdx.input.isKeyPressed(Keys.RIGHT) ){
			heli.setPosition(heli.getX() + 2, heli.getY());
		}
		if( Gdx.input.isKeyPressed(Keys.LEFT) ){
			heli.setPosition(heli.getX() - 2, heli.getY());
		}
		if( Gdx.input.isKeyPressed(Keys.UP) ){
			heli.setPosition(heli.getX(), heli.getY() + 2);
			
		}
		if( Gdx.input.isKeyPressed(Keys.DOWN) ){
			heli.setPosition(heli.getX() , heli.getY() - 2);
		}
	}



	@Override
	public void render(SpriteBatch batch) {
		heli.draw(batch);
		
	}
	

}
