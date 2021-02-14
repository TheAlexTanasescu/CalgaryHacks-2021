package hackoverflow.game.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javamusicthing.MusicTime;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;



public class Game {


	public static void main(String[] args) {
		String MENU_TRACK = "res/menu.wav";
		MusicTime MainMenu = new MusicTime();
		
		StartFrame startFrame = new StartFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		startFrame.setSize(1280, 720);
		startFrame.setLocation((int)(screenSize.getWidth()/2 - startFrame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - startFrame.getSize().getHeight()/2));
		startFrame.setResizable(false);
		startFrame.setTitle("HackOverflow");
		startFrame.setVisible(true);
		MainMenu.PlayMusicLoop(MENU_TRACK);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while (!startFrame.isFinished()) System.out.print("");;
		MainMenu.StopMusic();
		MainFrame frame = new MainFrame();
		// the icon image for the game
		ImageIcon Icon = new ImageIcon("res/GameIcon.png");;
		// setting the image as the icon for the game
		frame.setIconImage(Icon.getImage());
		
		frame.setSize(1280, 720);
		
		frame.setLocation((int)(screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - frame.getSize().getHeight()/2));
		
		frame.setResizable(false);
		frame.setTitle("HackOverflow");
		frame.setVisible(true);
		ImagePane.main("Hello there, eh, sorry to bother you\n"
				+ "I'm Justin Beaver\n"
				+ "I'll help you throughout the game\n"
				+ "\n"
				+ "Press A and D to go left and right\n"
				+ "Press W to jump and climb ladders\n"
				+ "\n"

				+ "There's a lot of polar bears around these parts, eh?\n"
				+ "Jump on them with your skates and hockey stick to defeat them\n"
				+ "\n"
				+ "You can earn maple syrup from polar bears if you beat them\n"
				+ "When you get maple syrup, trade it quickly at Timmy's for a double double\n"
				+ "to get energy for the next level\n"
				+ "\n"
				+ "Good luck, eh"
				, "Tutorial", args, null);

		
		//OptionPaneExample.main(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		/*    POP UP WINDOW EXAMPLE   
		

        final JFrame parent = new JFrame();
        JButton button = new JButton();

        button.setText("Click me to show dialog!");
        parent.add(button);
        parent.pack();
        parent.setVisible(true);

        button.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String name = JOptionPane.showInputDialog(parent,
                        "What is your name?", null);
            }
        });
    }
		*/
		
		
	}}

