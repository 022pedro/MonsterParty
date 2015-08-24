package com.pedro022.monsterparty.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.pedro022.monsterparty.TextureManager;

public class HelpScreen extends Screen{
	private OrthographicCamera camera;
	
	private int unit,x,y; 
	
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		sb.begin();
		sb.draw(TextureManager.back,0,0,unit*17,unit*17);
		
		sb.draw(TextureManager.tutorial,unit*3,unit*3,unit*10,unit*6);
		sb.draw(TextureManager.backr,unit*7,unit*1,unit*2,unit*1);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		camera.setToOrtho(false,width,height);
		 camera.update();
		unit=Gdx.graphics.getWidth()/16;
	}

	@Override
	public void update() {
		
		x=Gdx.input.getX();
		System.out.println(TextureManager.Time);
		y=Gdx.graphics.getHeight()-Gdx.input.getY();
		camera.update();
		if(Gdx.input.justTouched()){
			if(x>7*unit&&x<9*unit){
				if(y>1*unit&&y<2*unit){
					ScreenManager.setScreen(new GameScreen());
					System.out.println();
				}
			}
		}
		
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		unit=Gdx.graphics.getWidth()/16;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
