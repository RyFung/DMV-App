package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;


public class reLicLog {

	public Double LicenseRenewalFee(String expirationDateString, Boolean licenseClass, String county) {
        
        // 2. check license has not expired for more than 60 days
        
        boolean hasLicenseExpiredLong = expiredOver60Days(expirationDateString);
        if (hasLicenseExpiredLong) { // simulate validation, has to check against database or records later)
            return 0.0;
        } 
        
        // 3. check the license class and charge commercial license $58 otherwise $48
      
        
        boolean isComm = licenseClass;
        double baseFee = isComm ? 58.0 : 48.0;

       
        double countyFee = getCountyFee(county);

        double totalFee = baseFee + countyFee;
        return totalFee;
    }

    // returns true of license expired more than 60 days ago otherwise returns
    boolean expiredOver60Days(String expirationDateString) {
        // Convert expiration date into data format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate expiryDate = LocalDate.parse(expirationDateString, format);
        LocalDate currentDate = LocalDate.now();

        // Calculate the difference in days
        long daySinceExpired = currentDate.toEpochDay() - expiryDate.toEpochDay();

        return daySinceExpired > 60;
    }

    
    // Get county fee based on county name
    private double getCountyFee(String county) {
        switch (county) {
            case "Alameda":
            case "Antioch":
            case "Arcadia":
            case "Bakersfield":
            case "Burbank":
            case "Capitola":
            case "Chico":
            case "Concord":
            case "Fairfield":
            case "Fresno":
                return 10.0;
            case "Glendale":
            case "Loomis":
            case "Mount Shasta":
            case "Paradise":
            case "Sacramento":
                return 15.0;
            case "San Fernando":
            case "San Jose":
            case "Santa Cruz":
                return 20.0;
            case "Wheatland":
                return 25.0;
            default:
                return 5.0; // Default county fee
        }
    }

}
