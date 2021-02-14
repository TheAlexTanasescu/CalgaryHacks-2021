package hackoverflow.game.main;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ImagePane 
{
	

	public static void main(String message, String title, String[] args, Player p, ImageIcon icon)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
		if (p!= null) {
			p.keyLeft = false;
			p.keyRight = false;
			p.keyDown = false;
			p.keyUp = false;
		}
	}
}
