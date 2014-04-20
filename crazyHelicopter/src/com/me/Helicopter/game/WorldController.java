package com.me.Helicopter.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;
import com.me.Helicopter.game.objects.Bird;
import com.me.Helicopter.game.objects.Bomb;
import com.me.Helicopter.game.objects.Bullet;
import com.me.Helicopter.game.objects.Helicopter;
import com.me.Helicopter.game.objects.Helper;
import com.me.Helicopter.game.objects.Tank;

// tat ca cac doi tuong co trong game deu duoc khai bao va su dung tai day, no chiu trach nhiem 
// xu ly tat ca nhung tuong tac vv

// chu y la worldController chu yeu la goi toi cac ham update cua cac doi tuong
// vi du voi may bay thi no se goi toi helicopter.update



public class WorldController extends InputAdapter {
	public Helicopter helicopter;	// 1 doi tuong may bay
	public Bomb bomb;
	public Tank tank;
	public Bird bird;
	public Helper helper;
	public Bullet bullet;
	public Array<Bullet> bullets;
	public Array<Tank> tanks; 		// tao ra 1 mang cac tank de quan ly cac tank duoc tao ra
	public Array<Bomb> bombs;
	
	public Random random1;
	public Random random2;
	//public boolean start; //xac dinh xem co bird nao chua
	
	public long timePress = 550l; // khoang thoi gian giua cac lan ban
	public long BulletPressTime;  // bien nay de luu moc thoi gian khi ban 
	public long deltaTime;
	public long deltaTime1;
	
	// bien danh cho debug
	public int demBom=0;
	public Music boomboom;
	
	
	public WorldController(){		// khoi tao het cho bon no
		helicopter = new Helicopter();
		bullets = new Array<Bullet>();
		tanks = new Array<Tank>();
		bombs = new Array<Bomb>();
		deltaTime = System.currentTimeMillis();
		deltaTime1 = deltaTime;
		addTank();
		bird = new Bird();
		helper = new Helper();
		random1 = new Random();
		random2 = new Random();
	}
	
	public void update(){		// cap nhat tat ca cac thay doi cho game
							// no se goi toi cac thay doi cua tat ca cac thanh phan con
							// chi goi update cua cac phan tu con ma thoi
		checkCollision();
		
		helicopter.update();
		
		bird.update();
		
		helper.update();
		//helper nem bom
		if (helper.check == true) {
			if( System.currentTimeMillis() -  deltaTime1 > 200){
				bomb = new Bomb();						// tao ra 1 doi tuong la boom
				bombs.add(bomb);
				bomb.setPosition(helper.helper.getX() + helper.helper.getWidth()/2, 
						helper.helper.getY() -5);
				deltaTime1 = System.currentTimeMillis();
				Assets.instance.boomboom.play();
			}
		}
		
		tankShotBullet();
		
		for (Bullet b : bullets) {
			if(b.bullet.getY() > 600){
				bullets.removeValue(b, true);
			}
			else{
				b.update();
			}
			
		}
		//System.out.println("Bullets size: " + bullets.size);
		
		
		
		if(Gdx.input.isKeyPressed(Keys.SPACE)){		// neu nhu goi lenh tha boom
			if( System.currentTimeMillis() -  deltaTime > 200){
				bomb = new Bomb();						// tao ra 1 doi tuong la boom
				bombs.add(bomb);
				bomb.setPosition(helicopter.heli.getX() + helicopter.heli.getWidth()/2, helicopter.heli.getY() -5);
				deltaTime = System.currentTimeMillis();
				demBom++;
				Assets.instance.boomboom.play();
				
				//System.out.println("So boom : " + bombs.size);
				
			}
		}
		// duyet qua tat ca cac bomb 
		for (Bomb xbomb: bombs) {
			if(!xbomb.isLive()){
				bombs.removeValue(xbomb, true);
				
				System.out.println("So boom : " + bombs.size);
			}else{
				xbomb.update();
			}
			
		}
		
	}
	
	public void checkCollision(){
		// Check bullet collision with helicopter
		for (Bullet b : bullets) {
			if(b.bullet.getBoundingRectangle().overlaps(helicopter.heli.getBoundingRectangle())){
				b.afterCollision();
				
				helicopter.afterCollision();
			}
		}
		// Check bomb collision with tank and cannon
		for (Bomb bom : bombs) {
			// bomb collision with tank
			for( Tank t : tanks){
				if(bom.bomb.getBoundingRectangle().overlaps(t.tank.getBoundingRectangle())){
					bom.afterCollision();
					t.afterCollision();
				}
			}
			// bomb collision with cannon
			
		}
	}
	
	public void tankShotBullet(){
		for (Tank t : tanks) {
			t.update();
			if(t.shot()){		
				if(!t.getIsShot()){
					BulletPressTime = System.currentTimeMillis();
					t.setShot(true);
	
					bullet = new Bullet();
					bullets.add(bullet);
					bullet.setPositionBullet(t.tank.getX(), t.tank.getY() );
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
	public void addTank(){
		tank = new Tank();
		tanks.add(tank);
		tank = new Tank();
		tanks.add(tank);
	}

	
	
}
