package cpsc2150.banking.models;

public interface IMortgage {
    int BADCREDIT = 500;
    int FAIRCREDIT = 600;
    int GOODCREDIT = 700;
    int GREATCREDIT = 750;

    double BASERATE = .025;
    double GOODRATEADD = .005;
    double NORMALRATEADD = .01;
    double BADRATEADD = .05;
    double VERYBADRATEADD = .1;
    double RATETOOHIGH = .1;

    double DTOITOOHIGH = .4;
    int MIN_YEARS = 15;
    int MAX_YEARS = 30;
    double PREFERRED_PERCENT_DOWN = .2;
    double MIN_PERCENT_DOWN = .035;

    boolean loanApproved();
    double getPayment();
    double getRate();
    double getPrincipal();
    int getYears();
}