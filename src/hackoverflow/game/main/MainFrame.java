package hackoverflow.game.main;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;




public class MainFrame extends javax.swing.JFrame {

	public MainFrame() {

			try {
				JLabel background = new JLabel(new ImageIcon(ImageIO.read(new File("Hackathon 2021 Assets/BG.png"))));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		/*
		StartPanel start = new StartPanel();
		start.setLocation(0, 0);
		start.setSize(this.getSize());
		start.setBackground(Color.LIGHT_GRAY);
		start.setVisible(true);
		this.add(start);
		
		while(!start.isFinished);
		
		this.remove(start);
		*/
		GamePanel panel = new GamePanel();
		panel.setLocation(0, 0);
		panel.setSize(this.getSize());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);

		this.add(panel);
		addKeyListener(new KeyChecker(panel));


	}
	
}

