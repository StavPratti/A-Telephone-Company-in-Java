package gr.hua.it219151.actions;

import gr.hua.it219151.it219151;
import gr.hua.it219151.contracts.Contract;
import gr.hua.it219151.users.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GeneralContractInformation {

    public void showInformation(User loggedUser){ // function to show general statistics and active contracts
        System.out.println("Welcome to Contract Information Page!");

        Scanner scanner = new Scanner(System.in); //reads user's input
        String userTypeInput = "";

        while(true) {
            System.out.println("Pick 'a' to show Active Contracts, " +
                    "'b' to Show Total Discount, " +
                    "'c' to Show General User Statistics " +
                    "and 'd' to go back to User Profile Page.");

            userTypeInput = scanner.nextLine();
            while (!userTypeInput.equals("a") && !userTypeInput.equals("b") && !userTypeInput.equals("c") && !userTypeInput.equals("d")){ // check for valid user input
                System.out.println("This is not a valid option, pick again!");
                userTypeInput = scanner.nextLine();
            }
            if(userTypeInput.equals("a")){
                List<Contract> userContracts = new ArrayList<>();
                userContracts = getUserActiveContracts(loggedUser);

                ShowActiveContracts showActiveContract = new ShowActiveContracts();
                showActiveContract.printContracts(loggedUser, userContracts);
            }
            else if(userTypeInput.equals("b")){
                List<Contract> userContracts = new ArrayList<>();
                userContracts = getUserActiveContracts(loggedUser);
                if(!userContracts.isEmpty()) {
                    CalculateTotalDiscountImplementation calculateTotalDiscountImplementation = new CalculateTotalDiscountImplementation();
                    System.out.println("Total Discount " + loggedUser.getDiscount());
                    loggedUser.setDiscount(0);

                    int totaldiscount = 0;
                    totaldiscount += calculateTotalDiscountImplementation.discountByUserType(loggedUser, userContracts);
                    totaldiscount += calculateTotalDiscountImplementation.discountForLandline(userContracts);
                    totaldiscount += calculateTotalDiscountImplementation.discountByPaymentMethod(userContracts);
                    totaldiscount += calculateTotalDiscountImplementation.discountForEContract(userContracts);

                    if (totaldiscount >= 45) {
                        loggedUser.setDiscount(45);
                    } else {
                        loggedUser.setDiscount(totaldiscount);
                    }
                    System.out.println("Total Discount " + totaldiscount);
                }
                else{
                    System.out.println("You don't have any contracts to get Discount!");
                }
            }
            else if(userTypeInput.equals("c")){
                ShowUserStatisticsImplementation showUserStatisticsImplementation = new ShowUserStatisticsImplementation();
                showUserStatisticsImplementation.showStatisticContractType();
                showUserStatisticsImplementation.showStatisticFreeMinutesLandline();
                showUserStatisticsImplementation.showStatisticFreeMinutesMobile();
            }
            else{
                break;
            }

        }

    }

    private List<Contract> getUserActiveContracts(User loggedUser) { // method to get active contracts
        List<Contract> savedContracts = it219151.allContracts;

        List<Contract> userContracts = new ArrayList<>();
        for(Contract contract: savedContracts){ // for every contract
            //contract must belong to logged User and must be active, this means non zero value for free minutes or that it has not expired
            if(contract.getAFM().equals(loggedUser.getAFM()) && contract.getFreeMinutes() != 0 && hasNotExpired(contract.getStartDate(), contract.getContractDuration())){
                userContracts.add(contract);
            }
        }
        return userContracts;
    }

    private Boolean hasNotExpired(String startDate, String duration){ // method to check if contract has expired
        Date today = new Date();
        Date date = new Date();
        try {
            //european date format
            date = new SimpleDateFormat("dd-MM-yyyy").parse((startDate));
            long diff = today.getTime() - date.getTime(); // the difference between contracts start date and now
            diff = diff  / (1000 * 60 * 60 * 24); // the difference in days
            if(duration.equals("ONEYEAR") && diff <= 365){ // check if contract is within duration limits
                return true;
            }
            else if(duration.equals("TWOYEARS") && diff <= 365*2){
                return true;
            }
            else{
                System.out.println("A contract has expired!");
            }

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Unexpected error!");
        }
        return false;
    }

}
