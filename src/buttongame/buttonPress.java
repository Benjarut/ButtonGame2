package buttongame;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class buttonPress {
	private static final int WIDTH=65;
	static public final int HEIGHT=66;
	
	private int defsize=30;
	private double ovalWidth=getWidth()+defsize;
	private double ovalHeight=HEIGHT+defsize;
	private int x;
	private int y;
	private double time=0.05;
	private double changeSize=0;
	
	
	private Image image;
	Random ramdom=new Random();
	
	public buttonPress() throws SlickException {
		image=new Image("res/button.png");
		randomPosition();
	}
	
	public void randomPosition(){
		x=ramdom.nextInt(StartMenu.GAME_WIDTH-(int)ovalWidth);
		y=ramdom.nextInt(StartMenu.GAME_HEIGHT-(int)ovalHeight);
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(GameContainer container, int delta) throws SlickException{
		updateOval();
//		if(time > 0){
//			time-=1.00/1000;
//		}
//		else{
//			time=0;
//			randomPosition();
//			ovalHeight=HEIGHT+defsize;
//			ovalWidth=WIDTH+defsize;
//		}
	}
	public void updateOval(){
		ovalHeight-=time;
		ovalWidth-=time;
		changeSize+=time;
		CheckOval();
	}
	public double getOvalWidth(){
		return ovalWidth;  
	}
	public double getOvalHeight(){
		return ovalHeight;
	}
	public void CheckOval(){
		if(ovalHeight<=HEIGHT && ovalWidth <= getWidth()){
			randomPosition();
			ovalHeight=HEIGHT+defsize;
			ovalWidth=getWidth()+defsize;
			changeSize=0;
		}
	}
	public void draw(GameContainer container,Graphics g){
		image.draw(x,y);
		g.setColor(Color.black);
	
		//if(time>0){
			g.drawOval(x-defsize/2+(int)changeSize/2, y-defsize/2+(int)changeSize/2
					, (int)getOvalWidth(), (int)getOvalHeight());
	
		//}
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}

	public static int getWidth() {
		return WIDTH;
	}


}
