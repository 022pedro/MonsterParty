package com.pedro022.monsterparty.screen;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.pedro022.monsterparty.Score;
import com.pedro022.monsterparty.TextureManager;
import com.pedro022.monsterparty.entity.Monster;

public class StartScreen extends Screen{
	private OrthographicCamera camera;
	private Score score;
	private int unit,x,y;  
	private Monster monster1,monster2,monster3,monster4;
	private int monsterpick,monstertouch;
	private Random r1,r2,r3;
	private Texture tablebotsheet,tabletopsheet,cakesheet,handprintsheet,mouthprintsheet,numberssheet;
	private TextureRegion tablebotparts[],tabletopparts[],cakeparts[],handprintparts[],mouthprintparts[],numbersparts[];
	private TextureRegion tablebot,tabletop,cake,handprint,mouthprint,number;
	private Boolean fine=false;
	private int timelight,timelightoff,changepartylogotime,finetime;
	private boolean cakeAttacked=false;
	private boolean light=true;
	private boolean changeparty=true;
	private int cakenumber;
	private int partynumber;
	private Boolean eat=false;
	
	public void create() {
		// TODO Auto-generated method stub
		camera=new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		partynumber=1;
		unit=Gdx.graphics.getWidth()/16;
		score=new Score();
		monster1=new Monster(1,1);
		monster2=new Monster(4,3);
		monster3=new Monster(9,3);
		monster4=new Monster(12,1);
		r1= new Random();
		r2= new Random();
		r3= new Random();
		monsterpick=r1.nextInt(4);
		monstertouch=5;
		timelight=200;
		timelightoff=50;
		changepartylogotime=80;
		finetime=200;
		cakenumber=0;
		System.out.println(monsterpick);
		
		tablebotsheet=TextureManager.tablebotSheet;
		tablebotparts= new TextureRegion[10];
		tabletopsheet=TextureManager.tabletopSheet;
		tabletopparts= new TextureRegion[10];
		cakesheet=TextureManager.cakeSheet;
		cakeparts= new TextureRegion[10];
		handprintsheet=TextureManager.handprintSheet;
		handprintparts= new TextureRegion[10];
		mouthprintsheet=TextureManager.mouthprintSheet;
		mouthprintparts= new TextureRegion[10];
		numberssheet=TextureManager.numbers;
		numbersparts= new TextureRegion[10];
		table();
		TextureRegion[][] regions = TextureRegion.split(cakesheet, 64, 64);
        int index=0;
        for(int i=0;i<10;i++){
        	 
        	cakeparts[index++]=regions[0][i];
        	 
        }
        TextureRegion[][] regions1 = TextureRegion.split(numberssheet, 16, 16);
        int index1=0;
        for(int i=0;i<10;i++){
        	
        	numbersparts[index1++]=regions1[0][i];
        	
        }
        cake=cakeparts[cakenumber];
		number=numbersparts[partynumber];
		
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	public void clues(){
		TextureRegion[][] regions = TextureRegion.split(handprintsheet, 16, 16);
        int index=0;
        for(int i=0;i<10;i++){
        	 
        	handprintparts[index++]=regions[0][i];
        	 
        }
        TextureRegion[][] regions1 = TextureRegion.split(mouthprintsheet, 32, 16);
        int index1=0;
        for(int i=0;i<10;i++){
        	
        	mouthprintparts[index1++]=regions1[0][i];
        	
        }
        r2=new Random();
        if(monsterpick==0){
        	handprint=handprintparts[monster1.getArmnumber()];
        	mouthprint=mouthprintparts[monster1.getHeadnumber()];
        }
        if(monsterpick==1){
        	handprint=handprintparts[monster2.getArmnumber()];
        	mouthprint=mouthprintparts[monster2.getHeadnumber()];
        }
        if(monsterpick==2){
        	handprint=handprintparts[monster3.getArmnumber()];
        	mouthprint=mouthprintparts[monster3.getHeadnumber()];
        }
        if(monsterpick==3){
        	handprint=handprintparts[monster4.getArmnumber()];
        	mouthprint=mouthprintparts[monster4.getHeadnumber()];
        }
		
		
	}
	public void table(){
		TextureRegion[][] regions = TextureRegion.split(tablebotsheet, 64, 32);
        int index=0;
        for(int i=0;i<10;i++){
        	 
        	tablebotparts[index++]=regions[0][i];
        	 
        }
        r2=new Random();
    	
    	tablebot=tablebotparts[r2.nextInt(10)];
    	
    	TextureRegion[][] regions1 = TextureRegion.split(tabletopsheet, 96, 32);
    	int index1=0;
    	for(int i=0;i<10;i++){
    		
    		tabletopparts[index1++]=regions1[0][i];
    		
    	}
    	r2=new Random();
    	
    	tabletop=tabletopparts[r2.nextInt(10)];
        
        
        
	}

	@Override
	public void render(SpriteBatch sb) {
		// TODO Auto-generated method stub
		sb.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		
		sb.begin();
		
		sb.draw(TextureManager.room1,0,-unit,unit*17,unit*17);
		
		
		
		monster2.render(sb);
		monster3.render(sb);
		monster1.render(sb);
		monster4.render(sb);
		sb.draw(tablebot,unit*6,0,unit*4,unit*2);
		sb.draw(tabletop,unit*5,unit*1,unit*6,unit*2);
		sb.draw(cake,unit*6,unit*1.5f,unit*4,unit*4);
		if(cakeAttacked==true){
		sb.draw(handprint,unit*7.2f,unit*2.7f,unit,unit);
		sb.draw(handprint,unit*7.5f,unit*2.6f,unit,unit);
		sb.draw(handprint,unit*7.9f,unit*2.5f,unit,unit);
	
		sb.draw(mouthprint,unit*7.0f,unit*2.5f,unit*2,unit);
		}
		monster2.renderhead(sb);
		monster3.renderhead(sb);
		monster1.renderhead(sb);
		monster4.renderhead(sb);
		score.render(sb);
		if(changeparty==true){
			sb.draw(TextureManager.back,0,0,unit*17,unit*17);
			sb.draw(TextureManager.title,unit*3,Gdx.graphics.getHeight()-unit*5,unit*10,unit*4);
			sb.draw(number,unit*7.5f,unit*3,unit*1,unit*1);
			
		}
		if(light==false){
		sb.draw(TextureManager.black,0,0,unit*17,unit*17);
		}
		sb.end();
		
		
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false,width,height);
		
		
        camera.update();
        monster1.resize();
        monster2.resize();
        monster3.resize();
        monster4.resize();
	        // centers the camera at 0, 0 (the center of the virtual viewport) 
        unit=Gdx.graphics.getWidth()/16;
	}
	public void reset(){
		if(partynumber==9){
			TextureManager.win=true;
			ScreenManager.setScreen(new EndGameScreen());
			
		}else{
		monster1=new Monster(1,1);
		monster2=new Monster(4,3);
		monster3=new Monster(9,3);
		monster4=new Monster(12,1);
		
		r1= new Random();
		if(partynumber<9){
			partynumber++;
		}
		number=numbersparts[partynumber];
	
		monsterpick=r1.nextInt(4);
		changeparty=true;
		
		if(cakenumber<9){
		cakenumber++;
		}
		cake=cakeparts[cakenumber];
		eat=false;
		
		}
	}
	
