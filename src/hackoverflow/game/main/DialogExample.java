package hackoverflow.game.main;
import java.awt.*;  

import java.awt.event.*;  
public class DialogExample {  
    private static Dialog d;  
    DialogExample() {  
        Frame f= new Frame();  
        d = new Dialog(f , "Instructions", true);  
        d.setLayout( new FlowLayout() );  
        Button b = new Button ("OK");  
        
        b.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
                DialogExample.d.setVisible(false);  
            	
            }  
        });  
        
        d.add(new Label ("Use A and D to move right or left"));
        d.add(new Label ("Use W to jump - Like the snowman says >:("));
        d.add(b);   
        d.setSize(300,300);  
       
        d.setVisible(true);  
    }  
    public static void main(String args[])  
    {  
        new DialogExample();  
    }  
}  