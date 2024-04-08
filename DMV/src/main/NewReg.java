package main;

import java.util.Scanner;

public class NewReg { //Methods behind New Registration 

    Scanner input = new Scanner(System.in);
    double price; //price of vehicle at purchase
    double newRegFee; //total new registration fee
    double weight; //weight of commercial vehicle

    String run() {
        String data = startNewReg(); //Set to startNewReg method
        return data;
    }

    String startNewReg() {
        System.out.println("----------New Registration----------");
        System.out.println("What type of vehicle do you want to register?");
        System.out.println("Type \"1\" for Dealership Purchase, \"2\" for Motorcycle, or \"3\" for Commercial Vehicle");
        String key = input.nextLine();
        if (key.equalsIgnoreCase("1")) {
            String data = DePu();
            return data;
        } else if (key.equalsIgnoreCase("2")) {
            String data = Moto();
            return data;
        } else if (key.equalsIgnoreCase("3")) {
            String data = CoVe();
            return data;
        }
        System.out.println("Invalid option");
        String data = startNewReg(); //Loops startNewReg() method until valid input is given
        return data;

    }
//Start of DePu Branch

    String DePu() {
        System.out.println("Did your vehicle pass its smog check?");
        System.out.println("Please type \"Pass\" or \"Fail\": "); //split into Pass or Fail Smog Check Branches
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Pass")) {
            String data = DPCashOrCredit(); //Set to method tree for DPCashOrCheck
            return data;
        } else if (key.equalsIgnoreCase("Fail")) {
            String data = endNewReg(); //End NewReg run
            return data;
        }
        System.out.println("Invalid option");
        String data = DePu(); //Loops DePu() method until Pass or Fail chosen
        return data;
    }

    String DPCashOrCredit() {
        System.out.println("Please select \"Cash\" or \"Credit\" for your payment option: "); //split into Cash or Credit Branches
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Cash")) {
            String data = DPCash(); //Set to method tree for Cash
            return data;
        } else if (key.equalsIgnoreCase("Credit")) {
            String data = DPCredit(); //Set to method tree for Credit
            return data;
        }
        System.out.println("Invalid option");
        String data = DPCashOrCredit(); //Loops DPCashRrCredit() method until Cash or Credit Chosen
        return data;

    }

    String DPCash() {
        System.out.println("You selected Cash as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
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
        System.out.println("Do you have a Motorcycle License?");
        System.out.println("Please type \"Yes\" or \"No\": "); //splits into yes or no license
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Yes")) {
            String data = MotoInsur(); //Set to method tree for MotoInsur
            return data;
        } else if (key.equalsIgnoreCase("No")) {
            String data = endNewReg(); //End NewReg run
            return data;
        }
        System.out.println("Invalid option");
        String data = Moto(); //Loops Moto() method until Yes or No chosen
        return data;

    }

    String MotoInsur() {
        System.out.println("Do you have Motorcycle Insurance?");
        System.out.println("Please type \"Yes\" or \"No\": "); //splits into yes or no insurance
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Yes")) {
            String data = MTCashOrCredit(); //Set to method tree for MotoLicense
            return data;
        } else if (key.equalsIgnoreCase("No")) {
            String data = endNewReg(); //End NewReg run
            return data;
        }
        System.out.println("Invalid option");
        String data = MotoInsur(); //Loops Moto() method until Yes or No
        return data;

    }

    String MTCashOrCredit() {
        System.out.println("Please select \"Cash\" or \"Credit\" for your payment option: "); //split into Cash or Credit Branches
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Cash")) {
            String data = MTCash(); //Set to method tree for Cash
            return data;
        } else if (key.equalsIgnoreCase("Credit")) {
            String data = MTCredit(); //Set to method tree for Credit
            return data;
        }
        System.out.println("Invalid option");
        String data = MTCashOrCredit(); //Loops MTCashorCredit() method until Cash or Credit Chosen
        return data;

    }

    String MTCash() {
        System.out.println("You selected Cash as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0065) + 80);
        String data = MTSuccess(); //Displays MTSuccess()
        return data;

    }

    String MTCredit() {
        System.out.println("You selected Credit as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0068) + 80);
        String data = MTSuccess(); //Displays MTSuccess()
        return data;

    }

    String MTSuccess() {
        String data = "Congratulations! You successfully completed New Registration for your Motorcycle!/nTotal fees you must pay: $" + newRegFee;
        return data;

    }

//Start of CoVe branch
    String CoVe() {
        System.out.println("What is the unladen weight of your Commercial Vehicle?"); //splits into low, medium, or high branches
        System.out.println("Please type the weight in pounds: ");
        weight = input.nextFloat();
        if (weight <= 6000) {
            String data = "Sorry, you need a different type of registration."; //End
            return data;
        } else if (weight > 6000 && weight <= 10000) {
            String data = MedCV(); //Set to method tree for MedCV
            return data;
        } else if (weight > 10000) {
            String data = HighCVCashOrCredit(); //Set to method tree for HighCVCashOrCredit
            return data;
        }
        System.out.println("Invalid option");
        String data = CoVe(); //Loops CoVe() method until valid weight chosen
        return data;

    }

    String MedCV() {
        System.out.println("Does your Commercial Vehicle haul another vehicle?");
        System.out.println("Please type \"Yes\" or \"No\": "); //splits into  GVW or CGW
        String key = input.nextLine();
        if (key.equalsIgnoreCase("No")) {
            String data = GVWCashOrCredit(); //Set to method tree for GVWCashOrCredit
            return data;
        } else if (key.equalsIgnoreCase("Yes")) {
            String data = CGWCashOrCredit(); //Set to method tree for CGWCashOrCredit
            return data;
        }
        System.out.println("Invalid option");
        String data = MotoInsur(); //Loops MedCV() method until Yes or No
        return data;

    }

    String GVWCashOrCredit() {
        System.out.println("Your fee will be based on Declared GVW, which is the total unladen weight of the vehicle");
        System.out.println("plus the weight of the heaviest load that will be transported on the vehicle.");
        System.out.println("\nPlease select \"Cash\" or \"Credit\" for your payment option: "); //split into Cash or Credit Branches
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Cash")) {
            String data = GVWCash(); //Set to method tree for Cash
            return data;
        } else if (key.equalsIgnoreCase("Credit")) {
            String data = GVWCredit(); //Set to method tree for Credit
            return data;
        }
        System.out.println("Invalid option");
        String data = MTCashOrCredit(); //Loops GVWCashorCredit() method until Cash or Credit Chosen
        return data;
    }

    String GVWCash() {
        System.out.println("You selected Cash as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0065) + 80);
        String data = CVSuccess(); //Displays CVSuccess()
        return data;

    }

    String GVWCredit() {
        System.out.println("You selected Credit as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0068) + 80);
        String data = CVSuccess(); //Displays CVSuccess()
        return data;

    }

    String CGWCashOrCredit() {
        System.out.println("Your fee will be based on Declared CGW, which is the total unladen weight of the combination of vehicles");
        System.out.println("plus the weight of the heaviest load that will be transported by that combination.");
        System.out.println("\nPlease select \"Cash\" or \"Credit\" for your payment option: "); //split into Cash or Credit Branches
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Cash")) {
            String data = CGWCash(); //Set to method tree for Cash
            return data;
        } else if (key.equalsIgnoreCase("Credit")) {
            String data = CGWCredit(); //Set to method tree for Credit
            return data;
        }
        System.out.println("Invalid option");
        String data = CGWCashOrCredit(); //Loops CGWCashorCredit() method until Cash or Credit Chosen
        return data;
    }

    String CGWCash() {
        System.out.println("You selected Cash as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0066) + 80);
        String data = CVSuccess(); //Displays CVSuccess()
        return data;

    }

    String CGWCredit() {
        System.out.println("You selected Credit as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0069) + 80);
        String data = CVSuccess(); //Displays CVSuccess()
        return data;

    }

    //calculate CRVA fees for CVs over 10000 lbs
    int GetCRVA() {
        System.out.println("What is the heaviest combined gross weight of your vehicle?");
        System.out.println("Please enter the weight in pounds: ");
        weight = input.nextFloat();
        if (weight > 10000 && weight <= 20000) {
            return 400;
        } else if (weight > 20000 && weight <= 30000) {
            return 550;
        } else if (weight > 30000 && weight <= 40000) {
            return 800;
        } else if (weight > 40000 && weight <= 50000) {
            return 1100;
        } else if (weight > 50000 && weight <= 60000) {
            return 1400;
        } else if (weight > 60000 && weight <= 70000) {
            return 1700;
        } else if (weight > 70000) {
            return 2000;
        }
        System.out.println("Invalid option");
        int data = GetCRVA(); //Loops GetCRVA() method until Cash or Credit Chosen
        return data;
    }

    String HighCVCashOrCredit() {
        System.out.println("Your fee will include a CRVA fee based on the weight range of your vehicle.");
        System.out.println("\nPlease select \"Cash\" or \"Credit\" for your payment option: "); //split into Cash or Credit Branches
        String key = input.nextLine();
        if (key.equalsIgnoreCase("Cash")) {
            String data = HCVCash(); //Set to method tree for Cash
            return data;
        } else if (key.equalsIgnoreCase("Credit")) {
            String data = HCVCredit(); //Set to method tree for Credit
            return data;
        }
        System.out.println("Invalid option");
        String data = HighCVCashOrCredit(); //Loops HighCVCashorCredit() method until Cash or Credit Chosen
        return data;
    }

    String HCVCash() {
        System.out.println("You selected Cash as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0066) + GetCRVA() + 80);
        String data = CVSuccess(); //Displays CVSuccess()
        return data;

    }

    String HCVCredit() {
        System.out.println("You selected Credit as your payment option.");
        System.out.println("Please input the price of your vehicle at time of purchase: ");
        price = input.nextFloat();
        newRegFee = (int) ((price * 0.0069) + GetCRVA() + 80);
        String data = CVSuccess(); //Displays CVSuccess()
        return data;

    }

    String CVSuccess() {
        String data = "Congratulations! You successfully completed New Registration for your Commercial Vehicle!/nTotal fees you must pay: $" + newRegFee;
        return data;

    }

//New Reg failure message
    String endNewReg() {
        return "Sorry, you cannot get your New Registration today. Please come back another time.";
    }


}
