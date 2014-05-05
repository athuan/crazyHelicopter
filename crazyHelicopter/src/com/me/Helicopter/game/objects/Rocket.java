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
	public float angle;
	public boolean withboss;
	public Vector2 direction = new Vector2();

	// private Random rand = new Random();
	//
	// public Rocket(float angle) {
	// this.angle = angle;
	// init(angle);
	// }
	//
	// /*public Rocket(float angle) {
	// init(angle);
	// }*/
	//
	// public void init(float angle) {
	// rocket = new Sprite(Assets.instance.rocket);
	// // fire = new Sprite(Assets.instance.fire);
	// this.angle = angle;
	// //angle = rand.nextInt(120) + 30;
	// rocket.rotate(angle);
	// rocket.setSize(30, 5);
	// this.dimension.set(1, 1);
	// this.origin.set(dimension.x / 2, dimension.y / 2);
	// velocity.set((float) Math.cos(angle / 180 * Math.PI), (float)
	// Math.sin(angle / 180 * Math.PI));
	// //velocity.set(1, 1);
	// speed = 5;
	// angle = 0;
	// }
	public Rocket(Vector2 pos, Vector2 des) {
		rocket = new Sprite(Assets.instance.rocket);
		direction = new Vector2(-pos.x +des.x+ 50,  -pos.y + des.y+ 50);
		direction.nor();
		collision = false;
		angle = (float) Math.atan2(-pos.y + des.y, -pos.x +des.x);
		speed = 1;
		rocket.rotate((float) (angle/Math.PI* 180));
		rocket.setSize(30, 5);
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		//if (!collision) {
			rocket.draw(batch);
			//if (withboss == true) {
				// rocket.rotate(90);
			//}

		//}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
//		rocket.setPosition(rocket.getX() + 5* direction.x, rocket.getY()
//				+ 5* Math.abs(direction.y));
	}

	public void update(float speed) {
//		this.speed = speed;
//		rocket.setPosition(rocket.getX() + velocity.x * speed, rocket.getY()
//				+ velocity.y * speed);
		rocket.setPosition(rocket.getX() + speed* direction.x, rocket.getY()
				+ speed* Math.abs(direction.y));
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

	public float getY() {
		return rocket.getY();
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getSpeed() {
		return speed;
	}

	public void setRotation(float angle) {
		this.angle = angle;
	}

	public float getRotation() {
		return angle;
	}

}
