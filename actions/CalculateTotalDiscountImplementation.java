package gr.hua.it219151.actions;

import gr.hua.it219151.contracts.Contract;
import gr.hua.it219151.users.User;

import java.util.List;

// this class implements the interface CalculateTotalDiscount and we have to implement and override it's abstract methods
public class CalculateTotalDiscountImplementation implements CalculateTotalDiscount{

    @Override
    public int discountByUserType(User loggedUser, List<Contract> userContracts) { // custom functionality of discountByUserType
        int contractCount = userContracts.size();
        int discount = 0;
        if(loggedUser.getUserType().equals("NORMAL")){
            for(int i = 0; i <= contractCount; i++){
                discount +=5;
            }
            if(discount > 15){
                discount = 15;
            }
        }
        else if(loggedUser.getUserType().equals("PROFESSIONAL")){
            for(int i = 0; i <= contractCount; i++){
                discount +=10;
            }
        }
        else{
            for(int i = 0; i <= contractCount; i++){
                discount +=15;
            }
        }
        return discount;
    }

    @Override
    public int discountForLandline(List<Contract> userContracts) { // custom functionality of discountForLandline
        int discount = 0;
        for(Contract c: userContracts){
            if(c.getType().equals("LANDLINE") && c.getFreeMinutes() >= 1000){
                discount += 11;
            }
        }
        return discount;
    }

    @Override
    public int discountByPaymentMethod(List<Contract> userContracts) { // custom functionality of discountByPaymentMethod
        int discount = 0;
        for(Contract c: userContracts){
            if(c.getPaymentType().equals("CREDIT") || c.getPaymentType().equals("DEBIT")){
                discount += 5;
            }
        }
        return discount;
    }

    @Override
    public int discountForEContract(List<Contract> userContracts) { // custom functionality of discountForEContract
        int discount = 0;
        for(Contract c: userContracts){
            if(c.isEContract()){
                discount += 2;
            }
        }
        return discount;
    }
}
