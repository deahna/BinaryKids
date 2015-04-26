package tutorial;


import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*; 
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;




@SuppressWarnings("serial")
public class WelcomePage extends JApplet
{

	WelcomePage welcome = this;

	int pageFlag = 0;

	private int frameWidth = 800;
	private int frameHeight = 620;
	
	//new colors
	public static Color backgroundColor = new Color(255, 255, 204);
	public static Color buttonPanelColor = new Color(152, 46, 68);
	public static Color textColor = new Color(0, 0, 0);
	public static Color headersColor = new Color(255,102,102);

	private StartPage startPage;
	private FirstPage firstPage;
	private SecondPage secondPage;
	private ThirdPage thirdPage;
	private FourthPage fourthPage;
	BinaryDecimalOne bdOne;
	private BinaryDecimalTwo bdTwo;
	private BinaryDecimalThree bdThree;
	private BinaryDecimalFour bdFour;
	private DecToBinPage decToBinPage;
	private DecToBinPage2 decToBinPage2;
	private DecToBinPage3 decToBinPage3;
	private DecToBinPage4 decToBinPage4;
	private BinaryAddOne baOne;
	private DemoPage demoPage;

	JPanel buttonPanel;
	JButton nextButton;
	JButton closeButton;
	JButton tutorialButton;
	JButton debugButton;
	JButton gameButton; //only become available once completed tutorials
	JButton page3GoBackButton;
	JButton backToHomeButton;

	Container contentPane;

	private String userName = "";
	private String userAnswer = "";

	public static String titlePath = "images/titleTextImage.jpg";
	public static String titleImagePath = "images/titleImage.jpg";
	public static String lightOnImagePath = "images/lightOn.jpg";
	public static String lightOffImagePath = "images/lightOff.jpg";
	public static String binDecPg3TitleImagePath = "images/BinDecPg3Title.jpg";
	public Image titleImg;  //http://www.cs.colostate.edu/~boese/Geek/binaryCalculator.gif
	public Image lightOnImg;
	public Image lightOffImg;
	public Image titleTextImg;
	public Image binDec3TitleImg;

	//meghan's added images
    	public static String welcomeToBKPath = "images/welcomeToBKTitle.jpg";
    	public Image titleHeadline;
   	public Image binaryGraphic;


	    
    //num representation page images
    public static String binaryImageLightPath = “images/binaryLight.jpg";
    public static String binaryImageDarkPath = "images/binaryDark.jpg";
    public static String decimalImagePath = "images/decimal.jpg";
    public static String romanNumeralImagePath = "images/romanNumeral.jpg";
    public static String shapesImagePath = "images/shapes.jpg";
    public static String numRepTitlePath = "images/numRepPageTitle.jpg";
    public static String soccerBallPath = "images/soccerBall.jpg";
    
    
    //what are binary numbers page
    public static String whatBinaryTitlePath = "images/whatBinaryTitle.jpg";
    public static String dogBinaryImagePath = "images/dogBinary.gif";
    public static String bikeImagePath = "images/bicycle.png";
    public static String binocularsPath = "images/binoculars.png";
    
    //why binary numbers important page
    public static String whyBinaryImportantTitlePath = "images/thirdPageTitle.jpg";
    public static String instagramPath = "images/instagram.png";
    public static String fbPath = "images/fb.png";
    public static String youtubePath = "images/youtube.png";
    public static String emailPath = "images/gmail.png";
    public static String skypePath = "images/skype.png";
    public static String gamePath = "images/game.png";
    public static String cellPath = "images/cellPhone.png";
    public static String lightOffPath = "images/realLightOff.png";
    public static String lightOnPath = "images/realLightOn.png";
    public static String binaryDigitPath = "images/binaryDigit.gif";
    
    //dec number basics/bin num basics images
    public static String decBasicsPath = "images/decNumBasics.jpg";
    public static String crossOutPath = "images/crossOut.png";
    public static String binBasicsPath = "images/binNumBasics.jpg";
    
