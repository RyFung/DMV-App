package main;
import java.util.Scanner;

public class RenewReg {
    Scanner input = new Scanner(System.in);

    public void renewRegistration() {
        System.out.println("=== DMV Registration Renewal ===");

        System.out.print("Enter your county of residence: ");
        String county = input.nextLine();
        double countyFee = getCountyFee(county);

        System.out.print("Upgrade to Real ID (yes/no)? ");
        boolean upgradeToRealID = "yes".equalsIgnoreCase(input.nextLine());

        System.out.print("Did you pass the vision test (pass/fail)? ");
        boolean visionTestPassed = "pass".equalsIgnoreCase(input.nextLine());

        System.out.print("Did you pass the knowledge test (pass/fail)? ");
        boolean knowledgeTestPassed = "pass".equalsIgnoreCase(input.nextLine());

        if (!visionTestPassed || !knowledgeTestPassed) {
            System.out.println("You must pass both the vision and knowledge tests to renew your registration.");
            return;
        }

        int totalCost = calculateCosts(upgradeToRealID, countyFee);

        System.out.println("All tests passed. Proceeding with registration renewal.");
        System.out.println("Total Cost: $" + totalCost);
        System.out.println("Registration renewed successfully.");
    }

    private int calculateCosts(boolean upgradeToRealID, double countyFee) {
        int baseCost = 45; // base renewal cost

        if (upgradeToRealID) {
            baseCost += 35; // assuming an additional $35 for real id upgrade
        }

        return (int) (baseCost + countyFee);
    }

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
                return 5.0;
        }
    }

    public static void main(String[] args) {
        RenewReg renewReg = new RenewReg();
        renewReg.renewRegistration();
    }
}
