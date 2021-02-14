package hackoverflow.game.main;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ImagePane 
{
	

	public static void main(String message, String title, String[] args)
	{
		ImageIcon icon = new ImageIcon("res/justin.png");
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE, icon);
	}
}
