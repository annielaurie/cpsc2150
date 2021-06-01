package cpsc2150.banking.models;

public class Mortgage extends AbsMortgage implements IMortgage {
    private final double homeCost, homeDP, payment, rates, principal, DebtIncomeRatio, percentDown, monthlyInterestRate;
    private final int homeYears, numberOfPayments;
    private final int MONTHSPERYEAR = 12;
    private final ICustomer person;

    Mortgage(double houseCost, double downPayment, int years, ICustomer customer) {
        homeCost = houseCost;
        homeDP = downPayment;
        homeYears = years;
        person = customer;

        payment = getPayment();
        principal = getPrincipal();
        rates = getRate();

        DebtIncomeRatio = person.getMonthlyDebtPayments() /(person.getIncome() / MONTHSPERYEAR);
        monthlyInterestRate = getRate() / MONTHSPERYEAR;
        numberOfPayments = years * MONTHSPERYEAR;
        percentDown = downPayment / houseCost;
    }

    @Override
    public boolean loanApproved() {
        if(rates >= RATETOOHIGH || percentDown < MIN_PERCENT_DOWN || DebtIncomeRatio >= DTOITOOHIGH) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public double getPayment() {
        double top = monthlyInterestRate * principal;
        double bottom = 1 -(Math.pow((1 + monthlyInterestRate),(- numberOfPayments)));
        return top/bottom;
    }

    @Override
    public double getRate() {
        double rate = BASERATE;

        if(homeYears < MAX_YEARS) {
            rate = rate + GOODRATEADD;
        }
        else {
            rate = rate + NORMALRATEADD;
        }
        if(percentDown < PREFERRED_PERCENT_DOWN) {
            rate += GOODRATEADD;
        }
        if(person.getCreditScore() >= GREATCREDIT) {
            return rate;
        }
        else if(person.getCreditScore() >= GOODCREDIT) {
            rate += GOODRATEADD;
        }
        else if(person.getCreditScore() >= FAIRCREDIT) {
            rate += NORMALRATEADD;
        }
        else if(person.getCreditScore() >= BADCREDIT) {
            rate += BADRATEADD;
        }
        else if(person.getCreditScore() < BADCREDIT) {
            rate += VERYBADRATEADD;
        }
        return rate;
    }

    @Override
    public double getPrincipal() {
        return homeCost - homeDP;
    }

    @Override
    public int getYears() {
        return homeYears;
    }
}