package main;

import java.util.Scanner;

public class Input{ //Records and outputs what the user is typing
	private static final Scanner keys = new Scanner(System.in);
	
	public String getKeys(){ //Returns a string output of what keys I press until I hit enter
		String MyKeys = keys.nextLine(); //Records my keys in MyKeys
		return MyKeys;
	}
	
	//This version does not implement close since it uses System.in which links to keyboard
	
	
}
