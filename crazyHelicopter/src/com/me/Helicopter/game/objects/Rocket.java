package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.Assets;

public class Rocket extends AbstractObject {
	public Sprite rocket;
	public float deltaTime;
	public boolean collision;
	public Sprite fire;

	public Rocket() {
		rocket = new Sprite(Assets.instance.rocket);
		rocket.rotate(45);
		rocket.setSize(30, 5);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x / 2, dimension.y / 2);
		velocity.set(1, 1);
		deltaTime = 5;
		collision = false;
	}

	public Rocket(float angle) {
		rocket = new Sprite(Assets.instance.rocket);
		//fire = new Sprite(Assets.instance.fire);
		rocket.rotate(angle);
		rocket.setSize(30, 5);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x / 2, dimension.y / 2);
		velocity.set(1, 1);
		deltaTime = 5;
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		if (!collision) {
			
			rocket.draw(batch);
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		rocket.setPosition(rocket.getX() + velocity.x * deltaTime,
				rocket.getY() + deltaTime * velocity.y);
	}

	public void update(float deltaTime) {
		rocket.setPosition(rocket.getX() + velocity.x * deltaTime,
				rocket.getY() + velocity.y * Math.abs(deltaTime));
	}
	public void update(float a, float b){
		rocket.setPosition(a, b);
	}
	@Override
	public void afterCollision() {
		// TODO Auto-generated method stub
		collision = true;
	}

	public void setPosition(float x, float y) {
		this.rocket.setPosition(x, y);
	}
	public float getX(){
		return rocket.getX();
	}

}
