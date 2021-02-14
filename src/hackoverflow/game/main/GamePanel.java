  package hackoverflow.game.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import GameMob.MapleSyrup;
import GameMob.Mob;
import GameMob.PolarBear;


public class GamePanel extends javax.swing.JPanel implements ActionListener {

	public ArrayList<Wall> walls = new ArrayList<>();
	public ArrayList<Ladder> ladders = new ArrayList<>();
	public ArrayList<Mob> mobs = new ArrayList<>();
	public ArrayList<Icicle> icicles = new ArrayList<>();
	Wall timH;
	
	public Player player;
	int cameraX; //create camera
	Timer gameTimer;
	Image lvl1Png;
	Image lvl1InvsPng;
	Image lvl2InvsPng;
	Image lvl1TreePng;
	int pane;
	
	public GamePanel() {
		pane = 0;
		player = new Player(600, 500, this);
		
		initMobs();
		
		try {
			lvl1Png = ImageIO.read(new File("res/level1bg.png"));
			lvl1InvsPng = ImageIO.read(new File("res/level1transparent.png"));
			lvl1TreePng = ImageIO.read(new File("Hackathon 2021 Assets/Tree_2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		reset(); //Initialize walls with reset for ease

		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {		
				//DialogExample.main(null);
				player.set();
				for(Wall wall : walls) wall.set(cameraX);
				for(Ladder ladder : ladders) ladder.set(cameraX);
				for(Mob mob : mobs) mob.set(cameraX);
				for(Icicle icicle : icicles) icicle.set(cameraX);
				repaint();
				
			}
			
		}, 0, 17);
	}
	
public GamePanel(int i) {
		pane = 1;
		
		player = new Player(600, 500, this);
		initMobs();
		
		try {
			lvl1Png = ImageIO.read(new File("res/level1bg.png"));
			lvl2InvsPng = ImageIO.read(new File("res/level2transparent.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		reset2(); //Initialize walls with reset for ease

		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {		
				//DialogExample.main(null);
				player.set();
				for(Wall wall : walls) wall.set(cameraX);
				for(Ladder ladder : ladders) ladder.set(cameraX);
				for(Mob mob : mobs) mob.set(cameraX);
				for(Icicle icicle : icicles) icicle.set(cameraX);
				repaint();
				
			}
			
		}, 0, 17);
	}
	
	//Initializes mobs
	private void initMobs() {
		
		//Lvl 1 bear mob

		mobs.add(new MapleSyrup("maple", 1, 440, 310, this, "res/maple.png", "res/maple.png"));
		mobs.add(new PolarBear("Bob", 50, 550, 295, this, "res/bear.png", "res/bearLeft.png"));
		
	}
	
	
	public void makeWalls(int offset) {
		walls.add(new TimHortons(1150, 0, 200, 200, "tim"));
		
		for(int i = 50; i < 1400; i += 50) {
			walls.add(new Wall(i, 600, 50, 50));
		}
		
		for(int i = 50; i < 1400; i += 50) {
			if(i != 1150) {
				walls.add(new Wall(i, 360, 50, 50));
			}
		}
		
		for(int i = 50; i < 1400; i += 50) {
			if(i != 150) {
				walls.add(new Wall(i, 120, 50, 50));
			}
		}
		
		for(int i = -200; i < 600; i += 50) {
			walls.add(new Wall(50, i, 50, 50));
		}
		
		for(int i = -200; i < 600; i += 50) {
			walls.add(new Wall(1350, i, 50, 50));
		}

		

		//Obstacles floor 1
		walls.add(new Wall(450, 550, 50, 50)); //small mound 1
		walls.add(new Wall(500, 550, 50, 50)); //small mound 1
		walls.add(new Wall(800, 550, 50, 50)); //large mound 1
		walls.add(new Wall(800, 500, 50, 50)); //large mound 1
	}
	
	public void makeLadders(int offset) {		
		for(int i = 350; i < 600; i += 50) {
			ladders.add(new Ladder(1150, i, 50, 50));
		}
		
		for(int i = 100; i < 350; i += 50) {
			ladders.add(new Ladder(150, i, 50, 50));
		}
	}
	
	public void makeIcicles(int offset) {		
		for(int i = 250; i < 600; i += 50) {
			icicles.add(new Icicle(i, 0, 50, 50));
		}
		
	}
	
	public void makeFloor2(int offset) {
		for(int i = 50; i < 3000; i += 50) {
			walls.add(new Wall(i, 605, 50, 40));
		}
		
		for(int i = 50; i < 3000; i += 100) {
			if(i != 1250 && i != 1450 && i != 1600) {
				walls.add(new Wall(i, 380, 100, 40));
			}
		}
		
		for(int i = 380; i < 600; i += 50) {
			ladders.add(new Ladder(1270, i, 80, 50));
		}
		
		for(int i = 150; i < 380; i += 50) {
			ladders.add(new Ladder(165, i, 60, 50));
		}
		
		walls.add(new Wall(50, 160, 100, 40));
		walls.add(new Wall(230, 160, 100, 40));
		walls.add(new Wall(620, 160, 210, 40));
		walls.add(new Wall(1170, 160, 300, 40));
		
		for(int i = -200; i < 650; i += 50) {
			walls.add(new Wall(0, i, 50, 50));
		}
		
		for(int i = 150; i < 650; i += 50) {
			walls.add(new Wall(1450, i, 50, 50));
		}
		
		for(int i = -200; i < 650; i += 50) {
			walls.add(new Wall(2950, i, 50, 50));
		}
	}


	public void reset() {
		cameraX = -400;
		walls.clear();
		int offset = 50;
		makeWalls(offset); //Create walls every reset so they don't stack up each time
		makeLadders(offset); //Create walls every reset so they don't stack up each time
		makeIcicles(offset);
	}
	
	public void reset2() {
		cameraX = -400;
		walls.clear();
		int offset = 50;
		makeFloor2(offset);
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D gtd = (Graphics2D) g;
		
		g.drawImage(lvl1Png, 0, 0, 1280, 720, null);
		if (pane == 0) {
			g.drawImage(lvl1InvsPng, 55 - cameraX, -70, 1350, 720, null);
		} else {
			g.drawImage(lvl2InvsPng, 0 - cameraX, -70, 3000, 720, null);
		}
		
//		g.drawImage(lvl1TreePng, 220 - cameraX, 150, 160, 200, null);

		//player.draw(gtd);
		//gtd.fillRect((int)timHortons.getWidth(), (int)timHortons.getHeight(), (int)timHortons.getX(), (int) timHortons.getY());
		for(Wall wall: walls) wall.draw(gtd);
		for(Ladder ladder: ladders) ladder.draw(gtd);
		for(Mob mob: mobs) mob.draw(gtd);
		for(Icicle icicle: icicles) icicle.draw(gtd);

		player.draw(gtd);

	}
	


	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'a') player.keyLeft = true;
		if (e.getKeyChar() == 'w') player.keyUp = true;
		if (e.getKeyChar() == 's') player.keyDown = true;
		if (e.getKeyChar() == 'd') player.keyRight = true;
		if (e.getKeyChar() == ' ') player.keySpacebar = true;
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == 'a') player.keyLeft = false;
		if (e.getKeyChar() == 'w') player.keyUp = false;
		if (e.getKeyChar() == 's') player.keyDown = false;
		if (e.getKeyChar() == 'd') player.keyRight = false;
		if (e.getKeyChar() == ' ') player.keySpacebar = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	
}
