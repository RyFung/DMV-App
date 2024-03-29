package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame{
	
	private JPanel mainPanel;
	private String data; //Info to be returned, can add more private fields if data needs to be separated
	
	//private float cost; //To possibly keep track of registration costs?
	
	public Window() {
    	//setting size and dimensions of the window
    	
        setTitle("DMV App");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
        
        start();
        
    }
	public void start(){ //Opening buttons choosing License or Registration
		mainPanel = new JPanel(new BorderLayout()); //Choosing layout design
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Border spacing for window
        
        //Title/Header text? Could remove or change later
        JLabel welcomeLabel = new JLabel("DMV App");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(welcomeLabel, BorderLayout.NORTH); //Displays message based on welcomeLabel

        //Initial buttons
        JButton licenseButton = new JButton("License");
        JButton registerButton = new JButton("Registration");
        
        mainPanel.add(licenseButton, BorderLayout.LINE_START); //Adds button to left side of window
        mainPanel.add(registerButton, BorderLayout.LINE_END); //Adds button to right side of window
        
        licenseButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        registerButton.setPreferredSize(new Dimension(325,800));
        
        
        licenseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                license(); //Running next part of tree
            }
        });
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                registration(); //Running next part of tree
            }
        });
        
        add(mainPanel); //Adds JPanel to window
        
        revalidate(); 
        repaint(); //Updates visuals
	}
	
	public void license(){ //Begins License tree
	
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton newButton = new JButton("Register New License");
	    JButton reNewButton = new JButton("Renew License");
	        
	    mainPanel.add(newButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(reNewButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    newButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        reNewButton.setPreferredSize(new Dimension(325,800));
        
        
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                newLicense(); //Running next part of tree
            }
        });
        
        reNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                reNewLicense(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	public void newLicense(){
		//Code here
	}
	
	public void reNewLicense(){
		//Code here
	}
	
	public void registration(){ //Begins Registration tree
		
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton newButton = new JButton("Register New Vehicle");
	    JButton reNewButton = new JButton("Renew Registration");
	        
	    mainPanel.add(newButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(reNewButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    newButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        reNewButton.setPreferredSize(new Dimension(325,800));
        
        
        newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                newRegistration(); //Running next part of tree
            }
        });
        
        reNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                reNewRegistration(); //Running next part of tree
            }
        });
	    
		revalidate();
		repaint();
	}
	
	public void newRegistration(){
		//Code here
	}
	
	public void reNewRegistration(){
		//Code here
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
}
