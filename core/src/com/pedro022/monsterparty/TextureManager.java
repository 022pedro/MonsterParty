package com.pedro022.monsterparty;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {

	
	
	public static Texture room1 =new Texture(Gdx.files.internal("parts/room.png"));
	public static Texture back=new Texture(Gdx.files.internal("parts/startback.png"));
	public static Texture backr=new Texture(Gdx.files.internal("parts/back.png"));
	public static Texture title =new Texture(Gdx.files.internal("parts/title.png"));
	public static Texture tutorial =new Texture(Gdx.files.internal("parts/tutorial.png"));
	public static Texture winphrase =new Texture(Gdx.files.internal("parts/winphrase.png"));
	public static Texture lostphrase =new Texture(Gdx.files.internal("parts/lostphrase.png"));
	public static Texture black =new Texture(Gdx.files.internal("parts/black.png"));
	public static Texture help =new Texture(Gdx.files.internal("parts/help.png"));
	public static Texture start =new Texture(Gdx.files.internal("parts/start.png"));
	public static Texture shadow =new Texture(Gdx.files.internal("parts/shadow.png"));
	public static Texture highlight =new Texture(Gdx.files.internal("parts/highligth.png"));

	public static Texture feet1 =new Texture(Gdx.files.internal("parts/feet1.png"));
	public static Texture bodySheet =new Texture(Gdx.files.internal("parts/bodysheet.png"));
	public static Texture armSheet =new Texture(Gdx.files.internal("parts/armsheet.png"));
	public static Texture hairSheet =new Texture(Gdx.files.internal("parts/hairsheet.png"));
	public static Texture headSheet =new Texture(Gdx.files.internal("parts/headsheet.png"));
	public static Texture feetSheet =new Texture(Gdx.files.internal("parts/feetsheet.png"));
	public static Texture tablebotSheet =new Texture(Gdx.files.internal("parts/tablebotsheet.png"));
	public static Texture tabletopSheet =new Texture(Gdx.files.internal("parts/tabletopsheet.png"));
	public static Texture cakeSheet =new Texture(Gdx.files.internal("parts/cakesheet.png"));
	public static Texture handprintSheet =new Texture(Gdx.files.internal("parts/handprintsheet.png"));
	public static Texture mouthprintSheet =new Texture(Gdx.files.internal("parts/mouthprintsheet.png"));
	public static Texture numbers=new Texture(Gdx.files.internal("parts/numbers.png"));
	
	
	public static Sound cake1=Gdx.audio.newSound(Gdx.files.internal("sounds/cake1.ogg"));
	public static Sound cake2=Gdx.audio.newSound(Gdx.files.internal("sounds/cake2.ogg"));
	public static Sound cake3=Gdx.audio.newSound(Gdx.files.internal("sounds/cake3.ogg"));
	public static Sound eat1=Gdx.audio.newSound(Gdx.files.internal("sounds/eat1.ogg"));
	public static Sound eat2=Gdx.audio.newSound(Gdx.files.internal("sounds/eat2.ogg"));
	public static Sound eat3=Gdx.audio.newSound(Gdx.files.internal("sounds/eat3.ogg"));
	public static Sound eat4=Gdx.audio.newSound(Gdx.files.internal("sounds/eat4.ogg"));
	public static Sound eat5=Gdx.audio.newSound(Gdx.files.internal("sounds/eat5.ogg"));
	public static Sound eat6=Gdx.audio.newSound(Gdx.files.internal("sounds/eat6.ogg"));
	public static Sound mad1=Gdx.audio.newSound(Gdx.files.internal("sounds/mad1.ogg"));
	public static Sound mad2=Gdx.audio.newSound(Gdx.files.internal("sounds/mad2.ogg"));

	public static Sound monster1=Gdx.audio.newSound(Gdx.files.internal("sounds/monster1.ogg"));
	public static Sound monster2=Gdx.audio.newSound(Gdx.files.internal("sounds/monster2.ogg"));
	public static Sound party1=Gdx.audio.newSound(Gdx.files.internal("sounds/party.ogg"));
	public static Sound party2=Gdx.audio.newSound(Gdx.files.internal("sounds/party2.ogg"));
	public static Sound party3=Gdx.audio.newSound(Gdx.files.internal("sounds/party3.ogg"));
	public static Sound party4=Gdx.audio.newSound(Gdx.files.internal("sounds/party4.ogg"));
	
	public static float Time=0;
	public static boolean win;
}
