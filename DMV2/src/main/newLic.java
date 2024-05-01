package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class newLic extends JFrame{

	
	
	public newLic(DMVBase dmvBase){
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
		
        JPanel newLic = new JPanel(new GridLayout(4,2));
        JTextField Age = new JTextField();
        String[] bool = {"No","Yes"};
        JComboBox<String>resi = new JComboBox<>(bool);
        String[] bool2 = {"Yes","No"};
        JComboBox<String>Test = new JComboBox<>(bool2);
		JButton backNLic = new JButton("Go Back");
		JButton confirm = new JButton("Confirm");
		
		newLic.add(new JLabel("Age:"));
		newLic.add(Age);
		newLic.add(new JLabel("Do you live in California?"));
		newLic.add(resi);
		newLic.add(new JLabel("Did you pass the written and practical test?"));
		newLic.add(Test);
		newLic.add(backNLic);
		newLic.add(confirm);
		
		add(newLic);
		
		 confirm.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if ((Age.getText().isEmpty())){
	            		JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	            	}
	            	else{
	                int age = Integer.parseInt(Age.getText());
	                String resident = (String)resi.getSelectedItem();
	                String test = (String)Test.getSelectedItem();
	                 
	                   if(age>15 && test.equalsIgnoreCase("Yes") ){
	                	   //Output and possible loop here
	                	   if(resident.equalsIgnoreCase("Yes")){
	                		   inStateLic inLic = new inStateLic(dmvBase);
		                	   inLic.setVisible(true);
		                	   SwingUtilities.getWindowAncestor(newLic).dispose();
	                	   } else if(resident.equalsIgnoreCase("No")){
	                		   outStateLic outLic = new outStateLic(dmvBase);
		                	   outLic.setVisible(true);
		                	   SwingUtilities.getWindowAncestor(newLic).dispose();
	                	   }
	                	   
	                	   
	                   }
	                   else{
	                	JOptionPane.showMessageDialog(null, "Unable to Apply for License");
	                   }
	                }
	            }
	        });
	        
		 backNLic.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             
	             	   General general = new General(dmvBase);
	             	   general.setVisible(true);
	             	   SwingUtilities.getWindowAncestor(newLic).dispose();
	     
	         }
	     });
		
	}
}
