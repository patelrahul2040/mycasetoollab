import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
 
 class MovingText extends JFrame implements ActionListener{
  JLabel label;
  JLabel label2;
 
  public MovingText()  {
    label = new JLabel( "Hi this is rahul kumar patel");
    
     getContentPane().add(label, BorderLayout.NORTH);
     javax.swing.Timer timer = new javax.swing.Timer(200, this);
    timer.start();
  }
   public void actionPerformed(ActionEvent e)  {
    String oldText = label.getText();
    String newText = oldText.substring(1) + oldText.substring(0, 1);
     label.setText( newText );
  }
   public static void main(String[] args)  {
    MovingText frame = new MovingText();
    frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
    frame.setSize(300,100);
    frame.setVisible(true);
  }
}