package com.me.Helicopter.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.me.Helicopter.game.objects.Bird;
import com.me.Helicopter.game.objects.Bomb;
import com.me.Helicopter.game.objects.Bullet;
import com.me.Helicopter.game.objects.Burn;
import com.me.Helicopter.game.objects.Cannon;
import com.me.Helicopter.game.objects.Helicopter;
import com.me.Helicopter.game.objects.Helper;
import com.me.Helicopter.game.objects.Rocket;
import com.me.Helicopter.game.objects.Tank;

// tat ca cac doi tuong co trong game deu duoc khai bao va su dung tai day, no chiu trach nhiem 
// xu ly tat ca nhung tuong tac vv

// chu y la worldController chu yeu la goi toi cac ham update cua cac doi tuong
// vi du voi may bay thi no se goi toi helicopter.update

public class WorldController {
	public Helicopter helicopter; // 1 doi tuong may bay
	public Bomb bomb;
	public Tank tank;
	public Bird bird;
	public Helper helper;
	public Bullet bullet;
	public Burn burn;
	public Array<Burn> burns; // tao ra 1 mang cac dom lua sau khi dan va cham
								// vs may bay
	public Array<Bullet> bullets;
	public Array<Tank> tanks; // tao ra 1 mang cac tank de quan ly cac tank duoc
	public Sprite button;
	// tao ra
	public Array<Bomb> bombs;

	public Random random1;
	public Random random2;
	// public boolean start; //xac dinh xem co bird nao chua

	public long timePress = 550l; // khoang thoi gian giua cac lan ban
	public long BulletPressTime; // bien nay de luu moc thoi gian khi ban
	public long deltaTime;
	public long deltaTime1;

	// bien danh cho debug
	public int demBom = 0;
	public Music boomboom;

	// cannon and boom
	public Cannon cannon;
	public Array<Cannon> cannons;
	public Rocket rocket;
	public Array<Rocket> rockets1;
	public Array<Rocket> rockets2;
	public float speed;
	public long rocketPressTime;
	public Random rand;

	public WorldController() { // khoi tao het cho bon no

		helicopter = new Helicopter();
		bullets = new Array<Bullet>();
		tanks = new Array<Tank>();
		bombs = new Array<Bomb>();
		burns = new Array<Burn>();
		deltaTime = System.currentTimeMillis();
		deltaTime1 = deltaTime;
		addTank();
		bird = new Bird();
		helper = new Helper();
		random1 = new Random();
		random2 = new Random();

		// cannon and rocket
		rand = new Random();
		cannon = null;
		rocket = null;
		cannons = new Array<Cannon>();
		rockets1 = new Array<Rocket>();
		rockets2 = new Array<Rocket>();
		addCannon();

		//

		button = new Sprite(Assets.instance.buttonFire);
		button.setColor(1, 1, 1, 0.3f);

	}

	public void update() { // cap nhat tat ca cac thay doi cho game
		// no se goi toi cac thay doi cua tat ca cac thanh phan con
		// chi goi update cua cac phan tu con ma thoi
		checkCollision();

		helper.update();

		// helper nem bom
		if (helper.check == true) {
			if (System.currentTimeMillis() - deltaTime1 > 200) {
				bomb = new Bomb(); // tao ra 1 doi tuong la boom
				bombs.add(bomb);
				bomb.setPosition(
						helper.helper.getX() + helper.helper.getWidth() / 2,
						helper.helper.getY() - 5);
				deltaTime1 = System.currentTimeMillis();

			}
		}

		tankShotBullet();
		// CannonShotRocket();
		rocketUpdate();

		for (Burn bu : burns) {
			if (bu.time <= 0) {
				burns.removeValue(bu, true);
			} else {
				bu.update();
			}
		}
		if (Gdx.input.isTouched()) { // neu nhu goi lenh tha boom
			float x = Gdx.input.getX();
			float y = Gdx.graphics.getHeight() - Gdx.input.getY();
			if (button.getBoundingRectangle().contains(x, y)) {
				if (System.currentTimeMillis() - deltaTime > 80) {
					bomb = new Bomb(); // tao ra 1 doi tuong la boom
					bombs.add(bomb);
					bomb.setPosition(
							helicopter.heli.getX() + helicopter.heli.getWidth()
									/ 2, helicopter.heli.getY() - 5);
					deltaTime = System.currentTimeMillis();
					demBom++;
				}
			} else {
				// //// DI CHUYEN CUA MAY BAY
				helicopter.xPos = x - helicopter.heli.getX();
				helicopter.yPos = y - helicopter.heli.getY();
				// System.out.println(x + "  " + y);

			}
		}
		if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
			if (System.currentTimeMillis() - deltaTime > 300) {
				bomb = new Bomb(); // tao ra 1 doi tuong la boom
				bombs.add(bomb);
				bomb.setPosition(
						helicopter.heli.getX() + helicopter.heli.getWidth() / 2,
						helicopter.heli.getY() - 5);
				deltaTime = System.currentTimeMillis();
				demBom++;
			}
		}

