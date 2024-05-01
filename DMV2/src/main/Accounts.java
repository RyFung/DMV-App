package main;

//Database Objects for DMV Accounts

public class Accounts {
	private String username;
	private String password;
	private double balance;
	private boolean lic;
	private boolean reg;
	private String county;
	private boolean real;
	
	
	public Accounts(String username, String password){
		this.username = username;
		this.password = password;
		balance = 0;
		lic = false;
		reg = false;
		county = "Sacramento";
		real = false;
	}
	
	public Accounts(String username, String password, double balance, String lic, String reg, String county, String real){
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.county = county;
		if(real.equalsIgnoreCase("true")){
			this.real = true;
		} else{
			this.real = false;
		}
			
		
		if(lic.equalsIgnoreCase("true")){
			this.lic = true;
		} else {
			this.lic = false;
		}
		
		if(reg.equalsIgnoreCase("true")){
			this.reg = true;
		} else {
			this.reg = false;
		}
	}
	
	public String getUser(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public boolean checkLic(){
		return lic;
	}
	
	public boolean checkReal(){
		return real;
	}
	
	public String getReal(){
		String Real = ""+real;
		return Real;
	}
	
	public String getLic(){
		String Lic = ""+lic;
		return Lic;
	}
	
	public boolean checkReg(){
		return reg;
	}
	
	public String getReg(){
		String Reg = ""+reg;
		return Reg;
	}
	
	public String getCounty(){
		String County = county;
		return County;
	}
	
	public void changeUser(String username){
		this.username = username;
	}
	
	public void changePassword(String password){
		this.password = password;
	}
	
	public void changeBalance(double balance){
		this.balance = balance;
	}
	
	public void changeCounty(String county){
		this.county = county;
	}
	
	public void updateLic(boolean bool){
		lic = bool;
	}
	
	public void updateReg(boolean bool){
		reg = bool;
	}
	
	public void updateReal(boolean bool){
		real = bool;
	}
	
	
}

