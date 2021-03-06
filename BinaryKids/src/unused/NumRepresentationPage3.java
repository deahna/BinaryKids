package unused;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

import tutorial.WelcomePage;

import java.awt.*; 
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
3.	representations of numbers (decimal, roman numeral, blocks) how theyre used
4.	one system of numbers you might not be familiar with is binary, which we�re going to teach you
*/

public class NumRepresentationPage3 extends JPanel
{

	public Image titleImage;
	
	private Timer timer;
	private int DELAY = 1000;
	
	String explanation1 = "Binary numbers are important for computers and electronics";
	String explanation2 = "Binary numbers are made up of only 0s or 1s";
	String explanation3 = "The word 'Binary' comes from the root 'bi-' meaning 2.";
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
			
    
    public NumRepresentationPage3(WelcomePage welcome)
    {
    	welcomePage = welcome;

    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();
    	
    	
    	setVisible(true);
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(titleImage, 45, 10, this);
    	
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 40, 100);
    	g.drawString(explanation2, 40, 200);
    	g.drawString(explanation3, 40, 300);
    	


    }
    
    
    public void loadImages()
    {
		titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whatBinaryTitlePath)); 
		titleImage = titleImage.getScaledInstance(673, 50, Image.SCALE_SMOOTH);
		
	
    }


}
