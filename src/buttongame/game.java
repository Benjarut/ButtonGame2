package buttongame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class game {
	private Image image;
	
	public game() throws SlickException{
		image=new Image("res/background2.jpg");
	}
	public void  render() {
		image.draw(0,0);
	}
	public void update(){
		
	}

}
