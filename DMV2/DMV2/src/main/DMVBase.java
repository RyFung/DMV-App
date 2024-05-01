package main;

import java.util.ArrayList;

//Handles Account information, holds Account objects 

public class DMVBase {
	private ArrayList <Accounts> DMVBase;
	Read_N_Write pen = new Read_N_Write();
	public int tracker;
	
	
	public DMVBase(){
		DMVBase = new ArrayList <Accounts>();
	}
	
	public void addAcc(String username, String password){
		DMVBase.add(new Accounts(username,password));
		tracker = DMVBase.size()-1;
		pen.editFile("Accounts.txt", DMVBase.get(DMVBase.size()-1));
	}
	
	public void addAccList(ArrayList<Accounts>theList){
		for(int i = 0; i <theList.size(); i++){
			DMVBase.add(new Accounts(theList.get(i).getUser(), theList.get(i).getPassword(), theList.get(i).getBalance(), theList.get(i).getLic(),theList.get(i).getReg(),theList.get(i).getCounty(),theList.get(i).getReal()));
		}
	}
	
	public ArrayList<Accounts> ReturnDMVBase(){ //Returns current ArrayList
		return DMVBase;
	}
	
	public Boolean login(String username, String password){ //Returns true or false depending on if matching email and password found
		Boolean pass = false;
		for(int i = 0; i < DMVBase.size(); i++){
			if(DMVBase.get(i).getUser().equalsIgnoreCase(username) && DMVBase.get(i).getPassword().equalsIgnoreCase(password)){
				pass = true;
				tracker = i;
				
			}
		}
		
		return pass;
	}
	
	public Accounts get(int index){
		return DMVBase.get(index);
	}
	
	
}
