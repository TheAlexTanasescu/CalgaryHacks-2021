package hackoverflow.game.main;

import javax.swing.*;  
public class OptionPaneExample {  
JFrame f;  
OptionPaneExample(){  
    f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Press A and D to move left and right \n"
    								+ "Press W to jump and climb ladders like the snowman says >:(");  
}  		
public static void main(String[] args) {  
    new OptionPaneExample();  
}  
}  