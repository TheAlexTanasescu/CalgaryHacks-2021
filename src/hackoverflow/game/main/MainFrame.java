 package hackoverflow.game.main;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MainFrame extends javax.swing.JFrame {
	public MainFrame() {
		GamePanel panel = new GamePanel();
		panel.setLocation(0, 0);
		panel.setSize(this.getSize());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);
		
		//this.setContentPane(lblBackground1);
		this.add(panel);
		addKeyListener(new KeyChecker(panel));
		
		
		
	}
	
}
