package hackoverflow.game.main;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import GameMob.Mob;

public class StartPanel extends javax.swing.JPanel {
	boolean isFinished;
	Image background;
	
	
	public StartPanel() {
		try {
			background = ImageIO.read(new File("res/level1bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Button btnStart = new Button("start");
		btnStart.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				isFinished = true;
			}  
		});  
	}
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gtd = (Graphics2D) g;	
		g.drawImage(background, 0, 0, 1280, 720, null);


	}
	
	public boolean isFinished() {
		return isFinished; 
	}
}
