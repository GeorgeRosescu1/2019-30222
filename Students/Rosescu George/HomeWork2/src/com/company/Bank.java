package com.company;

import java.util.ArrayList;

public class Bank {

    public int noOfAccounts = 0;
    public Account myAccountsArray[] = new Account[noOfAccounts];

    //    Account myAccount =  new Account(1);
//    myAccountsArray[0] = myAccount; why we can't do this here if Account is a public class

    public void updateAccount(int sumInterest) {
        int index;
        for (index = 0; index < noOfAccounts; index++) {
            if (myAccountsArray[index] instanceof CurrentAccount) {
                if (((CurrentAccount) myAccountsArray[index]).isOverdraftLimit())
                    System.out.println("Letter sent!");
            }
            if (myAccountsArray[index] instanceof SavingsAccount) {
                ((SavingsAccount) myAccountsArray[index]).addInterest(sumInterest);
            }
        }
    }

    public void openAccount() {
        noOfAccounts += 1;
    }

    public void closeAccount() {
        noOfAccounts -= 1;
    }
}

