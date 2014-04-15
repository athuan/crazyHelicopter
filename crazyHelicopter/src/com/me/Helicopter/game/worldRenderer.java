package com.me.Helicopter.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

// no se chi chua SpriteBatch de ve ra man hinh va 1 cai worldControll
// sau do thuc hien ve ra man hinh sau khi da update moi thu

public class WorldRenderer {
	public SpriteBatch batch;		// co cai nay de dung de ve
	public WorldController worldController;
	
	
	public WorldRenderer(WorldController worldController ){
		this.worldController = worldController;			// gans bien cho no
	}

}
