package hackoverflow.game.main;

import java.awt.Image;

import javax.swing.*;  
public class OptionPaneExample {  
JFrame f;  
OptionPaneExample(){  
    f=new JFrame();  
    ImageIcon icon = new ImageIcon("justin.png");
	Image image2 = icon.getImage().getScaledInstance(200,200,0);
    JOptionPane.showMessageDialog(f,"Press A and D to move left and right \n"
    								+ "Press W to jump and climb ladders like the snowman says >:("); 
  
    
}  		
public static void main(String[] args) { 
	
    new OptionPaneExample();  
}  
}  