package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class outStateLic extends JFrame {

	Read_N_Write pen = new Read_N_Write();
	DecimalFormat df = new DecimalFormat("#.##");
	
	
	public outStateLic(DMVBase dmvBase){
		
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
        
		JPanel outStateLic = new JPanel(new GridLayout(4,2));
		String[] bool = {"No", "Yes"};
		JComboBox<String> Resi = new JComboBox<>(bool);
		String[] bool2 = {"No", "Yes"};
		JComboBox<String> Lic = new JComboBox<>(bool2);
		String[] bool3 = {"No", "Yes"};
		JComboBox<String> Upgr = new JComboBox<>(bool3);
		JButton Confirm = new JButton("Confirm");
		
		outStateLic.add(new JLabel("Are you a valid Resident of California?"));
		outStateLic.add(Resi);
		outStateLic.add(new JLabel("Do you have a valid License from Another State?"));
		outStateLic.add(Lic);
		outStateLic.add(new JLabel("Upgrade to Real ID?"));
		outStateLic.add(Upgr);
		outStateLic.add(new JLabel());
		outStateLic.add(Confirm);
		
		add(outStateLic);
		
		 Confirm.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String resident = ""+Resi.getSelectedItem();
	                String license = ""+Lic.getSelectedItem();
	            	if(resident.equalsIgnoreCase("Yes")&&license.equalsIgnoreCase("Yes")){
	            		String real = ""+Upgr.getSelectedItem();
	            		if(dmvBase.get(dmvBase.tracker).checkReal()&&real.equalsIgnoreCase("Yes")){
	                		
	                		JOptionPane.showMessageDialog(null, "You already have a Real ID");
	                		
	                	} else {
	                		if(real.equalsIgnoreCase("Yes")){
	                			
	                			int fees = 35;
	                			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
	                			dmvBase.get(dmvBase.tracker).updateLic(true);
	                			dmvBase.get(dmvBase.tracker).updateReal(true);
	                			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	    	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	    	            		 General general = new General(dmvBase);
	    		             	   general.setVisible(true);
	    		             	   SwingUtilities.getWindowAncestor(outStateLic).dispose();
	    		             	   
	                		} else if(real.equalsIgnoreCase("No")) {
	                			
	                			int fees = 30;
	                			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
	                			dmvBase.get(dmvBase.tracker).updateLic(true);
	                			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	    	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	    	            		 General general = new General(dmvBase);
	    		             	   general.setVisible(true);
	    		             	   SwingUtilities.getWindowAncestor(outStateLic).dispose();
	                		}
	                	}
	            		
	            	} else {
	            		JOptionPane.showMessageDialog(null, "You can not get a California driver's license");
	            	}
	            	
	            	
	            	
	              
	                  
	            }
	        });
		
	}
}
