package main;
import java.util.Scanner;

class RegistrationNode {
    String registrationId;
    RegistrationNode left, right;

    public RegistrationNode(String registrationId) {
        this.registrationId = registrationId;
        this.left = this.right = null;
    }
}

public class RenewReg {
    private RegistrationNode root;
    Scanner input = new Scanner(System.in);

    public RenewReg() {
        root = null;
    }

    public void insertRegistrationId(String registrationId) { // method that inserts a new registration id
        root = insertRec(root, registrationId);
    }

    private RegistrationNode insertRec(RegistrationNode root, String registrationId) {
        if (root == null) {
            root = new RegistrationNode(registrationId);
            return root;
        }
        if (registrationId.compareTo(root.registrationId) < 0)
            root.left = insertRec(root.left, registrationId);
        else if (registrationId.compareTo(root.registrationId) > 0)
            root.right = insertRec(root.right, registrationId);
        return root;
    }

    private boolean searchRegistrationId(String registrationId) { // method to search for a registration id in bst
        return searchRec(root, registrationId);
    }

    private boolean searchRec(RegistrationNode root, String registrationId) {
        if (root == null) return false;
        if (registrationId.equals(root.registrationId)) return true;
        if (registrationId.compareTo(root.registrationId) < 0)
            return searchRec(root.left, registrationId);
        else
            return searchRec(root.right, registrationId);
    }

    public void renewRegistration() {
        System.out.println("=== Vehicle Registration Renewal ===");
        System.out.print("Enter your vehicle's registration ID: ");
        String registrationId = input.nextLine();

        if (searchRegistrationId(registrationId)) { // validates and renews the registration id
            System.out.println("Renewing registration for ID: " + registrationId);
            System.out.println("Registration renewed successfully.");
        } else {
            System.out.println("Invalid registration ID. Please try again.");
        }
    }

    public static void main(String[] args) {
        RenewReg renewReg = new RenewReg();
        renewReg.insertRegistrationId("REG123");
        renewReg.insertRegistrationId("REG456");
        renewReg.insertRegistrationId("REG789");

        renewReg.renewRegistration();
    }
}