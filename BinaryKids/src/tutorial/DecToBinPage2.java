package tutorial;

import javax.imageio.ImageIO;
import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class DecToBinPage2 extends JPanel implements MouseListener
{

	WelcomePage welcomePage;
	JButton DecToBinSubmit; 
	JLabel DecToBinNumSquaresText;
	JLabel TextTens;
	JLabel TextOnes;

	final int DecToBinNumSquaresActual = 11;
	int DecToBinNumSquaresInput;
	private ImageIcon boxIcon;
	private Image img;
	private Rectangle rec;

	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;

	// The coordinates of the 10's rectangle and 1s rectangle 
	int box10x, box10y, box10width, box10height;
	int box1x, box1y, box1width, box1height;

	boolean rect1Clicked;
	boolean rect2Clicked;
	int rectSelectedNum = 0;

	boolean clickOrMove = true;
	boolean boxSelected10 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;

	final int rectUnit = 30;

	ArrayList<Image> imgList = new ArrayList<>();
	ArrayList<Rectangle> recList = new ArrayList<>();

	public DecToBinPage2(WelcomePage welcome)
	{
		welcomePage = welcome;

		int startx = 60;
		int starty = 100;
		
		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("Let's do an example!");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel);
		titlePanel.setBorder(new LineBorder(Color.BLACK)); 

		for (int i = 0; i < DecToBinNumSquaresActual; i++){
			//g.drawImage(img, startx, starty, this);

			rec = new Rectangle(startx, starty, rectUnit,rectUnit);
			recList.add(rec);
			startx+=40;
		}

		DecToBinSubmit = new JButton("Next Page"); 
		DecToBinNumSquaresText = new JLabel("How do we get the number 11?");


		//Add action listeners for the buttons. 
		DecToBinSubmit.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent le) {  


			}      
		});      


//		String obstImgFileName = "C:\\Users\\Christopher\\Documents\\Senior\\Adv_Prog\\proj2\\fire.png";
//		//try to load the image file
//		try {
//			boxIcon = new ImageIcon(ImageIO.read(new File(obstImgFileName)));
//		} catch (IOException e) {
//			System.out.println("Please check obstacle image file path.");
//			e.printStackTrace();
//		};
//
//		img = boxIcon.getImage();
//		img = img.getScaledInstance(rectUnit, rectUnit, Image.SCALE_SMOOTH);
//		for (int i = 0; i < 11; i++){
//			imgList.add(img);
//		}

		TextTens = new JLabel("10s");
		TextOnes = new JLabel("1s");

		add(titlePanel);
		add(DecToBinNumSquaresText);
		add(DecToBinSubmit);
		add(TextTens);
		add(TextOnes);

		// Assign values to the rectanagle coordinates. 
		box10x = 60; 
		box10y = 160; 
		box10width = 200; 
		box10height = 400;

		// Assign values to the rectanagle coordinates. 
		box1x = 300; 
		box1y = 160; 
		box1width= 200; 
		box1height = 400;

		// Add the MouseListener to your applet 
		addMouseListener(this); 


	}

	public void paint(Graphics g) {
		super.paint(g);
		//drawBoxes(DecToBinNumSquaresActual, g);
		if (boxSelected1)
			g.setColor(Color.RED);
		g.drawRect(box1x,box1y,box1width,box1height);
		g.setColor(Color.BLACK);
		if (boxSelected10)
			g.setColor(Color.RED);
		g.drawRect(box10x,box10y,box10width,box10height);
		//Graphics2D g2d = (Graphics2D) g.create();
		g.setColor(Color.BLACK);
		for (int i = 0;i < recList.size(); i++){
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}
	}

//	private void drawBoxes(int numBoxes, Graphics g){
//		
//		for (int i = 0; i < numBoxes; i++){
//			//g.drawImage(img, startx, starty, this);
//
//			rec = new Rectangle(startx, starty, rectUnit,rectUnit);
//			recList.add(rec);
//			startx+=40;
//		}	  
//	}

	// This method will be called when the mouse has been clicked. 
	public void mouseClicked (MouseEvent me) 
	{

		// Save the coordinates of the click lke this.
		xpos = me.getX(); 
		ypos = me.getY();


		//select one of the rectangles first
		for (int i = 0; i < recList.size(); i++){
			int recx = (int) recList.get(i).getX();
			int recy = (int) recList.get(i).getY();
			if ((xpos >= recx) && (xpos <= (recx + rectUnit)) && (ypos >= recy) && (ypos <= (recy + rectUnit))){
				rectSelected = true;
				rectSelectedNum = i;
				break;
			} 
			

		}
		
		if(rectSelected)
		{
			if((xpos >= box10x) && (xpos <= (box10x + box10width)) && (ypos >= box10y) && (ypos <= (box10y + box10height)))
			{
				boxSelected10 = true;
				boxSelected1 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
				//imgList.get(rectSelectedNum).
				
			}
			else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
			{
				boxSelected1 = true;
				boxSelected10 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
				
			}
			else {
				boxSelected10 = false;
				boxSelected1 = false;
			}

		}




		//show the results of the click 
		repaint();

	}


	// When it has been released 
	// note that a click also calls these Mouse-Pressed and Released. 
	// since they are empty nothing hapens here. 
	public void mouseReleased (MouseEvent me) {} 

	// This is called when the mous has been pressed 
	public void mousePressed (MouseEvent me) {}

	// This is executed when the mouse enters the applet. it will only 
	// be executed again when the mouse has left and then re-entered. 
	public void mouseEntered (MouseEvent me) {}

	// When the Mouse leaves the applet. 
	public void mouseExited (MouseEvent me) {} 

	public void mouseMoved(MouseEvent me){}

	public void mouseDragged(MouseEvent me) {}


} //end class
