package buttongame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
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
	
	Music music;
	Sound click;
//	private buttonPress buttonPress;
//	private MovebuttonPress movebuttonPress;
	
	private buttonPress[] buttons;
	private BonusButton bonusButton;
	private ArrayList<Entity> entities;
	private int button_count=4;
	
	private String bg="res/background2.jpg";
	private int xpos,ypos;
	private int count=6;
	public static double time=60;
	public static int score=0;
	Font font;
	TrueTypeFont ttf;
	
	public MainGame(int state){
		entities= new ArrayList<Entity>();
	}
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		background=new Image(bg);
		bonusButton=new BonusButton();
		click=new Sound("res/click.wav");
		music=new Music("res/DesiJourney.wav");
		music.play();
		music.loop();

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
			else if(i==1){
				button=new UnseenbuttonPress();
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
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		background.draw(0,0,GAME_WIDTH,GAME_HEIGHT);
		ttf.drawString(600, 10, "SCORE : "+score);
		ttf.drawString(300, 10, "TIME : "+(int) time);
		if(count>0 && time%10>=7){
			bonusButton.draw(g);
		}
		for(Entity entity : entities){	
			entity.draw(g);
		}
	}
	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
		xpos=container.getInput().getMouseX();
		ypos=container.getInput().getMouseY();
		bonusButton.update(delta);
		updateEntities(delta);
		
		if(time > 0){
			time-=delta*1/1000f;
			if(time%10==0){
				count-=1;
			}
		}
		else{
			time=0;	
		}
		if(time==0){
			enterEndState(sbg);
		}	
	}
	private void enterEndState(StateBasedGame sbg) {
		sbg.enterState(2);
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
		click.play();
		int i;
		i=Checkhit();
		if(i<3){
			score+=1;
			if(buttons[i].getOvalHeight()>=buttonPress.getHeight() && buttons[i].getOvalHeight()<=buttonPress.getHeight()+5){
				score+=4;
			}
			buttons[i].resetOval();
		}
		if(hitBonus()){
			score+=20;
			bonusButton.resetOval();
		}
	}
	private boolean hitBonus() {
		if(xpos>=bonusButton.getX() && xpos<=bonusButton.getX()+BonusButton.getWidth() && ypos >=bonusButton.getY() && ypos <= bonusButton.getY()+BonusButton.getHeight()){
			return true;
		}
		return false;
	}
	public int Checkhit(){
		int i;
		for(i=0;i<button_count;i++){
			if(xpos>=buttons[i].getX() && xpos<=buttons[i].getX()+buttonPress.getWidth() && ypos >=buttons[i].getY() && ypos <= buttons[i].getY()+buttonPress.getWidth()){
				return i;
			}
			
		}
		return 3;
	}
	public static int getScore(){
		return score;
	}
}
