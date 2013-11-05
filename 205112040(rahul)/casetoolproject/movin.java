import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
class AnimatedJFrame extends JFrame implements Runnable
{ 
   Thread t;
   public AnimatedJFrame()
   {  
     setTitle("Animated JFrame");
     setSize(500,500);
     setDefaultCloseOperation(EXIT_ON_CLOSE);  
setUndecorated(true);
setShape(new Ellipse2D.Double(0,0,500,500));
getContentPane().setBackground(Color.CYAN);
setOpacity(0.5f);

setVisible(true);
t=new Thread(this);
t.start();
}

public void run()
{
try
{
   int width=Toolkit.getDefaultToolkit().getScreenSize().width;
   for(int i=0;i<=width;i++)
    {

// If i value equals width (i.e. reaches end of screen), start from starting of the screen (i.e. i=0) so looped forever
if(i==width) 
i=0;

// Set location, x-coordinate changes but y-coordinate is constant
setLocation(i,55);

// Get the effect!
Thread.sleep(20);

}

}catch(Exception e){}

}

public static void main(String args[])
{
new AnimatedJFrame();
}

}