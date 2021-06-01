package cpsc2150.banking.views;
import cpsc2150.banking.controllers.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import javax.swing.*;

public class MortgageGUIView extends JFrame implements ActionListener, IMortgageView {
    private IMortgageController cont;
    private JLabel message;
    private JButton submit;
    private JTextArea nameTxt;
    private JTextArea incomeTxt;
    private JTextArea debtTxt;
    private JTextArea creditScoreTxt;
    private JTextArea houseCostTxt;
    private JTextArea dpTxt;
    private JComboBox yearsCb;
    private JTextArea approvedTxt;
    private JTextArea rateTxt;
    private JTextArea paymentTxt;

    private JLabel nameLbl;
    private JLabel incomeLbl;
    private JLabel debtLbl;
    private JLabel creditScoreLbl;
    private JLabel houseCostLbl;
    private JLabel dpLbl;
    private JLabel yearsLbl;
    private JLabel approvedLbl;
    private JLabel rateLbl;
    private JLabel paymentLbl;

    private JPanel namePnl;
    private JPanel incomePnl;
    private JPanel debtPnl;
    private JPanel creditPnl;
    private JPanel houseCostPnl;
    private JPanel dpPnl;
    private JPanel yearsPnl;
    private JPanel approvedPnl;
    private JPanel ratePnl;
    private JPanel paymentPnl;

    private String [] posYears = {"5", "10", "15", "20", "25", "30"};

    private final int ROWS_IN_GRID = 12;

    public MortgageGUIView() {
        super("Mortgage App");

        Border border = BorderFactory.createLineBorder(Color.BLACK);

        this.setLayout(new GridLayout(ROWS_IN_GRID, 1));

        message = new JLabel("Provide Customer and Mortgage information");
        this.add(message);

        namePnl = new JPanel();
        namePnl.setLayout(new GridLayout(1, 2));
        nameLbl = new JLabel("Name: ");
        nameTxt = new JTextArea();
        nameTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        namePnl.add(nameLbl);
        namePnl.add(nameTxt);
        this.add(namePnl);

        incomePnl = new JPanel();
        incomePnl.setLayout(new GridLayout(1, 2));
        incomeLbl = new JLabel("Yearly Income: ");
        incomeTxt = new JTextArea();
        incomeTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        incomePnl.add(incomeLbl);
        incomePnl.add(incomeTxt);
        this.add(incomePnl);

        debtPnl = new JPanel();
        debtPnl.setLayout(new GridLayout(1, 2));
        debtLbl = new JLabel("Monthly Debt: ");
        debtTxt = new JTextArea();
        debtTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        debtPnl.add(debtLbl);
        debtPnl.add(debtTxt);
        this.add(debtPnl);

        creditPnl = new JPanel();
        creditPnl.setLayout(new GridLayout(1, 2));
        creditScoreLbl = new JLabel("Credit Score: ");
        creditScoreTxt = new JTextArea();
        creditScoreTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        creditPnl.add(creditScoreLbl);
        creditPnl.add(creditScoreTxt);
        this.add(creditPnl);

        houseCostPnl = new JPanel();
        houseCostPnl.setLayout(new GridLayout(1, 2));
        houseCostLbl = new JLabel("House Cost: ");
        houseCostTxt = new JTextArea();
        houseCostTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        houseCostPnl.add(houseCostLbl);
        houseCostPnl.add(houseCostTxt);
        this.add(houseCostPnl);

        dpPnl = new JPanel();
        dpPnl.setLayout(new GridLayout(1, 2));
        dpLbl = new JLabel("Down Payment: ");
        dpTxt = new JTextArea();
        dpTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        dpPnl.add(dpLbl);
        dpPnl.add(dpTxt);
        this.add(dpPnl);

        yearsPnl = new JPanel();
        yearsPnl.setLayout(new GridLayout(1, 2));
        yearsLbl = new JLabel("Years: ");
        yearsCb = new JComboBox(posYears);
        yearsPnl.add(yearsLbl);
        yearsPnl.add(yearsCb);
        this.add(yearsPnl);

        submit = new JButton("Submit");
        submit.addActionListener(this);
        this.add(submit);

        approvedPnl = new JPanel();
        approvedPnl.setLayout(new GridLayout(1, 2));
        approvedLbl = new JLabel("Loan Approved: ");
        approvedTxt = new JTextArea();
        approvedTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        approvedTxt.setEditable(false);
        approvedPnl.add(approvedLbl);
        approvedPnl.add(approvedTxt);
        this.add(approvedPnl);

        ratePnl = new JPanel();
        ratePnl.setLayout(new GridLayout(1, 2));
        rateLbl = new JLabel("Interest Rate: ");
        rateTxt = new JTextArea();
        rateTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        rateTxt.setEditable(false);
        ratePnl.add(rateLbl);
        ratePnl.add(rateTxt);
        this.add(ratePnl);

        paymentPnl = new JPanel();
        paymentPnl.setLayout(new GridLayout(1, 2));
        paymentLbl = new JLabel("Monthly Payment: ");
        paymentTxt = new JTextArea();
        paymentTxt.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        paymentTxt.setEditable(false);
        paymentPnl.add(paymentLbl);
        paymentPnl.add(paymentTxt);
        this.add(paymentPnl);

        this.pack();
        this.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        Object source = event.getSource();
        if(source.equals(submit)) {
            cont.submitApplication();
        }
        this.setCursor(Cursor.getDefaultCursor());
    }

    public void setController(IMortgageController c) {
        cont = c;
    }

    @Override
    public double getHouseCost() {
        double cost = Double.parseDouble(houseCostTxt.getText());
        return cost;
    }

    @Override
    public double getDownPayment() {
        double dp = Double.parseDouble(dpTxt.getText());
        return dp;
    }

    @Override
    public int getYears() {
        int y = Integer.parseInt(yearsCb.getSelectedItem().toString());
        return y;
    }

    @Override
    public double getMonthlyDebt() {
        double debt = Double.parseDouble(debtTxt.getText());
        return debt;
    }

    @Override
    public double getYearlyIncome() {
        double income = Double.parseDouble(incomeTxt.getText());
        return income;
    }

    @Override
    public int getCreditScore() {
        int cs = Integer.parseInt(creditScoreTxt.getText());
        return cs;
    }

    @Override
    public String getName() {
        String name = nameTxt.getText();
        return name;
    }

    @Override
    public void printToUser(String s) {
        message.setText(s);
    }

    @Override
    public void displayApproved(boolean a) {
        if(a) {
            approvedTxt.setText("Loan Approved");
        }
        else {
            approvedTxt.setText("Loan Denied");
        }
    }

    @Override
    public void displayRate(double r) {
        rateTxt.setText(Double.toString(r*100) + "% APR");
    }

    @Override
    public void displayPayment(double p) {
        paymentTxt.setText("$" + Double.toString(p));
    }

    public boolean getAnotherCustomer() {
        return true;
    }

    public boolean getAnotherMortgage() {
        return true;
    }
}