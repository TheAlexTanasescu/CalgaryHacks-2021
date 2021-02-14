package hackoverflow.game.main;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GameMob.Mob;

public class Player {

	private GamePanel panel;
	private int x;
	private int y;
	private int width;
	private int height;
	private int timer;
	
	private int hp;
	private int maxHp;
	
	private int lives;
	private boolean gameOver;
	private JLabel lblHp;
	
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
	private ImageIcon player0l;
	private ImageIcon player1l;
	private ImageIcon player2l;
	
	
	public Player(int x, int y, GamePanel panel) {
		
		this.panel = panel;
		this.x = x;
		this.y = y;
		timer = 0;
		maxHp = 20;
		hp = maxHp;
        lives = 3;
        gameOver = false;
		width = 50;
		height = 100;
		
		//Image stuff
		player0 = new ImageIcon("res/player0.png");
		player1 = new ImageIcon("res/player1.png");
		player2 = new ImageIcon("res/player2.png");
		player0l = new ImageIcon("res/player0left.png");
		player1l = new ImageIcon("res/player1left.png");
		player2l = new ImageIcon("res/player2left.png");
		
		lblPlayer = new JLabel(player0);
		lblHp = new JLabel("HP: " + hp);

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
			
			for(Ladder ladder : panel.ladders) {
				if (ladder.hitBox.intersects(hitBox)) yspeed = -8;
			}
			
			hitBox.y --;
		}
		
		yspeed += 0.3;
		
		//Horizontal Collision
		hitBox.x += xspeed;
		collisionCheckX();
		//---
		
		//Vertical Collision
		hitBox.y += yspeed;
		collisionCheckY();
		//---

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
	
	//Checks for y collisions on objects
	private void collisionCheckX() {
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
		for(Mob mob : panel.mobs) {
			if (mob.isAlive()) {
				if (mob.hitBox.intersects(hitBox)) {
					hitBox.x -= xspeed;
					while(!mob.hitBox.intersects(hitBox))hitBox.x += Math.signum(xspeed);				
					hitBox.x -= Math.signum(xspeed);
					xspeed = 0;
					x = hitBox.x;
					mob.hit();
					hp --;
				}
			}
		}
	}
	
	private void hit() {
		hp --;
		if (hp <= 0) {
			loseLife();
		}
	}
	
	private void loseLife() {
		lives --;
		if (lives <= 0) gameOver = true;
	}
	//Checks for x collisions on objects
	private void collisionCheckY() {
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
		for(Mob mob : panel.mobs) {
			if (mob.isAlive()) {
				if (mob.hitBox.intersects(hitBox)) {
					hitBox.y -= yspeed;
					while(!mob.hitBox.intersects(hitBox))hitBox.y += Math.signum(yspeed);				
					hitBox.y -= Math.signum(yspeed);
					yspeed = 0;
					y = hitBox.y;
					mob.hit();
				}
			}
		}
	}
	//Changes the player image to imitate movement
	private void setPlayerIcon() {
		if (keyRight && keyLeft) {
			return;
		}
		if (timer % 7 == 0) {
			if (keyRight && !keyUp) {
				if (lblPlayer.getIcon() == player0) lblPlayer.setIcon(player1);
				else if (lblPlayer.getIcon() == player1) lblPlayer.setIcon(player2);
				else if (lblPlayer.getIcon() == player2) lblPlayer.setIcon(player0);
				else lblPlayer.setIcon(player0);
			} else if (keyLeft && !keyUp) {
				if (lblPlayer.getIcon() == player0l) lblPlayer.setIcon(player1l);
				else if (lblPlayer.getIcon() == player1l) lblPlayer.setIcon(player2l);
				else if (lblPlayer.getIcon() == player2l) lblPlayer.setIcon(player0l);
				else lblPlayer.setIcon(player0l);
			} else if (keyUp && keyLeft) {
				lblPlayer.setIcon(player1l);
			} else if (keyUp && keyRight) {
				lblPlayer.setIcon(player1);
			}
		}
	}
	
	public void draw(Graphics2D gtd) {
		lblPlayer.getIcon().paintIcon(panel, gtd, x, y);
		gtd.setColor(Color.black);
	    gtd.fillRect(x, y, width, 5);
	    gtd.setColor(Color.red);
	    System.out.println("hp: " + hp);
	    gtd.fillRect(x, y, (width * hp) / maxHp, 5);
	}
}
