package GameMob;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import hackoverflow.game.main.GamePanel;

public abstract class Mob {
	
	// amount of health a mob has
	private int Health;
	
	// running speed of the mob
	private double xspeed;
	private double yspeed;
	
	//  0 = friendly  1 = neutral  2 = hostile
	private int hostility;
	
	private GamePanel panel;
	private String mobName;
	private JLabel lblMob;
	private JLabel lblMobName;
	private ImageIcon mobIcon;
	
	private int x;
	private int y;
	private int width;
	private int height;
	private Rectangle hitBox;
	
	
	// to init a mob
	public Mob(String name, int x, int y, GamePanel panel, String mobImgPath) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		
		mobName = name;
		lblMobName = new JLabel(mobName);
		mobIcon = new ImageIcon(mobImgPath);
		lblMob = new JLabel(mobIcon);
		
		width = mobIcon.getIconWidth();
		height = mobIcon.getIconHeight();
		
		hitBox = new Rectangle(x, y, width, height);
	}
	
	private void setMobIcon() {
		
	}
	
	public void draw(Graphics2D gtd) {
		lblMob.getIcon().paintIcon(panel, gtd, x, y);
	}

}







