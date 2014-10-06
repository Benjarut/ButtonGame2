package buttongame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BonusButton extends buttonPress{
	private static final int width=76;
	private static final int height=53;
	public BonusButton() throws SlickException {
		super();
	}
	public void addImage() throws SlickException {
		image = new Image("res/bonusButton.png");
	} 
	
	public static int getWidth(){
		return width;
	}
	public static int getHeight(){
		return height;
	}

}
