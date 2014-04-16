package com.me.Helicopter;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;


public class Main {
	public static boolean rebuild = false;
	public static boolean debug 	= true;
	public static void main(String[] args) {
		
		// day la phan tao ra file trong pack
		// neu ko muon tao lai va ko muon debug thi cho no la false het

		if(rebuild){
			Settings settings = new Settings();
			settings.debug =  debug;
			settings.maxHeight = 1024;
			settings.maxWidth = 2048;
			
			TexturePacker2.process(settings, "assets-raw", "../crazyHelicopter-android/assets/pack", "myImages");
			
		}	
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "crazyHelicopter";
		cfg.useGL20 = false;
		cfg.width = 1024;
		cfg.height = 768;
		
		new LwjglApplication(new MainGame(), cfg);
	}
}
