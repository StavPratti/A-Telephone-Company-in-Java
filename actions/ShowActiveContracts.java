package gr.hua.it219151.actions;

import gr.hua.it219151.contracts.Contract;
import gr.hua.it219151.users.User;

import java.util.ArrayList;
import java.util.List;


public class ShowActiveContracts {

    //the list of all contracts
    public static List<Contract> savedContracts = new ArrayList<>();

    public void printContracts(User loggedUser, List<Contract> userContracts){ // function that print contract's information

        if(userContracts.isEmpty()){
            System.out.println("You don't have any contracts!");
        }
        else{
            int counter = 0;
            System.out.println("Your Active Contracts:");
            for(Contract contract: userContracts){ // for every contract use the Contract getters
                System.out.println(counter+". Id: " + contract.getContractID() +
                        " Contract Type: " + contract.getType() +
                        " Phone Number: " + contract.getPhoneNumber() +
                        " AFM: " + contract.getAFM() +
                        " Password: " + contract.getPassword() +
                        " Free Minutes: " + contract.getFreeMinutes() +
                        " Start Date: " + contract.getStartDate() +
                        " Contract Duration: " + contract.getContractDuration() +
                        " Monthly Cost: " + contract.getMonthlyCost() +
                        " Is E-Contract: " + contract.isEContract() +
                        " Payment Method: " + contract.getPaymentType() +
                        " Network Type: " + contract.getNetworkSpeed() +
                        " Free Monthly Data: " + contract.getFreeMonthlyGB() +
                        " Free Monthly SMS: " + contract.getFreeMonthlySMS()
                );
                counter++;
            }
        }
    }
}
