package buttongame;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Button extends StateBasedGame{
	public static final int GAME_WIDTH=1000;
	public static final int GAME_HEIGHT=800;
	public static final String name="Button Game";
	
	public static int menu=0;
	public static int mainGame=1;
	public static int credits=2;
	public static int endgame=3;

	public Button(String name) throws SlickException {
		super(name);
		
		this.addState(new StartMenu(menu));
		this.addState(new MainGame(mainGame));
//		this.addState(new Credits(credits));
//		this.addState(new Endgame(endgame));
	
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(menu).init(container, this);
		this.getState(mainGame).init(container, this);
//		this.getState(credits).init(container, this);
//		this.getState(endgame).init(container, this);
		this.enterState(menu);
	}
	public static void main(String[] args){
		try {
		      AppGameContainer container = new AppGameContainer(new Button(name));
		      container.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		      container.setMinimumLogicUpdateInterval(1000/60);
		      container.start();
		 } catch (SlickException e) {
		      e.printStackTrace();
		 }
		System.out.println(GL11.glGetInteger(GL11.GL_MAX_TEXTURE_SIZE));

	}

	
}
