package cpsc2150.banking.models;

public class Customer extends AbsCustomer implements ICustomer {
    private double income;
    private double monthlyDebtPayments;
    private int creditScore;
    private String name;

    public Customer(double debt, double inc, int score, String n) {
        creditScore = score;
        income = inc;
        monthlyDebtPayments = debt;
        name = n;
    }

    @Override
    public boolean applyForLoan(double downPayment, double houseCost, int years) {
        loan = new Mortgage(houseCost, downPayment, years, this);
        return loan.loanApproved();
    }

    @Override
    public double getRate() {
        return loan.getRate();
    }

    @Override
    public double getMonthlyPay() {
        return loan.getPayment();
    }

    @Override
    public double getMonthlyDebtPayments() {
		return monthlyDebtPayments;
	}

    @Override
    public double getIncome() {
		return income;
	}

    @Override
    public int getCreditScore() {
        return creditScore;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean appliedForLoan() {
        return loan != null;
    }
}