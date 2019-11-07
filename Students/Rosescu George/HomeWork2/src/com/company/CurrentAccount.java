package com.company;

public class CurrentAccount extends Account {
    private boolean overdraftLimit = false;

    public CurrentAccount(int number) {
        super(number);
    }

    public void addOverdraftLimit() {

    }

    public boolean isOverdraftLimit() {
        if (this.getBalance() <= 0)
            this.overdraftLimit = true;
        return overdraftLimit;
    }

    public void setOverdraftLimit(boolean overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public String toString() {
        return "Current Account No." + super.getAccountNumber() + ": balance = " +
                super.getBalance() + " overdraft limit = " + overdraftLimit + ".";
    }
}
