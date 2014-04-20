package com.me.Helicopter.level;

import com.badlogic.gdx.math.Vector2;

public abstract class Level {
	// file nay se mo ta tat ca cac thuoc tinh cua cac doi tuong trong 1 level
	
	
	// cac thong so cho Helicopter
	public Vector2 velocityHeli;			// van toc cua helicopter
	public int numberOfBomb;			// so luong bomb cua no o level do
	public int bloodHelicopter;					// luong mau no duoc cung cap
	
	// thong so cho tank
	public int numberOfTank;
	public int bloodTank;
	public Vector2 velocityTank;
	
	// thong so cho bomb
	
	public Vector2 velocityBomb;		// vay toc cua bom, khi may bay ban ra
	
	//
	
	
	public Level(){
		
	}
}
