package gr.hua.it219151.profile;


import gr.hua.it219151.it219151;
import gr.hua.it219151.users.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateProfile {

    //the list of all users
    public static List<User> savedUsers = new ArrayList<>();

    public User createUser(){ // function that gathers user's information and returns a new User object
        System.out.println("Welcome to Create User Page!");

        savedUsers = it219151.allUsers; // get the allUsers static List of the Main class

        Scanner scanner = new Scanner(System.in); //reads user's input

        System.out.println("Give first name:");
        String fname = scanner.nextLine();

        System.out.println("Give last name:");
        String lname = scanner.nextLine();

        String regExAfm = "^[0-9]{9}$"; // this is a Regular Expression for an AFM only numbers 9 digit String
        String afm = "";
        while(true){ // loop to check proper AFM input and to be unique in system
            System.out.println("Give AFM:");
            afm = scanner.nextLine();
            boolean unique = true;
            if(afm.matches(regExAfm)){ // if AFM matches Regular expression
                for(User user: savedUsers){ // for every User in system
                    if(user.getAFM().equals(afm)){ // check for unique new AFM
                        unique = false;
                        System.out.println("This AFM already exists in our system!");
                    }
                }
                if(unique){ // if it is unique break loop and continue
                    break;
                }
            }
            else{
                System.out.println("This is an invalid AFM, please give 9 digit number!");
            }
        }

        System.out.println("Give Address:");
        String address = scanner.nextLine();

        System.out.println("Give ID Number:");
        String id = scanner.nextLine();

        System.out.println("Pick user Type, 'a' for Normal, 'b' for Student and 'c' for Professional:");
        String userTypeInput = scanner.nextLine();
        while (!userTypeInput.equals("a") && !userTypeInput.equals("b")  && !userTypeInput.equals("c") ){ // check for valid user input
            System.out.println("This is not a valid option, pick again!");
            userTypeInput = scanner.nextLine();
        }
        String usertype;
        if(userTypeInput.equals("a")){
            usertype = "NORMAL";
        }
        else if(userTypeInput.equals("b")){
            usertype = "STUDENT";
        }
        else{
            usertype = "PROFESSIONAL";
        }

        String regExEmail = "^(.+)@(.+)$"; // Regular Expression for valid email
        String email = "";
        while(true){
            System.out.println("Give email:");
            email = scanner.nextLine();
            if(email.matches(regExEmail)){ // if Email matches Regular expression
                break;
            }
            else{
                System.out.println("This is an invalid Email Address!");
            }
        }

        String password = "pass" + afm;
        System.out.println("Your password is: " + password);

        User newUser = new User(fname,lname,afm,address,id,usertype,email,password,0);

        return newUser; // return the new User object
    }
}
