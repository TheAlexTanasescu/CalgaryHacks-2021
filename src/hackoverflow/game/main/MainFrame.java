package hackoverflow.game.main;
import java.awt.Color;





public class MainFrame extends javax.swing.JFrame {

	public MainFrame(int lvl) {
		
		GamePanel panel = new GamePanel(this, lvl);
		panel.setLocation(0, 0);
		panel.setSize(this.getSize());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);
		
		this.add(panel);
		addKeyListener(new KeyChecker(panel));
		
		
	}
	
public MainFrame() {
		
		GamePanel panel = new GamePanel(this);
		panel.setLocation(0, 0);
		panel.setSize(this.getSize());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);
		
		this.add(panel);
		addKeyListener(new KeyChecker(panel));
		
		
	}
	
}

