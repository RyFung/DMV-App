package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class HighCV extends JFrame{
	
	Read_N_Write pen = new Read_N_Write();
	countyTax tax = new countyTax();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public HighCV(DMVBase dmvBase, String paytype, double price){
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
		
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        JLabel welcome = new JLabel("Combined Haul and Vehicle Registration");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(welcome,BorderLayout.NORTH);
        
		JPanel highCV = new JPanel(new GridLayout(2,2));
		highCV.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
		JTextField comboWeight = new JTextField();
		JButton Confirm = new JButton("Confirm");
		JLabel weightprompt = new JLabel("Heaviest Combined Gross Weight of Vehicle: ");
		weightprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		highCV.add(weightprompt);
		highCV.add(comboWeight);
		highCV.add(new JLabel());
		highCV.add(Confirm);
		
		textPanel.add(highCV);
		add(textPanel);
		
		Confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(comboWeight.getText().isEmpty()){
            		JOptionPane.showMessageDialog(null, "Please enter the heaviest combined weight of your vehicle and haul");
            	} else{
                Double weight = Double.parseDouble(comboWeight.getText());
                int CRVAfee = 400;
                if (weight > 20000 && weight <= 30000) {
                    CRVAfee = 550;
                } else if (weight > 30000 && weight <= 40000) {
                    CRVAfee = 800;
                } else if (weight > 40000 && weight <= 50000) {
                    CRVAfee = 1100;
                } else if (weight > 50000 && weight <= 60000) {
                    CRVAfee = 1400;
                } else if (weight > 60000 && weight <= 70000) {
                    CRVAfee = 1700;
                } else if (weight > 70000) {
                    CRVAfee = 2000;
                }
                
            	
            		
            		if(paytype.equalsIgnoreCase("Credit")){
            			double fees = (price*0.0069)+80+CRVAfee;
            			fees = fees + tax.County(dmvBase.get(dmvBase.tracker).getCounty(), fees);
            			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
            			dmvBase.get(dmvBase.tracker).updateReg(true);
            			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	            		 General general = new General(dmvBase);
		             	   general.setVisible(true);
		             	   SwingUtilities.getWindowAncestor(highCV).dispose();
            			
            		}
            		
            		if(paytype.equalsIgnoreCase("Cash")){
            			double fees = (price*0.0066)+80+CRVAfee;
            			fees = fees + tax.County(dmvBase.get(dmvBase.tracker).getCounty(), fees);
            			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
            			dmvBase.get(dmvBase.tracker).updateReg(true);
            			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	            		 General general = new General(dmvBase);
		             	   general.setVisible(true);
		             	   SwingUtilities.getWindowAncestor(highCV).dispose();
            		}
            		
            		
            		
            	}
                    
                  
                
            
            }
            
        });
		
		
	}
	
	
}
