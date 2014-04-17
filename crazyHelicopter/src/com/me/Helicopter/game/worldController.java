package com.me.Helicopter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.utils.Array;
import com.me.Helicopter.game.objects.Bomb;
import com.me.Helicopter.game.objects.Helicopter;
import com.me.Helicopter.game.objects.Tank;

// tat ca cac doi tuong co trong game deu duoc khai bao va su dung tai day, no chiu trach nhiem 
// xu ly tat ca nhung tuong tac vv

// chu y la worldController chu yeu la goi toi cac ham update cua cac doi tuong
// vi du voi may bay thi no se goi toi helicopter.update



public class WorldController {
	public Helicopter helicopter;	// 1 doi tuong may bay
	public Bomb bomb;
	public Array<Tank> tanks; 		// tao ra 1 mang cac tank de quan ly cac tank duoc tao ra
	public Array<Bomb> bombs;		// 1 mang de chua cac boom
	
	
	public WorldController(){		// khoi tao het cho bon no
		helicopter = new Helicopter();
		tanks = new Array<Tank>();
		bombs = new Array<Bomb>();
	}
	
	public void update(){		// cap nhat tat ca cac thay doi cho game
							// no se goi toi cac thay doi cua tat ca cac thanh phan con
							// chi goi update cua cac phan tu con ma thoi
		helicopter.update();	
		if(Gdx.input.isKeyPressed(Keys.SPACE)){		// neu nhu goi lenh tha boom
			bomb = new Bomb();						// tao ra 1 doi tuong la boom
			bombs.add(bomb);
			bomb.setPosition(helicopter.heli.getX(), helicopter.heli.getY());
			// cho no tinh toan de no tu roi
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
	
	
	
	
}
