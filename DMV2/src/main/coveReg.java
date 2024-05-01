package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class coveReg extends JFrame{

	Read_N_Write pen = new Read_N_Write();
	countyTax tax = new countyTax();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public coveReg(DMVBase dmvBase){
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
		
		JPanel coveReg = new JPanel(new GridLayout(5,2));
		JTextField price = new JTextField();
		JTextField weight = new JTextField();
		String[] bool = {"No", "Yes"};
		JComboBox<String> Haul = new JComboBox<>(bool);
		String[] type = {"Credit", "Cash"};
		JComboBox<String> payType = new JComboBox<>(type);
		JButton Confirm = new JButton("Confirm");
		JButton backDepu = new JButton("Go Back");
		
		coveReg.add(new JLabel("Vehicle Price:"));
		coveReg.add(price);
		coveReg.add(new JLabel("Vehicle Weight:"));
		coveReg.add(weight);
		coveReg.add(new JLabel("Does your Commercial Vehicle haul another vehicle?"));
		coveReg.add(Haul);
		coveReg.add(new JLabel("Payment Type:"));
		coveReg.add(payType);
		coveReg.add(backDepu);
		coveReg.add(Confirm);
		
		add(coveReg);
		
		Confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if(price.getText().isEmpty()||weight.getText().isEmpty()){
            		JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            	} else{
                
            	if(Integer.parseInt(weight.getText())<=6000){
            		JOptionPane.showMessageDialog(null, "Your vehicle is too light to qualify for this Registration");
            	} else {
            		String paytype = ""+payType.getSelectedItem();
            		if(Integer.parseInt(weight.getText())>6000 && Integer.parseInt(weight.getText())<=10000){
            			 String haul = ""+Haul.getSelectedItem();
            			 if(haul.equalsIgnoreCase("No")){
			
			
    		if(paytype.equalsIgnoreCase("Credit")){
    			double fees = (Double.parseDouble(price.getText())*0.0068)+80;
    			fees = fees + tax.County(dmvBase.get(dmvBase.tracker).getCounty(), fees);
    			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
    			dmvBase.get(dmvBase.tracker).updateReg(true);
    			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
        		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
        		 General general = new General(dmvBase);
             	   general.setVisible(true);
             	   SwingUtilities.getWindowAncestor(coveReg).dispose();
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
             	   SwingUtilities.getWindowAncestor(coveReg).dispose();
    		}
    		
			
			
			
            			 } else if(haul.equalsIgnoreCase("Yes")){
            				 
            				
                     		if(paytype.equalsIgnoreCase("Credit")){
                     			double fees = (Double.parseDouble(price.getText())*0.0069)+80;
                     			fees = fees + tax.County(dmvBase.get(dmvBase.tracker).getCounty(), fees);
                     			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
                     			dmvBase.get(dmvBase.tracker).updateReg(true);
                     			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
         	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
         	            		 General general = new General(dmvBase);
         		             	   general.setVisible(true);
         		             	   SwingUtilities.getWindowAncestor(coveReg).dispose();
                     			
                     		}
                     		
                     		if(paytype.equalsIgnoreCase("Cash")){
                     			double fees = (Double.parseDouble(price.getText())*0.0066)+80;
                     			fees = fees + tax.County(dmvBase.get(dmvBase.tracker).getCounty(), fees);
                     			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
                     			dmvBase.get(dmvBase.tracker).updateReg(true);
                     			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
         	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
         	            		 General general = new General(dmvBase);
         		             	   general.setVisible(true);
         		             	   SwingUtilities.getWindowAncestor(coveReg).dispose();
                     		}
                     		
                     		
            			 }
		}
            		
            		if(Integer.parseInt(weight.getText())> 10000){
            			double cost = Double.parseDouble(price.getText());
            			HighCV highcv = new HighCV(dmvBase, paytype, cost);
            			highcv.setVisible(true);
            			SwingUtilities.getWindowAncestor(coveReg).dispose();
            			
            		}
            		
            		
            		
            		
            		
            	}
                    
                  
                
            
            }
            }
        });
		
		 backDepu.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	                	   newReg newreg = new newReg(dmvBase);
	                	   newreg.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(coveReg).dispose();
	                  
	            }
	        });
		
		
		
	}
	
}
