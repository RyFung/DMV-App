package main;
import java.util.Scanner;

public class RenewReg {
    Scanner input = new Scanner(System.in);

    public void renewRegistration() {
        System.out.println("=== DMV Registration Renewal ===");

        System.out.print("Upgrade to Real ID (yes/no)? "); // user decides on upgrading to real id
        boolean upgradeToRealID = "yes".equalsIgnoreCase(input.nextLine());

        System.out.print("Did you pass the vision test (pass/fail)? "); // user takes a vision test
        boolean visionTestPassed = "pass".equalsIgnoreCase(input.nextLine());

        System.out.print("Did you pass the knowledge test (pass/fail)? "); // user takes knowledge test
        boolean knowledgeTestPassed = "pass".equalsIgnoreCase(input.nextLine());

        int totalCost = calculateCosts(upgradeToRealID); // calculating costs with real id upgrade option

        if (!visionTestPassed || !knowledgeTestPassed) { // checking if user passed both tests
            System.out.println("You must pass both the vision and knowledge tests to renew your registration.");
            return; // exits the method early if failure occurs
        }

        System.out.println("All tests passed. Proceeding with registration renewal."); // proceeds with renewal if tests are passed
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Registration renewed successfully.");
    }

    private int calculateCosts(boolean upgradeToRealID) {
        int baseCost = 45; // base renewal cost

        if (upgradeToRealID) {
            baseCost += 35; // assuming an additional $35 for real id upgrade
        }

        return baseCost;
    }

    public static void main(String[] args) {
        RenewReg renewReg = new RenewReg();
        renewReg.renewRegistration();
    }
}