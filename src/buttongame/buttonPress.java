package buttongame;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class buttonPress implements Entity{
	private static final int WIDTH = 65;
	private static final int HEIGHT = 66;
	
	protected int defsize = 30;
	protected double ovalWidth = WIDTH+defsize;
	protected double ovalHeight = HEIGHT+defsize;
	protected int x;
	protected int y;
	protected double seenButtonTime = 30;
	protected double changeSize = 0;
		
	protected Image image;
	Random ramdom=new Random();
	
	public buttonPress() throws SlickException {
		addImage();
		randomPosition();
	}
	
	public void addImage() throws SlickException {
		image = new Image("res/button.png");
	}
	
	public void randomPosition(){
		x = ramdom.nextInt(Button.GAME_WIDTH-(int)ovalWidth);
		y = ramdom.nextInt(Button.GAME_HEIGHT-(int)ovalHeight);
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(int delta){
		updateOval(delta);
		updateMovement();
		if(seenButtonTime>0){
			seenButtonTime -= delta*0.01f;
		}else{
			seenButtonTime = 30;
		}
	}
	
	protected void updateMovement(){
		
	}
	
	public void updateOval(int delta){
		changeOval(delta);
		checkOval();
	}
	
	protected void changeOval(int delta) {
		ovalHeight -= delta*0.01f;
		ovalWidth -= delta*0.01f;
		changeSize += delta*0.01f;
	}
	
	public double getOvalWidth(){
		return ovalWidth;  
	}
	
	public double getOvalHeight(){
		return ovalHeight;
	}
	
	public double setOvalHeight(){
		return ovalHeight = HEIGHT+defsize;
	}
	
	public double setOvalWidth(){
		return ovalWidth=WIDTH+defsize; 
	}
	
	public void checkOval(){
		if (ovalHeight <= HEIGHT && ovalWidth <= getWidth()){
			resetOval();
		}
	}
	
	public void resetOval() {
		randomPosition();
		setOvalHeight();
		setOvalWidth();
		changeSize = 0;
	}
	
	public void draw(Graphics g){
		drawImage();
		drawOutline(g);

	}
	
	protected void drawOutline(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(x-defsize/2+(int)changeSize/2, y-defsize/2+(int)changeSize/2
					, (int)getOvalWidth(), (int)getOvalHeight());
	}
	
	public void drawImage() {
		image.draw(x,y);
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
