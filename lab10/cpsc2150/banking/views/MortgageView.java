package cpsc2150.banking.views;
import cpsc2150.banking.controllers.*;
import java.util.Scanner;

public class MortgageView implements IMortgageView {
    IMortgageController controlObj;
    Scanner scanObj;

    public MortgageView() {
        scanObj = new Scanner(System.in);
    }

    @Override
    public void setController(IMortgageController c) {
    }

    @Override
    public String getName() {
        System.out.format("What's your name?\n");
        String name = scanObj.nextLine();
        return name;
    }

    @Override
    public double getYearlyIncome() {
        double yearlyIncome;
        System.out.format("How much is your yearly income?\n");
        yearlyIncome = scanObj.nextDouble();

        if(yearlyIncome < 0) {
            System.out.format("Income must be greater than 0.\n");
        }
        return yearlyIncome;
    }

    @Override
    public double getMonthlyDebt() {
        double monthlyDebtPayment;
        System.out.format("How much are your monthly debt payments?\n");
        monthlyDebtPayment = scanObj.nextDouble();

        if(monthlyDebtPayment < 0) {
            System.out.format("Debt must be greater than or equal to 0.\n");
        }
        return monthlyDebtPayment;
    }

    @Override
    public int getCreditScore() {
        int creditScore;
        System.out.format("What is your credit score?\n");
        creditScore = scanObj.nextInt();

        if(creditScore < 0 || creditScore > 850) {
            System.out.format("Credit Score must be greater than 0 and less than 850.\n");
        }
        return creditScore;
    }

    @Override
    public double getHouseCost() {
        double houseCost;
        System.out.format("How much does the house cost?\n");
        houseCost = scanObj.nextDouble();

        if(houseCost < 0) {
            System.out.format("Cost must be greater than 0.\n");
        }
        return houseCost;
    }

    @Override
    public double getDownPayment(Double houseCost) {
        double downPayment;
        System.out.format("How much is the down payment?\n");
        downPayment = scanObj.nextDouble();

        if(downPayment < 0 || downPayment > houseCost) {
            System.out.format("Down Payment must be greater than 0 and less than the cost of the house.\n");
        }
        return downPayment;
    }

    @Override
    public int getYears() {
        int numOfYears;
        System.out.format("How many years?\n");
        numOfYears = scanObj.nextInt();

        if(numOfYears < 0) {
            System.out.format("Years must be greater than 0.\n");
        }
        return numOfYears;
    }

    @Override
    public void printToUser(String s) {
        System.out.format("%s\n", s);
    }

    @Override
    public boolean getAnotherMortgage() {
        char choiceInput;
        do {
            System.out.format("Would you like to apply for another mortgage? Y/N\n");
            choiceInput = scanObj.next().charAt(0);

            if(choiceInput != 'y' && choiceInput != 'Y' && choiceInput != 'n' && choiceInput != 'N') {
                System.out.format("That was not an acceptable input.\n");
            }
        } while(choiceInput != 'y' && choiceInput != 'Y' && choiceInput != 'n' && choiceInput != 'N');
        if(choiceInput == 'y' || choiceInput == 'Y') {
            return true;
        }
        return false;
    }

    @Override
    public boolean getAnotherCustomer() {
        char choiceInput;
        do {
            System.out.format("Would you like to consider another customer? Y/N\n");
            choiceInput = scanObj.next().charAt(0);
            String newLineBugFix_doNotRemove = scanObj.nextLine();

            if(choiceInput != 'y' && choiceInput != 'Y' && choiceInput != 'n' && choiceInput != 'N') {
                System.out.format("That was not an acceptable input.\n");
            }
        } while(choiceInput != 'y' && choiceInput != 'Y' && choiceInput != 'n' && choiceInput != 'N');
		
        if(choiceInput == 'y' || choiceInput == 'Y') {
            return true;
        }
        return false;
    }
}