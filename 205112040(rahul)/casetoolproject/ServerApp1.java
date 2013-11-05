import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

class ServerApp1 extends JFrame implements ActionListener,Runnable
 { 
 
     ServerSocket ss;    
     JButton b1,b2;
     JTextField tx;TextArea tx1;
     JLabel l2;  
     BufferedReader br; 
     BufferedWriter bw;
   ServerApp1(String title)
     {
            
                  super(title);   
                  setLayout(null);
                  setSize(400,400);
                  setVisible(true);
                  setBackground(Color.yellow);
                  tx=new JTextField(60);  
                  tx.setSize(300,30);
                  tx.setLocation(20,20);
                  add(tx);
           l2=new JLabel("By Rahul kumar patel"); 
                  l2.setSize(150,50);
                  l2.setLocation(350,320);
                  add(l2);                         
             tx1=new TextArea("inbox");   
                    tx1.setSize(200,120);
                    tx1.setLocation(300,100);
                    add(tx1);
             b1=new JButton("SEND");
                  b1.setSize(85,40);
                  b1.setLocation(30,100);
                  add(b1);
               b1.addActionListener(this);

           
               b2=new JButton("status");
                  b2.setSize(100, 20);
                  b2.setLocation(365,10);
                  add(b2);
                  b2.addActionListener(this);
                   JLabel l6=new JLabel(new ImageIcon("11.png"));
                l6.setSize(690,600); 
                l6.setLocation(-160,-100);
                add(l6);


  
       try{

               ss=new ServerSocket(2500);
               Socket s=ss.accept();

               OutputStreamWriter osr=new OutputStreamWriter(s.getOutputStream());
               bw=new BufferedWriter(osr);
               bw.write("hellow and welcome");
               bw.newLine();
               bw.flush();  

               InputStreamReader isr=new InputStreamReader(s.getInputStream());
               br=new BufferedReader(isr);
               Thread th=new Thread(this);
               th.start();              

          }
     catch(Exception e2)
          {
            JOptionPane.showConfirmDialog(null,"Sorry no connection is available ","Status",JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE);
          }
 }
public void actionPerformed(ActionEvent e)
{
     
    if(e.getSource()==b2)
       {
              System.exit(0);
       }
    
   else if(e.getSource()==b1)
   {
           
           try
           {
               	  String s=tx.getText();
                  bw.write(s);
                  bw.newLine();
                  bw.flush();
                  tx.setText("\n");
               
          }catch(Exception e3){}
                     
     }
}
public void run()
{
	String strLine;
	  int i=0;
      String s;
     try
      {
        ss.setSoTimeout(1);
    }catch(Exception e){}
while(true)
   {
        try
         {
             System.out.println("\n");
             tx1.setText(br.readLine());

         }catch(Exception e1){}
   }
}
public static void main(String args[])
{
   	
              ServerApp1 l1=new ServerApp1("ServerApp");
              l1.getContentPane().setBackground(Color.CYAN);
              Toolkit kit =l1.getToolkit();
	          GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	          GraphicsDevice[] gs = ge.getScreenDevices();
	          Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
	         Dimension d = kit.getScreenSize();
	         int max_width = (d.width - in.left - in.right);
	         int max_height = (d.height - in.top - in.bottom);
	         l1.setSize(Math.min(max_width,500), Math.min(max_height,400));
  	         l1.setLocation((int) (max_width - l1.getWidth()) / 2, (int) (max_height - l1.getHeight() ) / 2);
    }
}

