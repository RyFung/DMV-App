package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class reNewReg extends JFrame{

	Read_N_Write pen = new Read_N_Write();
	DecimalFormat df = new DecimalFormat("#.##");
	
	public reNewReg(DMVBase dmvBase){
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
		
		JPanel reNewReg = new JPanel(new GridLayout(4,2));
		String[] upgrade = {"No", "Yes"};
		JComboBox<String> real = new JComboBox<>(upgrade);
		String[] bool1 = {"No", "Yes"};
		JComboBox<String> Vision = new JComboBox<>(bool1);
		String[] bool2 = {"No", "Yes"};
		JComboBox<String> Knowledge = new JComboBox<>(bool2);
		JButton Confirm = new JButton("Confirm");
		JButton backreNReg = new JButton("Go Back");
		
		reNewReg.add(new JLabel("Do you want to upgrade to Real ID?"));
		reNewReg.add(real);
		reNewReg.add(new JLabel("Did you pass a Vision Test??"));
		reNewReg.add(Vision);
		reNewReg.add(new JLabel("Did you pass a Knowledge Test?"));
		reNewReg.add(Knowledge);
		reNewReg.add(backreNReg);
		reNewReg.add(Confirm);
		
		add(reNewReg);
		
		Confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String upgr = ""+real.getSelectedItem();
                String Vis = ""+Vision.getSelectedItem();
                String Know = ""+Knowledge.getSelectedItem();
                if(Vis.equalsIgnoreCase("Yes")&&Know.equalsIgnoreCase("Yes")){
                	if(dmvBase.get(dmvBase.tracker).checkReal()&&upgr.equalsIgnoreCase("Yes")){
                		
                		JOptionPane.showMessageDialog(null, "You already have a Real ID");
                		
                	} else {
                		if(upgr.equalsIgnoreCase("Yes")){
                			
                			Double fees = 80+getCountyFee(dmvBase.get(dmvBase.tracker).getCounty());
                			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
                			dmvBase.get(dmvBase.tracker).updateReal(true);
                			
                			JOptionPane.showMessageDialog(null,"Thank you for Renewing. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
    	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
    	            		 General general = new General(dmvBase);
    		             	   general.setVisible(true);
    		             	   SwingUtilities.getWindowAncestor(reNewReg).dispose();
                			
                		} else if(upgr.equalsIgnoreCase("No")){
                			
                			Double fees = 45+getCountyFee(dmvBase.get(dmvBase.tracker).getCounty());
                			dmvBase.get(dmvBase.tracker).changeBalance(dmvBase.get(dmvBase.tracker).getBalance()+fees);
                			
                			JOptionPane.showMessageDialog(null,"Thank you for Renewing. Your Fee is $"+df.format(fees)+ ". Your new balance is $"+ df.format(dmvBase.get(dmvBase.tracker).getBalance()));
    	            		pen.writeFile("Accounts.txt", dmvBase.ReturnDMVBase());
    	            		 General general = new General(dmvBase);
    		             	   general.setVisible(true);
    		             	   SwingUtilities.getWindowAncestor(reNewReg).dispose();
                			
                			
                		}
                	}
                } else{
                	
                	JOptionPane.showMessageDialog(null, "You must pass both tests to renew your ID");
                	
                }
            	
            	
            }
        });
		
		backreNReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                	   General general = new General(dmvBase);
                	   general.setVisible(true);
                	   SwingUtilities.getWindowAncestor(backreNReg).dispose();
                
            }
        });
	
		
	    
	}
	
	private double getCountyFee(String county) {
        switch (county) {
            case "Alameda":
            case "Antioch":
            case "Arcadia":
            case "Bakersfield":
            case "Burbank":
            case "Capitola":
            case "Chico":
            case "Concord":
            case "Fairfield":
            case "Fresno":
                return 10.0;
            case "Glendale":
            case "Loomis":
            case "Mount Shasta":
            case "Paradise":
            case "Sacramento":
                return 15.0;
            case "San Fernando":
            case "San Jose":
            case "Santa Cruz":
                return 20.0;
            case "Wheatland":
                return 25.0;
            default:
                return 5.0;
        }
    }
}
