package cpsc2150.banking.views;
import cpsc2150.banking.controllers.IMortgageController;

public interface IMortgageView {
    void setController(IMortgageController c);
    double getHouseCost();
    double getDownPayment();
    int getYears();
    double getMonthlyDebt();
    double getYearlyIncome();
    int getCreditScore();
    String getName();
    void printToUser(String s);
    void displayPayment(double p);
    void displayRate(double r);
    void displayApproved(boolean a);
    boolean getAnotherMortgage();
    boolean getAnotherCustomer();
}