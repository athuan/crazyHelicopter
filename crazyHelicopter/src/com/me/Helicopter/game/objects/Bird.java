package com.me.Helicopter.game.objects;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Bird extends AbstractObject {
	
	public Sprite bird;
	public Sprite bird1;
	public Sprite bird2;
	public Random random = new Random();
	public float xPos1;
	public float xPos2;
	public float yPos;	// do cao
	public boolean check; //check xem da co bird ko
	public boolean direction; //huong bay den (true = trai qua; false = phai qua)
	
	public Bird(){
		init();
	}

	public void init(){
		bird1 = new Sprite(Assets.instance.bird);
		bird2 = new Sprite(Assets.instance.bird);
		bird2.flip(true, false);
		bird = new Sprite(Assets.instance.bird);
		bird.setPosition(-100, 0);
		xPos1 = 0;
		xPos2 = Gdx.graphics.getWidth();
		yPos = random.nextInt(Gdx.graphics.getHeight()/2) + Gdx.graphics.getHeight()/2
				- 50;
				//- bird.getHeight()/2;
		check = false;
		direction = random.nextBoolean();
	}

	@Override
	public void update() {
		if (check == false){
			if ( random.nextInt(3000) <= 10){
				init();
				check = true;
			}
		}else{
			if ( bird1.getX() > Gdx.graphics.getWidth() || bird2.getX() < 0 ){
				check = false;
			}else{
				if (direction){
					xPos1 += 200*Gdx.graphics.getDeltaTime();
					bird = bird1;
					bird.setPosition(xPos1, yPos);
				}else{
					xPos2 -= 200*Gdx.graphics.getDeltaTime();
					bird = bird2;
					bird.setPosition(xPos2, yPos);
				}
			}
		}
		
	}
	

	@Override
	public void render(SpriteBatch batch) {
		if (!check) return;
		bird.draw(batch);
	}
	

	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		
	}
	
}
