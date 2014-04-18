package com.me.Helicopter.game.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Tank extends AbstractObject {
	
	public Sprite tank;
	private Random rand = new Random();
	private float xPos; // create position.x random for tank
	private boolean isShot;
	
	private long timeToCheck = 1200l;
	private long originCheckTime;
	
	private float delta = 1;
	
	public Tank(){
		tank = new Sprite(Assets.instance.tank);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2);
		xPos = rand.nextInt(700);
		tank.setPosition(xPos, 100);
		isShot = false;
		originCheckTime = System.currentTimeMillis();
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
			if(tank.getX() <= 0 || tank.getX() > xPos) delta = -delta;
		}
	}



	@Override
	public void render(SpriteBatch batch) {
		tank.draw(batch);
		
	}
	
	// sinh ra 1 so ngau nhien, neu < 20 thi tank se ban dan
	public boolean shot(){
		return rand.nextInt(1000) < 20;
	}

	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		
	}

}
