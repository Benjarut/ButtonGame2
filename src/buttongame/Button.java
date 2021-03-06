package buttongame;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Button extends StateBasedGame{
	public static final int GAME_WIDTH = 1000;
	public static final int GAME_HEIGHT = 800;
	public static final String name = "Button Game";
	
	public static int menu = 0;
	public static int mainGame = 1;
	public static int endGame = 2;
	public static int credit = 3;

	public Button(String name) throws SlickException {
		super(name);
		
		this.addState(new StartMenu(menu));
		this.addState(new MainGame(mainGame));
		this.addState(new EndGame(endGame));
		this.addState(new Credit());
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(menu).init(container, this);
		this.getState(mainGame).init(container, this);
		this.getState(endGame).init(container, this);
		this.getState(credit).init(container, this);
		this.enterState(menu);
	}

	public static void main(String[] args){
		try {
		      AppGameContainer container = new AppGameContainer(new Button(name));
		      container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		      container.setMinimumLogicUpdateInterval(1000/60);
		      container.setShowFPS(false);
		      container.setIcon("res/buttonIcon.png");
		      container.start();
		 } catch (SlickException e) {
		      e.printStackTrace();
		 }
		System.out.println(GL11.glGetInteger(GL11.GL_MAX_TEXTURE_SIZE));

	}

	
}
