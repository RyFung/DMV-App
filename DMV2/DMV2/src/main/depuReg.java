package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class depuReg extends JFrame{

	Read_N_Write pen = new Read_N_Write();
	countyTax tax = new countyTax();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public depuReg(DMVBase dmvBase){
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
		
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        JLabel welcome = new JLabel("Department Vehicle Registration");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(welcome,BorderLayout.NORTH);
        
		JPanel depuReg = new JPanel(new GridLayout(5,2));
		depuReg.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
		JTextField price = new JTextField();
		String[] bool = {"No", "Yes"};
		JComboBox<String> Smog = new JComboBox<>(bool);
		String[] type = {"Credit", "Cash"};
		JComboBox<String> payType = new JComboBox<>(type);
		JButton Confirm = new JButton("Confirm");
		JButton backDepu = new JButton("Go Back");
		
		JLabel priceprompt = new JLabel("Vehicle Price: $");
		priceprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel smogprompt = new JLabel("Did you get and pass a Smog Check? ");
		smogprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel payprompt = new JLabel("Payment Type: ");
		payprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		depuReg.add(priceprompt);
		depuReg.add(price);
		depuReg.add(smogprompt);
		depuReg.add(Smog);
		depuReg.add(payprompt);
		depuReg.add(payType);
		depuReg.add(new JLabel());
		depuReg.add(Confirm);
		depuReg.add(new JLabel());
		depuReg.add(backDepu);
		
		textPanel.add(depuReg);
		add(textPanel);
		
		Confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(price.getText().isEmpty()){
            		JOptionPane.showMessageDialog(null, "Please enter your Vehicle Price");
            	} else{
                String smog = ""+Smog.getSelectedItem();
            	if(smog.equalsIgnoreCase("No")){
            		JOptionPane.showMessageDialog(null, "You must pay and pass a Smog Check before Registering");
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
		             	   SwingUtilities.getWindowAncestor(depuReg).dispose();
            			
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
		             	   SwingUtilities.getWindowAncestor(depuReg).dispose();
            		}
            		
            		
            		
            	}
                    
                  
                
            
            }
            }
        });
		
		 backDepu.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	                	   newReg newreg = new newReg(dmvBase);
	                	   newreg.setVisible(true);
	                	   SwingUtilities.getWindowAncestor(depuReg).dispose();
	                  
	            }
	        });
		
	}
	
}
