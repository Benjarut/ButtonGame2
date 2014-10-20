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

public class EndGame extends BasicGameState{
//	public static final int GAME_WIDTH = 1000;
//	public static final int GAME_HEIGHT = 800;
	public Image background;
	public Image replay;
	public Image timeup;
	public Input input;
	private boolean mousePress = false;
	Font font;
	TrueTypeFont ttf;
	private int replayWidth = 207;
	private int replayHeight = 33;
	private int timeupWidth = 374;
	private String bg = "res/Endbackground.jpg";
	private int xpos,ypos;

	public EndGame(int endgame) {
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		background = new Image(bg);
		replay = new Image("res/replay.png");
		timeup = new Image("res/Time-up.png");
		setFontText();
	}

	private void setFontText() {
		font = new Font("Times New Roman",Font.BOLD,28);
		ttf = new TrueTypeFont(font, true);
	}
	
	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0,Button.GAME_WIDTH,Button.GAME_HEIGHT);
		ttf.drawString(600, 320, "SCORE : "+MainGame.getScore());
		replay.draw(Button.GAME_WIDTH/2-replayWidth/2,Button.GAME_HEIGHT/2+100);
		timeup.draw(Button.GAME_WIDTH/2-timeupWidth/2,200);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		xpos = container.getInput().getMouseX();
		ypos = container.getInput().getMouseY();
		if(mousePress){
			enterGameState(sbg);
		}
	}
	
	private void enterGameState(StateBasedGame sbg) {
		MainGame.score = 0;
		MainGame.time = 60;
		sbg.enterState(1);
		
	}

	public void mousePressed(int button,int x,int y){
		
		if(xpos >= Button.GAME_WIDTH/2-replayWidth/2 && xpos <= Button.GAME_WIDTH/2+replayWidth/2 ){
			if(ypos >= Button.GAME_HEIGHT/2+100 && ypos <= Button.GAME_HEIGHT/2+100+replayHeight){
				mousePress = true;
			}
		}
	}
	
	@Override
	public int getID() {
		return 2;
	}

}
