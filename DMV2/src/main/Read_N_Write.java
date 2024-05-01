package main;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*; //Got lazy of importing new io stuff...

//Reads and Writes txt file containing saved database info

public class Read_N_Write { //Reads txt file then saves lines into an array

	BufferedReader file; //Declare because try limits scope if declared inside
	
	public void writeFile(String txt, ArrayList<Accounts> TheList){ //Takes ArrayList in and then writes it into the given text file while replacing the entire file. If file doesn't exist, makes a new file of that name)
		PrintWriter Pen;
		try{
			Pen = new PrintWriter(new FileWriter(txt, false)); //New filewriter given to printwriter, filewriter given txt file to modify and boolean deciding if true to modify at top/start or if false at bottom/end
		}
		catch(IOException e){
			return;
		}
		
		for(int i = 0; i < TheList.size(); i++){ //Increments through array given, prints each line in txt file given
			Pen.println(TheList.get(i).getUser()+"*"+TheList.get(i).getPassword()+"*"+TheList.get(i).getBalance()+"*"+TheList.get(i).checkLic()+"*"+TheList.get(i).checkReg()+"*"+TheList.get(i).getCounty()+"*"+TheList.get(i).getReal());
		}
		Pen.close();
	}
	
	
	public ArrayList<Accounts> readFile (String txt){ //Able to detect empty lines (Takes txt file and saves each line into a patient object)
		
		ArrayList<String> TheList = new ArrayList<String>();
		ArrayList<Accounts> dmvList = new ArrayList<Accounts>(); 
		
		try{
			file = new BufferedReader(new FileReader(txt)); //Set up BufferedReader using FileReader given txt file
		}
		catch(FileNotFoundException e){
			System.out.println("Account List Not Found");
			return null; //Gives nothing... should basically break expected code if returned
		}
		try{
			String line = "empty"; //Defined empty case
			
			line = file.readLine(); //Reads next line
			if(line == null || line == ""){ //Checks if empty
				line = "empty"; //Assigns assumed empty case
			}
			
			//Error: Empty lines are still getting added, occurs in while loop. Suggests condition doesn't work
			
			
			while(line != "empty"){ //Stops at empty line, txt file set up to not have any empty lines between text, loops to add all lines into an array
					TheList.add(line); //Adds entire line of txt file *then possibly starts to look at next line?*
					
					//Could replace below with method doing same as above
					line = file.readLine();
					
					
					if(line == null || line.equals("")){
						line = "empty";
					}
				}
			
		}
		
		catch(IOException e2){
			System.out.println("File not Found?");
			return null; //Same nothing...cope
		}
		try{
			file.close();
		}
		catch(IOException e3){
			System.out.println("File Already Closed?");
			return null; //Idk why this would happen
		}
		
		for(int i = 0; i < TheList.size(); i++){ //Goes through the list and turns each line into tokens
			String lines = TheList.get(i);
			StringTokenizer Token = new StringTokenizer(lines,"*");
			String username = Token.nextToken();
			String password = Token.nextToken();
			Double balance = Double.parseDouble(Token.nextToken());
			String lic = Token.nextToken();
			String reg = Token.nextToken();
			String county = Token.nextToken();
			String real = Token.nextToken();
			dmvList.add(new Accounts(username, password, balance, lic, reg, county, real));
		}
		
		return dmvList;
	}
	
	public void editFile (String txt, Accounts ex){ //Adds line to end of document on next available line, does not rewrite doc
		PrintWriter Pen;
		try{
			Pen = new PrintWriter(new FileWriter(txt, true));
		}
		catch(IOException e){
			return;
		}
		Pen.println(ex.getUser()+"*"+ex.getPassword()+"*"+ex.getBalance()+"*"+ex.checkLic()+"*"+ex.checkReg()+"*"+ex.getCounty()+"*"+ex.getReal());
		Pen.close();
	}
	
	public void editFile (String txt, ArrayList<Accounts> theList){ //Takes an ArrayList of objects and adds it to end of given txt doc
		PrintWriter Pen;
		try{
			Pen = new PrintWriter(new FileWriter(txt, true));
		}
		catch(IOException e){
			return;
		}
		
		for(int i = 0; i < theList.size(); i++){ //Increments through array given, prints each line in txt file given
			Pen.println(theList.get(i).getUser()+"*"+theList.get(i).getPassword()+"*"+theList.get(i).getBalance()+"*"+theList.get(i).checkLic()+"*"+theList.get(i).checkReg()+"*"+theList.get(i).getCounty()+"*"+theList.get(i).getReal());
		}
		Pen.close();
	}
	
}
