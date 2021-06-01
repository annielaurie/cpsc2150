package cpsc2150.banking.controllers;
import cpsc2150.banking.models.*;
import cpsc2150.banking.views.*;

public class MortgageGUIController implements IMortgageController {
    private IMortgageView viewObj;

    public MortgageGUIController(IMortgageView view) {
        viewObj = view;
    }

    @Override
    public void submitApplication() {
        String name = viewObj.getName();
        Double yearlyIncome = viewObj.getYearlyIncome();
        Double monthlyDebt = viewObj.getMonthlyDebt();
        Integer creditScore = viewObj.getCreditScore();
        Double houseCost = viewObj.getHouseCost();
        Double downPayment = viewObj.getDownPayment();
        Integer numOfYears = viewObj.getYears();
        boolean areUserInputsInBounds = true;

        if(yearlyIncome <= 0) {
            viewObj.printToUser("Income must be greater than 0.");
            areUserInputsInBounds = false;
        }
        else if(monthlyDebt < 0) {
            viewObj.printToUser("Debt must be greater than or equal to 0.");
            areUserInputsInBounds = false;
        }
        else if(creditScore <= 0 || creditScore >= 850) {
            viewObj.printToUser("Credit Score must be greater than 0 and less than 850.");
            areUserInputsInBounds = false;
        }
        else if(houseCost <= 0) {
            viewObj.printToUser("Cost must be greater than 0.");
            areUserInputsInBounds = false;
        }
        else if(downPayment <= 0 || downPayment >= houseCost) {
            viewObj.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
            areUserInputsInBounds = false;
        }
        else if(numOfYears <= 0) {
            viewObj.printToUser("Years must be greater than 0.");
            areUserInputsInBounds = false;
        }

        ICustomer thisCustomer = new Customer(monthlyDebt, yearlyIncome, creditScore, name);

        if(areUserInputsInBounds) {
            boolean isLoanApproved = thisCustomer.applyForLoan(downPayment, houseCost, numOfYears);

            if(isLoanApproved) {
                viewObj.displayApproved(true);
                viewObj.displayRate(thisCustomer.getRate());
                viewObj.displayPayment(thisCustomer.getMonthlyPay());
                viewObj.printToUser("The loan was successfully approved.");
            }
            else {
                viewObj.displayApproved(false);
                viewObj.displayRate(0);
                viewObj.displayPayment(0);
                viewObj.printToUser("The loan was denied.");
            }
        }
        else {
            viewObj.displayApproved(false);
            viewObj.displayRate(0);
            viewObj.displayPayment(0);
        }
    }
}