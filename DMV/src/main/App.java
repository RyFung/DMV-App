package main;

public class App { //Methods behind App  
	private Input In = new Input();
	String run(){
		String data = start(); //Set to start method
		return data;
	}

	String start(){
		System.out.println("Type License or Registration");
		String key = In.getKeys();
		if(key.equalsIgnoreCase("License")){
			String data = License();
			return data;
		}
		else if(key.equalsIgnoreCase("Registration")){
			String data = Registration();
			return data;
		}
		System.out.println("Invalid option");
		String data = start(); //Loops start() method until License or Registration chosen
		return data;
		
	}
	
	String License(){
		System.out.println("Type New or Renew");
		String key = In.getKeys();
		if(key.equalsIgnoreCase("New")){
			NewDL newDL = new NewDL();
			newDL.newDL();
			String data = "";
			return data;
		}
		else if(key.equalsIgnoreCase("Renew")){
			RenewLicense renewLic = new RenewLicense(); // simple test run of the renewal process
		    	renewLic.startLicenseRenewal();
			String data = "";
			return data;
		}
		System.out.println("Invalid option");
		String data = License(); //Loops License() method until New or Renew chosen
		return data;
	}
	
	String Registration(){
		System.out.println("Type New or Renew");
		String key = In.getKeys();
		if(key.equalsIgnoreCase("New")){
			NewReg NewReg = new NewReg();
			String data = NewReg.run(); //Set to method tree for New Registration
			return data;
		}
		else if(key.equalsIgnoreCase("Renew")){
			RenewReg renewReg = new RenewReg();
	        	renewReg.renewRegistration();
	        	String data = "";
	        	return data;
		}
		System.out.println("Invalid option");
		String data = Registration(); //Loops Registration() method until New or Renew chosen
		return data;
		
	}
	
}
