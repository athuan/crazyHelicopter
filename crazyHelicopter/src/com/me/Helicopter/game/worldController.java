package com.me.Helicopter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.me.Helicopter.game.objects.Bomb;
import com.me.Helicopter.game.objects.Bullet;
import com.me.Helicopter.game.objects.Cannon;
import com.me.Helicopter.game.objects.Helicopter;
import com.me.Helicopter.game.objects.Tank;
import com.me.Helicopter.game.Level;

// tat ca cac doi tuong co trong game deu duoc khai bao va su dung tai day, no chiu trach nhiem 
// xu ly tat ca nhung tuong tac vv

// chu y la worldController chu yeu la goi toi cac ham update cua cac doi tuong
// vi du voi may bay thi no se goi toi helicopter.update



public class WorldController {
	public Level level;
	
	public long timePress = 550l; // khoang thoi gian giua cac lan ban
	public long BulletPressTime;  // bien nay de luu moc thoi gian khi ban 
	
	
	public WorldController(){		// khoi tao het cho bon no
		level = new Level();
	}
	
	public void update(){		// cap nhat tat ca cac thay doi cho game
							// no se goi toi cac thay doi cua tat ca cac thanh phan con
							// chi goi update cua cac phan tu con ma thoi
		checkCollision();
		
		level.helicopter.update();
		
		tankShotBullet();
		
		for (Bullet b : level.bullets) {
			if(b.bullet.getY() > 600){
				level.bullets.removeValue(b, true);
			}
			else{
				b.update();
			}
			
		}
		//System.out.println("Bullets size: " + bullets.size);
		
		
		
		if(Gdx.input.isKeyPressed(Keys.SPACE)){		// neu nhu goi lenh tha boom
<<<<<<< HEAD
			level.bomb = new Bomb();						// tao ra 1 doi tuong la boom
			level.bombs.add(level.bomb);
			level.bomb.setPosition(level.helicopter.heli.getX(), level.helicopter.heli.getY());
			level.bomb.update();							// cho no tinh toan de no tu roi
=======
			bomb = new Bomb();						// tao ra 1 doi tuong la boom
			bombs.add(bomb);
			bomb.setPosition(helicopter.heli.getX(), helicopter.heli.getY());
			// cho no tinh toan de no tu roi
>>>>>>> d15812ef1d51d6ad27cd9a0af8f0e51098570ef9
		}
		// duyet qua tat ca cac bomb 
		
		for (Bomb xBomb : bombs) {
			if(!xBomb.isLive() ){	// kiem tra xem no co con duoc suat hien tren man hinh khong
				bombs.removeValue(xBomb, false);
				
			}else{
				xBomb.update();
			}	
		}
		
	}
	
	public void checkCollision(){
		// Check bullet collision with helicopter
		for (Bullet b : level.bullets) {
			if(b.bullet.getBoundingRectangle().overlaps(level.helicopter.heli.getBoundingRectangle())){
				b.afterCollision();
				level.helicopter.afterCollision();
			}
		}
		// Check bomb collision with tank and cannon
		for (Bomb bom : level.bombs) {
			// bomb collision with tank
			for( Tank t : level.tanks){
				if(bom.bomb.getBoundingRectangle().overlaps(t.tank.getBoundingRectangle())){
					bom.afterCollision();
					t.afterCollision();
				}
			}
			// bomb collision with cannon
			
		}
	}
	
	public void tankShotBullet(){
		for (Tank t : level.tanks) {
			t.update();
			if(t.shot()){		
				if(!t.getIsShot()){
					BulletPressTime = System.currentTimeMillis();
					t.setShot(true);
	
					level.bullet = new Bullet();
					level.bullets.add(level.bullet);
					level.bullet.setPositionBullet(t.tank.getX(), t.tank.getY() );
					//System.out.println("BulletTime" + BulletPressTime);
				}
				else{
					if(System.currentTimeMillis() - BulletPressTime >= timePress){
						t.setShot(false);	
					}
				}
			}
		}
	}
	
}
