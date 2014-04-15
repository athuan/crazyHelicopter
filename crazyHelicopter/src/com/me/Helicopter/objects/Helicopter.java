package com.me.Helicopter.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.me.Helicopter.game.Assets;

public class Helicopter extends AbstractObject{
	public Sprite helicopter;
	
	
	public Helicopter(){
		helicopter = Assets.instance.helicopter;
		this.dimension.set(1, 1);
		this.origin.set(dimension.x/2, dimension.y/2);
		this.position.set(0,0);
		
	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}
