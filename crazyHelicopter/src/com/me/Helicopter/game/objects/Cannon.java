package com.me.Helicopter.game.objects;

import java.util.Random;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Cannon extends AbstractObject {

	public Sprite cannon;
	public Sprite cannon1;
	private Random rand;
	private float xPos;
	private boolean shot;
	public Sprite fire;

	public Cannon() {
		cannon = new Sprite(Assets.instance.cannon);
		cannon1 = new Sprite(Assets.instance.cannon);
		cannon.flip(false, false);
		cannon1.flip(true, false);
		dimension.set(1, 1);
		origin.set(dimension.x / 2, dimension.y / 2);
		rand = new Random();
		xPos = rand.nextInt(700);
		cannon.setPosition(xPos, 100);
		cannon.setSize(50, 50);
		shot = false;
		blood = 70;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		drawBlood(batch);
		if (blood > 0) {
			cannon.draw(batch);
		}
	}
	
	public void drawBlood(SpriteBatch batch){
		pixmap = new Pixmap((int)blood/2, boundBloodY, Format.RGBA8888 );
		pixmap.setColor(1, 0, 0, 1);
		
		pixmap.fill();
		texture = new Texture(pixmap);
		batch.draw(texture, cannon.getX(), cannon.getY() + 70);
	}

	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		blood -= 2;

	}

	public void setShot(boolean shot) {
		this.shot = shot;
	}

	public boolean getShot() {
		return this.shot;
	}

	public boolean shot() {
		return rand.nextInt(1000) < 50;
	}

	public void setPosition(float x, float y) {
		this.cannon.setPosition(x, y);
	}

	public void setBlood(int blood) {
		this.blood = blood;
	}
	
	public int getBlood(){
		return this.blood;
	}

}
