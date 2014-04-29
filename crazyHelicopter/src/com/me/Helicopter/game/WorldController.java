package com.me.Helicopter.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Rectangle;
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

public class WorldController  {
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

		

		bird.update();

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
		CannonShotRocket();

		for (Bullet b : bullets) {
			if(b.bullet.getY() < 100){
				bullets.removeValue(b, true);
			} else {
				b.update();
			}
		}
		
		for (Rocket r : rockets1) {
			if(r.rocket.getY() > 800){
				rockets1.removeValue(r, true);
			}else{
				r.update();
			}
		}
		
		for (Burn bu :burns){
			if(bu.time <=0 ){
				burns.removeValue(bu, true);
			}else{
				bu.update();
			}
		}
		if ( Gdx.input.isTouched()) { // neu nhu goi lenh tha boom
			float x= Gdx.input.getX();
			float y =Gdx.graphics.getHeight() - Gdx.input.getY();
			if( button.getBoundingRectangle().contains( x,y) ){
				if(System.currentTimeMillis() - deltaTime > 80){
					bomb = new Bomb(); // tao ra 1 doi tuong la boom
					bombs.add(bomb);
					bomb.setPosition(
							helicopter.heli.getX() + helicopter.heli.getWidth() / 2,
							helicopter.heli.getY() - 5);
					deltaTime = System.currentTimeMillis();
					demBom++;
				}
			}else{
			////// DI CHUYEN CUA MAY BAY
				helicopter.xPos = x - helicopter.heli.getX();
				helicopter.yPos = y -  helicopter.heli.getY();
				//System.out.println(x + "  " + y);
				
			}
		}
		helicopter.update();
				// System.out.println("So boom : " + bombs.size);
		// duyet qua tat ca cac bomb
		for (Bomb xbomb : bombs) {
			if (!xbomb.isLive()) {
				bombs.removeValue(xbomb, true);
			} else {
				xbomb.update();
			}

		}

		// rocket
		//rocketUpdate();

	}

	public void checkCollision() {
		// Check bullet collision with helicopter
		for (Bullet b : bullets) {
			if (b.bullet.getBoundingRectangle().overlaps(
					helicopter.heli.getBoundingRectangle())) {
				// b.afterCollision();
				bullets.removeValue(b, true);
				// sau khi dan mat thi xuat hien 1 dom lua
				burn = new Burn();
				burns.add(burn);
				burn.setPositionBullet(helicopter.heli.getX(),
						helicopter.heli.getY());
				helicopter.afterCollision();
			}
		}
		// Check bomb collision with tank and cannon
		for (Bomb bom : bombs) {
			// bomb collision with tank
			for (Tank t : tanks) {
				if (bom.bomb.getBoundingRectangle().overlaps(
						t.tank.getBoundingRectangle())) {
					bom.afterCollision();
					t.afterCollision();
				}
			}
			// bomb collision with cannon

		}

		// collision rocket, cannon
		rocketCollision();
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

	public void CannonShotRocket() {
		for (Cannon c : cannons) {
			c.update();
			if (c.shot()) { // tank chuan bi ban
				if (!c.getShot()) { // Neu chua ban thi ban
					BulletPressTime = System.currentTimeMillis();
					c.setShot(true);
					// Assets.instance.boomboom.play();
					rocket = new Rocket(new Vector2(c.cannon.getX(),
							c.cannon.getY()), new Vector2(
							helicopter.heli.getX(), helicopter.heli.getY()));
					rockets1.add(rocket);
					rocket.setPosition(c.cannon.getX(), c.cannon.getY());
					// bullet.setPositionBullet(t.tank.getX(), t.tank.getY());
				} else { // Neu ban roi va thoi gian ban vien truoc > timePress
							// thi coi nhu la chua ban de ban
					if (System.currentTimeMillis() - BulletPressTime >= timePress) {
						c.setShot(false);
					}
				}
			}
		}
	}

	public void addTank() {
		tank = new Tank();
		tanks.add(tank);
		tank = new Tank();
		tanks.add(tank);
	}

	// cannon
	public void addCannon() {
		cannon = new Cannon();
		cannon.setPosition(200, 100);
		cannon.setBlood(100);
		// cannon.cannon.flip(false, true);
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
		for (Cannon cn : cannons) {
			if (cn.shot()) {
				if (!cn.getShot()) {
					rocketPressTime = System.currentTimeMillis();
					cn.setShot(true);
					if (cn.cannon.getX() < helicopter.heli.getX()) {
						if (cn.getBlood() > 0 /* && helicopter.blood > 0 */) {
							cn.cannon.flip(false, false);
							rocket = new Rocket(45);
							rockets1.add(rocket);
							rocket.setPosition(cn.cannon.getX() + 15,
									cn.cannon.getY() + 50);
						}
					}
					if (cn.cannon.getX() > helicopter.heli.getX()) {
						if (cn.getBlood() > 0 /* && helicopter.blood > 0 */) {
							cn.cannon.flip(true, false);
							rocket = new Rocket(-45);
							rockets2.add(rocket);
							rocket.setPosition(cn.cannon.getX(),
									cn.cannon.getY() + 50);
						}
					}
				}
				// }
			} else {
				if (System.currentTimeMillis() - rocketPressTime >= timePress) {
					cn.setShot(false);
				}
			}
			for (Rocket rk : rockets1) {
				rk.update(speed);
				if (rk.rocket.getY() > 600) {
					rockets1.removeValue(rk, true);
				}

			}
			for (Rocket rk : rockets2) {
				rk.update(-speed);
				if (rk.getX() == helicopter.heli.getX()) {
					// System.out.println("vi tri la day");
				}
				if (rk.rocket.getY() > 600) {
					rockets2.removeValue(rk, true);
				}
			}

		}
	}

	// check collision rocket
	public void rocketCollision() {
		for (Rocket rk : rockets1) {
			if (rk.rocket.getBoundingRectangle().overlaps(
					helicopter.heli.getBoundingRectangle())) {
				// helicopter.afterCollision();
				rk.afterCollision();
				// System.out.println("tenlua1: " + helicopter.blood);
				break;
			} else {
				continue;
			}
		}
		for (Rocket rk : rockets2) {
			if (rk.rocket.getBoundingRectangle().overlaps(
					helicopter.heli.getBoundingRectangle())) {
				// helicopter.afterCollision();
				rk.afterCollision();
				// System.out.println("tenlua2: " + helicopter.blood);
				break;
			} else {
				continue;
			}
		}
	}

	public void cannonCollisionWithBomb() {
		for (Bomb bomb : bombs) {
			for (Cannon ca : cannons) {
				if (bomb.bomb.getBoundingRectangle().overlaps(
						ca.cannon.getBoundingRectangle())) {
					bomb.afterCollision();
					ca.afterCollision();
					System.out.println(ca.blood);
				} else {
					continue;
				}

			}
		}
	}

}
