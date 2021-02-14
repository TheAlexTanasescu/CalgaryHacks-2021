  package hackoverflow.game.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends javax.swing.JPanel implements ActionListener {

	ArrayList<Wall> walls = new ArrayList<>();
	Player player;
	int cameraX; //create camera
	Timer gameTimer;
	
	public GamePanel() {
		
		player = new Player(100, 400, this);
		
		reset(); //Intitalize walls with reset for ease

		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				player.set();
				for(Wall wall : walls) wall.set(cameraX);
				repaint();
				
			}
			
		}, 0, 17);
	}
	

	public void makeWalls(int offset) {
		for(int i = 50; i < 1400; i += 50) {
			walls.add(new Wall(i, 600, 50, 50));
		}
		
		for(int i = 50; i < 1400; i += 50) {
			walls.add(new Wall(i, 350, 50, 50));
		}
		
		for(int i = 50; i < 1400; i += 50) {
			if(i != 150) {
				walls.add(new Wall(i, 50, 50, 50));
			}
		}
		
		for(int i = -200; i < 600; i += 50) {
			walls.add(new Wall(50, i, 50, 50));
		}
		
		for(int i = -200; i < 600; i += 50) {
			walls.add(new Wall(1350, i, 50, 50));
		}
		
		//Obstacles floor 1
		walls.add(new Wall(500, 550, 50, 50)); //small mound 1
		walls.add(new Wall(550, 550, 50, 50)); //small mound 1
		walls.add(new Wall(850, 550, 50, 50)); //large mound 1
		walls.add(new Wall(850, 500, 50, 50)); //large mound 1
	}

	public void reset() {
		player.x = 100;
		player.y = 500;
		cameraX = 0;
		player.xspeed = 0;
		player.yspeed = 0;
		walls.clear();
		int offset = 50;
		makeWalls(offset); //Create walls every reset so they don't stack up each time

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gtd = (Graphics2D) g;
		
		player.draw(gtd);
		for(Wall wall: walls) wall.draw(gtd);
	}
	


	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'a') player.keyLeft = true;
		if (e.getKeyChar() == 'w') player.keyUp = true;
		if (e.getKeyChar() == 's') player.keyDown = true;
		if (e.getKeyChar() == 'd') player.keyRight = true;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == 'a') player.keyLeft = false;
		if (e.getKeyChar() == 'w') player.keyUp = false;
		if (e.getKeyChar() == 's') player.keyDown = false;
		if (e.getKeyChar() == 'd') player.keyRight = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
}
