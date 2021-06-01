package cpsc2150.banking.models;

public abstract class AbsCustomer implements ICustomer {
    protected IMortgage loan;

    @Override
    public String toString() {
        String str = "";
        str += "Name: " + getName() + "\n";
        str += "Income: $" + getIncome() + "\n";
        str += "Credit Score: " + getCreditScore() + "\n";
        str += "Monthly Debt: $" + getMonthlyDebtPayments() + "\n";
        str += "Mortgage info: \n";
        if(appliedForLoan()) {
            str += loan.toString();
        }
        return str;
    }
}