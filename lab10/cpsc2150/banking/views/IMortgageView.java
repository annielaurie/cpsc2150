package cpsc2150.banking.views;
import cpsc2150.banking.controllers.IMortgageController;

public interface IMortgageView {
    void setController(IMortgageController c);
    String getName();
    double getYearlyIncome();
    double getMonthlyDebt();
    int getCreditScore();
    double getHouseCost();
    double getDownPayment(Double houseCost);
    int getYears();
    void printToUser(String s);
    boolean getAnotherMortgage();
    boolean getAnotherCustomer();
}