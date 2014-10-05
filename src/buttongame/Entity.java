package buttongame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Entity {
	void draw(Graphics g);
	void update(int delta);
	void addImage() throws SlickException;
	void drawImage();
	
}
