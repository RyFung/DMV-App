package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame{
	
	
	public Login(DMVBase dmvBase){
		//setting size and dimensions of the window
		
		
        setTitle("DMV Online App v2");
        setSize(1250, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); //Prevents resizing, added instead of re-scaling algorithm
        
        //DMV icon
        ImageIcon icon = new ImageIcon(getClass().getResource("DMV-Logo.png"));
        setIconImage(icon.getImage());
        
        JPanel loginPanel = new JPanel(new GridLayout(5,2));
		JTextField nameField = new JTextField();
		JPasswordField passField = new JPasswordField();
		JButton login = new JButton("Login");
		JButton createAcc = new JButton("Create an Account");
		
		loginPanel.add(new JLabel("Username:"));
		loginPanel.add(nameField);
		loginPanel.add(new JLabel("Password:"));
		loginPanel.add(passField);
		loginPanel.add(new JLabel());
		loginPanel.add(login);
		loginPanel.add(new JLabel());
		loginPanel.add(new JLabel());
		loginPanel.add(new JLabel());
		loginPanel.add(createAcc);
		
		add(loginPanel);
		
		login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                String password = new String(passField.getPassword());
                
                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.");
                } else {
                    
                   if(dmvBase.login(username, password)){
                	   General general = new General(dmvBase);
                	   general.setVisible(true);
                	   SwingUtilities.getWindowAncestor(loginPanel).dispose();
                   }
                   else{
                	JOptionPane.showMessageDialog(null, "Invalid Login Credentials.");
                   }
                }
            }
        });
		
		createAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                	   regAcc regacc = new regAcc(dmvBase);
                	   regacc.setVisible(true);
                	   SwingUtilities.getWindowAncestor(loginPanel).dispose();
        
            }
        });
		
		
	}
}
