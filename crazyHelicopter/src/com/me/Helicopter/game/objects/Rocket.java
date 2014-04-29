package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.me.Helicopter.game.Assets;

public class Rocket extends AbstractObject {
	public Sprite rocket;
	public float speed;
	public boolean collision;
	public Sprite fire;
	public Vector2 direction;

	public Rocket(Vector2 pos, Vector2 des) {
		rocket = new Sprite(Assets.instance.rocket);
		rocket.rotate(45);
		rocket.setSize(30, 5);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x / 2, dimension.y / 2);
		velocity.set(1, 1);
		speed = 1;
		collision = false;
		direction = new Vector2((des.x - pos.x),(des.y - pos.y));
		direction.nor();
	}

	public Rocket(float angle) {
		rocket = new Sprite(Assets.instance.rocket);
		// fire = new Sprite(Assets.instance.fire);
		rocket.rotate(angle);
		rocket.setSize(30, 5);
		this.dimension.set(1, 1);
		this.origin.set(dimension.x / 2, dimension.y / 2);
		velocity.set(1, 1);
		speed = 5;
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
		//rocket.setPosition(rocket.getX() + velocity.x * speed,
		//		rocket.getY() + speed * velocity.y);
		rocket.setPosition(rocket.getX() + direction.x, rocket.getY() + direction.y);
	}

	public void update(float deltaTime) {
		rocket.setPosition(rocket.getX() + velocity.x * deltaTime,
				rocket.getY() + velocity.y * Math.abs(deltaTime));
	}

	public void update(float a, float b) {
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

	public float getX() {
		return rocket.getX();
	}
	public void setSpeed(float speed){
		this.speed = speed;
	}
	public float getSpeed(){
		return speed;
	}

}
