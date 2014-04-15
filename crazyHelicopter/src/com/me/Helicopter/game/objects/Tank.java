package com.me.Helicopter.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.me.Helicopter.game.Assets;

public class Tank extends AbstractObject {
	
	public Sprite tank;
	
	public Tank(){
		tank = Assets.instance.tank;
	}

	@Override
	public void render() {		// ve ra cai xe tang thoi
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {	// ham nay se co cac dung lam cho xe tang chay o canh duoi man hinh
							// chay qua chay lai 1 cach random
		
	}

}
