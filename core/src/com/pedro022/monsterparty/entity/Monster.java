package com.pedro022.monsterparty.entity;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pedro022.monsterparty.TextureManager;

public class Monster {
	int posx,posy;
	Texture armsheet,hairsheet,bodysheet,feetsheet,headsheet;
	int headnumber,hairnumber,bodynumber,armnumber,feetnumber;
	TextureRegion body,arm,hair,head,feet;
	TextureRegion bodyparts[],armparts[],hairparts[],headparts[],feetparts[];
	int unit,change,change2,down,down2,change3;
	boolean fine=false;
	Random r1,r2,r3,r4;
	private boolean high,mad;
	private int grow;
	private int sound;
	public Monster(int posx, int posy){
		high=true;
		mad=false;
		this.posx=posx;
		this.posy=posy;
		headsheet=TextureManager.headSheet;
		hairsheet=TextureManager.hairSheet;
		armsheet=TextureManager.armSheet;
		feetsheet=TextureManager.feetSheet;
		bodysheet=TextureManager.bodySheet;
		bodyparts= new TextureRegion[100];
		armparts= new TextureRegion[10];
		hairparts= new TextureRegion[10];
		headparts= new TextureRegion[10];
		feetparts= new TextureRegion[10];
		r3=new Random();
	    sound=10+r3.nextInt(5)*5;
        unit=Gdx.graphics.getWidth()/16;
        grow=0;
        TextureRegion[][] regions = TextureRegion.split(bodysheet, 48, 48);
        int index=0;
        for(int i=0;i<10;i++){
        	 for(int t=0;t<10;t++){
        	bodyparts[index++]=regions[i][t];
        	 }
        }
        TextureRegion[][] regions1 = TextureRegion.split(armsheet, 16, 32);
        int index1=0;
        for(int i=0;i<10;i++){
        
        		armparts[index1++]=regions1[0][i];
        	
        }
        TextureRegion[][] regions2 = TextureRegion.split(hairsheet, 32, 16);
        int index2=0;
        for(int i=0;i<10;i++){
        	
        	hairparts[index2++]=regions2[0][i];
        	
        }
        TextureRegion[][] regions3 = TextureRegion.split(headsheet, 48, 32);
        int index3=0;
        for(int i=0;i<10;i++){
        	
        	headparts[index3++]=regions3[0][i];
        	
        }
        TextureRegion[][] regions4 = TextureRegion.split(feetsheet, 48, 16);
        int index4=0;
        for(int i=0;i<10;i++){
        	
        	feetparts[index4++]=regions4[0][i];
        	
        }
    	r1=new Random();
    	r2=new Random();
    	
    	r4=new Random();
    	bodynumber=r3.nextInt(100);
    	body=bodyparts[bodynumber];
    	r3=new Random();
    	armnumber=r3.nextInt(10);
    	arm=armparts[armnumber];
    	r3=new Random();
    	hairnumber=r3.nextInt(10);
    	hair=hairparts[hairnumber];
    	r3=new Random();
    	headnumber=r3.nextInt(10);
    	head=headparts[headnumber];
    	r3=new Random();
    	feetnumber=r3.nextInt(10);
    	feet=feetparts[feetnumber];
		down=30;
		down2=40;
		
		
	}
	public int getHeadnumber() {
		return headnumber;
	}
	public void setHeadnumber(int headnumber) {
		this.headnumber = headnumber;
	}
	public void update(){
		if(down>0){
			down-=Gdx.graphics.getDeltaTime();
		}else{
			change=r1.nextInt(2)*3;
			down=30;
		}
		if(down2>0){
			down2-=Gdx.graphics.getDeltaTime();
		}else{
			change2=r2.nextInt(2)*4;
			change3=r1.nextInt(3)*3;
			down2=40;
		}
		if(fine==true){
			if(grow<8*unit){
				grow+=20;
			}
		}
		if(sound>0){
			sound-=Gdx.graphics.getDeltaTime();
		}else{
			r4=new Random();
		if(r4.nextInt(9)==0)TextureManager.cake1.play(0.02f);
		if(r4.nextInt(9)==1)TextureManager.cake2.play(0.02f);
		if(r4.nextInt(9)==2)TextureManager.cake3.play(0.02f);
		if(r4.nextInt(9)==3)TextureManager.monster1.play(0.02f);
		if(r4.nextInt(9)==4)TextureManager.monster2.play(0.02f);
		if(r4.nextInt(9)==5)TextureManager.party1.play(0.02f);
		if(r4.nextInt(9)==6)TextureManager.party2.play(0.02f);
		if(r4.nextInt(9)==7)TextureManager.party3.play(0.02f);
		if(r4.nextInt(9)==8)TextureManager.party4.play(0.02f);
		r3=new Random();
	    sound=40+r3.nextInt(5)*15;
	   
	    	
	    
		}
		 if(fine==true){
			 if(mad==false){
				 TextureManager.mad1.play(0.5f);
				 mad=true;
			 }
			 
		 }
		
	}
	public boolean isFine() {
		return fine;
	}
	public void setFine(boolean fine) {
		this.fine = fine;
	}
	public int getArmnumber() {
		return armnumber;
	}
	public void setArmnumber(int armnumber) {
		this.armnumber = armnumber;
	}
	public void render(SpriteBatch sb){
		sb.draw(TextureManager.shadow,posx*unit,(posy-0.5f)*unit+change,unit*3,unit*2);
		
		sb.draw(feet,posx*unit,posy*unit+change3,unit*3,unit*1);
		sb.draw(body,posx*unit,(posy+0.2f)*unit+change,unit*3,unit*3);
		sb.draw(arm,posx*unit+change,posy*unit+unit*0.5f+change,unit,unit*2);
		sb.draw(arm,posx*unit+unit*2+change,posy*unit+unit*0.5f+change,unit,unit*2);
		if(fine==false){
			sb.draw(head,posx*unit,posy*unit+unit*2.2f+change2,unit*3+grow,unit*2+grow);
			sb.draw(hair,posx*unit,posy*unit+unit*3.7f+change2,unit*3+grow,unit+grow);
		}
		
		
		
		
	}
	public void renderhead(SpriteBatch sb){
		if(fine==true){
		sb.draw(head,Gdx.graphics.getWidth()/2-(unit*1.5f+(grow/2)),Gdx.graphics.getHeight()/2-(unit+(grow/2)+change2),unit*3+grow,unit*2+grow);
		sb.draw(hair,Gdx.graphics.getWidth()/2-grow/2-unit+3,Gdx.graphics.getHeight()/2+change2,unit*3+grow,unit+grow);
		}
	}
	public void resize(){
		
		unit=Gdx.graphics.getWidth()/16;
		
		
	}
	
}
