package gr.hua.it219151.actions;

import gr.hua.it219151.it219151;
import gr.hua.it219151.contracts.Contract;
import gr.hua.it219151.users.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CreateContract {

    //the list of all contracts
    public static List<Contract> savedContracts = new ArrayList<>();

    public void insertContract(User loggedUser){ // function that gathers contract's information and returns a new Contract object
        System.out.println("Welcome to Insert Contract Page!");

        savedContracts = it219151.allContracts; // get the allUsers static List of the Main class

        Scanner scanner = new Scanner(System.in); //reads user's input
        String userTypeInput = "";

        String ID = "id" + LocalDateTime.now().toString();

        System.out.println("Pick Contract Type, 'a' for Landline and 'b' for Mobile:");
        userTypeInput = scanner.nextLine();
        while (!userTypeInput.equals("a") && !userTypeInput.equals("b")){ // check for valid user input
            System.out.println("This is not a valid option, pick again!");
            userTypeInput = scanner.nextLine();
        }
        String contractType;
        if(userTypeInput.equals("a")){
            contractType = "LANDLINE";
        }
        else {
            contractType = "MOBILE";
        }

        String regExPhone = "^[0-9]{10}$"; // this is a Regular Expression for an Phone only numbers 10 digit String
        String phonenumber = "";
        while (true){ // check for valid phone number for given contract type
            System.out.println("Give phone Number:");
            phonenumber = scanner.nextLine();
            boolean unique = true;
            if(phonenumber.matches(regExPhone)) { // if Phone number matches Regular expression
                for(Contract c: savedContracts){ // for every User in system
                    if(c.getPhoneNumber().equals(phonenumber)){ // check for unique new Phone
                        unique = false;
                        System.out.println("This Phone number already exists in our system! Try Again!");
                    }
                }
                if (unique) { // if it is unique we also must check if it is mobile or landline phone number
                    if (contractType == "LANDLINE" && phonenumber.charAt(0) == '2') {
                        break;
                    } else if (contractType == "MOBILE" && phonenumber.charAt(0) == '6') {
                        break;
                    }
                    System.out.println("Phone number type doesn't match contract Type! Give again:");
                }
            }
            else{
                System.out.println("This is invalid phone number, please give 10 digit number!");
            }

        }

        //get User's AFM and password through User getters
        String afm = loggedUser.getAFM();

        String password = loggedUser.getPassword();

        int freeminutes = 0;
        String userChoice = "";

        System.out.println("You can choose between three free minute packages, " +
                "Pick 'a' for 1000 free minutes " +
                "'b' for 2500 minutes" +
                "or 'c' for 5000 minutes!");

        userChoice = scanner.nextLine(); //read user input

        while (!userChoice.equals("a") && !userChoice.equals("b")  && !userChoice.equals("c") ){ // check for valid user input
            System.out.println("This is not a valid option, pick again!");
            userChoice = scanner.nextLine();
        }

        if(userChoice.equals("a")){ //check which action was selected
            freeminutes = 1000;
        }
        else if(userChoice.equals("b")){
            freeminutes = 2500;
        }
        else{
            freeminutes = 5000;
        }

        //a european date format
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String inputDate = "";
        Date startDate = new Date();
        while(true){
            System.out.println("Give Date for contract activation in format dd-MM-yyyy (must be today or later):");
            inputDate = scanner.nextLine();

            boolean valid = true;
            try { // we check for valid date format
                formatter.parse(inputDate);
                startDate = formatter.parse(inputDate);
            } catch (ParseException pe) {
                valid = false;
            }

            if(valid) {
                Date now = new Date(); // we get the date time of now
                if (now.after(startDate)) { // we check if given date is lated than now
                    System.out.println("You can't give a past Date for a new Contract! Try again!");
                }
                else{
                    break;
                }
            }
        }

        System.out.println("Pick Contract Duration, 'a' for One Year and 'b' for Two Years:");
        userTypeInput = scanner.nextLine();
        while (!userTypeInput.equals("a") && !userTypeInput.equals("b")){ // check for valid user input
            System.out.println("This is not a valid option, pick again!");
            userTypeInput = scanner.nextLine();
        }
        String contractDuration;
        if(userTypeInput.equals("a")){
            contractDuration = "ONEYEAR";
        }
        else {
            contractDuration = "TWOYEARS";
        }

        System.out.println("We will now Calculate contract's Monthly Cost according to Contract Type and User Type.");
        int monthlyCost = 0;
        if(contractType.equals("LANDLINE")){
            if(loggedUser.getUserType().equals("NORMAL")){
                monthlyCost = 15;
            }
            else if(loggedUser.getUserType().equals("STUDENT")){
                monthlyCost = 5;
            }
            else{
                monthlyCost = 10;
            }
        }
        else{
            if(loggedUser.getUserType().equals("NORMAL")){
                monthlyCost = 12;
            }
            else if(loggedUser.getUserType().equals("STUDENT")){
                monthlyCost = 5;
            }
            else{
                monthlyCost = 8;
            }
        }
        System.out.println("This contract's monthly cost is: " + monthlyCost);

        boolean isEContract = true;
        System.out.println("Choose if you want Contract to be E-Contract, 'a' for E-Contract and 'b' for Physical Contract:");
        userTypeInput = scanner.nextLine();
        while (!userTypeInput.equals("a") && !userTypeInput.equals("b")){ // check for valid user input
            System.out.println("This is not a valid option, pick again!");
            userTypeInput = scanner.nextLine();
        }
        if(userTypeInput.equals("b")){
            isEContract = false;
        }

        System.out.println("Pick Payment Method, 'a' for Credit, 'b' for Cash and 'c' for Debit:");
        userTypeInput = scanner.nextLine();
        while (!userTypeInput.equals("a") && !userTypeInput.equals("b") && !userTypeInput.equals("c")){ // check for valid user input
            System.out.println("This is not a valid option, pick again!");
            userTypeInput = scanner.nextLine();
        }
        String paymentMethod;
        if(userTypeInput.equals("a")){
            paymentMethod = "CREDIT";
        }
        else if(userTypeInput.equals("b")){
            paymentMethod = "CASH";
        }
        else {
            paymentMethod = "DEBIT";
        }

        String networkSpeed;
        if(contractType == "LANDLINE"){
            System.out.println("Pick Network Speed, 'a' for ADSL, 'b' for VDSL or if you don't want internet pick 'c':");
            userTypeInput = scanner.nextLine();
            while (!userTypeInput.equals("a") && !userTypeInput.equals("b") && !userTypeInput.equals("c")){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                userTypeInput = scanner.nextLine();
            }

            if(userTypeInput.equals("a")){
                networkSpeed = "ADSL";
            }
            else if(userTypeInput.equals("b")){
                networkSpeed = "VDSL";
            }
            else {
                networkSpeed = "NOINTERNET";
            }
        }
        else{
            networkSpeed = "DATA";
        }

        int freeMonthlyGB;
        int freeMonthlySMS;
        if(contractType == "MOBILE"){
            System.out.println("You can choose between three free monthly GB & SMS combo packages, " +
                    "Pick 'a' for 1GB Data & 1000 SMS " +
                    "'b' for 2GB Data & 500 SMS " +
                    "or 'c' for 500MB Data & 2000 SMS!");

            userChoice = scanner.nextLine(); //read user input

            while (!userChoice.equals("a") && !userChoice.equals("b")  && !userChoice.equals("c") ){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                userChoice = scanner.nextLine();
            }

            if(userChoice.equals("a")){ //check which action was selected
                freeMonthlyGB = 1000;
                freeMonthlySMS = 1000;
            }
            else if(userChoice.equals("b")){
                freeMonthlyGB = 2000;
                freeMonthlySMS = 500;
            }
            else{
                freeMonthlyGB = 500;
                freeMonthlySMS = 2000;
            }
        }
        else{
            freeMonthlyGB = 0;
            freeMonthlySMS = 0;
        }

        //new Contract Object
        Contract newContract = new Contract(ID, contractType, phonenumber, afm, password, freeminutes, inputDate, contractDuration, monthlyCost, isEContract, paymentMethod, networkSpeed,freeMonthlyGB,freeMonthlySMS);

        it219151.allContracts.add(newContract);

    }
}
