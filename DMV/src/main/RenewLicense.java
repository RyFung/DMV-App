
package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Random;

public class RenewLicense {

    Scanner scanner = new Scanner(System.in);

    public void startLicenseRenewal() {
        System.out.println("License Renewal Starts Program Starts");

        System.out.print("Enter your License Number: "); // prompt for registration id
        String licenseNumber = scanner.nextLine();

        System.out.println("Here is license number: " + licenseNumber);

        // 1. check License is not suspended
        boolean hasLicenseSus = isSuspended(licenseNumber);
        if (hasLicenseSus) { // simulate validation, has to check against database or records later)
            System.out.println("License is suspended");
            endLicenseRenewal();
            return;
        } 
        
        // 2. check license has not expired for more than 60 days
        System.out.print("Enter license expiration data in mm-dd-yyyy format: ");
        String expirationDateString = scanner.nextLine();
        boolean hasLicenseExpiredLong = expiredOver60Days(expirationDateString);
        if (hasLicenseExpiredLong) { // simulate validation, has to check against database or records later)
            System.out.println("License has expired for more than 60 days, so we can't renew it. Apply again");
            endLicenseRenewal();
            return;
        } 
        
        //3. check the license class and charge commercial license $58 otherwise $48
        System.out.print("Enter license class: commercial or noncommercial ");
        String licenseClass = scanner.nextLine();
        boolean isComm = isCommercial(licenseClass);
        if (isComm) { // simulate validation, has to check against database or records later)
            System.out.println("License is commercia. Renewal fee is $58.");
        } else {
            System.out.println("License is noncommercial. Renewal fee is $45.");
        }
        
        System.out.println("Congratulations. Your License is now renewed");

        return;
      
    }

    //returns true of license expired more than 60 days ago otherwise returns
    boolean expiredOver60Days(String expirationDateString) {
        // Convert expiration date into data format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate expiryDate = LocalDate.parse(expirationDateString, format);
        LocalDate currentDate = LocalDate.now();

        // Calculate the difference in days
        long daySinceExpired = currentDate.toEpochDay() - expiryDate.toEpochDay();
        //System.out.println("Now: " + currentDate + "  days since epoch " + currentDate.toEpochDay());
        //System.out.println("expiry date: " + expiryDate + "  days since epoch " + expiryDate.toEpochDay());
        //System.out.println(" days: " + daySinceExpired);

        if (daySinceExpired > 60) { // simulate validation, has to check against database or records later)
            //System.out.println("License has expired for more than 60 days, so we can't renew it. Apply again");
            return true;

        } else {
            //System.out.println("Expiry date is ok");
            return false;
        }
    }
    
    //returns true if license is suspended otherwise it return false
    boolean isSuspended(String licenceID) {
        Random random = new Random();
        boolean result = random.nextBoolean();
        result = false;
        //System.out.println("Randomly picked: " + result); 
        return result;
    }
    
    //returns true if license is commercial otherwise it returns false
    boolean isCommercial(String licenseClass) {
    	String input = "Commercial";
    	if (input.equalsIgnoreCase(licenseClass)) {
    		//System.out.println("The string is equal to 'commercial' (case-insensitive).");
    		return true;
        } else {
        	//System.out.println("The string is not equal to 'commercial' (case-insensitive).");
        	return false;
        }
    }
    
    void endLicenseRenewal() {
    	System.out.println("You cannot get your License today. Please complete the DMV requirements.");
    }
          
    public static void main(String[] args) {
        RenewLicense renewLic = new RenewLicense(); // simple test run of the renewal process
        renewLic.startLicenseRenewal();
    }
}
