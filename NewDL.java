package main;

import java.util.Scanner;

public class NewDL {
    public static void goThroughQuestionaire(TreeNode questionaire, Scanner myObj) {
        questionaire.displayQuestion();

        if (questionaire.optionA != null && questionaire.optionB != null) {
            String choice = myObj.nextLine(); // Get user input
            while (!choice.equals("A") && !choice.equals("B")) { // Validate user input
                System.out.println("Invalid choice. Please enter 'A' or 'B'.");
                choice = myObj.nextLine(); // Re-prompt for valid input
            }

            // Recur to the next appropriate node
            if (choice.equals("A")) {
                goThroughQuestionaire(questionaire.optionA, myObj);
            } else {
                goThroughQuestionaire(questionaire.optionB, myObj);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner myObj = new Scanner(System.in)) { // Use try-with-resources for automatic Scanner closure
            TreeNode age = new TreeNode("Are You Over 16? Pick A or B, A: Yes, B: No.");

            TreeNode overSixteen = new TreeNode("Do you live in California? Pick A or B, A: Yes, B: No.");
            TreeNode tooYoung = new TreeNode("You need to be over 16 to receive a valid California driver's license.");

            age.optionA = overSixteen;
            age.optionB = tooYoung;

            TreeNode inState = new TreeNode("Did you pass the written and practical tests? Pick A or B, A: Yes, B: No.");
            TreeNode outState = new TreeNode("Are you a valid resident? Pick A or B, A: Yes, B: No.");

            overSixteen.optionA = inState;
            overSixteen.optionB = outState;

            TreeNode passed = new TreeNode("Do you want RealID or a regular ID? A: RealID, B: Regular ID");
            TreeNode failed = new TreeNode("You need to pass the written and practical test first.");

            inState.optionA = passed;
            inState.optionB = failed;

            TreeNode realID = new TreeNode("Do you live in Placer County or Sacramento County? A: Sacramento, B: Placer");
            TreeNode regularID = new TreeNode("Do you live in Placer County or Sacramento County? A: Sacramento, B: Placer");

            passed.optionA = realID;
            passed.optionB = regularID;

            TreeNode realIdSac = new TreeNode("Your total cost is $65 for RealID in Sacramento.");
            TreeNode realIdPlacer = new TreeNode("Your total cost is $60 RealID in Placer.");

            realID.optionA = realIdSac;
            realID.optionB = realIdPlacer;

            TreeNode regIdSac = new TreeNode("Your total cost is $55 for a regular ID in Sacramento.");
            TreeNode regIdPlacer = new TreeNode("Your total cost is $50 for a regular ID in Placer.");

            regularID.optionA = regIdSac;
            regularID.optionB = regIdPlacer;

            // Start the questionnaire
            goThroughQuestionaire(age, myObj); // Pass the same Scanner through recursion
        }
    }
}

class TreeNode {
    public String question;
    public TreeNode optionA;
    public TreeNode optionB;

    public TreeNode(String question) {
        this.question = question; // Constructor initializes question
    }

    public void displayQuestion() {
        System.out.println(this.question); // Display the question
    }
}
