package com.me.Helicopter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.Helicopter.Screens.MenuScreen;
import com.me.Helicopter.game.Assets;


public class MainGame extends Game{
	// tao ra 2 bien de dung chung cho ca game
	
	public SpriteBatch batch;	// bien dung de ve moi thu
	public BitmapFont font;		// bien dung de viet chu ra man hinh
								// dung de viet ra mau, diem, mang con lai
	
	
	@Override
	public void create() {
		// khoi tao ra tui no
		batch = new SpriteBatch();		// khoi tao cho batch
		font = new BitmapFont();		// khoi tao font
		
		// set cai man hinh dau tien cua game
		// tam thoi la cai man hinh  chinh cua game
		MenuScreen menu = new MenuScreen(this);
		this.setScreen(menu);	// chu y thong so dau vao cua no la chinh cai MainGame nay
		menu=null;
		// de lay 2 bien ra dung cho ca game ma ko can phai tao cai moi
		
	}
	


	@Override
	public void render() {
		super.render();					// very imfortant :)
	}

	@Override
	public void dispose() {
		
		
		batch.dispose();		// huy di khi khong dung nua
		font.dispose();			// huy font chu khi ko dung nua
		
	}
}