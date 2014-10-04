package buttongame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class StartMenu extends BasicGameState{
	public static final int GAME_WIDTH=1000;
	public static final int GAME_HEIGHT=800;
	public Image background;
	private Image startButton;
	private Image logo;
	public Input input;
	private String bg="res/colorful-triangles-background.jpg";
	int xpos,ypos;
	
	
//	private double time=60;
//	private int score=0;
	private boolean mousePress=false;
	private buttonPress buttonPress;
	private boolean isMouseClick=false;
	//private String position="";
	
	public StartMenu(int state){
		
	}

	@Override
	public void render(GameContainer container,StateBasedGame game, Graphics g) throws SlickException {
		background.draw(0,0, GAME_WIDTH,GAME_HEIGHT);
		if(!isMouseClick){
			startButton.draw(GAME_WIDTH/2-76,600);
			logo.draw(275,200,500,150);
		}else{
//			g.drawString("SCORE : "+score, 600, 10);
//			g.drawString("TIME : "+time, 300, 10);
//			buttonPress.draw(container,g);
		}
		
	}
	
	@Override
	public void init(GameContainer container,StateBasedGame game) throws SlickException {
		background=new Image(bg);
		startButton=new Image("res/startButton.png");
		logo =new Image("res/logo.png");
		buttonPress=new buttonPress();
		
	}
	
	@Override
	public void update(GameContainer container,StateBasedGame game,int delta) throws SlickException {
		xpos=container.getInput().getMouseX();
		ypos=container.getInput().getMouseY();
		
		if(mousePress){
			enterGameState(game);
		}
//		if(isMouseClick==true){
//			if(time > 0){
//				time-=1.00/1000;
//			}
//			else{
//				time=0;
//			}
//		}
//		
//		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
//			isMouseClick=true;
//		}
		
	}
	
	public void mousePressed(int button,int x,int y){
		//if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
		if(xpos>=GAME_WIDTH/2-76 && xpos<=GAME_WIDTH/2+76 &&ypos>=600 && ypos<=647){
//			bg="res/background2.jpg";
//			try {
//				background=new Image(bg);
//				background.draw(0,0,GAME_WIDTH,GAME_HEIGHT);
//				isMouseClick=true;
//				
//			} catch (SlickException e) {
//				e.printStackTrace();
//			}
			mousePress=true;
		}
	}
	private void enterGameState(StateBasedGame game) {
		game.enterState(1);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
