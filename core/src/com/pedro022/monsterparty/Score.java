package com.pedro022.monsterparty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Score {

	private Texture numbers;
	private Texture scoreTexture;
	private Texture distanceTexture;

	TextureRegion numberFrames[];

	int highScore;
	String number;
	String numberHS;
	String numberDist;
	char[] digits1;
	char[] digits2;
	char[] digits3;
	boolean gameOver=false;


	
	int numbersX;
	int numbersY;
	private int unit;
	
	
	public Score(){
		unit=Gdx.graphics.getWidth()/16;
	
		 numbersX=0;
		 numbersY=Gdx.graphics.getHeight()-unit;
		
		numberFrames = new TextureRegion[10];
		
	
		numbers=TextureManager.numbers;
		
		TextureRegion[][] temp=TextureRegion.split(numbers, 16,16);
		int index=0;
		for(int i=0;i<10;i++){
			numberFrames[index++]=temp[0][i];
		}
		number = String.valueOf(TextureManager.Time);
		digits1 = number.toCharArray();
		
		
	}
	public void update() {
		
		number = String.valueOf((int)Math.round(TextureManager.Time));
		digits1 = number.toCharArray();
	
	}
	public void render(SpriteBatch sb){
			
			
		
		
			for(int i =0;i<digits1.length;i++){
				for(int t=0;t<10;t++){
					if(digits1[i]==48+t)sb.draw(numberFrames[t],unit*i, numbersY-16,unit,unit);
					}	
		
			}
		
		
			
	}
	public void resize(){
		
		unit=Gdx.graphics.getWidth()/16;
		
		
	}
		
	
		
		
	

}