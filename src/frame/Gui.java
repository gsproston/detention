package frame;
//author Tom
//Import packages
// 08-07-12
import javax.swing.*;
//ImageIcon needs to be input or find a way for the background to be placed
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class Gui extends JFrame{
    //@param args the command line arguments
    //declare swing components to be used
  static JFrame frame;
  static Container pane;
  static JButton btnStart,btnExit;
  static JButton btnlevel1,btnlevel2,btnlevel3,btnlevel4,btnlevel5,btnlevel6,btnlevel7,btnlevel8,btnlevel9,btnlevel10,btnlevel11,btnlevel12,btnlevel13,btnlevel14,btnlevel15;
  static JLabel lblTitle;
  static Insets insets;
  static boolean start = false;
  public Gui() {
	add(new Board());
        setTitle("Detention");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200,100,960,480);
        setVisible(true);
        setResizable(false);
  }
    public static void main(String[] args) {
        // TODO code application logic here
        //Set Look and Feel
        if (start == true) {
            new Gui();
        }
        try 
        {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
    //Create the frame
        frame = new JFrame ("Detention");
        
        //Set its place and size
        frame.setBounds(200,100,960,480);
        //Prepare panel
        pane = frame.getContentPane();
        insets = pane.getInsets();
        //Apply the null layout
        pane.setLayout (null);
        lblTitle = new JLabel ("Detention");
        //setting font because the JFrame is so large :P
        lblTitle.setFont(new Font("sansserif",Font.BOLD, 36));
        btnStart = new JButton ("Start");
        btnStart.setFont(new Font("sansserif",Font.PLAIN,20));
        btnExit = new JButton ("Quit");
        btnExit.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel1 = new JButton (" Level  1");
        btnlevel1.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel2 = new JButton (" Level  2");
        btnlevel2.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel3 = new JButton (" Level  3");
        btnlevel3.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel4 = new JButton (" Level  4");
        btnlevel4.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel5 = new JButton (" Level  5");
        btnlevel5.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel6 = new JButton (" Level  6");
        btnlevel6.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel7 = new JButton (" Level  7");
        btnlevel7.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel8 = new JButton (" Level  8");
        btnlevel8.setFont(new Font("sansserif",Font.PLAIN,20));
        btnlevel9 = new JButton (" Level  9");
        btnlevel9.setFont(new Font("sansserif",Font.PLAIN,20));
	btnlevel10 = new JButton ("Level 10");
        btnlevel10.setFont(new Font("sansserif",Font.PLAIN,20));
	btnlevel11 = new JButton ("Level 11");
        btnlevel11.setFont(new Font("sansserif",Font.PLAIN,20));
	btnlevel12 = new JButton ("Level 12");
        btnlevel12.setFont(new Font("sansserif",Font.PLAIN,20));
	btnlevel13 = new JButton ("Level 13");
        btnlevel13.setFont(new Font("sansserif",Font.PLAIN,20));
	btnlevel14 = new JButton ("Level 14");
        btnlevel14.setFont(new Font("sansserif",Font.PLAIN,20));
	btnlevel15 = new JButton ("Level 15");
        btnlevel15.setFont(new Font("sansserif",Font.PLAIN,20));
//Add all components to panel
pane.add (lblTitle);
pane.add (btnStart);
pane.add (btnExit);
pane.add (btnlevel1);
pane.add (btnlevel2);
pane.add (btnlevel3);
pane.add (btnlevel4);
pane.add (btnlevel5);
pane.add (btnlevel6);
pane.add (btnlevel7);
pane.add (btnlevel8);
pane.add (btnlevel9);
pane.add (btnlevel10);
pane.add (btnlevel11);
pane.add (btnlevel12);
pane.add (btnlevel13);
pane.add (btnlevel14);
pane.add (btnlevel15);


//Place all components on the JFrame in certain locations
//allows the buttons to be placed around the JFrame
lblTitle.setBounds (insets.left + 420, insets.top + 25, lblTitle.getPreferredSize().width, lblTitle.getPreferredSize().height);
btnStart.setBounds (insets.left + 462, lblTitle.getY() + lblTitle.getHeight() + 30, btnStart.getPreferredSize().width, btnStart.getPreferredSize().height);
btnExit.setBounds (insets.left + 465, btnStart.getY() + btnStart.getHeight() + 10,btnExit.getPreferredSize().width, btnExit.getPreferredSize().height);
btnlevel1.setBounds (insets.left + 333, btnExit.getY() + btnExit.getHeight() + 20,btnlevel1.getPreferredSize().width, btnlevel1.getPreferredSize().height);
btnlevel2.setBounds (btnlevel1.getX() + btnlevel1.getWidth() + 5, insets.top = btnlevel1.getY(), btnlevel2.getPreferredSize().width, btnlevel2.getPreferredSize().height);
btnlevel3.setBounds (btnlevel2.getX() + btnlevel2.getWidth() + 5, insets.top = btnlevel1.getY(), btnlevel3.getPreferredSize().width, btnlevel3.getPreferredSize().height);
btnlevel4.setBounds (insets.left + 333, btnlevel1.getY() + btnlevel1.getHeight() + 5,btnlevel4.getPreferredSize().width, btnlevel4.getPreferredSize().height);
btnlevel5.setBounds (btnlevel4.getX() + btnlevel4.getWidth() + 5, insets.top = btnlevel4.getY(), btnlevel5.getPreferredSize().width, btnlevel5.getPreferredSize().height);
btnlevel6.setBounds (btnlevel5.getX() + btnlevel5.getWidth() + 5, insets.top = btnlevel4.getY(), btnlevel6.getPreferredSize().width, btnlevel6.getPreferredSize().height);
btnlevel7.setBounds (insets.left + 333, btnlevel4.getY() + btnlevel4.getHeight() + 5, btnlevel7.getPreferredSize().width, btnlevel7.getPreferredSize().height);
btnlevel8.setBounds (btnlevel7.getX() + btnlevel7.getWidth() + 5, insets.top = btnlevel7.getY(), btnlevel8.getPreferredSize().width, btnlevel8.getPreferredSize().height);
btnlevel9.setBounds (btnlevel8.getX() + btnlevel8.getWidth() +5, insets.top = btnlevel7.getY(), btnlevel9.getPreferredSize().width, btnlevel9.getPreferredSize().height);
btnlevel10.setBounds (insets.left + 333, btnlevel7.getY() + btnlevel7.getHeight() + 5, btnlevel10.getPreferredSize().width, btnlevel10.getPreferredSize().height);
btnlevel11.setBounds (btnlevel10.getX() + btnlevel10.getWidth() + 5, insets.top = btnlevel10.getY(), btnlevel11.getPreferredSize().width, btnlevel11.getPreferredSize().height);
btnlevel12.setBounds (btnlevel11.getX() + btnlevel11.getWidth() + 5, insets.top = btnlevel10.getY(), btnlevel12.getPreferredSize().width, btnlevel12.getPreferredSize().height);
btnlevel13.setBounds (insets.left + 333, btnlevel10.getY() + btnlevel10.getHeight() + 5, btnlevel13.getPreferredSize().width, btnlevel13.getPreferredSize().height);
btnlevel14.setBounds (btnlevel13.getX() + btnlevel13.getWidth() + 5, insets.top = btnlevel13.getY(), btnlevel14.getPreferredSize().width, btnlevel14.getPreferredSize().height);
btnlevel15.setBounds (btnlevel14.getX() + btnlevel14.getWidth() + 5, insets.top = btnlevel13.getY(), btnlevel15.getPreferredSize().width, btnlevel15.getPreferredSize().height);

// set the visibility ... if unset, the JFrame will not pop up when the program is run 
frame.setVisible (true);

    //Button's action
// first block is just adding them
// after them is the individual button actions
        btnExit.addActionListener(new btnExitAction());
        btnStart.addActionListener(new btnStartAction());
        btnlevel1.addActionListener(new btnlevel1Action());
        btnlevel2.addActionListener(new btnlevel2Action());
        btnlevel3.addActionListener(new btnlevel3Action());
        btnlevel4.addActionListener(new btnlevel4Action());
        btnlevel5.addActionListener(new btnlevel5Action());
        btnlevel6.addActionListener(new btnlevel6Action());
        btnlevel7.addActionListener(new btnlevel7Action());
        btnlevel8.addActionListener(new btnlevel8Action());
        btnlevel9.addActionListener(new btnlevel9Action());
	btnlevel10.addActionListener(new btnlevel10Action());
	btnlevel11.addActionListener(new btnlevel11Action());
	btnlevel12.addActionListener(new btnlevel12Action());
	btnlevel13.addActionListener(new btnlevel13Action());
	btnlevel14.addActionListener(new btnlevel14Action());
	btnlevel15.addActionListener(new btnlevel15Action());
    }
   // below are the actions for the buttons - they currently just close the window
    public static class btnExitAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
    public static class btnStartAction implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            start = true;
            new Gui();
        }
    }
    public static class btnlevel1Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 1;
            start = true;
            new Gui();
        }
    }    
    public static class btnlevel2Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 2;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel3Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 3;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel4Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 4;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel5Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 5;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel6Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 6;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel7Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 7;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel8Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 8;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel9Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 9;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel10Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 10;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel11Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 11;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel12Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 12;
            start = true;
            new Gui();
        }
    }

    public static class btnlevel13Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 13;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel14Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 14;
            start = true;
            new Gui();
        }
    }
    public static class btnlevel15Action implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Global.level = 15;
            start = true;
            new Gui();
        }
    }
}



