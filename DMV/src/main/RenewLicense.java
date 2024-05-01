
package main;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class RenewLicence {

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
        
        // 3. check the license class and charge commercial license $58 otherwise $48
        System.out.print("Enter license class: commercial or noncommercial ");
        String licenseClass = scanner.nextLine();
        boolean isComm = isCommercial(licenseClass);
        double baseFee = isComm ? 58.0 : 48.0;

        // 4. Get county fee based on user input
        System.out.println("Enter your county of residence from the provided list:");
        System.out.println("Alameda, Antioch, Arcadia, Bakersfield, Burbank, Capitola, Chico, Concord, Fairfield, Fresno");
        System.out.println("Glendale, Loomis, Mount Shasta, Paradise, Sacramento, San Fernando, San Jose, Santa Cruz, Wheatland");
        System.out.println("Please enter \"Other\" if your county is not listed above.");
        String county = scanner.nextLine();
        double countyFee = getCountyFee(county);

        double totalFee = baseFee + countyFee;

        if (isComm) {
            System.out.println("License is commercial. Renewal fee is $" + totalFee);
        } else {
            System.out.println("License is noncommercial. Renewal fee is $" + totalFee);
        }

        System.out.println("Congratulations. Your License is now renewed");
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

    // returns true if license is suspended otherwise it returns false
    boolean isSuspended(String licenceID) {
        Random random = new Random();
        boolean result = random.nextBoolean();
        result = false;
        return result;
    }

    // returns true if license is commercial otherwise it returns false
    boolean isCommercial(String licenseClass) {
        String input = "Commercial";
        return input.equalsIgnoreCase(licenseClass);
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

    void endLicenseRenewal() {
        System.out.println("You cannot get your License today. Please complete the DMV requirements.");
    }

    public static void main(String[] args) {
        Lep renewLic = new Lep(); // simple test run of the renewal process
        renewLic.startLicenseRenewal();
    }
}
