package buttongame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class UnseenbuttonPress extends buttonPress
{	
	public UnseenbuttonPress() throws SlickException {
		super();
	}
	@Override
	public void addImage() throws SlickException {
		image=new Image("res/button3.png");
	} 
	@Override
	protected void drawImage(){
		if(seenButtonTime>20){
			image.draw(x,y);
		}
	}
	
}
