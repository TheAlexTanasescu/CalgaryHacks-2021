package GameMob;

import hackoverflow.game.main.GamePanel;

public class PolarBear extends Mob {
	boolean moveRight;
	
	public PolarBear(String name, int health, int x, int y, GamePanel panel, String mobImgPath) {
		super(name, health, x, y, panel, mobImgPath);
		moveRight = true;
		
	}

	@Override
	public void set(int cameraX) {
		x = xOffset + (startX - cameraX);
		timer ++;
		
		hitBox.x = x;
		
		if (moveRight) {
			if (timer % 100 == 0) {
				moveRight = false;
			}
			xspeed ++;
		} else {
			if (timer % 100 == 0) {
				moveRight = true;
			}
			xspeed --;
		}
		
		
		if (xspeed > 0 && xspeed < 0.75) xspeed = 0;
		if (xspeed < 0 && xspeed > -0.75) xspeed = 0;
		if (xspeed > 7) xspeed = 7;
		if (xspeed < -7) xspeed = -7;
		
		//Horizontal Collision
		hitBox.x += xspeed;
		collisionCheckX();
		//---
				
		//Vertical Collision
		hitBox.y += yspeed;
		collisionCheckY();
		//---
		x += xspeed;
		y += yspeed;
		
		hitBox.x = x;
		hitBox.y = y;
		
		xOffset = xOffset += xspeed;
	}
		
}
	
	
	
	

