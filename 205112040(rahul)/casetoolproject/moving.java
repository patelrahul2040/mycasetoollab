    import javax.imageio.ImageIO;
    import javax.swing.*;
    import java.awt.image.BufferedImage;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.*;

    public  class LabelFrame extends JFrame{


public LabelFrame( ) 
{
    super("The Structures Game");



    setSize(475,400);
    setLocation(350,200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);



    JMenuBar menubar = new JMenuBar();
    setJMenuBar(menubar);

    JMenu Change = new JMenu("Pick a Level");
    menubar.add(Change);
        JMenu Move = new JMenu("Move keys");
    menubar.add(Move);

    JMenu Options = new JMenu("Options");
    menubar.add(Options);

    JMenu About = new JMenu("About");
    menubar.add(About);

    JMenu Select = new JMenu("Select");
    menubar.add(Select);



    final JMenuItem black = new JMenuItem("Black BackGround");
    Options.add(black);

    final JMenuItem blue = new JMenuItem("Blue BackGround");
    Options.add(blue);

    final JMenuItem yellow = new JMenuItem("Yellow BackGround");
    Options.add(yellow);

    final JMenuItem green = new JMenuItem("Green BackGround");
    Options.add(green);

    final JMenuItem white = new JMenuItem("White BackGround");
    Options.add(white);

    JMenuItem info = new JMenuItem("infomation");
    About.add(info);

    JMenuItem Level1 = new JMenuItem("Level 1");
    Change.add(Level1);


    JMenuItem Level2 = new JMenuItem("Level 2");
    Change.add(Level2);

    JMenuItem Level3 = new JMenuItem("Level 3");
    Change.add(Level3);

    JMenuItem Level4 = new JMenuItem("Level 4");
    Change.add(Level4);

    JMenuItem Level5 = new JMenuItem("Level 5");
    Change.add(Level5);
    final JRadioButton redBlock = new JRadioButton("redblock");
    final JRadioButton blockverticala = new JRadioButton("2blockvertical");
    final JRadioButton blockverticalb = new JRadioButton("4blockvertical");
    final JRadioButton blockhorizontal = new JRadioButton("2blcokhorizontal");

    final JButton moveleft = new JButton("Left");
    final JButton moveright = new JButton("Right");
    final JButton moveup = new JButton("Up");
    final JButton movedown = new JButton("Down");



    Select.add(redBlock);
    Select.add(blockverticala);
    Select.add(blockverticalb);
    Select.add(blockhorizontal);
    Move.add(moveleft);
    Move.add(moveright);
    Move.add(moveup);
    Move.add(movedown);

    Level1.addActionListener(new ActionListener()
    {   
        public void actionPerformed(ActionEvent event)
        {
            final LoadingPictures levelpics = new LoadingPictures(1);

            add(levelpics);
            repaint();


            if(redBlock.isSelected())
            {
                moveright.addActionListener(new ActionListener()
                {   
                    public void actionPerformed(ActionEvent right)
                    {
                        //if(right.getSource() = moveright)
                        LoadingPictures.top+=50;

                        levelpics.repaint();
                    }});
            }

            else if(blockverticala.isSelected())
            {
                moveright.addActionListener(new ActionListener()
                {   
                    public void actionPerformed(ActionEvent right)
                    {

                    }});
            }

            else if(blockverticalb.isSelected())
            {
                moveright.addActionListener(new ActionListener()
                {   
                    public void actionPerformed(ActionEvent right)
                    {

                    }});
            }
            if(blockhorizontal.isSelected())
            {
                moveright.addActionListener(new ActionListener()
                {   
                    public void actionPerformed(ActionEvent right)
                    {

                    }});
            }


            black.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    levelpics.setBackground(Color.black);

                }});
            blue.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    levelpics.setBackground(Color.blue);

                }});
            yellow.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    levelpics.setBackground(Color.yellow);

                }});
            green.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    levelpics.setBackground(Color.green);

                }});
            white.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    levelpics.setBackground(Color.white);

                }});


            }


    });






    info.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event)
        {   
            JOptionPane.showMessageDialog(null,"•This is our Final project for computer programming 3 \n" +
                                            "•Created by Jon Eagle and Nick Bonaventure\n•Based off of the " +
                                            "game by KIRA GAmes called UnBlock Me");
                        }});


}

}

    