package com.me.Helicopter.game;

import com.badlogic.gdx.utils.Array;
import com.me.Helicopter.game.objects.Bomb;
import com.me.Helicopter.game.objects.Bullet;
import com.me.Helicopter.game.objects.Helicopter;
import com.me.Helicopter.game.objects.Tank;


// tam thoi cai nay t chua dung toi


public class Level {
	
	public Helicopter helicopter;	// 1 doi tuong may bay
	public Bomb bomb;
	public Tank tank;
	public Bullet bullet;
	public Array<Bullet> bullets;
	public Array<Tank> tanks; 		// tao ra 1 mang cac tank de quan ly cac tank duoc tao ra
	public Array<Bomb> bombs;
	
	public Level(){		// khoi tao het cho bon no
		Level1();
	}
	
	public void Level1(){
		helicopter = new Helicopter();
		tanks = new Array<Tank>();
		bombs = new Array<Bomb>();
		bullets = new Array<Bullet>();
		bomb = null;
		tank = null;
		addTank();
	}
	
	public void addTank(){
		tank = new Tank();
		tanks.add(tank);
		tank = new Tank();
		tanks.add(tank);
	}

}
