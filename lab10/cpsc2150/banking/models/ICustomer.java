package cpsc2150.banking.models;

public interface ICustomer {
    int MAX_CREDIT_SCORE = 850;

    boolean applyForLoan(double downPayment, double houseCost, int years);
    double getRate();
    double getMonthlyPay();
    double getMonthlyDebtPayments();
    double getIncome();
    int getCreditScore();
    String getName();
    boolean appliedForLoan();
}