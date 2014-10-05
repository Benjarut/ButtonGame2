package buttongame;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MovebuttonPress extends buttonPress{
	Random random=new Random();
	public MovebuttonPress() throws SlickException {
		super();
	}
	public void addImage() throws SlickException {
		image=new Image("res/button2.png");
	} 
	@Override
	public void updateMovement(){	
		if(seenButtonTime<defsize/2){
//		if(x>MainGame.GAME_WIDTH-buttonPress.getWidth() || y>MainGame.GAME_HEIGHT-buttonPress.getHeight()){
			randomPosition();
			seenButtonTime=30;
		}
	}
}
