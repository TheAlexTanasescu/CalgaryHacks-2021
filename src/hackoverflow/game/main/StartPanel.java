package hackoverflow.game.main;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import GameMob.Mob;

public class StartPanel  extends javax.swing.JPanel {
	boolean isFinished = false;
	Image background;
	
	public StartPanel(JFrame frame) {
		setLayout( new GridBagLayout() );
		JButton b = new JButton("Play");  
	    b.addActionListener(new ActionListener() {  
	    	public void actionPerformed(ActionEvent e) {  
	            frame.dispose();
	            isFinished = true;
	        }  
	    });
	    add(b, new GridBagConstraints());
	    
	    ImagePane.main("Press Maply's nose to Start", "Start", null, null);
	    try {
			background = ImageIO.read(new File("res/GameIcon2.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gtd = (Graphics2D) g;
		
		gtd.drawImage(background, 0, 0, 1280, 720, null);


	}
	
	public boolean isFinished() {
		return isFinished;
	}
}
