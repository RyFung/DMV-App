package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Window extends JFrame{
	
	//Panel used to add buttons and text boxes
	private JPanel mainPanel;
	
	//Fields used to store info between methods, keeps data changes as we move through tree
	private String data = "";
	private float numbers = 0;
	
	public Window() { //Creates window and icon then runs starting code
    	//setting size and dimensions of the window
    	
        setTitle("UI Demo"); //Sets window title
        setSize(700, 800); //Changes dimensions of window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ends window when closed instead of hiding it

        //Sets Icon for window
        ImageIcon icon = new ImageIcon(getClass().getResource("SuperEarthLogo.png")); //Takes given png in file
        setIconImage(icon.getImage()); //Applies image to window icon
        
        start(); //Runs starting code
        
    }
	
	//Creating methods
	public void start(){ //public void method, parameters may be determined if temp values need to be passed along for a few steps then discarded
		//JPanel layouts
		
		//Creating JPanel BorderLayout
		mainPanel = new JPanel(new BorderLayout()); //Choosing layout design, look into types of JPanel Layouts to decide most fitting design
		
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Border spacing for window
        
        
        
        //Creating Display Text
        JLabel welcomeHead = new JLabel("SUPER EARTH: JOIN THE HELLDIVERS"); //JLabel parameters determine displayed text
        welcomeHead.setHorizontalAlignment(SwingConstants.CENTER); //Modifies horizontal position that text starts at, only accepts left center right leading trailing
        mainPanel.add(welcomeHead, BorderLayout.NORTH); //Displays message based on welcomeLabel, adds label to specified layout position
        welcomeHead.setPreferredSize(new Dimension(700,20)); //Changes size of text box NOT text, based on dimension(width,height)

        //html tags required to display new lines on single label. <html> starts string, </html> ends string, <br> notes new line
        JLabel welcomeComment = new JLabel("<html>PROVE TO YOURSELF THAT YOU HAVE THE STRENGTH AND THE COURAGE TO BE FREE.<br>BECOME PART OF AN ELITE PEACEKEEPING FORCE! SEE EXOTIC NEW LIFEFORMS.<br>AND SPREAD MANAGED DEMOCRACY THROUGHOUT THE GALAXY!</html>");
        welcomeComment.setHorizontalAlignment(SwingConstants.LEADING); 
        mainPanel.add(welcomeComment, BorderLayout.SOUTH);
        welcomeComment.setPreferredSize(new Dimension(700,60));
        
       

        //Creating Buttons
        JButton encourageButton = new JButton("ENCOURAGE"); //Text displayed on button based on given String parameter
        mainPanel.add(encourageButton, BorderLayout.LINE_START); //Adds button to left side of window
        encourageButton.setPreferredSize(new Dimension(125,800)); //Modifies size of button (width, height), height overwritten by panel layout for LINE_START, CENTER, and LINE_END so only width changes
        
        //Assigning Code run when button pressed
        encourageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Code inside is run, can not see variables outside of it unless private or public
            	
            	String encouragement;
            	int val = (int)(Math.random() * 3);
            	switch(val)
            	{
            	case 0:
            		encouragement = "Liberty";
            		break;
            		
            	case 1:
            		encouragement = "Democracy";
            		break;
            		
            	case 2:
            		encouragement = "Freedom";
            		break;
            		
            	case 3:
            		encouragement = "Prosperity";
            		break;
            	
            	default:
            		encouragement = "Why Not";
            		break;
            	}
            	
            	data = data + "Encouragment Received: " +encouragement+"\n"; //Private variables can be changed and used for current and other methods
                System.out.println(data);
            }
        });
        
        
        JButton joinButton = new JButton("JOIN THE HELLDIVERS");
        JButton terminateButton = new JButton("TERMINATE");
        
        mainPanel.add(joinButton, BorderLayout.CENTER); //Center auto sizes fit to fill center without gaps aside from window border
        mainPanel.add(terminateButton, BorderLayout.LINE_END);
        
        terminateButton.setPreferredSize(new Dimension(125,800));
        
        //Changing to new Buttons from a button
        joinButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		data = data + "HellDiver:\n";
        		System.out.println("Welcome to the HellDivers");
        		
        		program(); //Runs next method that remakes panel with new buttons
        	}
        });
        
        terminateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	data = "";
                System.out.println("REPLACEMENT INCOMING");
                
            }
        });
        
        add(mainPanel); //Adds JPanel to window
        
        revalidate(); 
        repaint(); //Updates visuals
	}
	
	
	
	//Transitioning from Methods
	//Transitioning to same layout type
	public void program(){ //Method run after pressing joinButton
		
		mainPanel.removeAll(); //Empties panel for new buttons
		
		//WIP TBD, will add further examples later
		
		
		
		
		 JButton licenseButton = new JButton("License");
	        JButton register1Button = new JButton("Registration");
	        
	        mainPanel.add(licenseButton, BorderLayout.LINE_START); //Adds button to left side of window
	        mainPanel.add(register1Button, BorderLayout.LINE_END); //Adds button to right side of window
		
		/*
		mainPanel = new JPanel(new GridLayout(4,2));
		
		JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(new JLabel());
        mainPanel.add(loginButton);
        mainPanel.add(new JLabel());
        mainPanel.add(registerButton);
		
        add(mainPanel); //Adds panel back to window 
        */
		revalidate();
		repaint(); //Updates visuals
	}
	
	
	
	
	
	
	
	//Exe initially run
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { //Occurs when run
                new Window().setVisible(true); //Creates window based on Window() and makes window visible
            }
        });
    }
}
