package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class inStateLic extends JFrame{

	Read_N_Write pen = new Read_N_Write();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public inStateLic(DMVBase dmvBase){
		
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
        
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        JLabel welcome = new JLabel("In-State License Registration");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(welcome,BorderLayout.NORTH);
        
		JPanel inStateLic = new JPanel(new GridLayout(4,2));
		inStateLic.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
		String[] bool = {"No", "Yes"};
		JComboBox<String> Know = new JComboBox<>(bool);
		String[] bool2 = {"No", "Yes"};
		JComboBox<String> Prac = new JComboBox<>(bool2);
		String[] bool3 = {"No", "Yes"};
		JComboBox<String> Upgr = new JComboBox<>(bool3);
		JButton Confirm = new JButton("Confirm");
		
		JLabel knowprompt = new JLabel("Did you pass a Written Test? ");
		knowprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel pracprompt = new JLabel("Did you pass a Practical Driving Test? ");
		pracprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel upgrprompt = new JLabel("Upgrade to Real ID? ");
		upgrprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		inStateLic.add(knowprompt);
		inStateLic.add(Know);
		inStateLic.add(pracprompt);
		inStateLic.add(Prac);
		inStateLic.add(upgrprompt);
		inStateLic.add(Upgr);
		inStateLic.add(new JLabel());
		inStateLic.add(Confirm);
		
		textPanel.add(inStateLic);
		add(textPanel);
		
		 Confirm.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String know = ""+Know.getSelectedItem();
	                String prac = ""+Prac.getSelectedItem();
	            	if(know.equalsIgnoreCase("Yes")&&prac.equalsIgnoreCase("Yes")){
	            		String real = ""+Upgr.getSelectedItem();
	            		if(dmvBase.get(dmvBase.tracker).checkReal()&&real.equalsIgnoreCase("Yes")){
	                		
	                		JOptionPane.showMessageDialog(null, "You already have a Real ID");
	                		
	                	} else {
	                		if(real.equalsIgnoreCase("Yes")){
	                			
	                			int fees = 35;
	                			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
	                			dmvBase.get(dmvBase.tracker).updateReal(true);
	                			dmvBase.get(dmvBase.tracker).updateLic(true);
	                			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	    	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	    	            		 General general = new General(dmvBase);
	    		             	   general.setVisible(true);
	    		             	   SwingUtilities.getWindowAncestor(inStateLic).dispose();
	    		             	   
	                		} else if(real.equalsIgnoreCase("No")) {
	                			
	                			int fees = 30;
	                			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
	                			dmvBase.get(dmvBase.tracker).updateLic(true);
	                			JOptionPane.showMessageDialog(null,"Thank you for Registering. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
	    	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
	    	            		 General general = new General(dmvBase);
	    		             	   general.setVisible(true);
	    		             	   SwingUtilities.getWindowAncestor(inStateLic).dispose();
	                		}
	                	}
	            		
	            	} else {
	            		JOptionPane.showMessageDialog(null, "You can not get a California driver's license");
	            	}
	            	
	            	
	            	
	              
	                  
	            }
	        });
		
	}
	
	
	
}
