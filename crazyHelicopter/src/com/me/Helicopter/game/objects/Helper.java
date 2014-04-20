package com.me.Helicopter.game.objects;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Helper extends AbstractObject {
	
	public Sprite helper;
	public Random random = new Random();
	public float xPos;
	public float yPos;	// do cao mac dinh 500
	public float rand;  // xac suat XH
	public boolean check; //ckeck xem co helper ko
	
	public Helper(){
		init();
	}

	public void init(){
		helper = new Sprite(Assets.instance.helper);
		helper.flip(true, false);
		xPos = 0;
		yPos = 300;
		rand = 0;
		check = false;
	}

	@Override
	public void update() {
		if (check == false){
			if ( random.nextInt(3000) <= 10){
				init();
				check = true;
			}
		}else{
			if ( helper.getX() > Gdx.graphics.getWidth() ){
				check = false;
			}else{
				xPos += 5;
				helper.setPosition(xPos, yPos);
			}
		}
	}
	

	@Override
	public void render(SpriteBatch batch) {
		if (!check) return;
		helper.draw(batch);
	}
	

	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		
	}
	
}
