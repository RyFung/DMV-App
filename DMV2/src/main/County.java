package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class County extends JFrame {
	Read_N_Write pen = new Read_N_Write();
	
	public County(DMVBase dmvBase){
		
		setTitle("DMV Online App v2");
	     setSize(1250, 700);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
	     
	     //DMV icon
	     ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
	     setIconImage(icon.getImage());
	     
	     JPanel County = new JPanel(new GridLayout(3,2));
	     JTextField county = new JTextField();
	     JButton Confirm = new JButton("Confirm");
	     JButton backCount = new JButton("Go Back");
	     County.add(new JLabel("Current County:"));
	     County.add(new JLabel(dmvBase.get(dmvBase.tracker).getCounty()));
	     County.add(new JLabel("New County:"));
	     County.add(county);
	     County.add(backCount);
	     County.add(Confirm);
	     
	     add(County);
		
	     Confirm.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             if(county.getText().isEmpty()){
	            	 JOptionPane.showMessageDialog(null, "Please fill in all fields.");
	             } else {
	            	 dmvBase.get(dmvBase.tracker).changeCounty(county.getText());
	            	 JOptionPane.showMessageDialog(null, dmvBase.get(dmvBase.tracker).getCounty()+" County Confirmed");
	            	 pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	            	 General general = new General(dmvBase);
	             	   general.setVisible(true);
	             	   SwingUtilities.getWindowAncestor(County).dispose();
	            	 }
	            	 
	             }
	        	 
	             
	         
	     });
	     
	     backCount.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             
	             	   General general = new General(dmvBase);
	             	   general.setVisible(true);
	             	   SwingUtilities.getWindowAncestor(County).dispose();
	     
	         }
	     });
		
		
	}
}
