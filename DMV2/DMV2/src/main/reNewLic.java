package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class reNewLic extends JFrame {
	
	Read_N_Write pen = new Read_N_Write();
	reLicLog log = new reLicLog();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public reNewLic(DMVBase dmvBase) {
		JPanel reNewLic = new JPanel(new GridLayout(5,2));
		reNewLic.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
		
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        JLabel welcome = new JLabel("Renew Registration");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(welcome,BorderLayout.NORTH);
        
        JTextField cardNumber = new JTextField();
        JTextField expDate = new JTextField();
        String[] licTypes = {"Non-Commercial", "Commercial"};
        JComboBox<String> licClass = new JComboBox<>(licTypes);
        JButton backreNLic = new JButton("Go Back");
        JButton confirm = new JButton("Confirm");
        
        JLabel cardprompt = new JLabel("Card Number: ");
        cardprompt.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel dateprompt = new JLabel("Expiration Date in MM-DD-YYYY: ");
        dateprompt.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel licprompt = new JLabel("License Type: ");
        licprompt.setHorizontalAlignment(SwingConstants.RIGHT);
       
        
        reNewLic.add(cardprompt);
        reNewLic.add(cardNumber);
        reNewLic.add(dateprompt);
        reNewLic.add(expDate);
        reNewLic.add(licprompt);
        reNewLic.add(licClass);
        reNewLic.add(new JLabel());
        reNewLic.add(confirm);
        reNewLic.add(new JLabel());
        reNewLic.add(backreNLic);
        
        textPanel.add(reNewLic);
        add(textPanel);
        
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cardnumber = cardNumber.getText();
                String expdate = expDate.getText();
                String licclass = (String)licClass.getSelectedItem();
                Boolean lic = false;
                
                if ((cardnumber.isEmpty() || expdate.isEmpty())){
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                } else {
                	if(licclass.equalsIgnoreCase("Commercial")){
                    	lic = true;
                    } 
                	Double fee = log.LicenseRenewalFee(expdate,lic,dmvBase.get(dmvBase.tracker).getCounty());
                	if(fee == 0.0){
                		 JOptionPane.showMessageDialog(null, "License has expired for more than 60 days, so we can't renew it. Please apply for a new License");
                		 dmvBase.get(dmvBase.tracker).updateLic(false);
                		 pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	            		 General general = new General(dmvBase);
		             	   general.setVisible(true);
		             	   SwingUtilities.getWindowAncestor(reNewLic).dispose();
                	} else{
                		dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fee);
            			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fee)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	            		 General general = new General(dmvBase);
		             	   general.setVisible(true);
		             	   SwingUtilities.getWindowAncestor(reNewLic).dispose();
                	}
                	   
                   
                   
                }
            }
        });
        
        backreNLic.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             
	             	   General general = new General(dmvBase);
	             	   general.setVisible(true);
	             	   SwingUtilities.getWindowAncestor(reNewLic).dispose();
	     
	         }
	     });
	}
}
