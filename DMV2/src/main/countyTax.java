package main;

public class countyTax {
	double County(String key, double fee) {
        double data = fee;
         if (key.equalsIgnoreCase("Alameda") 
                 || key.equalsIgnoreCase("Arcadia")
                 || key.equalsIgnoreCase("Burbank")
                 || key.equalsIgnoreCase("Glendale")
                 || key.equalsIgnoreCase("San Fernando")) {
             data = tax1(fee); //calculate county fee
            return data;
        } else if (key.equalsIgnoreCase("Antioch") 
                 || key.equalsIgnoreCase("Capitola")
                 || key.equalsIgnoreCase("Concord")
                 || key.equalsIgnoreCase("San Jose")
                 || key.equalsIgnoreCase("Santa Cruz")) {
             data = tax2(fee); //calculate county fee
            return data;
        } else if (key.equalsIgnoreCase("Bakersfield") 
                 || key.equalsIgnoreCase("Chico")
                 || key.equalsIgnoreCase("Fairfield")
                 || key.equalsIgnoreCase("Fresno")
                 || key.equalsIgnoreCase("Sacramento")) {
             data = tax3(fee); //calculate county fee
            return data;
        }else if (key.equalsIgnoreCase("Other") 
                 || key.equalsIgnoreCase("Loomis")
                 || key.equalsIgnoreCase("Mount Shasta")
                 || key.equalsIgnoreCase("Paradise")
                 || key.equalsIgnoreCase("Wheatland")) {
             data = tax4(fee); //calculate county fee
            return data;
        }
       
       return data;
    }
    

    double tax1(Double newRegFee){
        double tax = 0.10 * newRegFee;
        return tax;
    }
    
    double tax2(Double newRegFee){
        double tax = 0.09 * newRegFee;
        return tax;
    }
    
     double tax3(Double newRegFee){
        double tax = 0.08 * newRegFee;
        return tax;
    }
     
      double tax4(Double newRegFee){
        double tax = 0.07 * newRegFee;
        return tax;
    }
}
