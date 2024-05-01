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
	     
	     JPanel textPanel = new JPanel(new BorderLayout());
	        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
	        JLabel welcome = new JLabel("Current County: "+dmvBase.get(dmvBase.tracker).getCounty());
	        welcome.setHorizontalAlignment(SwingConstants.CENTER);
	        textPanel.add(welcome,BorderLayout.NORTH);
	     
	     JPanel County = new JPanel(new GridLayout(3,2));
	     County.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
	     JTextField county = new JTextField();
	     JButton Confirm = new JButton("Confirm");
	     JButton backCount = new JButton("Go Back");
	     
	     JLabel newcountyPrompt = new JLabel("New County: ");	
	     newcountyPrompt.setHorizontalAlignment(SwingConstants.RIGHT);
	     
	     JPanel hold1 = new JPanel(new GridLayout(2,1));
	     hold1.add(Confirm);
	     hold1.add(backCount);
	     
	     County.add(newcountyPrompt);
	     County.add(county);
	     County.add(new JLabel());
	     County.add(hold1);
	     County.add(new JLabel());
	     County.add(new JLabel());
	     
	     textPanel.add(County);
	     add(textPanel);
		
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
