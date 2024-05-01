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
			
	        JPanel textPanel = new JPanel(new BorderLayout());
	        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
	        JLabel welcome = new JLabel("Motocycle Registration");
	        welcome.setHorizontalAlignment(SwingConstants.CENTER);
	        textPanel.add(welcome,BorderLayout.NORTH);
	        
			JPanel motoReg = new JPanel(new GridLayout(6,2));
			motoReg.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
			JTextField price = new JTextField();
			String[] bool = {"No", "Yes"};
			JComboBox<String> License = new JComboBox<>(bool);
			String[] bool2 = {"No", "Yes"};
			JComboBox<String> Insurance = new JComboBox<>(bool2);
			String[] type = {"Credit", "Cash"};
			JComboBox<String> payType = new JComboBox<>(type);
			JButton Confirm = new JButton("Confirm");
			JButton backMoto = new JButton("Go Back");
			
			JLabel priceprompt = new JLabel("Vehicle Price: $");
			priceprompt.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel licprompt = new JLabel("Do you have a Motocyle License? ");
			licprompt.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel insurprompt = new JLabel("Is your Motorcycle Insured?");
			insurprompt.setHorizontalAlignment(SwingConstants.RIGHT);
			JLabel payprompt = new JLabel("Payment Type: ");
			payprompt.setHorizontalAlignment(SwingConstants.RIGHT);
			
			motoReg.add(priceprompt);
			motoReg.add(price);
			motoReg.add(licprompt);
			motoReg.add(License);
			motoReg.add(insurprompt);
			motoReg.add(Insurance);
			motoReg.add(payprompt);
			motoReg.add(payType);
			motoReg.add(new JLabel());
			motoReg.add(Confirm);
			motoReg.add(new JLabel());
			motoReg.add(backMoto);
			
			textPanel.add(motoReg);
			add(textPanel);
			
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
