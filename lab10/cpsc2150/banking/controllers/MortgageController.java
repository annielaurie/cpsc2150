package cpsc2150.banking.controllers;
import cpsc2150.banking.models.*;
import cpsc2150.banking.views.*;
import java.util.Vector;

public class MortgageController implements IMortgageController {
    private IMortgageView viewObj;

    public MortgageController(IMortgageView view) {
        viewObj = view;
    }
	
    @Override
    public void submitApplication() {
        Double yearlyIncome, monthlyDebt, houseCost, downPayment;
        Integer creditScore, numOfYears;

        do {
            String name = viewObj.getName();

            do {
                yearlyIncome = viewObj.getYearlyIncome();
            } while(yearlyIncome < 0);

            do {
                monthlyDebt = viewObj.getMonthlyDebt();
            } while(monthlyDebt < 0);

            do {
                creditScore = viewObj.getCreditScore();
            } while(creditScore < 0 || creditScore > 850);

            do {
                do {
                    houseCost = viewObj.getHouseCost();
                } while(houseCost < 0);

                do {
                    downPayment = viewObj.getDownPayment(houseCost);
                } while(downPayment < 0 || downPayment > houseCost);

                do {
                    numOfYears = viewObj.getYears();
                } while(numOfYears < 0);

                ICustomer thisCustomer = new Customer(monthlyDebt, yearlyIncome, creditScore, name);
                thisCustomer.applyForLoan(downPayment, houseCost, numOfYears);

                viewObj.printToUser(thisCustomer.toString());
            } while(viewObj.getAnotherMortgage());
        } while(viewObj.getAnotherCustomer());
    }
}