		helicopter.update();
	}

	public void checkCollision() {
		// Check bullet collision with helicopter
		for (Bullet b : bullets) {
			if (b.bullet.getBoundingRectangle().overlaps(
					helicopter.heli.getBoundingRectangle())) {
				// sau khi va cham thi xuat hien 1 dom lua
				addBurn(b.bullet.getX(), b.bullet.getY(), Assets.instance.fire);
				bullets.removeValue(b, true);
				helicopter.afterCollision();
			}
			// Check bullet collision with land
			else if (b.bullet.getY() < 90) {
				addBurn(b.bullet.getX(), b.bullet.getY(), Assets.instance.fire);
				bullets.removeValue(b, true);
			} else {
				b.update();
			}
		}
		// Check bomb collision with tank and cannon
		for (Bomb bom : bombs) {
			// bomb collision with tank
			for (Tank t : tanks) {
				if (bom.bomb.getBoundingRectangle().overlaps(
						t.tank.getBoundingRectangle())) {
					addBurn(bom.bomb.getX(), bom.bomb.getY(),
							Assets.instance.bird);
					bombs.removeValue(bom, true);
					if (t.blood <= 0) {
						tanks.removeValue(t, true);
					} else {
						t.afterCollision();
					}
				}
			}
			// bomb collision with cannon
			for (Cannon cn : cannons) {
				if (bom.bomb.getBoundingRectangle().overlaps(
						cn.cannon.getBoundingRectangle())) {
					addBurn(bom.bomb.getX(), bom.bomb.getY()-50,
							Assets.instance.fire);
					bombs.removeValue(bom, true);
					if (cn.blood <= 0) {
						cannons.removeValue(cn, true);
					} else {
						cn.afterCollision();
					}
				}
			}
			if (bom.bomb.getY() < 90) {
				addBurn(bom.bomb.getX(), bom.bomb.getY(), Assets.instance.fire);
				bombs.removeValue(bom, true);
			} else {
				bom.update();
			}

		}

		for (Rocket rk : rockets1) {
			if (rk.rocket.getBoundingRectangle().overlaps(
					helicopter.heli.getBoundingRectangle())) {

				// sau khi dan mat thi xuat hien 1 dom lua
				addBurn(rk.rocket.getX(), rk.rocket.getY(), Assets.instance.fire);
				rockets1.removeValue(rk, true);
				helicopter.afterCollision();
			}
//			if (rk.rocket.getY() > 800) {
//				rockets1.removeValue(rk, true);
//			} else {
//				rk.update();
//			}
		}

		if (helicopter.heli.getBoundingRectangle().overlaps(
				bird.bird.getBoundingRectangle())) {
			// helicopter.blood -= 2;
			addBurn(bird.bird.getX(), bird.bird.getY(), Assets.instance.fire);
			// bird.check = true;
		} else {
			bird.update();
		}

		// collision rocket, cannon
		// rocketCollision();
		// cannonCollisionWithBomb();
	}

	public void tankShotBullet() {
		for (Tank t : tanks) {
			t.update();
			if (t.shot()) { // tank chuan bi ban
				if (!t.getIsShot()) { // Neu chua ban thi ban
					BulletPressTime = System.currentTimeMillis();
					t.setShot(true);
					Assets.instance.boomboom.play();
					bullet = new Bullet(t.getIsFaceLeft());
					bullets.add(bullet);
					bullet.setPositionBullet(t.tank.getX(), t.tank.getY());
				} else { // Neu ban roi va thoi gian ban vien truoc > timePress
							// thi coi nhu la chua ban de ban
					if (System.currentTimeMillis() - BulletPressTime >= timePress) {
						t.setShot(false);
					}
				}
			}
		}
	}

	// sau khi va cham se xuat hien sprite o vi tri (posX, posY)
	public void addBurn(float posX, float posY, Sprite sprire) {
		burn = new Burn(sprire);
		burns.add(burn);
		burn.setPositionBullet(posX, posY);
	}

	public void addTank() {
		tank = new Tank();
		tanks.add(tank);
		tank = new Tank();
		tanks.add(tank);
		tank = new Tank();
		tanks.add(tank);
		tank = new Tank();
		tanks.add(tank);
	}

	// cannon
	public void addCannon() {
		cannon = new Cannon();
		cannon.setPosition(200, 100);
		cannon.setBlood(70);
		cannons.add(cannon);
		cannon = new Cannon();
		cannon.setPosition(600, 200);
		cannon.setBlood(100);
		cannons.add(cannon);
		// cannon = new Cannon();
		// cannon.setPosition(600, 100);
		// cannon.setBlood(100);
		// cannons.add(cannon);
		// cannon = new Cannon();
		// cannon.setPosition(400, 200);
		// cannon.setBlood(100);
		// cannons.add(cannon);
		speed = 5;

	}

	// rocket
	public void rocketUpdate() {
		Rocket rocket;
		// float angle;
		for (Cannon cn : cannons) {

			if (rand.nextInt(1000) < 10) {

				if (cn.getBlood() > 0  && helicopter.blood > 0 ) {
					Vector2 pos = new Vector2();
					pos.set(cn.cannon.getX(), cn.cannon.getY());
					Vector2 des = new Vector2();
					des.set(helicopter.heli.getX(), helicopter.heli.getY());
					rocket = new Rocket(pos, des);
			//		System.out.println(rocket.angle);
					rocket.setPosition(cn.cannon.getX() + 15,
							cn.cannon.getY() + 50);
					rockets1.add(rocket);
				}
				if (cn.cannon.getX() < helicopter.heli.getX()) {
					// cn.direction = true;
					cn.cannon.flip(false, false);
				}
				if (cn.cannon.getX() > helicopter.heli.getX()) {
					// cn.cannonFlip = cn.cannon;
					// cn.cannon.flip(true, false);
					cn.cannon.flip(true, false);
					// cn.direction = false;
				}
			}

		}
		for (Rocket rk : rockets1) {
			rk.update(speed);
			if (rk.getY() > 600 || rk.collision == true) {
				rockets1.removeValue(rk, true);
			}
			
		}
	}
}