	@Override
	public void update() {
		if(changeparty==true){
			if(changepartylogotime>0){
				changepartylogotime-=Gdx.graphics.getDeltaTime();
			}else{
				changeparty=false;
				cakeAttacked=false;
				
				changepartylogotime=80;
			}
		}
		if(fine==false){
		TextureManager.Time+=Gdx.graphics.getDeltaTime();
		}
		System.out.println(timelight);
		//if(changeparty=false){
			if(light==false){
				if(timelightoff>0){
					timelightoff-=Gdx.graphics.getDeltaTime();
					if(eat==false){
						r3=new Random();
						if(r3.nextInt(6)==0)TextureManager.eat1.play(0.4f);
						if(r3.nextInt(6)==1)TextureManager.eat2.play(0.4f);
						if(r3.nextInt(6)==2)TextureManager.eat3.play(0.4f);
						if(r3.nextInt(6)==3)TextureManager.eat4.play(0.4f);
						if(r3.nextInt(6)==4)TextureManager.eat5.play(0.4f);
						if(r3.nextInt(6)==5)TextureManager.eat6.play(0.4f);
						eat=true;
					}
					
				}else{
					light=true;
					cakeAttacked=true;
					clues();
					timelightoff=50;
				}
				
			}
		//}
		if(cakeAttacked==false){
			if(light==true){
				if(timelight>0){
					timelight-=Gdx.graphics.getDeltaTime();
				}else{
					light=false;
					timelight=80;
				}
			}
		}
		x=Gdx.input.getX();
		
		y=Gdx.graphics.getHeight()-Gdx.input.getY();
		// TODO Auto-generated method stub
		camera.update();
		monster1.update();
		monster2.update();
		monster3.update();
		monster4.update();
		score.update();
		if(fine==true){
			if(finetime>0){
				finetime-=Gdx.graphics.getDeltaTime();
			}else{
				TextureManager.win=false;
				ScreenManager.setScreen(new EndGameScreen());
				
			}
		}
		if(Gdx.input.justTouched()){
			if(fine==false){
				if(cakeAttacked==true){
					if(x>unit&&x<unit*4){
						if(y>unit&&y<unit*6){
							monstertouch=0;
							if(monstertouch==monsterpick){
								reset();
								
							}else if(monstertouch!=monsterpick){
								monster1.setFine(true);
								fine=true;
							}
						}
					}
					if(x>unit*4&&x<unit*7){
						if(y>unit*3&&y<unit*8){
							monstertouch=1;
							if(monstertouch==monsterpick){
								reset();
							}else if(monstertouch!=monsterpick){
								monster2.setFine(true);
								fine=true;
							}
						}
					}
					if(x>unit*9&&x<unit*12){
						if(y>unit*3&&y<unit*8){
							monstertouch=2;
							if(monstertouch==monsterpick){
								reset();
							}else if(monstertouch!=monsterpick){
								monster3.setFine(true);
								fine=true;
							}
						}
					}
					if(x>unit*12&&x<unit*15){
						if(y>unit*1&&y<unit*6){
							monstertouch=3;
							if(monstertouch==monsterpick){
								reset();
							}else if(monstertouch!=monsterpick){
								monster4.setFine(true);
								fine=true;
							}
						}
					}
				}
			}
		}
		
		
		
	}

	

}
