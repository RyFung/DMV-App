package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame{
	
	private JPanel mainPanel;
	private int cost = 0; //Info to be returned, can add more private fields if data needs to be separated
	private String vehicle = "";
	private String weight = "";
	
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
	
	public void fail(){ //General invalid method
		mainPanel.removeAll(); //Empties panel for new buttons
		/*
		mainPanel = new JPanel(new BorderLayout()); //Choosing layout design
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); //Border spacing for window
        */
		JLabel exitLabel = new JLabel("Not Elligible for this service");
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        add(mainPanel, BorderLayout.CENTER);
        
        revalidate();
		repaint();
	}
	
	
	//Beginning of License branch
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
	
	
	
	//Beginning of new License branch
	public void newLicense(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("<16yrs");
	    JButton passButton = new JButton("+16yrs");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                stateLicense(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	
	public void stateLicense(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton outButton = new JButton("Out of State");
	    JButton inButton = new JButton("In State");
	        
	    mainPanel.add(outButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(inButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    outButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        inButton.setPreferredSize(new Dimension(325,800));
        
        
        outButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                outState(); //Running next part of tree
            }
        });
        
        inButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                inState(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	public void outState(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("Invalid Resident");
	    JButton passButton = new JButton("Valid Resident");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                interLic(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	public void interLic(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("Invalid Out of State License");
	    JButton passButton = new JButton("Valid Out of State License");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                licType(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	public void licType(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton fedButton = new JButton("Federal License");
	    JButton realButton = new JButton("Real License");
	        
	    mainPanel.add(fedButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(realButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    fedButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        realButton.setPreferredSize(new Dimension(325,800));
        
        
        fedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fedLic(); //Running next part of tree
            }
        });
        
        realButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                realLic(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	public void fedLic(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JLabel exitLabel = new JLabel("<html>Success: Federal ID<br>Cost:$30</html>");
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        revalidate();
		repaint();
	}
	
	public void realLic(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JLabel exitLabel = new JLabel("<html>Success: Real ID<br>Cost:$35</html>");
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        revalidate();
		repaint();
	}
	
	
	public void inState(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("Test Failed");
	    JButton passButton = new JButton("Test Passed");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                licType(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	//Beginning of renew License branch
	public void reNewLicense(){
		
		//Potentially edit to incorporate isExpired method (Grid with textfields)
		
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton susButton = new JButton("Suspended License");
	    JButton actButton = new JButton("Active License");
	        
	    mainPanel.add(susButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(actButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    susButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        actButton.setPreferredSize(new Dimension(325,800));
        
        
        susButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        actButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                licenseType(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	public void licenseType(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton nonCButton = new JButton("Non-Commercial");
	    JButton CButton = new JButton("Commercial");
	        
	    mainPanel.add(nonCButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(CButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    nonCButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        CButton.setPreferredSize(new Dimension(325,800));
        
        
        nonCButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                nonCommercial(); //Running next part of tree
            }
        });
        
        CButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                commercial(); //Running next part of tree
            }
        });
		
		revalidate();
		repaint();
	}
	
	public void nonCommercial(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JLabel exitLabel = new JLabel("<html>Success: Non-Commercial ID<br>Cost:$45</html>");
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        revalidate();
		repaint();
	}
	
	public void commercial(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JLabel exitLabel = new JLabel("<html>Success: Commercial ID<br>Cost:$58</html>");
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        revalidate();
		repaint();
	}
	
	//Beginning of Registration branch
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
	
	
	//Beginning of new Registration branch
	public void newRegistration(){
		mainPanel.removeAll(); //Empties panels for new buttons
		mainPanel = new JPanel(new GridLayout(1,3)); //Sets panel to new layout
		
		
	    JButton dePu = new JButton("Dealership");
       
        JButton moto = new JButton("Motorcycle");
      
        JButton coVe = new JButton("Commercial");
        
        
        mainPanel.add(dePu);
        mainPanel.add(moto);
        mainPanel.add(coVe);
     
        dePu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	vehicle = "Dealership";
                smog(); //Running next part of tree
            }
        });
        
        moto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	vehicle = "Motorcycle";
                motoLic(); //Running next part of tree
            }
        });
        
        coVe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	vehicle = "Commercial";
                weight(); //Running next part of tree
            }
        });
        
        add(mainPanel, BorderLayout.CENTER); //Adds panel back to window 
		
		revalidate();
		repaint();
	}
	
	public void smog(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("Smog Fail");
	    JButton passButton = new JButton("Smog Pass");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                payType(); //Running next part of tree
            }
        });
	    
		revalidate();
		repaint();
	}
	
	
	
	public void motoLic(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("Invalid License");
	    JButton passButton = new JButton("Valid License");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                insurance(); //Running next part of tree
            }
        });
	    
		revalidate();
		repaint();
	}
	
	public void insurance(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("Not Insured");
	    JButton passButton = new JButton("Insured");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                payType(); //Running next part of tree
            }
        });
	    
		revalidate();
		repaint();
	}
	
	public void weight(){
		mainPanel.removeAll(); //Empties panels for new buttons
		mainPanel = new JPanel(new GridLayout(1,3)); //Sets panel to new layout
		
		
	    JButton lowWeight = new JButton("<= 6k lbs");
       
        JButton midWeight = new JButton("6-10k lbs");
      
        JButton highWeight = new JButton("+10k lbs");
        
        
        mainPanel.add(lowWeight);
        mainPanel.add(midWeight);
        mainPanel.add(highWeight);
     
        lowWeight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        midWeight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                haul(); //Running next part of tree
            }
        });
        
        highWeight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	weight = "high";
                payType(); //Running next part of tree
            }
        });
        
        add(mainPanel, BorderLayout.CENTER); //Adds panel back to window 
		
		revalidate();
		repaint();
	}
	
	public void haul(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton noHaulButton = new JButton("Does Not Haul");
	    JButton haulButton = new JButton("Does Haul");
	        
	    mainPanel.add(noHaulButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(haulButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    noHaulButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        haulButton.setPreferredSize(new Dimension(325,800));
        
        
        noHaulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                payType(); //Running next part of tree
            }
        });
        
        haulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	weight = "haul";
                payType(); //Running next part of tree
            }
        });
	    
        add(mainPanel, BorderLayout.CENTER); //Adds panel back to window 
        
		revalidate();
		repaint();
	}
	
	public void payType(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton cashButton = new JButton("Cash Payment");
	    JButton creditButton = new JButton("Credit Payment");
	        
	    mainPanel.add(cashButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(creditButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    cashButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        creditButton.setPreferredSize(new Dimension(325,800));
        
        
        cashButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                cash(); //Running next part of tree
            }
        });
        
        creditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                credit(); //Running next part of tree
            }
        });
	    
        add(mainPanel, BorderLayout.CENTER); //Adds panel back to window 
        
		revalidate();
		repaint();
	}
	
	public void cash(){
		 //newRegFee = (int) ((price * 0.0065) + 80);
		mainPanel.removeAll(); //Empties panels for new buttons
		mainPanel = new JPanel(new GridLayout(2,2)); //Sets panel to new layout
		
		
	    JLabel price = new JLabel("Vehicle Price:");
       
        JTextField vCost = new JTextField();
      
        JButton submitButton = new JButton("Submit");
        
        
        mainPanel.add(price);
        mainPanel.add(vCost);
        mainPanel.add(new JLabel(""));
        mainPanel.add(submitButton);
     
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(weight.equalsIgnoreCase("haul")){
                	cost = (int)((Integer.parseInt(vCost.getText())*0.0066)+80);
                    checkout(); //Running next part of tree
                }
                else if(weight.equalsIgnoreCase("high")){
                	cost = (int)((Integer.parseInt(vCost.getText())*0.0066)+80);
                    checkout(); //Running next part of tree
                } else {
            	cost = (int)((Integer.parseInt(vCost.getText())*0.0065)+80);
                checkout(); //Running next part of tree
                }
            }
        });
        
        revalidate();
        repaint();
	}
	
	public void credit(){
		//newRegFee = (int) ((price * 0.0068) + 80);
		mainPanel.removeAll(); //Empties panels for new buttons
		mainPanel = new JPanel(new GridLayout(2,2)); //Sets panel to new layout
		
		
	    JLabel price = new JLabel("Vehicle Price:");
       
        JTextField vCost = new JTextField();
      
        JButton submitButton = new JButton("Submit");
        
        
        mainPanel.add(price);
        mainPanel.add(vCost);
        mainPanel.add(new JLabel(""));
        mainPanel.add(submitButton);
     
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	if(weight.equalsIgnoreCase("haul")){
                	cost = (int)((Integer.parseInt(vCost.getText())*0.0069)+80);
                    checkout(); //Running next part of tree
                }
                else if(weight.equalsIgnoreCase("high")){
                	cost = (int)((Integer.parseInt(vCost.getText())*0.0069)+80);
                    checkout(); //Running next part of tree
                } else {
            	cost = (int)((Integer.parseInt(vCost.getText())*0.0068)+80);
                checkout(); //Running next part of tree
                }
            }
        });
        
        revalidate();
        repaint();
	}
	
	public void checkout(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JLabel exitLabel = new JLabel("Registration:Complete  Vehicle: "+vehicle+"  Weight: "+weight+"  Cost: $"+cost);
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        revalidate();
		repaint();
	}
	
	//Beginning of renew Registration branch
	public void reNewRegistration(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton failButton = new JButton("Test Fail");
	    JButton passButton = new JButton("Test Pass");
	        
	    mainPanel.add(failButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(passButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    failButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        passButton.setPreferredSize(new Dimension(325,800));
        
        
        failButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fail(); //Running next part of tree
            }
        });
        
        passButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                regType(); //Running next part of tree
            }
        });
	    
		revalidate();
		repaint();
	}
	
	public void regType(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JButton fedButton = new JButton("Federal");
	    JButton realButton = new JButton("Real");
	        
	    mainPanel.add(fedButton, BorderLayout.LINE_START); //Adds button to left side of window
	    mainPanel.add(realButton, BorderLayout.LINE_END); //Adds button to right side of window
		
	    fedButton.setPreferredSize(new Dimension(325,800)); //Modifies size of button (width, height), height overwritten by panel so only width changes
        realButton.setPreferredSize(new Dimension(325,800));
        
        
        fedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run license code
            	
                fed(); //Running next part of tree
            }
        });
        
        realButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Run registration code
            	
                real(); //Running next part of tree
            }
        });
	    
		revalidate();
		repaint();
	}
	
	public void fed(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JLabel exitLabel = new JLabel("<html>Success: Federal<br>Cost:$45</html>");
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        revalidate();
		repaint();
	}
	
	public void real(){
		mainPanel.removeAll(); //Empties panel for new buttons
		
		JLabel exitLabel = new JLabel("<html>Success: Commercial ID<br>Cost:$70</html>");
	    JButton restartButton = new JButton("Restart");
	      
	    mainPanel.add(exitLabel, BorderLayout.NORTH); //Adds button to left side of window
	    mainPanel.add(restartButton, BorderLayout.CENTER); //Adds button to right side of window
		
	    exitLabel.setHorizontalAlignment(SwingConstants.CENTER);
	   
        
        
        restartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	mainPanel.removeAll();
            	
                start(); //Running next part of tree
            }
        });
        
        revalidate();
		repaint();
	}
	
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }
}
