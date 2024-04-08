package main;

import java.util.Scanner;

public class NewReg { //Methods behind New Registration 

    private Input In = new Input();
    Scanner input = new Scanner(System.in);
    double price; //price of vehicle at purchase
    double newRegFee; //total new registration fee

    String run() {
        String data = startNewReg(); //Set to startNewReg method
        return data;
    }

    String startNewReg() {
        System.out.println("Type Dealership Purchase, Motorcycle, or Commercial Vehicle");
        String key = In.getKeys();
        if (key.equalsIgnoreCase("Dealership Purchase")) {
            String data = DePu();
            return data;
        } else if (key.equalsIgnoreCase("Moto")) {
            String data = Moto();
            return data;
        } else if (key.equalsIgnoreCase("CoVe")) {
            String data = CoVe();
            return data;
        }
        System.out.println("Invalid option");
        String data = startNewReg(); //Loops startNewReg() method until valid input is given
        return data;

    }
//Start of DePu Branch

    String DePu() {
        System.out.println("Type Pass Smog Check or Fail Smog Check");
        String key = In.getKeys();
        if (key.equalsIgnoreCase("Pass Smog Check")) {
            String data = DPCashOrCheck(); //Set to method tree for DPCashOrCheck
            return data;
        } else if (key.equalsIgnoreCase("Fail Smog Check")) {
            String data = endNewReg(); //End NewReg run
            return data;
        }
        System.out.println("Invalid option");
        String data = DePu(); //Loops DePu() method until Pass or Fail chosen
        return data;
    }

    String DPCashOrCheck() {
        System.out.println("Please select \"Cash\" or \"Credit\" for your payment option.");
        String key = In.getKeys();
        if (key.equalsIgnoreCase("Cash")) {
            String data = DPCash(); //Set to method tree for Cash
            return data;
        } else if (key.equalsIgnoreCase("Credit")) {
            String data = DPCredit(); //Set to method tree for Credit
            return data;
        }
        System.out.println("Invalid option");
        String data = DPCashOrCheck(); //Loops DPCashorCheck() method until Cash or Credit Chosen
        return data;

    }

    String DPCash() {
        System.out.println("You selected Cash as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0065) + 80);
        String data = DPSuccess(); //Displays DPSuccess()
        return data;

    }

    String DPCredit() {
        System.out.println("You selected Credit as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0068) + 80);
        String data = DPSuccess(); //Displays DPSuccess()
        return data;

    }

    String DPSuccess() {
        String data = "Congratulations! You successfully completed New Registration for your Dealership Purchase!/nTotal fees you must pay: $" + newRegFee;
        return data;

    }

    //Start of Moto branch
    String Moto() {
        System.out.println("Type Motorcycle License or No License");
        String key = In.getKeys();
        if (key.equalsIgnoreCase("Motorcycle License")) {
            String data = "method here"; //Set to method tree for MotoLicense
            return data;
        } else if (key.equalsIgnoreCase("No License")) {
            String data = endNewReg(); //End NewReg run
            return data;
        }
        System.out.println("Invalid option");
        String data = Moto(); //Loops Moto() method until License or No License chosen
        return data;

    }
    
     
//Start of CoVe branch

    String CoVe() {
        System.out.println("Type <6000 lbs, 6000-10000 lbs, or <10000 lbs");
        String key = In.getKeys();
        if (key.equalsIgnoreCase("<6000 lbs")) {
            String data = "Sorry, you need a different type of registration."; //End
            return data;
        } else if (key.equalsIgnoreCase("6000-10000 lbs")) {
            String data = "method here"; //Set to method tree for LowComVe
            return data;
        } else if (key.equalsIgnoreCase(">10000 lbs")) {
            String data = "method here"; //Set to method tree for HighComVe
            return data;
        }
        System.out.println("Invalid option");
        String data = CoVe(); //Loops CoVe() method until weight class chosen
        return data;

    }

    String endNewReg() {
        return "Sorry, you cannot get your New Registration today. Please come back another time.";
    }

}
