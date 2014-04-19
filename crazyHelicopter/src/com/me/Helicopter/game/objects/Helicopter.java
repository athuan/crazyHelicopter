package com.me.Helicopter.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Helicopter extends AbstractObject{
	public Sprite heli;
	public Sprite heli1;
	public Sprite heli2;
	public float xPos;		// mac dinh ban dau la di chuyen sang trai
	public float yPos;	// do cao ban dau lad 200
	public float xCor;
	public float xFactor;
	int count=0;
	
	
	public Helicopter(){
		heli1 = new Sprite(Assets.instance.helicopter);
		heli2 = new Sprite(Assets.instance.helicopter);
		heli2.flip(true, false);
		heli = heli2;
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2);
		this.position.set(0,100);
		xPos=0;
		yPos=0;
		velocity.x =2;
		velocity.y =0;
		Assets.instance.heli.play();
		Assets.instance.heli.loop();
		
		
	}
	


	@Override
	public void update() {
		////// DI CHUYEN CUA MAY BAY
		if( Gdx.input.isTouched() ){
			xPos = Gdx.input.getX() - heli.getX();
			yPos = Gdx.input.getY() - heli.getY();
		}
		if( heli.getX() > Gdx.graphics.getWidth() +50 ){
			heli.setX(-50);
		}
		if( heli.getX() < -50 ){
			heli.setX(Gdx.graphics.getWidth() + 50);
		}
		if( xPos ==0 ){
			xPos=1;
		}else if(xPos > 0) {
			heli2.setPosition(heli.getX(), heli.getY());
			heli = heli2;
			
		}else{
			heli1.setPosition(heli.getX(), heli.getY());
			heli = heli1;
		}
		if(count < 7){
			count++;
			heli.setPosition(heli.getX() + velocity.x*xPos/Math.abs(xPos), 500);
		}else if( count>=7 && count<14) {
			count++;
			heli.setPosition(heli.getX() + velocity.x*xPos/Math.abs(xPos) , 505);
		}else{
			count=0;
		}
		////////////////////////////////////////////////
		
		
	}



	@Override
	public void render(SpriteBatch batch) {
		heli.draw(batch);
		
	}



	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		
	}
	

}
