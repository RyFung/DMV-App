package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;


public class payBal extends JFrame {
	Read_N_Write pen = new Read_N_Write();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public payBal(DMVBase dmvBase){
		
		setTitle("DMV Online App v2");
	     setSize(1250, 700);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
	     
	     //DMV icon
	     ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
	     setIconImage(icon.getImage());
	     
	     JPanel payBal = new JPanel(new GridLayout(3,2));
	     JTextField Pay = new JTextField();
	     JButton Confirm = new JButton("Confirm");
	     JButton backPay = new JButton("Go Back");
	     
	     payBal.add(new JLabel("Current Balance:"));
	     payBal.add(new JLabel(""+df.format(dmvBase.get(dmvBase.tracker).getBalance())));
	    
	     
	     payBal.add(new JLabel("Pay Amount:"));
	     payBal.add(Pay);
	     payBal.add(backPay);
	     payBal.add(Confirm);
	     
	     add(payBal);
		
	     Confirm.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             if(Pay.getText().isEmpty()){
	            	 JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	             } else {
	            	 double pay = Double.parseDouble(Pay.getText());
	            	 if(pay>dmvBase.get(dmvBase.tracker).getBalance()){
	            		 JOptionPane.showMessageDialog(null, "Amount Exceeds Current Balance. Please Input a Value Less than or Equal to Your Amount Due");
	            	 } else{
	            		dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()-pay);
	            		JOptionPane.showMessageDialog(null,"Thank you for Paying. Your remaining balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	            		 General general = new General(dmvBase);
		             	   general.setVisible(true);
		             	   SwingUtilities.getWindowAncestor(payBal).dispose();
	            	 }
	            	 
	             }
	        	 
	             }
	         
	     });
	     
	     backPay.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             
	             	   General general = new General(dmvBase);
	             	   general.setVisible(true);
	             	   SwingUtilities.getWindowAncestor(payBal).dispose();
	     
	         }
	     });
		
		
	}
}
