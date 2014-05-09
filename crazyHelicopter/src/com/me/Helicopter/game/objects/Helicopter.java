package com.me.Helicopter.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
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
	public boolean isLive;


	public Helicopter(){
		heli1 = new Sprite(Assets.instance.helicopter);
		heli2 = new Sprite(Assets.instance.helicopter);
		heli2.flip(true, false);
		heli = heli2;
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2);
		xPos=50;
		yPos=0;
		velocity.x =50;
		velocity.y =50;
		heli.setPosition(0, 500);
		blood = 100;
		isLive = true;

	}



	@Override
	public void update() {


		if( heli.getX() > Gdx.graphics.getWidth() +50 ){
			heli.setX(-50);
		}
		if( heli.getX() < -50 ){
			heli.setX(Gdx.graphics.getWidth() + 50);
		}
		if( xPos == 0 ){
			xPos=1;
		}else if(xPos > 0) {
			heli2.setPosition(heli.getX(), heli.getY() );
			heli = heli2;

		}else{
			heli1.setPosition(heli.getX(), heli.getY());
			heli = heli1;
		}
		if(count < 6){
			heli.setPosition(heli.getX() + Gdx.graphics.getDeltaTime()*velocity.x*xPos/150, heli.getY() + Gdx.graphics.getDeltaTime()*velocity.y*yPos/150+1);
			count++;
		}else if(count>=6 && count <12){
			heli.setPosition(heli.getX() + Gdx.graphics.getDeltaTime()*velocity.x*xPos/150, heli.getY() + Gdx.graphics.getDeltaTime()*velocity.y*yPos/150-1);
			count++;

		}else{
			count=0;
		}

		////////////////////////////////////////////////


	}



	@Override
	public void render(SpriteBatch batch) {
		if(isLive()){
			drawBlood(batch);
		}
		heli.draw(batch);

	}

	

	@Override
	public void drawBlood(SpriteBatch batch) {
			pixmap = new Pixmap((int)blood, 5, Format.RGBA8888 );// neu ma mau am thi toi luon :v, vut ra loi ngay
			if( this.blood > 60 ){
				pixmap.setColor(0, 0, 1, 1);
			}else {
				pixmap.setColor(1, 0, 0, 1);
			}
			
			pixmap.fill();
			texture = new Texture(pixmap);
			batch.draw(texture, heli.getX(), heli.getY() + 50);
	}



	@Override
	public void afterCollision() {
		this.blood -= 3;
		if(blood <=0 ){
			isLive = false;
		}

	}
	
	public boolean isLive(){
		return isLive;
	}




}