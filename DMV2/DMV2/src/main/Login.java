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
        
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(60,0,0,0));
        JLabel welcome = new JLabel("Welcome to the Online DMV Assist");
        welcome.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(welcome,BorderLayout.NORTH);
        
        
        
        
        JPanel loginPanel = new JPanel(new GridLayout(5,2));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 60, 400));
		JTextField nameField = new JTextField();
		JPasswordField passField = new JPasswordField();
		JButton login = new JButton("Login");
		JButton createAcc = new JButton("Create an Account");
		JLabel userprompt = new JLabel("Username: ");
	    userprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		JLabel passprompt = new JLabel("Password: ");
		passprompt.setHorizontalAlignment(SwingConstants.RIGHT);
		
		loginPanel.add(userprompt);
		loginPanel.add(nameField);
		loginPanel.add(passprompt);
		loginPanel.add(passField);
		loginPanel.add(new JLabel());
		loginPanel.add(login);
		loginPanel.add(new JLabel());
		loginPanel.add(new JLabel());
		loginPanel.add(new JLabel());
		loginPanel.add(createAcc);
		
		textPanel.add(loginPanel,BorderLayout.CENTER);
		add(textPanel);
		
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
