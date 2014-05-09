package com.me.Helicopter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.Helicopter.MainGame;
import com.me.Helicopter.Screens.MenuScreen;
import com.me.Helicopter.game.objects.Bomb;
import com.me.Helicopter.game.objects.Bullet;
import com.me.Helicopter.game.objects.Burn;
import com.me.Helicopter.game.objects.Cannon;
import com.me.Helicopter.game.objects.Rocket;
import com.me.Helicopter.game.objects.Tank;

// no se chi chua SpriteBatch de ve ra man hinh va 1 cai worldControll
// sau do thuc hien ve ra man hinh sau khi da update moi thu

public class WorldRenderer {
	final MainGame game;

	public WorldController worldController;
	// thu ve xem the nao
	
	//Animation birdAni;
	//TextureRegion currentFrame;
	//float time;
	
	public WorldRenderer(WorldController worldController, final MainGame g) {
		this.game = g;
		this.worldController = worldController; // gans bien cho no
		
		
		//
		//birdAni = Assets.instance.birdAnimation;
		//time= 0.0f;
		

	}

	public void render() {
		worldController.update();

		Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT); // xoa di bo dem
		Gdx.gl10.glClearColor(1, 1, 1, 0);

		// check dieu kien tam dung cua game

		if (!worldController.helicopter.isLive()) {
			// khi do moi thu se duoc giai phong
			game.setScreen(new MenuScreen(game));
			
		} else {
			game.batch.begin();
			
			//
			// thu ve con chim xem nao
			//time += Gdx.graphics.getDeltaTime();
			//currentFrame = birdAni.getKeyFrame(time, true);	
			// ve
			//game.batch.draw(currentFrame, 100,100);
			
			
			
			//
			worldController.helicopter.render(game.batch);
			worldController.bird.render(game.batch);
			worldController.helper.render(game.batch);
			// in ra cai button
			worldController.buttonFire.draw(game.batch);
			worldController.buttonHelper.draw(game.batch);
			
			for (Tank tank : worldController.tanks) {
				tank.render(game.batch);
			}

			for (Bullet bullet : worldController.bullets) {
				bullet.render(game.batch);
			}

			for (Bomb xBomb : worldController.bombs) {
				xBomb.render(game.batch);
			}

			// cannon and boom
			for (Cannon ca : worldController.cannons) {
				ca.render(game.batch);
			}
			for (Rocket rk : worldController.rockets1) {
				rk.render(game.batch);
			}
			for (Rocket rk : worldController.rockets2) {
				rk.render(game.batch);
			}
			for (Burn bu : worldController.burns) {
				bu.render(game.batch);
			}

			game.batch.end();
		}
	}

}