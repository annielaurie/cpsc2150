package cpsc2150.banking.models;

/**
 * @author Annie Hayes, Marc Caramello
 *
 * @invariant MONTHSPERYEAR = 12 AND payment >= 0 AND Rate >= 0 AND Customer != null AND DebtToIncomeRatio >= 0 AND
 *            Principal >= 0 AND NumberOfPayments >= 0 AND PercentDown >= 0 AND MIN_YEARS <= homeYears <= MAX_YEARS
 *
 * @Correspondence self.Payment = payment AND self.Rate = rates AND self.Customer = person AND
 *                 self.DebtToIncomeRatio = DebtIncomeRatio AND self.Principal = principal AND
 *                 self.NumberOfPayments = numberOfPayments AND self.PercentDown = percentDown AND
 *                 self.MonthlyInterestRate = monthlyInterestRate
 */
public class Mortgage extends AbsMortgage implements IMortgage {
    private final double homeCost, homeDP, payment, rates, principal, DebtIncomeRatio, percentDown, monthlyInterestRate;
    private final int homeYears, numberOfPayments;
    private final int MONTHSPERYEAR = 12;

    private final ICustomer person;

    /**
     * This creates a new object to keep track of information for the mortgage.
     *
     * @param houseCost the dollar amount of the house being bought
     * @param downPayment the dollar amount of the customer's down payment
     * @param years the number od years the mortgage is set at
     * @param customer the customer's data from Customer.java
     *
     * @pre houseCost >= 0 AND downPayment >= 0 AND years >= 0 AND customer != null
     * @post homeCost = houseCost AND homeDP = downPayment AND homeYears = years AND
     *       person = customer AND payment = getPayment() AND rates = getRate() AND
     *       principal = getPrincipal AND percentDown = homeDP / homeCost AND
     *       DebtIncomeRatio = person.getMonthlyDebtPayments() / (person.getIncome() / MONTHSPERYEAR)
     *       AND numberOfPayments = homeYears + MONTHSPERYEAR AND monthlyInterestRate = getRate() / MONTHSPERYEAR
     */
     Mortgage(double houseCost, double downPayment, int years, ICustomer customer) {

         //assign parameters to correct variables
         homeCost = houseCost;
         homeDP = downPayment;
         homeYears = years;
         person = customer;

         //assign getter functions to correct variables
         payment = getPayment();
         rates = getRate();
         principal = getPrincipal();

         //the percent down is the down payment percent of the total home cost
         percentDown = downPayment / houseCost;

         //ratio of debt payments divided by the income over a period of time
         DebtIncomeRatio = person.getMonthlyDebtPayments() / (person.getIncome() / MONTHSPERYEAR);

         //the number of payments is the length of the mortgage times 12
         numberOfPayments = years * MONTHSPERYEAR;

         monthlyInterestRate = getRate() / MONTHSPERYEAR;
     }

     @Override
     public boolean loanApproved () {
         //if APR >= 10% or if percentDown < 3.5% or if DebtIncomeRatio >= 40% return false
         if (rates >= RATETOOHIGH || percentDown < MIN_PERCENT_DOWN || DebtIncomeRatio >= DTOITOOHIGH) {
             return false;
         }
         else {
             return true;
         }
     }

        @Override
        public double getPayment() {
         //monthly interest rate
         //double mInterestRate = getRate() / MONTHSPERYEAR;
         double top = monthlyInterestRate * principal;
         double bottom = 1 - (Math.pow((1 + monthlyInterestRate),(- numberOfPayments)));
         return top/bottom;
        }

        @Override
        public double getRate() {
            //rate is equal to .025
            double rate = BASERATE;
            //if homeYears < 30
            if(homeYears < MAX_YEARS) {
                //add .005 to rate
                rate = rate + GOODRATEADD;
            } else {
                //add .01 to rate
                rate = rate + NORMALRATEADD;
            }
            //if percentDown < .2
            if(percentDown < PREFERRED_PERCENT_DOWN)
            {
                //add .005 to rate
                rate += GOODRATEADD;
            }
            //if credit score >= 750
            if(person.getCreditScore() >= GREATCREDIT) {
                return rate;
            }
            //if credit score >= 700
            else if(person.getCreditScore() >= GOODCREDIT) {
                rate += GOODRATEADD;
            }
            //if credit score >= 600
            else if(person.getCreditScore() >= FAIRCREDIT) {
                rate += NORMALRATEADD;
            }
            //if credit score >= 500
            else if(person.getCreditScore() >= BADCREDIT) {
                rate += BADRATEADD;
            }
            //if credit score < 500
            else if(person.getCreditScore() < BADCREDIT) {
                rate += VERYBADRATEADD;
            }
            return rate;
        }

        @Override
        public double getPrincipal () {
            return homeCost - homeDP;
        }

        @Override
        public int getYears () {
            return homeYears;
        }
    }
