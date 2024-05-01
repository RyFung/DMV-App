package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class regAcc extends JFrame{
	
	
	
	 public regAcc(DMVBase dmvBase){
		 
	 setTitle("DMV Online App v2");
     setSize(1250, 700);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
     
     //DMV icon
     ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
     setIconImage(icon.getImage());
     
     JPanel textPanel = new JPanel(new BorderLayout());
     textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
     JLabel welcome = new JLabel("Create an Account");
     welcome.setHorizontalAlignment(SwingConstants.CENTER);
     textPanel.add(welcome,BorderLayout.NORTH);
     
     JPanel regAccPanel = new JPanel(new GridLayout(6,2));
     regAccPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
     JTextField newNameField = new JTextField();
 	 JPasswordField newPassField = new JPasswordField();
 	 JPasswordField confirmPassField = new JPasswordField();
 	 JButton create = new JButton("Create Account");
 	 JButton backCreate = new JButton("Go Back");
 	 JLabel userprompt = new JLabel("Username: ");
 	 JLabel passprompt = new JLabel("Password: ");
 	 JLabel conpassprompt = new JLabel("Confirm Password: ");
 	userprompt.setHorizontalAlignment(SwingConstants.RIGHT);
 	passprompt.setHorizontalAlignment(SwingConstants.RIGHT);
 	conpassprompt.setHorizontalAlignment(SwingConstants.RIGHT);
 	 
 	regAccPanel.add(userprompt);
	regAccPanel.add(newNameField);
	regAccPanel.add(passprompt);
	regAccPanel.add(newPassField);
	regAccPanel.add(conpassprompt);
	regAccPanel.add(confirmPassField);
	regAccPanel.add(new JLabel());
	regAccPanel.add(create);
	regAccPanel.add(new JLabel());
	regAccPanel.add(backCreate);
	
	textPanel.add(regAccPanel,BorderLayout.CENTER);
	add(textPanel);
 	 
	create.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String username = newNameField.getText();
            String password = new String(newPassField.getPassword());
            String conPass = new String(confirmPassField.getPassword());
            
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else {
                
               if(password.equalsIgnoreCase(conPass)){
            	   dmvBase.addAcc(username, password);
            	   General general = new General(dmvBase);
            	   general.setVisible(true);
            	   SwingUtilities.getWindowAncestor(regAccPanel).dispose();
               }
               else{
            	JOptionPane.showMessageDialog(null, "Passwords Do Not Match.");
               }
            }
        }
    });
	
	
	backCreate.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            
            	   Login login = new Login(dmvBase);
            	   login.setVisible(true);
            	   SwingUtilities.getWindowAncestor(regAccPanel).dispose();
    
        }
    });
	
	
	 }
}