    //demo page images
    public static String puttingTogetherPath = "images/puttingAllTogether.jpg";
    

	//Called when this applet is loaded into the browser.
	public void init() 
	{
		//Execute a job on the event-dispatching thread; creating this applet's GUI.
		try {
			SwingUtilities.invokeAndWait(new Runnable() 
			{
				public void run() 
				{
					createGUI();
				}
			});
		} 
		catch (Exception e) 
		{ 
			System.err.println("createGUI didn't complete successfully");
			e.printStackTrace();
		}
	}


	/*
	 * Create the GUI. For thread safety, this method should
	 * be invoked from the event-dispatching thread.
	 */
	private void createGUI() 
	{

		//initializaing all of the components of the tutorial
		contentPane = getContentPane();
		startPage = new StartPage(this);
		firstPage = new FirstPage(this);
		secondPage = new SecondPage(this);
		thirdPage = new ThirdPage(this);
		fourthPage = new FourthPage(this);
		bdOne = new BinaryDecimalOne(this);
		bdTwo = new BinaryDecimalTwo(this);
		bdThree = new BinaryDecimalThree(this);
		bdFour = new BinaryDecimalFour(this);
		decToBinPage = new DecToBinPage(this);
		decToBinPage2 = new DecToBinPage2(this);
		decToBinPage3 = new DecToBinPage3(this);
		decToBinPage4 = new DecToBinPage4(this);
		baOne = new BinaryAddOne(this);
		demoPage = new DemoPage(this);

		//dialog box welcomes user to game and gives them brief instructions
		//String welcomeMessage = "Welcome to BinaryKids: Type in your name and click next to get started!";
		//JOptionPane.showMessageDialog(this, welcomeMessage, "Welcome to BinaryKids", JOptionPane.YES_NO_OPTION);

		//set up the panel of buttons that is always visible
		createButtonPanel();

		//Create and set up the content pane.
		setLayout(new BorderLayout()); 
		//add(startPage, BorderLayout.CENTER);
		add(startPage, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.NORTH); //add buttonPanel to the top of game frame


		loadImages();

		// Setup the applet
		getContentPane().setBackground(backgroundColor);
		setName("BinaryKids");
		setSize(frameWidth, frameHeight);
		setVisible(true);

	}  

