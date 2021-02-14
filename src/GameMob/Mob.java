package GameMob;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import hackoverflow.game.main.GamePanel;
import hackoverflow.game.main.Wall;

public abstract class Mob {
	
	// amount of health a mob has
	protected int hp;
	protected boolean isAlive;
	
	// running speed of the mob
	protected double xspeed;
	protected double yspeed;
	
	//  0 = friendly  1 = neutral  2 = hostile
	protected int hostility;
	
	protected GamePanel panel;
	protected String mobName;
	protected JLabel lblMob;
	protected JLabel lblMobName;
	protected ImageIcon mobIcon;
	
	protected int startX;
	protected int xOffset;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	public Rectangle hitBox;
	
	//Timer stuff
	protected int timer;
	protected int sTime;
	
	
	// Initialize Mob
	public Mob(String name, int health, int startX, int startY, GamePanel panel, String mobImgPath) {
		this.panel = panel;
		this.x = startX;
		this.y = startY;
		this.startX = startX;
		this.hp = health;
		this.xOffset = 0;
		
		isAlive = true;
		timer = 0; // timer to create movement patterns
		mobName = name;
		lblMobName = new JLabel(mobName);
		mobIcon = new ImageIcon(mobImgPath);
		lblMob = new JLabel(mobIcon);
		
		width = mobIcon.getIconWidth();
		height = mobIcon.getIconHeight();
		
		hitBox = new Rectangle(x, y, width, height);
	}
	
	//Sets mob movement patterns
	public void set(int cameraX) {
		x = startX - cameraX;
		hitBox.x = x;
	}
	
	private void destroyMob() {
		isAlive = false;
		lblMob.setVisible(false);
	}
	
	public void hit() {
		hp --;
		if (hp <= 0) {
			destroyMob();
		}
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void draw(Graphics2D gtd) {
		if (isAlive) lblMob.getIcon().paintIcon(panel, gtd, x, y);
	}

	//Checks for y collisions on objects
	protected void collisionCheckX() {
		for (Wall wall : panel.walls)
		{
			if(hitBox.intersects(wall.hitBox))
			{
				hitBox.x -= xspeed;
				while(!wall.hitBox.intersects(hitBox))hitBox.x += Math.signum(xspeed);				
				hitBox.x -= Math.signum(xspeed);
				xspeed = 0;
				x = hitBox.x;

			}
		}
	}
		
	//Checks for x collisions on objects
	protected void collisionCheckY() {
		for (Wall wall : panel.walls) {
			if(hitBox.intersects(wall.hitBox))
			{
				hitBox.y -= yspeed;
				while(!wall.hitBox.intersects(hitBox)) hitBox.y += Math.signum(yspeed);
				hitBox.y -= Math.signum(yspeed);
				yspeed = 0;
				y = hitBox.y;

			}
		}
	}
}







