package gr.hua.it219151;

import gr.hua.it219151.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    //the list of all users
    public static List<User> savedUsers = new ArrayList<>();

    public User loginUser(){
        System.out.println("Welcome to Login Page!");

        savedUsers = it219151.allUsers; // get the allUsers static List of the Main class

        Scanner scanner = new Scanner(System.in); //reads user's input

        String userInput = ""; //saves user's input

        while(true){ //infinite loop that runs Login page
            System.out.println("Give AFM:");
            String afm = scanner.nextLine();

            System.out.println("Give Password:");
            String password = scanner.nextLine();

            for(User user: savedUsers){ // check if AFM and Password combination exists in the system
                if(user.getAFM().equals(afm) && user.getPassword().equals(password)){ // if credentials match
                    return user; // return User and leave Login page
                }

            }
            System.out.println("Wrong Credentials! Press 'a' to try Login again " +
                    "or 'b' to go back to Main Page!");
            userInput = scanner.nextLine();
            while (!userInput.equals("a") && !userInput.equals("b")){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                userInput = scanner.nextLine();
            }

            if(userInput.equals("b")){ //check if exit action was selected
                break; //exit Loop
            }
        }
        System.out.println("Back to Main Page!");
        return null; // return empty User

    }
}
