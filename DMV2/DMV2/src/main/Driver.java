package main;

import javax.swing.*;

//Starts program, runs window

public class Driver{
	
		public static void main(String[] args) {
			
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	Read_N_Write pen = new Read_N_Write();
	            	DMVBase dmvBase = new DMVBase();
	            	dmvBase.addAccList(pen.readFile("Accounts.txt"));
	                new Login(dmvBase).setVisible(true);
	            }
	        });
	    }
        
    }

