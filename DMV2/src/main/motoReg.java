package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class motoReg extends JFrame{
	Read_N_Write pen = new Read_N_Write();
	countyTax tax = new countyTax();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public motoReg(DMVBase dmvBase){
		
		
			setTitle("DMV Online App v2");
	        setSize(1250, 700);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
	        
	        //DMV icon
	        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
	        setIconImage(icon.getImage());
			
			JPanel motoReg = new JPanel(new GridLayout(5,2));
			JTextField price = new JTextField();
			String[] bool = {"No", "Yes"};
			JComboBox<String> License = new JComboBox<>(bool);
			String[] bool2 = {"No", "Yes"};
			JComboBox<String> Insurance = new JComboBox<>(bool2);
			String[] type = {"Credit", "Cash"};
			JComboBox<String> payType = new JComboBox<>(type);
			JButton Confirm = new JButton("Confirm");
			JButton backMoto = new JButton("Go Back");
			
			motoReg.add(new JLabel("Vehicle Price:"));
			motoReg.add(price);
			motoReg.add(new JLabel("Do you have a Motorcycle License?"));
			motoReg.add(License);
			motoReg.add(new JLabel("Is your Motocycle Insured?"));
			motoReg.add(Insurance);
			motoReg.add(new JLabel("Payment Type:"));
			motoReg.add(payType);
			motoReg.add(backMoto);
			motoReg.add(Confirm);
			
			add(motoReg);
			
			Confirm.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if(price.getText().isEmpty()){
	            		JOptionPane.showMessageDialog(null, "Please enter your Vehicle Price");
	            	} else{
	                String license = ""+License.getSelectedItem();
	                String insurance = ""+Insurance.getSelectedItem();
	            	if(license.equalsIgnoreCase("No")||insurance.equalsIgnoreCase("No")){
	            		if(license.equalsIgnoreCase("No")){
	            		JOptionPane.showMessageDialog(null, "You must have a Motorcycle License before Registering");
	            		}
	            		if(insurance.equalsIgnoreCase("No")){
	            		JOptionPane.showMessageDialog(null, "You must have Motorcycle Insurance before Registering");
	            		}
	            		
	      
	            		
	            	} else {
	            		String paytype = ""+payType.getSelectedItem();
	            		if(paytype.equalsIgnoreCase("Credit")){
	            			double fees = (Double.parseDouble(price.getText())*0.0068)+80;
	            			fees = fees + tax.County(dmvBase.get(dmvBase.tracker).getCounty(), fees);
	            			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
	            			dmvBase.get(dmvBase.tracker).updateReg(true);
	            			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
		            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
		            		 General general = new General(dmvBase);
			             	   general.setVisible(true);
			             	   SwingUtilities.getWindowAncestor(motoReg).dispose();
	            			
	            		}
	            		
	            		if(paytype.equalsIgnoreCase("Cash")){
	            			double fees = (Double.parseDouble(price.getText())*0.0065)+80;
	            			fees = fees + tax.County(dmvBase.get(dmvBase.tracker).getCounty(), fees);
	            			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
	            			dmvBase.get(dmvBase.tracker).updateReg(true);
	            			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
		            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
		            		 General general = new General(dmvBase);
			             	   general.setVisible(true);
			             	   SwingUtilities.getWindowAncestor(motoReg).dispose();
	            		}
	            		
	            		
	            		
	            	}
	                    
	                  
	                
	            
	            }
	            }
	        });
			
			 backMoto.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                
		                	   newReg newreg = new newReg(dmvBase);
		                	   newreg.setVisible(true);
		                	   SwingUtilities.getWindowAncestor(motoReg).dispose();
		                  
		            }
		        });
			
		}
		
		
		
	
}
