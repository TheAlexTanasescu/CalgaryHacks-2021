package hackoverflow.game.main;

import java.awt.*;

import javax.swing.ImageIcon;

public class Wall 
{
	int x, y, width, height;
	int startX;
	String name;
	public Rectangle hitBox;
	
	public Wall(int x, int y, int width, int height)
	{
		 this.x = x;
		 this.y = y;
		 this.height = height;
		 this.width = width;
		 startX = x;
		 
		 hitBox = new Rectangle(x, y, width, height);
	}
	
	public Wall(int x, int y, int width, int height, String name) {
		this.x = x;
		 this.y = y;
		 this.height = height;
		 this.width = width;
		 this.name = name;
		 startX = x;
		 
		 hitBox = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics2D gtd)
	{
		gtd.setColor(Color.BLACK);
		//gtd.drawRect(x, y, width, height);
		gtd.setColor(Color.cyan);
		//gtd.fillRect(x+1, y+1, width-2, height-2);
		
		
		
	}
	
	//Setting walls to move and hitbox
	public void set(int cameraX) {
		x = startX - cameraX;
		hitBox.x = x;
	}
}
