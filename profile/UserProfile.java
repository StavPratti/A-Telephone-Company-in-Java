package gr.hua.it219151.profile;

import gr.hua.it219151.actions.CreateContract;
import gr.hua.it219151.actions.DeleteContract;
import gr.hua.it219151.actions.GeneralContractInformation;
import gr.hua.it219151.users.User;

import java.util.Scanner;

public class UserProfile {

    public void userActions(User loggedUser){
        System.out.println("Welcome to User Profile Page " + loggedUser.getFirstName() + " " + loggedUser.getLastName() +"!");

        Scanner scanner = new Scanner(System.in); //reads user's input

        String userInput = ""; //saves user's input

        //infinite loop that runs profile page
        while (true){
            System.out.println("Pick a User action, insert 'a' to create contract, " +
                    "insert 'b' to delete contract, " +
                    "insert 'c' to show statistics & active contracts," +
                    "or insert 'd' to logout!");

            userInput = scanner.nextLine(); //read user input

            while (!userInput.equals("a") && !userInput.equals("b")  && !userInput.equals("c") && !userInput.equals("d")){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                userInput = scanner.nextLine();
            }

            if(userInput.equals("a")){ //check which action was selected
                CreateContract createContract = new CreateContract();
                createContract.insertContract(loggedUser);
            }
            else if(userInput.equals("b")){
                DeleteContract deleteContract = new DeleteContract();
                deleteContract.removeContract(loggedUser);
            }
            else if(userInput.equals("c")){
                GeneralContractInformation generalContractInformation = new GeneralContractInformation();
                generalContractInformation.showInformation(loggedUser);
            }
            else{
                break;
            }

        }
        System.out.println("Logging out! Back to Main Page!");

    }

}
