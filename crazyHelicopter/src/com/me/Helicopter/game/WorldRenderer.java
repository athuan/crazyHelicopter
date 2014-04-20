package com.me.Helicopter.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.game.objects.Bomb;
import com.me.Helicopter.game.objects.Bullet;
import com.me.Helicopter.game.objects.Cannon;
import com.me.Helicopter.game.objects.Rocket;
import com.me.Helicopter.game.objects.Tank;

// no se chi chua SpriteBatch de ve ra man hinh va 1 cai worldControll
// sau do thuc hien ve ra man hinh sau khi da update moi thu

public class WorldRenderer {
	public SpriteBatch batch;		// co cai nay de dung de ve
	public WorldController worldController;
	
	
	public WorldRenderer(WorldController worldController ){
		this.worldController = worldController;			// gans bien cho no
		this.batch = new SpriteBatch();
	}
	
	public void render(){
		worldController.update();
		
		Gdx.gl10.glClear( GL10.GL_COLOR_BUFFER_BIT );	// xoa di bo dem
		Gdx.gl10.glClearColor(1, 1, 1, 0);
		
		batch.begin();
		
		//Assets.instance.backGround.draw(batch)	// load background

		worldController.helicopter.render(batch);
		for (Tank tank : worldController.tanks) {
			tank.render(batch);
		}
		
		for (Bullet bullet : worldController.bullets) {
			bullet.render(batch);
		}
		
		for (Bomb xBomb : worldController.bombs) {
			xBomb.render(batch);
		}
		
		//cannon and boom
		for (Cannon ca : worldController.cannons) {
			ca.render(batch);
		}
		for(Rocket rk : worldController.rockets1){
			rk.render(batch);
		}
		for(Rocket rk : worldController.rockets2){
			rk.render(batch);
		}
		
		
		batch.end();
		
	}

}
