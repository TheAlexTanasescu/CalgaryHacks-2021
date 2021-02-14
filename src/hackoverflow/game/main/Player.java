package hackoverflow.game.main;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {

	private GamePanel panel;
	private int x;
	private int y;
	private int width;
	private int height;
	private int timer;
	
	private double xspeed;
	private double yspeed;
	
	private Rectangle hitBox;
	public boolean keyLeft;
	public boolean keyRight;
	public boolean keyUp;
	public boolean keyDown;
	
	//Image stuff
	private JLabel lblPlayer;
	private ImageIcon player0;
	private ImageIcon player1;
	private ImageIcon player2;
	
	public Player(int x, int y, GamePanel panel) {
		
		this.panel = panel;
		this.x = x;
		this.y = y;
		timer = 0;
		
		width = 50;
		height = 100;
		
		//Image stuff
		player0 = new ImageIcon("res/player0.png");
		player1 = new ImageIcon("res/player1.png");
		player2 = new ImageIcon("res/player2.png");
		
		lblPlayer = new JLabel(player0);
		
        width = player0.getIconWidth();
        height = player0.getIconHeight();
        
        hitBox = new Rectangle(x, y, width, height);
	}
	
	public void set() {
		if (keyLeft && keyRight || !keyLeft && !keyRight) xspeed = 0.5;
		else if (keyLeft && !keyRight) xspeed --;
		else if (keyRight && !keyLeft) xspeed ++;
		
		//Timer
		timer ++;
		setPlayerIcon();
		
		if (xspeed > 0 && xspeed < 0.75) xspeed = 0;
		if (xspeed < 0 && xspeed > -0.75) xspeed = 0;
		if (xspeed > 7) xspeed = 7;
		if (xspeed < -7) xspeed = -7;

		if (keyUp)
		{
			hitBox.y = hitBox.y + 2;
			
			for (Wall wall: panel.walls)
			{
				if (wall.hitBox.intersects(hitBox)) yspeed = -8;
			}
			hitBox.y --;
		}
		
		yspeed += 0.3;
		
		//Horizontal Collision
		
		hitBox.x += xspeed;
		for (Wall wall : panel.walls)
		{
			if(hitBox.intersects(wall.hitBox))
			{
				hitBox.x -= xspeed;
				while(!wall.hitBox.intersects(hitBox))hitBox.x += Math.signum(xspeed);				

				while(!wall.hitBox.intersects(hitBox))
					hitBox.x += Math.signum(xspeed);

					hitBox.x -= Math.signum(xspeed);
					xspeed = 0;
					x = hitBox.x;

          hitBox.x -= Math.signum(xspeed);
          xspeed = 0;
          x = hitBox.x;

			}
		}
		
		//Vertical Collision
		
		hitBox.y += yspeed;
		for (Wall wall : panel.walls)
		{
			if(hitBox.intersects(wall.hitBox))
			{
				hitBox.y -= yspeed;
				while(!wall.hitBox.intersects(hitBox))
					hitBox.y += Math.signum(yspeed);
					hitBox.y -= Math.signum(yspeed);
					yspeed = 0;
					y = hitBox.y;

			}
		}

		if(xspeed > 0 && xspeed < 0.75) xspeed = 0;
		if(xspeed < 0 && xspeed > -0.75) xspeed = 0;
		
		if(xspeed > 7) xspeed = 7;
		if(xspeed < -7) xspeed = -7;

		
		panel.cameraX += xspeed;
		y += yspeed;
		
		hitBox.x = x;
		hitBox.y = y;
		
		//Code for death
		if(y > 800) {
			this.reset();
			panel.reset();
		}
	}
	
	private void reset() {
		x = 200;
		y = 150;
		xspeed = 0;
		yspeed = 0;
		panel.reset();
	}
	
	//Changes the player image to imitate movement
	private void setPlayerIcon() {
		if (timer % 10 == 0) {
			if ((lblPlayer.getIcon() == player0) && (keyRight|| keyLeft) && !(keyUp)) lblPlayer.setIcon(player1);
			else if ((lblPlayer.getIcon() == player1) && (keyRight|| keyLeft) && !(keyUp)) lblPlayer.setIcon(player2);
			else if ((lblPlayer.getIcon() == player2) && (keyRight|| keyLeft) && !(keyUp)) lblPlayer.setIcon(player0);
		}
	}
	
	public void draw(Graphics2D gtd) {
		lblPlayer.getIcon().paintIcon(panel, gtd, x, y);
	}
}
