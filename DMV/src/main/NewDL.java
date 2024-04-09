package main;

import java.util.Scanner;

public class NewDL {
        public static void goThroughQuestionaire(TreeNode questionaire) {
        questionaire.displayQuestion();
        
        if (questionaire.optionA != null && questionaire.optionB != null){
            Scanner myObj = new Scanner(System.in);
            String choice = "";
            choice = myObj.nextLine();
            while (!choice.equals("A") && !choice.equals("B")) {
                System.out.println("Invalid choice");
                choice = myObj.nextLine();
            }
            
            if (choice.equals("A")) {
                goThroughQuestionaire(questionaire.optionA);
            } else {
                goThroughQuestionaire(questionaire.optionB);
            }
            
            myObj.close();
        }
    }
   // public static void main(String[] args) {
        
        public void newDL(){
        // first node age
        TreeNode age = new TreeNode();
      age.question = "Are You Over 16? Pick A or B, A: yes. B: no.";
      
      
      TreeNode overSixteen = new TreeNode();
      overSixteen.question = "Do you live in California? Pick A or B, A: yes. B: no.";
      TreeNode tooYoung = new TreeNode();
      tooYoung.question = "You need to be over 16 to recieve a valid California driver's license.";
      
      age.optionA = overSixteen;
      age.optionB = tooYoung;
      
      TreeNode inState = new TreeNode();
      inState.question = "Did you pass written and practical test?  Pick A or B, A: yes. B: no.";
      TreeNode outState = new TreeNode();
      outState.question = "Are you a valid resident? Pick A or B, A: yes. B: no.";
      
      overSixteen.optionA = inState;
      overSixteen.optionB = outState;
        
      TreeNode valid_res = new TreeNode();
        valid_res.question = "Do you have a valid driver's license from another state? Pick A or B, A: yes. B: no.";
      TreeNode not_valid_res = new TreeNode();
      not_valid_res.question = "You can not get a California driver's license.";
      
      outState.optionA = valid_res;
      outState.optionB = not_valid_res;
      
      TreeNode valid_outstateL = new TreeNode();
      valid_outstateL.question = "Do you want RealID or regular ID? Pick A or B, A: yes. B: no.";
      TreeNode not_valid_outstateL = new TreeNode();
      not_valid_outstateL.question = "You can not get a driver's license.";
      
      valid_res.optionA = valid_outstateL;
      valid_res.optionB = not_valid_outstateL;
      
      TreeNode out_realID = new TreeNode();
      out_realID.question = "You pay $35.";
      TreeNode out_regularID = new TreeNode();
      out_regularID.question = "You pay $30.";
      
      valid_outstateL.optionA = out_realID;
      valid_outstateL.optionB = out_regularID;
      
      TreeNode passed = new TreeNode();
      passed.question = "Do you want RealID or a regular ID? A: RealID, B: Regular ID";
      TreeNode failed = new TreeNode();
      failed.question = "You need to pass the written and practical test first.";
      
      inState.optionA = passed;
      inState.optionB = failed;
      
      TreeNode realId = new TreeNode();
      realId.question = "Give us $35";
      TreeNode regularId = new TreeNode();
      regularId.question = "Give us $30";
      
      passed.optionA = realId;
      passed.optionB = regularId;
      
      goThroughQuestionaire(age);
    }
}

class TreeNode {
    public String question;
    public TreeNode optionA;
    public TreeNode optionB;
    
    public void displayQuestion() {
        System.out.println(this.question);
    }

}

