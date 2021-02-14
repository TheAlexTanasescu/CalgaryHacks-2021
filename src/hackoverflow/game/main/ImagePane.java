package hackoverflow.game.main;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ImagePane 
{

	public static void main(String[] args)
	{
		ImageIcon icon = new ImageIcon("res/justin.png");
		JOptionPane.showMessageDialog(null, "Hello there, eh, sorry to bother you\n"
				+ "I'm Justin Beaver\n"
				+ "I'll help you throughout the game\n"
				+ "\n"
				+ "Press A and D to go left and right\n"
				+ "Press W to jump and climb ladders\n"
				+ "\n"
				+ "I'll help you more once you save me from Barry the Polar Bear\n"
				+ "and Marley the Moose\n", "Tutorial", JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
