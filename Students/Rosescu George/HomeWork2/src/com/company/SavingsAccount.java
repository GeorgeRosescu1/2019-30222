package com.company;

public class SavingsAccount extends Account {

    private double interest;

    public SavingsAccount(int number) {
        super(number);
    }

    public void addInterest(double interest) {
        if (interest > 0) {
            this.interest += interest;
        } else {
            System.err.print("Can't add negative interest");
        }
    }

    public double getInterest() {
        return interest;
    }

    public String toString() {
        return "Savings Account No." + super.getAccountNumber() + ": balance =  " + super.getBalance() + " interest = " + interest + ".";
    }
}
