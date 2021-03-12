package gr.hua.it219151.actions;

import gr.hua.it219151.contracts.Contract;
import gr.hua.it219151.users.User;

import java.util.List;

//this is an interface that describes a specific functionality using abstract methods that can be implemented
public interface CalculateTotalDiscount {

    int discountByUserType(User loggedUser, List<Contract> userContracts);

    int discountForLandline(List<Contract> userContracts);

    int discountByPaymentMethod(List<Contract> userContracts);

    int discountForEContract(List<Contract> userContracts);

}
