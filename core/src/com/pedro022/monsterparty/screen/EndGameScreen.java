package com.pedro022.monsterparty.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pedro022.monsterparty.TextureManager;

public class EndGameScreen extends Screen{
	private OrthographicCamera camera;
	
	private int unit,x,y; 
	private Texture numbers;

	private TextureRegion[] numberFrames;

	private String number;

	private char[] digits1;

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		sb.begin();
		sb.draw(TextureManager.back,0,0,unit*17,unit*17);
		if(TextureManager.win==false){
			sb.draw(TextureManager.lostphrase,unit*3,Gdx.graphics.getHeight()-unit*5,unit*10,unit*4);
		}
		if(TextureManager.win==true){
			sb.draw(TextureManager.winphrase,unit*3,Gdx.graphics.getHeight()-unit*5,unit*10,unit*4);
			for(int i =0;i<digits1.length;i++){
				for(int t=0;t<10;t++){
					if(digits1[i]==48+t)sb.draw(numberFrames[t],(unit*(8-digits1.length/2))+unit*i, unit*3,unit,unit);
					}	
		
			}
			
		}
		sb.draw(TextureManager.backr,unit*7,unit*1,unit*2,unit*1);
	
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false,width,height);
		 camera.update();
		unit=Gdx.graphics.getWidth()/16;
	}

	@Override
	public void update() {
		x=Gdx.input.getX();
		
		y=Gdx.graphics.getHeight()-Gdx.input.getY();
		camera.update();
		if(Gdx.input.justTouched()){
			if(x>7*unit&&x<9*unit){
				if(y>1*unit&&y<2*unit){
					TextureManager.Time=0;
					ScreenManager.setScreen(new GameScreen());
				}
			}
		}
	}

	@Override
	public void create() {
		camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		unit=Gdx.graphics.getWidth()/16;
		numberFrames = new TextureRegion[10];
		
		
		numbers=TextureManager.numbers;
		TextureRegion[][] temp=TextureRegion.split(numbers, 16,16);
		int index=0;
		for(int i=0;i<10;i++){
			numberFrames[index++]=temp[0][i];
		}
		number = String.valueOf((int)Math.round(TextureManager.Time));
		digits1 = number.toCharArray();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

}
