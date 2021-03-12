package gr.hua.it219151;

import gr.hua.it219151.contracts.Contract;
import gr.hua.it219151.profile.CreateProfile;
import gr.hua.it219151.profile.UserProfile;
import gr.hua.it219151.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class it219151 {

    /*
    All of the system's Users and Contracts will be saved in two Lists (allUsers, allContracts)
    These Lists will be static which means that only one instance of these static members
    is created which is shared across all instances of the Main class
     */

    //the list of all users
    public static List<User> allUsers = new ArrayList<>();

    //the list of all contracts
    public static List<Contract> allContracts = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Welcome to JavaPhone Application!");

        //Initial Users objects
        User u1 = new User("Stavroula","Pratti","123456789","Address 1","ID 123456789", "STUDENT", "stav@mail.com","pass1234567890",0);
        User u2 = new User("Despoina","Pratti","123456780","Address 2","ID 123456780", "NORMAL", "desp@mail.com","pass1234567891",0);
        User u3 = new User("Panagiotis","Prattis","123456781","Address 3","ID 123456781", "PROFESSIONAL", "pan@mail.com","pass1234567892",0);

        //Insert initial users
        allUsers.add(u1);
        allUsers.add(u2);
        allUsers.add(u3);

        //Initial Contracts objects
        Contract c1 = new Contract("id_12345", "LANDLINE", "2101234567", "123456789", "pass123456789", 2000, "01-01-2021", "TWOYEARS", 5,true, "CREDIT", "VDSL",0,0);
        Contract c2 = new Contract("id_12344", "MOBILE", "6912345678", "123456789", "pass123456789", 1000, "01-01-2019", "ONEYEAR", 5,true, "CREDIT", "DATA",1000,1000);

        //Insert initial contracts
        allContracts.add(c1);
        allContracts.add(c2);

        Scanner scanner = new Scanner(System.in); //reads user's input

        String userInput = ""; //saves user's input

        //infinite loop that runs app
        while (true){
            System.out.println("Pick an action 'a' to create profile, " +
                    "'b' to login " +
                    "or 'c' to logout!");

            userInput = scanner.nextLine(); //read user input

            while (!userInput.equals("a") && !userInput.equals("b")  && !userInput.equals("c") ){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                userInput = scanner.nextLine();
            }

            if(userInput.equals("a")){ //check which action was selected
                CreateProfile createProfile = new CreateProfile(); // create instance of CreateProfile class
                allUsers.add(createProfile.createUser()); // add a new user calling CreateProfile's createUser method that returns User object
            }
            else if(userInput.equals("b")){
                Login login = new Login();
                UserProfile userProfile = new UserProfile();
                User loggedUser = login.loginUser(); // call Login's loginUser method to get a user from the system
                if (loggedUser != null) // if a user logged in
                    userProfile.userActions(loggedUser); // call UserProfile's userActions method and pass the logged User object
            }
            else{
                break; // program finishes
            }

        }
        System.out.println("Thank you for using JavaPhone!");
    }
}
