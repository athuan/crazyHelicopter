package com.me.Helicopter.game.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Tank extends AbstractObject {
	
	public Sprite tank;
	private Random rand = new Random();
	private float xPos; // create position.x random for tank
	private boolean isShot;
	private int isFaceLeft;
	private long timeToCheck = 1200l;
	private long originCheckTime;
	
	
	private float delta = 1;
	
	public Tank(){
		Texture.setEnforcePotImages(false);
		
		tank = new Sprite(Assets.instance.tank);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2);
		xPos = rand.nextInt(700);
		tank.setPosition(xPos, 100);
		isShot = false;
		originCheckTime = System.currentTimeMillis();
		isFaceLeft = rand.nextInt(1);
		blood = 70;
		boundBloodX = blood;
		//pixmap = new Pixmap((int)blood, 5, Format.RGBA8888 );
		
	}
	
	public int getIsFaceLeft(){
		return isFaceLeft;
	}
	
	public void setShot(boolean isShot){
		this.isShot = isShot;
	}
	
	public boolean getIsShot(){
		return this.isShot;
	}
	

	@Override
	public void update() {	// ham nay se co cac dung lam cho xe tang chay o canh duoi man hinh
						// chay qua chay lai 1 cach random
		
		this.tank.setPosition(tank.getX() + delta, 100);
		if(System.currentTimeMillis() - originCheckTime >= timeToCheck){
			originCheckTime = System.currentTimeMillis();
			xPos = rand.nextInt(400) + 350;
			if(tank.getX() <= 0 || tank.getX() > xPos) {
				if(isFaceLeft == 1){
					isFaceLeft = 0;
				}else{
					isFaceLeft = 1;
				}
				tank.flip(true, false);
				delta = -delta;
			}
		}
		
		
	}



	@Override
	public void render(SpriteBatch batch) {
		drawBlood(batch);
		tank.draw(batch);
		
	}
	
	public void drawBlood(SpriteBatch batch){
		pixmap = new Pixmap((int)blood, boundBloodY, Format.RGBA8888 );
		pixmap.setColor(1, 0, 0, 1);
		
		pixmap.fill();
		texture = new Texture(pixmap);
		batch.draw(texture, tank.getX(), tank.getY() + 50);
	}
	
	// sinh ra 1 so ngau nhien, neu < 20 thi tank se ban dan
	public boolean shot(){
		if(rand.nextInt(1000) < 20){
			return true;
		}
		return false;
	}
	

	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		this.blood -= 2;
	}
	

}
