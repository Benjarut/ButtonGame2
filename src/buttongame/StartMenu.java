package buttongame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class StartMenu extends BasicGameState{
//	public static final int GAME_WIDTH = 1000;
//	public static final int GAME_HEIGHT = 800;
	public Image background;
	private Image startButton;
	private Image logo;
	public Input input;
	private String bg = "res/colorful-triangles-background.jpg";
	int xpos,ypos;
	private boolean mousePress = false;
	
	public StartMenu(int state){
		
	}

	@Override
	public void render(GameContainer container,StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0, Button.GAME_WIDTH,Button.GAME_HEIGHT);
		startButton.draw(Button.GAME_WIDTH/2-76,600);
		logo.draw(275,200,500,150);
		
	}
	
	@Override
	public void init(GameContainer container,StateBasedGame sbg) throws SlickException {
		background = new Image(bg);
		startButton = new Image("res/startButton.png");
		logo = new Image("res/logo.png");
		
	}
	
	@Override
	public void update(GameContainer container,StateBasedGame sbg,int delta) throws SlickException {
		xpos = container.getInput().getMouseX();
		ypos = container.getInput().getMouseY();
		
		if (mousePress){
			enterGameState(sbg);
		}	
	}
	
	public void mousePressed(int button,int x,int y){
		if (xpos >= Button.GAME_WIDTH/2-76 && xpos <= Button.GAME_WIDTH/2 + 76 && ypos >= 600 && ypos <= 647){
			mousePress=true;
		}
	}
	private void enterGameState(StateBasedGame sbg) {
		sbg.enterState(1);
	}

	@Override
	public int getID() {
		return 0;
	}
	
}
