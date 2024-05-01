package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class General extends JFrame {
	
	DecimalFormat df = new DecimalFormat("#.##");
	
	
	public General(DMVBase dmvBase){
		setTitle("DMV Online App v2");
		setSize(1250, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
    
		//DMV icon
		ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
		setIconImage(icon.getImage());
		
		JPanel General = new JPanel(new GridLayout(3,3));
		JButton newLic = new JButton("Apply for New License");
		JButton reNewLic = new JButton("Renew License");
		JButton newReg = new JButton("Apply for New Vehicle Registration");
		JButton reNewReg = new JButton("Renew Registration");
		JButton checkBal = new JButton("Check Balance");
		JButton payBal = new JButton("Pay Balance");
		JButton County = new JButton("Change County");
		
		
		JButton signOut = new JButton("Sign Out");
		
		General.add(newLic);
		General.add(newReg);
		General.add(checkBal);
		General.add(reNewLic);
		General.add(reNewReg);
		General.add(payBal);
		General.add(new JLabel());
		General.add(County);
		General.add(signOut);
		
		add(General);
		
		
		
		
		 newLic.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            		   
	                	   newLic newlic = new newLic(dmvBase);
	                	   newlic.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(General).dispose();
	                   
	                
	            }
	        });
		 
		 reNewLic.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	               if(dmvBase.get(dmvBase.tracker).checkLic()){
	            	  
	                	   reNewLic renewlic = new reNewLic(dmvBase);
	                	   renewlic.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(General).dispose();
	                   
	               }
	               else{
	            	   JOptionPane.showMessageDialog(null, "No Valid License Registered. Please Apply for a New License");
	               }
	            }
	        });
		 
		 
		 newReg.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            	
	                	   newReg newreg = new newReg(dmvBase);
	                	   newreg.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(General).dispose();
	                   
	                
	            }
	        });
		 
		 reNewReg.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	               if(dmvBase.get(dmvBase.tracker).checkReg()){
	            	   
	                	   reNewReg renewreg = new reNewReg(dmvBase);
	                	   renewreg.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(General).dispose();
	                   
	               }
	               else{
	            	   JOptionPane.showMessageDialog(null, "No Valid Registration Registered. Please Apply for a New Registration");
	               }
	            }
	        });
		 
		 checkBal.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	               
	            	   JOptionPane.showMessageDialog(null, "Balance: $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	               
	            }
	        });
		 
		 payBal.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            	
	                	   payBal paybal = new payBal(dmvBase);
	                	   paybal.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(General).dispose();
	                   
	                
	            }
	        });
		 
		 County.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            	
	                	   County county = new County(dmvBase);
	                	   county.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(General).dispose();
	                   
	                
	            }
	        });
		 
		
		 signOut.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            	
	                	   Login login = new Login(dmvBase);
	                	   dmvBase.tracker = 0;
	                	   login.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(General).dispose();
	                   
	                
	            }
	        });
		
		
		
		 
		
		 
		 
		 
		 
		 
		 
		
		
	}
}
