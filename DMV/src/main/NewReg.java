
//inomplete
package main;
import java.util.Scanner;

class RegistrationNode {
    String veType;
    RegistrationNode left, right;

    public RegistrationNode(String veType) {
        this.veType = veType;
        this.left = this.right = null;
    }
}

public class NewReg {
    private RegistrationNode root;
    Scanner input = new Scanner(System.in);

    public NewReg() {
        root = null;
    }

    public void insertVeType(String veType) { // method that inserts a new registration id
        root = insertRec(root, veType);
    }

    private RegistrationNode insertRec(RegistrationNode root, String veType) {
        if (root == null) {
            root = new RegistrationNode(veType);
            return root;
        }
        if (veType.compareTo(root.veType) < 0)
            root.left = insertRec(root.left, veType);
        else if (veType.compareTo(root.veType) > 0)
            root.right = insertRec(root.right, veType);
        return root;
    }

    private boolean searchVeType(String veType) { // method to search for a registration id in bst
        return searchRec(root, veType);
    }

    private boolean searchRec(RegistrationNode root, String veType) {
        if (root == null) return false;
        if (veType.equals(root.veType)) return true;
        if (veType.compareTo(root.veType) < 0)
            return searchRec(root.left, veType);
        else
            return searchRec(root.right, veType);
    }

    public void newRegistration() {
        System.out.println("=== New Vehicle Registration ===");
        System.out.print("What type of vehicle are you registering today?");
        System.out.print("Type \"Deal\" for Dealership Purchase, \"Moto\" for Motorcycle, or \"Comm\" for Commercial Vehicle");
        String veType = input.nextLine();

        if (searchVeType(veType)) { // validates the user's input
            System.out.println("Creating a new registration for vehicle type: " + veType);
            System.out.println("New registration created successfully.");
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public static void main(String[] args) {
        NewReg newReg = new NewReg();
        newReg.insertVeType("Deal");
        newReg.insertVeType("Moto");
        newReg.insertVeType("Comm");

        newReg.newRegistration();
    }
}
