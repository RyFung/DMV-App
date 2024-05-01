package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class newReg extends JFrame{
	
	
	
	
	
	public newReg(DMVBase dmvBase){
		
		setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
        
        JPanel newReg = new JPanel(new BorderLayout());
        JButton coveReg = new JButton("Commercial");
        JButton depuReg = new JButton("Department");
        JButton motoReg = new JButton("Motorcycle");
        JButton backNReg = new JButton("Go Back");
        JLabel prompt = new JLabel("Please Select Your Vehicle Type");
        prompt.setHorizontalAlignment(SwingConstants.CENTER);
        
        coveReg.setPreferredSize(new Dimension(400,500));
        depuReg.setPreferredSize(new Dimension(400,500));
        motoReg.setPreferredSize(new Dimension(400,500));
        backNReg.setPreferredSize(new Dimension(300,80));
       
        newReg.add(prompt,BorderLayout.NORTH);
        newReg.add(coveReg,BorderLayout.EAST);
        newReg.add(motoReg, BorderLayout.CENTER);
        newReg.add(depuReg,BorderLayout.WEST);
        newReg.add(backNReg,BorderLayout.SOUTH);
        
        add(newReg);
		
        coveReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                	   coveReg covereg = new coveReg(dmvBase);
                	   covereg.setVisible(true);
                	   SwingUtilities.getWindowAncestor(newReg).dispose();
                  
            }
        });
        
        motoReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                	   motoReg motoreg = new motoReg(dmvBase);
                	   motoreg.setVisible(true);
                	   SwingUtilities.getWindowAncestor(newReg).dispose();
                  
            }
        });
        
        depuReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                	   depuReg depureg = new depuReg(dmvBase);
                	   depureg.setVisible(true);
                	   SwingUtilities.getWindowAncestor(newReg).dispose();
                  
            }
        });
        
        
        backNReg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                	   General general = new General(dmvBase);
                	   general.setVisible(true);
                	   SwingUtilities.getWindowAncestor(newReg).dispose();
                  
            }
        });
        
        
        
        
	}
	
	
}
