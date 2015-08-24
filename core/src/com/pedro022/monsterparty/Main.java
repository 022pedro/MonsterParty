package com.pedro022.monsterparty;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pedro022.monsterparty.screen.GameScreen;
import com.pedro022.monsterparty.screen.ScreenManager;
import com.pedro022.monsterparty.screen.StartScreen;


public class Main extends Game {
	SpriteBatch batch;
	
	
	@Override
	public void create () {
		
			
			batch = new SpriteBatch();
			ScreenManager.setScreen( new GameScreen());
			
			}
		public void dispose(){
			if(ScreenManager.getCurrentScreen()!=null){
				ScreenManager.getCurrentScreen().dispose();
			}
			batch.dispose();
		}

		@Override
		public void render () {
			Gdx.gl.glClearColor(0, 0, 0, 0);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			
		
			if(ScreenManager.getCurrentScreen()!=null){
				ScreenManager.getCurrentScreen().update();
			}
			if(ScreenManager.getCurrentScreen()!=null){
				ScreenManager.getCurrentScreen().render(batch);
				
			}
		
			
		}
		public  void resize(int width,int height){
			if(ScreenManager.getCurrentScreen()!=null){
			
		
			ScreenManager.getCurrentScreen().resize(width,height);
			}
		}
		public void pause(){
			
			
		}
		public void resume(){
			
			
		}
}
		
		