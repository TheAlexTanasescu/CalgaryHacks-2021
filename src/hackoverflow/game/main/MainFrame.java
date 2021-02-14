package hackoverflow.game.main;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;




public class MainFrame extends javax.swing.JFrame {

	public MainFrame() {
		
		GamePanel panel = new GamePanel(1);
		panel.setLocation(0, 0);
		panel.setSize(this.getSize());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);
		
		this.add(panel);
		addKeyListener(new KeyChecker(panel));

		
		
	}
	
}

