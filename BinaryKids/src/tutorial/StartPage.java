package tutorial;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;


@SuppressWarnings("serial")
public class StartPage extends JPanel
{
	Button submitButton;
	TextField nameField;
	JPanel titlePanel;
	JLabel titleLabel;
	boolean nameEntered = false;
	
	private ImageIcon boxIcon;
	private Image img;
	
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
    
    public StartPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	
    	setBackground(WelcomePage.backgroundColor);
    	
    	
    	titlePanel = new JPanel();
    	titleLabel = new JLabel("Welcome to BinaryKids!");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK)); 
    	
    	
    	submitButton = new Button("Submit");
    	nameField = new TextField("Enter your name here");
    	
    	
    	JLabel directionsLabel = new JLabel("This applet will teach you how to use binary. "
    			+ "Then you can play a fun game with the skills you've learned!!");
    	directionsLabel.setFont(new Font("Verdana", 1, 12));
    	
    	
    	submitButton.addActionListener(new nameButtonListener());
    	
    	add(titlePanel);
    	add(directionsLabel);
    	
    	add(nameField);
    	add(submitButton);
    	
    	
    	
		//try to load the image file
		try {
			boxIcon = new ImageIcon(ImageIO.read(new File(WelcomePage.titleImagePath)));
		} catch (IOException e) {
			System.out.println("Please check image file path.");
			e.printStackTrace();
		};
		img = boxIcon.getImage();
		img = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
    	
    	
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);

    	g.setColor(Color.blue);
    	String nameString = "Welcome!!!!!";
    	if(nameEntered)
    		nameString = "Welcome, " + nameField.getText() + "!";

    	g.setFont(new Font("Verdana", 1, 20));
    	g.drawString(nameString, 280,200);
    	
    	g.drawImage(img, 200, 300, this);

    }
    
	class nameButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			welcomePage.setUserName(nameField.getText());
			nameEntered = true;
			repaint();
			
		}
	}
	


}
