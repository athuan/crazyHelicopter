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
	public boolean check; //ckeck xem co helper ton tai khong
	public boolean callHelper; // check xem co kha nang goi helper ko
	public long time;	// sau 1 khoang time la co the goi duoc helper
	
	public Helper(){
		init();
	}

	public void init(){
		helper = new Sprite(Assets.instance.helper);
		helper.setSize(80, helper.getHeight()/helper.getWidth()*80);
		xPos = 0;
		yPos = 500;
		rand = 0;
		check = false;
		callHelper = false;
		time = System.currentTimeMillis();
	}

	@Override
	public void update() {
		// check dieu kien de bat sang la co goi duoc helper ko
		if(System.currentTimeMillis() -  time > 13000 ){
			
			callHelper =  true;
			time =  System.currentTimeMillis();
		}
		if (check == true){	// neu no true thi chi don gian la cap nhat vi tri moi cho no
			if ( helper.getX() > Gdx.graphics.getWidth() ){
				check = false;
				// cho no ve vi tri ban dau de cho doi
				helper.setX(-5);
				
			}else{
				helper.setPosition(helper.getX() + 100*Gdx.graphics.getDeltaTime(), yPos);
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
