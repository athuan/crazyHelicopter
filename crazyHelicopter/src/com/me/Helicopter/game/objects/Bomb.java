package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.me.Helicopter.game.Assets;

public class Bomb extends AbstractObject {
	
	public Sprite bomb;
	
	public Bomb(){
		bomb = Assets.instance.tank;
	}

	@Override
	public void render() {		// ve qua boom theo tao do duoc tinh sau update()
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {		// ham nay de tinh toan qua boom khi duoc goi thi no se roi(cap nhat vi tri roi)
		// TODO Auto-generated method stub
		
	}

}
