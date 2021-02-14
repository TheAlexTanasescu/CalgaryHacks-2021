package hackoverflow.game.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ladder 
{
	int x, y, width, height;
	int startX;
	Rectangle hitBox;
	
	public Ladder(int x, int y, int width, int height)
	{
		 this.x = x;
		 this.y = y;
		 this.height = height;
		 this.width = width;
		 startX = x;
		 
		 hitBox = new Rectangle(x, y, width, height);
	}
	
	public void draw(Graphics2D gtd)
	{
		gtd.setColor(Color.ORANGE);
		//gtd.drawRect(x, y, width, height);
		gtd.setColor(Color.ORANGE);
		//gtd.fillRect(x+1, y+1, width-2, height-2);
		
	}
	
	public int set(int cameraX) {
		x = startX - cameraX;
		hitBox.x = x;
		return x;
	}
}
