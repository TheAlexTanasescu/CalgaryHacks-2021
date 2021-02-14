package GameMob;

import hackoverflow.game.main.GamePanel;
import hackoverflow.game.main.ImagePane;

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
		ImagePane.main("How's it going, eh?\n"
				+ "Congrats on the Maple!\n", "OBTAINED MAPLE", null);
	}
}
