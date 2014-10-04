package buttongame;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.awt.Font;

public class MainGame extends BasicGameState {
	public static final int GAME_WIDTH=1000;
	public static final int GAME_HEIGHT=800;
	public Image background;
	public Input input;
	
	private buttonPress buttonPress;
	private String bg="res/background2.jpg";
	int xpos,ypos;
	
	private double time=60;
	private int score=0;
	Font font;
	TrueTypeFont ttf;
	public MainGame(int state){
		
	}
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background=new Image(bg);
		buttonPress=new buttonPress();
		setFontText();
	}

	private void setFontText() {
		font =new Font("Verdana",Font.BOLD,14);
		ttf=new TrueTypeFont(font, true);
	}
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.magenta);
		background.draw(0,0,GAME_WIDTH,GAME_HEIGHT);
		ttf.drawString(600, 10, "SCORE : "+score);
		ttf.drawString(300, 10, "TIME : "+time);
		buttonPress.draw(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		xpos=container.getInput().getMouseX();
		ypos=container.getInput().getMouseY();
	
		if(time > 0){
			time-=1.00/1000;
		}
		else{
			time=0;
		}
		
		buttonPress.update();
	}

	@Override
	public int getID() {
		return 1;
	}
	
	public void mousePressed(int button,int x,int y){
		if(Checkhit()){
			score+=1;
			if(buttonPress.getOvalHeight()>=buttongame.buttonPress.getHeight() && buttonPress.getOvalHeight()<=buttongame.buttonPress.getHeight()+5){
				score+=2;
			}
			buttonPress.resetOval();
		}
	}
	public boolean Checkhit(){
		if(xpos>=buttonPress.getX() && xpos<=buttonPress.getX()+buttongame.buttonPress.getWidth() && ypos >=buttonPress.getY() && ypos <= buttonPress.getY()+buttongame.buttonPress.getWidth()){
			return true;
		}
		else{
			return false;
		}
	}
}