	public void loadImages(){

		titleImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.titleImagePath));
		titleImg = titleImg.getScaledInstance(550, 300, Image.SCALE_SMOOTH);

		lightOnImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOnImagePath));

		lightOnImg = lightOnImg.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		lightOffImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOffImagePath));
		lightOffImg = lightOnImg.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		titleTextImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.titlePath));
		titleTextImg = titleTextImg.getScaledInstance(700, 40, Image.SCALE_SMOOTH);
		binDec3TitleImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binDecPg3TitleImagePath));  
		binDec3TitleImg = binDec3TitleImg.getScaledInstance(650, 50, Image.SCALE_SMOOTH);
		
		titleHeadline = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.welcomeToBKPath)); 
		titleHeadline = titleHeadline.getScaledInstance(586, 50, Image.SCALE_SMOOTH);
		
		//try to load the image file
		try {
			binaryGraphic = new ImageIcon(new URL("http://media.giphy.com/media/nlJF31X6I1LW/giphy.gif")).getImage();

		} catch (IOException e) {
			System.out.println("Please check image file path.");
			e.printStackTrace();
		};
		binaryGraphic = binaryGraphic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	}

	public void createButtonPanel()
	{
		//creates a close button to allow user to exit whenever
		closeButton = new JButton("Close");
		closeButton.addActionListener(new closeButtonListener());

		debugButton = new JButton("Debug");
		debugButton.addActionListener(new debugButtonListener());

		nextButton = new JButton("NextPage");
		nextButton.addActionListener(new nextButtonListener());

		tutorialButton = new JButton("Tutorials");
		tutorialButton.addActionListener(new tutorialButtonListener());

		gameButton = new JButton("Play Game");
		gameButton.addActionListener(new gameButtonListener());

		page3GoBackButton = new JButton("Go back");
		page3GoBackButton.addActionListener(new backButtonListener());

  		backToHomeButton = new JButton("Back to Home");
  		backToHomeButton.addActionListener(new backHomeButtonListener());

		//buttons panel that holds close button
		buttonPanel = new JPanel();
		buttonPanel.setBackground(WelcomePage.buttonPanelColor);
		buttonPanel.add(backToHomeButton);
		buttonPanel.add(closeButton); //add button to the buttonPanel
		buttonPanel.add(debugButton);

	}


	public void paint(Graphics g) 
	{     	
		super.paint(g);

	}





	/* gameOver - 
	 * When the game comes to an end, show a dialog box that says it is over 
	 * and shows the score before exiting.
	 */
	public void gameOver() 
	{
		String message = "Thanks for learning!";
		JOptionPane.showMessageDialog(this, message, "Close tutorial?", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}


	/* closeButtonListener- 
	 * Create a new custom listener that is an inner class
	 * to handle when user clicks close button
	 */
	class closeButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			gameOver();
		}
	}


	public void loadNewTutorial(String tutorialType)
	{
		contentPane.remove(fourthPage);
		contentPane.remove(demoPage);
		if (tutorialType.equals("DECBIN"))
		{
			contentPane.add(decToBinPage, BorderLayout.CENTER);
		}
		else if (tutorialType.equals("BINDEC"))
		{
			contentPane.add(bdOne, BorderLayout.CENTER);
		}
		else {
			System.out.println("still need to implement other tutorial pages");
		}


		validate();
		setVisible(true);
		repaint();
	}

	public void loadDecBin2()
	{
		contentPane.remove(decToBinPage);
		decToBinPage2 = new DecToBinPage2(welcome);
		contentPane.add(decToBinPage2, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadDecBin3()
	{
		contentPane.remove(decToBinPage2);
		decToBinPage3 = new DecToBinPage3(welcome);
		contentPane.add(decToBinPage3, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadDecBin4()
	{
		contentPane.remove(decToBinPage3);
		decToBinPage4 = new DecToBinPage4(welcome);
		contentPane.add(decToBinPage4, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}



	public void decToBinTutorial()
	{
		contentPane.remove(fourthPage);
		decToBinPage = new DecToBinPage(welcome);
		contentPane.add(decToBinPage, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void binToDecTutorial()
	{
		contentPane.remove(fourthPage);
		bdOne = new BinaryDecimalOne(welcome);
		contentPane.add(bdOne, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadBinToDec2()
	{
		contentPane.remove(bdOne);
		bdTwo = new BinaryDecimalTwo(welcome);
		contentPane.add(bdTwo, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadBinToDec3()
	{
		contentPane.remove(bdTwo);
		bdThree = new BinaryDecimalThree(welcome);
		contentPane.add(bdThree, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadBinToDec4()
	{
		contentPane.remove(bdThree);
		bdFour = new BinaryDecimalFour(welcome);
		contentPane.add(bdFour, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void binAddTutorial()
	{
		contentPane.remove(fourthPage);
		baOne = new BinaryAddOne(this);
		contentPane.add(baOne, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadFirstPage()
	{
		contentPane.remove(startPage);
		firstPage = new FirstPage(welcome);
		contentPane.add(firstPage, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadSecondPage()
	{
		contentPane.remove(firstPage);
		secondPage = new SecondPage(welcome);
		contentPane.add(secondPage, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void setUserName(String name)
	{
		userName = name;
	}

	public String getUserName()
	{
		return userName;
	}


	public void setUserAnswer(String answer)
	{
		userAnswer = answer;
	}

	public String getUserAnswer()
	{
		return userAnswer;
	}

	class tutorialButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(firstPage);
			contentPane.remove(secondPage);
			contentPane.remove(thirdPage);
			contentPane.remove(fourthPage);
			contentPane.remove(bdOne);
			contentPane.remove(bdTwo);
			contentPane.remove(bdThree);
			contentPane.remove(bdFour);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
			contentPane.remove(decToBinPage3);
			contentPane.remove(decToBinPage4);
			contentPane.remove(baOne);
			contentPane.remove(demoPage);
			contentPane.add(fourthPage);
			validate();
			setVisible(true);
			repaint();	
		}
	}

	class backHomeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(startPage);
			contentPane.remove(firstPage);
			contentPane.remove(secondPage);
			contentPane.remove(thirdPage);
			contentPane.remove(fourthPage);
			contentPane.remove(bdOne);
			contentPane.remove(bdTwo);
			contentPane.remove(bdThree);
			contentPane.remove(bdFour);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
			contentPane.remove(decToBinPage3);
			contentPane.remove(decToBinPage4);
			contentPane.remove(baOne);
			contentPane.remove(demoPage);
			
			startPage = new StartPage(welcome);
			contentPane.add(startPage);

			pageFlag = 0;
			
			validate();
	        setVisible(true);
	        repaint();	
		}
	}

	class gameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(thirdPage);
			contentPane.remove(fourthPage);
			contentPane.remove(bdOne);
			contentPane.remove(bdTwo);
			contentPane.remove(bdThree);
			contentPane.remove(bdFour);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
			//contentPane.add(gamePage);
			validate();
			setVisible(true);
			repaint();	
		}
	}

	class backButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(secondPage);
			contentPane.remove(thirdPage);
			contentPane.remove(bdOne);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
			thirdPage = new ThirdPage(welcome);
			contentPane.add(thirdPage);
			validate();
			setVisible(true);
			repaint();	
		}
	}

	class debugButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(startPage);
			contentPane.remove(firstPage);
			contentPane.remove(secondPage);
			contentPane.remove(thirdPage);
			contentPane.remove(fourthPage);
			contentPane.remove(bdOne);
			contentPane.remove(bdTwo);
			contentPane.remove(bdThree);
			contentPane.remove(bdFour);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
			contentPane.remove(decToBinPage3);
			contentPane.remove(decToBinPage4);
			contentPane.remove(baOne);
			contentPane.remove(demoPage);


			contentPane.add(new DecToBinPage2(welcome));

			validate();
			setVisible(true);
			repaint();	
		}
	}

	class nextButtonListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			/*
			if(pageFlag == 0)
			{
				contentPane.remove(startPage);
				firstPage = new FirstPage(welcome);
				contentPane.add(firstPage, BorderLayout.CENTER);
				pageFlag++;

				validate();
		        setVisible(true);
		        repaint();

			}
			else if(pageFlag == 1)
			{
				contentPane.remove(firstPage);
				secondPage = new SecondPage(welcome);
				secondPage.userName = userName;
				secondPage.answer = userAnswer;
				contentPane.add(secondPage, BorderLayout.CENTER);
				pageFlag++;

				validate();
		        setVisible(true);
		        repaint();

			}
			 */
			if(pageFlag == 0)
			{
				contentPane.remove(secondPage);
				contentPane.add(thirdPage, BorderLayout.CENTER);
				if(thirdPage.pageClickedOnce)
				{
					buttonPanel.add(page3GoBackButton);
				}
				pageFlag++;

				validate();
				setVisible(true);
				repaint();
			}
			else if(pageFlag == 1)
			{

				contentPane.remove(thirdPage);
				contentPane.add(demoPage, BorderLayout.CENTER);

				pageFlag++;

				validate();
				setVisible(true);
				repaint();
			}
			else if(pageFlag == 2)
			{

				contentPane.remove(demoPage);
				buttonPanel.remove(nextButton);
				buttonPanel.remove(page3GoBackButton);
				buttonPanel.add(tutorialButton);
				contentPane.add(fourthPage, BorderLayout.CENTER);

				pageFlag++;

				validate();
				setVisible(true);
				repaint();
			}
			else
			{
				//buttonPanel.add(gameButton);
				//gameOver();
			}

		} //end action performed

	} //end class nextButtonListener

} //end class WelcomePage
