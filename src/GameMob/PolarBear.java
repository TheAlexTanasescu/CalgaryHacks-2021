package GameMob;

import hackoverflow.game.main.GamePanel;

public class PolarBear extends Mob {
	boolean moveRight;
	
	public PolarBear(String name, int health, int x, int y, GamePanel panel, String mobImgPathRight, String mobImgPathLeft) {
		super(name, health, x, y, panel, mobImgPathRight, mobImgPathLeft);
		moveRight = true;
		
	}

	@Override
	public void set(int cameraX) {
		x = xOffset + (startX - cameraX);
		timer ++;
		
		hitBox.x = x;
		
		if (moveRight) {
			lblMob.setIcon(mobIconR);
			if (timer % 50 == 0) {
				moveRight = false;
			}
			xspeed += 0.2;
		} else {
			lblMob.setIcon(mobIconL);
			if (timer % 50 == 0) {
				moveRight = true;
			}
			xspeed -= 0.2;
		}
		
		
		if (xspeed > 0 && xspeed < 0.1) xspeed = 0;
		if (xspeed < 0 && xspeed > -0.1) xspeed = 0;
		
		//Max Speed of mob
		if (xspeed > 4) xspeed = 4;
		if (xspeed < -4) xspeed = -4;
		
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
	
	
	
	

