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
        
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        JLabel welcome = new JLabel("Out-State License Registration");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(welcome,BorderLayout.NORTH);
        
		JPanel outStateLic = new JPanel(new GridLayout(4,2));
		outStateLic.setBorder(BorderFactory.createEmptyBorder(60, 0, 60, 400));
		String[] bool = {"No", "Yes"};
		JComboBox<String> Resi = new JComboBox<>(bool);
		String[] bool2 = {"No", "Yes"};
		JComboBox<String> Lic = new JComboBox<>(bool2);
		String[] bool3 = {"No", "Yes"};
		JComboBox<String> Upgr = new JComboBox<>(bool3);
		JButton Confirm = new JButton("Confirm");
		
		JLabel resiprompt = new JLabel("Are you a valid Resident of California? ");
		resiprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel licprompt = new JLabel("Do you have a valid License from Another State? ");
		licprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel upgrprompt = new JLabel("Upgrade to Real ID? ");
		upgrprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		outStateLic.add(resiprompt);
		outStateLic.add(Resi);
		outStateLic.add(licprompt);
		outStateLic.add(Lic);
		outStateLic.add(upgrprompt);
		outStateLic.add(Upgr);
		outStateLic.add(new JLabel());
		outStateLic.add(Confirm);
		
		textPanel.add(outStateLic);
		add(textPanel);
		
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
