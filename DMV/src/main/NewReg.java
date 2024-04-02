package main;

public class NewReg { //Methods behind New Registration 


    private Input In = new Input();

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

    String DePu() {
        System.out.println("Type Pass Smog Check or Fail Smog Check");
        String key = In.getKeys();
        if (key.equalsIgnoreCase("Pass Smog Check")) {
            String data = "method here"; //Set to method tree for PassSC
            return data;
        } else if (key.equalsIgnoreCase("Fail Smog Check")) {
            String data = endNewReg(); //End NewReg run
            return data;
        }
        System.out.println("Invalid option");
        String data = DePu(); //Loops DePu() method until Pass or Fail chosen
        return data;
    }

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
