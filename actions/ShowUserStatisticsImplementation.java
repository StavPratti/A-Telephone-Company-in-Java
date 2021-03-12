package gr.hua.it219151.actions;

import gr.hua.it219151.it219151;
import gr.hua.it219151.contracts.Contract;

import java.util.ArrayList;
import java.util.List;

// this class implements the interface ShowUserStatistics and we have to implement and override it's abstract methods
public class ShowUserStatisticsImplementation implements ShowUserStatistics{

    //the list of all contracts
    public static List<Contract> savedContracts = new ArrayList<>();

    @Override
    public void showStatisticContractType() { // custom functionality of showStatisticContractType
        savedContracts = it219151.allContracts;

        int landlinecount = 0;
        int mobilecount = 0;

        for(Contract c: savedContracts){
            if(c.getType().equals("LANDLINE")){
                landlinecount ++;
            }
            else{
                mobilecount++;
            }
        }
        int landlineperc = (landlinecount/savedContracts.size()) * 100;
        int mobileperc = (mobilecount/savedContracts.size()) * 100;
        System.out.println("The percentage of Landline Contracts is: " + landlineperc + "% of total Contracts.");
        System.out.println("The percentage of Mobile Contracts is: " + mobileperc + "% of total Contracts.");


    }

    @Override
    public void showStatisticFreeMinutesLandline() { // custom functionality of showStatisticFreeMinutesLandline
        savedContracts = it219151.allContracts;

        int lfreeminutesmin = -1;
        int lfreeminutesmax = 0;
        int lfreeminutesmean = 0;
        int lfreeminutessum = 0;
        int lfreeminutescount = 0;


        for(Contract c: savedContracts){
            if(c.getType().equals("LANDLINE")){
                if(c.getFreeMinutes() > lfreeminutesmax){
                    lfreeminutesmax = c.getFreeMinutes();
                }
                if (c.getFreeMinutes() < lfreeminutesmin || lfreeminutesmin == -1){
                    lfreeminutesmin = c.getFreeMinutes();
                }
                lfreeminutescount += 1;
                lfreeminutessum += c.getFreeMinutes();
            }
        }
        lfreeminutesmean = lfreeminutessum/lfreeminutescount;

        System.out.println("---The Statistics for Landline Contracts---");
        System.out.println("The minimum free minutes for a Landline contract are: " + lfreeminutesmin + " minutes.");
        System.out.println("The maximum free minutes for a Landline contract are: " + lfreeminutesmax + " minutes.");
        System.out.println("The mean value of minutes for Landline contracts is: " + lfreeminutesmean + ".");
        System.out.println("There are " + lfreeminutescount + " active Landline contracts with "
                + lfreeminutessum + " minutes in total.");
    }

    @Override
    public void showStatisticFreeMinutesMobile() { // custom functionality of showStatisticFreeMinutesMobile
        savedContracts = it219151.allContracts;

        int mfreeminutesmin = -1;
        int mfreeminutesmax = 0;
        int mfreeminutesmean = 0;
        int mfreeminutessum = 0;
        int mfreeminutescount = 0;

        for(Contract c: savedContracts) {
            if (c.getType().equals("MOBILE")) {
                if (c.getFreeMinutes() > mfreeminutesmax) {
                    mfreeminutesmax = c.getFreeMinutes();
                }
                if (c.getFreeMinutes() < mfreeminutesmin || mfreeminutesmin == -1) {
                    mfreeminutesmin = c.getFreeMinutes();
                }
                mfreeminutescount += 1;
                mfreeminutessum += c.getFreeMinutes();
            }
        }
        mfreeminutesmean = mfreeminutessum/mfreeminutescount;

        System.out.println("---The Statistics for Mobile Contracts---");
        System.out.println("The minimum free minutes for a Mobile contract are: " + mfreeminutesmin + " minutes.");
        System.out.println("The maximum free minutes for a Mobile contract are: " + mfreeminutesmax + " minutes.");
        System.out.println("The mean value of minutes for Mobile contracts is: " + mfreeminutesmean + ".");
        System.out.println("There are " + mfreeminutescount + " active Mobile contracts with "
                + mfreeminutessum + " minutes in total.");

    }

}
