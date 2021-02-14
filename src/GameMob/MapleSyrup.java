package GameMob;

import hackoverflow.game.main.GamePanel;

public class MapleSyrup extends Mob {
	
	public MapleSyrup(String name, int health, int startX, int startY, GamePanel panel, String mobImgPathRight,
			String mobImgPathLeft) {
		super(name, health, startX, startY, panel, mobImgPathRight, mobImgPathLeft);

	}

	@Override
	public void set(int cameraX) {
		x = (startX - cameraX);
		hitBox.x = x;
		hitBox.y = y;
	}
	
	@Override
	protected void destroyMob() {
		super.destroyMob();
		super.panel.player.obtainedMaple = true;
		System.out.println("You have obtained Maple!");
	}
}
