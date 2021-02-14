package hackoverflow.game.main;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import  javamusicthing.musictime;



public class Game {


	public static void main(String[] args) {
		StartFrame startFrame = new StartFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		startFrame.setSize(1280, 720);
		startFrame.setLocation((int)(screenSize.getWidth()/2 - startFrame.getSize().getWidth()/2), (int)(screenSize.getHeight()/2 - startFrame.getSize().getHeight()/2));
		startFrame.setResizable(false);
		startFrame.setTitle("HackOverflow");
		startFrame.setVisible(true);
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (!startFrame.isFinished()) System.out.print("");;
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
		ImagePane.main(args);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

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

