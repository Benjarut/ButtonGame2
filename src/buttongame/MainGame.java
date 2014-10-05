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
import java.util.ArrayList;

public class MainGame extends BasicGameState {
	public static final int GAME_WIDTH=1000;
	public static final int GAME_HEIGHT=800;
	public Image background;
	public Input input;
//	private buttonPress buttonPress;
//	private MovebuttonPress movebuttonPress;
	
	private buttonPress[] buttons;
	private ArrayList<Entity> entities;
	
	private String bg="res/background2.jpg";
	private int xpos,ypos;
	private int score=0;
	private int button_count=3;
	private double time=60;
	
	Font font;
	TrueTypeFont ttf;
	
	public MainGame(int state){
		entities= new ArrayList<Entity>();
	}
	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		background=new Image(bg);
//		buttonPress=new buttonPress();
//		movebuttonPress=new MovebuttonPress();
		initButtons();
		setFontText();
	}
	private void initButtons() throws SlickException {
		buttons=new buttonPress[button_count];
		
		for(int i=0;i<button_count;i++){
			buttonPress button;
			if(i==0){
				button =new MovebuttonPress();
			}
			else
				button=new buttonPress();
			buttons[i]= button;
			entities.add(button);
		}
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
		ttf.drawString(300, 10, "TIME : "+(int) time);
//		buttonPress.draw(g);
//		if(time<=59.5){
//			movebuttonPress.draw(g);
//		}
		for(Entity entity : entities){
			entity.draw(g);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		xpos=container.getInput().getMouseX();
		ypos=container.getInput().getMouseY();
	
		updateEntities(delta);
		if(time > 0){
		//	time-=1.00/100;
			time-=delta*1/1000f;
		}
		else{
			time=0;
		}
//		buttonPress.update();
//		if(time<=59.5){
//			movebuttonPress.update();
//		}
//		for(buttonPress buttonPress:buttons){
//			buttonPress.update();
//		}
		
	}
	private void updateEntities(int delta){
		for(Entity entity:entities){
			entity.update(delta);
		}
	}

	@Override
	public int getID() {
		return 1;
	}
	
	public void mousePressed(int button,int x,int y){
		int i;
		i=Checkhit();
		if(i<3){
			score+=1;
			if(buttons[i].getOvalHeight()>=buttongame.buttonPress.getHeight() && buttons[i].getOvalHeight()<=buttongame.buttonPress.getHeight()+5){
				score+=4;
			}
			buttons[i].resetOval();
		}
	}
	public int Checkhit(){
		int i;
		for(i=0;i<button_count;i++){
			if(xpos>=buttons[i].getX() && xpos<=buttons[i].getX()+buttongame.buttonPress.getWidth() && ypos >=buttons[i].getY() && ypos <= buttons[i].getY()+buttongame.buttonPress.getWidth()){
				return i;
			}
			
		}
		return 3;
	}
}
