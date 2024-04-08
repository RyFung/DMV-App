package main;
import java.util.Scanner;

public class RenewReg {

    Scanner input = new Scanner(System.in);

    public void renewRegistration() {
        System.out.println("=== Vehicle Registration Renewal ===");

        System.out.print("Enter your vehicle's registration ID: "); // prompt for registration id
        String registrationId = input.nextLine();


        if(isValidRegistrationId(registrationId)) { // simulate validation, has to check against database or records later)

            System.out.println("Renewing registration for ID: " + registrationId); // simulate renewal process
            System.out.println("Registration renewed successfully."); // more steps can be added here, like payment processing
        } else {
            System.out.println("Invalid registration ID. Please try again.");
        }
    }

    private boolean isValidRegistrationId(String registrationId) {

        return registrationId != null && !registrationId.trim().isEmpty(); // some placeholder for actual validation logic
    }

    public static void main(String[] args) {
        RenewReg renewReg = new RenewReg(); // simple test run of the renewal process
        renewReg.renewRegistration();
    }
}