package com.me.Helicopter.game;

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
	public Array<Tank> tanks; 		// tao ra 1 mang cac tank de quan ly cac tank duoc tao ra
	public Array<Bomb> booms;		// 1 mang de chua cac boom
	
	
	public WorldController(){		// khoi tao het cho bon no
		
	}
	
	public void update(){		// cap nhat tat ca cac thay doi cho game
							// no se goi toi cac thay doi cua tat ca cac thanh phan con
							// chi goi update cua cac phan tu con ma thoi
		
		
	}
	
	
	
	
}
