package buttongame;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class buttonPress implements Entity{
	private static final int WIDTH=65;
	private static final int HEIGHT=66;
	
	private int defsize=30;
	private double ovalWidth=WIDTH+defsize;
	private double ovalHeight=HEIGHT+defsize;
	protected int x;
	protected int y;
	private double time=0.09;
	private double changeSize=0;
	
	
	protected Image image;
	Random ramdom=new Random();
	
	public buttonPress() throws SlickException {
		addImage();
		randomPosition();
	}

	public void addImage() throws SlickException {
		image=new Image("res/button.png");
	}
	
	public void randomPosition(){
		x=ramdom.nextInt(MainGame.GAME_WIDTH-(int)ovalWidth);
		y=ramdom.nextInt(MainGame.GAME_HEIGHT-(int)ovalHeight);
	}
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(){
		updateOval();
		updateMovement();
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
	protected void updateMovement(){
		
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
	public double setOvalHeight(){
		return ovalHeight=HEIGHT+defsize;
	}
	public double setOvalWidth(){
		return ovalWidth=WIDTH+defsize; 
	}
	public void CheckOval(){
		if(ovalHeight<=HEIGHT && ovalWidth <= getWidth()){
			resetOval();
		}
	}
	public void resetOval() {
		randomPosition();
		setOvalHeight();
		setOvalWidth();
		changeSize=0;
	}
	public void draw(Graphics g){
		image.draw(x,y);
		g.setColor(Color.black);
		g.drawOval(x-defsize/2+(int)changeSize/2, y-defsize/2+(int)changeSize/2
					, (int)getOvalWidth(), (int)getOvalHeight());
	
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
	public static int getHeight(){
		return HEIGHT;
	}

}
