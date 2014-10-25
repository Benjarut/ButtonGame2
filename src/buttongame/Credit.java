package buttongame;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Credit extends BasicGameState{
	public Image background;
	public Image back;
	public Image creditLogo;
	public Input input;
	private boolean mousePress = false;
	private int backWidth = 106;
	private int backHeight = 39;
	private int creditLogoWidth = 309;
	private String bg = "res/picturesque-bokeh-background.jpg";
	private int xpos,ypos;
	
	Font font;
	TrueTypeFont ttf;
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg)	throws SlickException {
		background = new Image(bg);
		creditLogo = new Image("res/creditLogo.png");
		back = new Image("res/back.png");
		setFontText();
	}
	
	private void setFontText() {
		font = new Font("Segoe Script",Font.BOLD,30);
		ttf = new TrueTypeFont(font, true);
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)	throws SlickException {
		background.draw(0,0,Button.GAME_WIDTH,Button.GAME_HEIGHT);
		creditLogo.draw(Button.GAME_WIDTH/2-creditLogoWidth/2,150);
		ttf.drawString(Button.GAME_WIDTH/2, 400, "Credit by Cin ^U^~ ");
		back.draw(Button.GAME_WIDTH/2-backWidth/2, Button.GAME_HEIGHT-200);
		
	}

	public void mousePressed(int button,int x,int y){
		
		if(xpos >= Button.GAME_WIDTH/2-backWidth/2 && xpos <= Button.GAME_WIDTH/2+backWidth/2 ){
			if(ypos >= Button.GAME_HEIGHT-200 && ypos <= Button.GAME_HEIGHT-200+backHeight){
				mousePress = true;
			}
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)	throws SlickException {
		xpos = container.getInput().getMouseX();
		ypos = container.getInput().getMouseY();
		if(mousePress){
			enterMenuState(sbg);
			mousePress =false;
			StartMenu.mousePress = 0;
		}	
	}

	private void enterMenuState(StateBasedGame sbg) {
		sbg.enterState(0);
		
	}

	@Override
	public int getID() {
		return 3;
	}

}
