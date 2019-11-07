package com.company;

public class Main {

    public static void main(String[] args) {

        Bank myBank = new Bank();
        int accountIndex = 0;
        myBank.openAccount();
        myBank.openAccount();
        myBank.openAccount();
        myBank.openAccount();

        //here we create all the objects in array
        myBank.myAccountsArray[accountIndex] = new SavingsAccount(accountIndex + 1);
        accountIndex++;
        myBank.myAccountsArray[accountIndex] = new SavingsAccount(accountIndex + 1);
        accountIndex++;
        myBank.myAccountsArray[accountIndex] = new Account(accountIndex + 1);
        accountIndex++;
        myBank.myAccountsArray[accountIndex] = new CurrentAccount(accountIndex + 1);

        //here we do some operations
        myBank.myAccountsArray[3].deposit(500);
        myBank.myAccountsArray[3].withdraw(450);
        myBank.myAccountsArray[3].print();
        myBank.myAccountsArray[3].withdraw(50);

        myBank.myAccountsArray[0].deposit(321);
        ((SavingsAccount) myBank.myAccountsArray[0]).addInterest(150);
        myBank.myAccountsArray[0].print();
        System.out.print('\n');

        myBank.updateAccount(50);
        for (accountIndex = 0; accountIndex < myBank.noOfAccounts; accountIndex++)
            myBank.myAccountsArray[accountIndex].print();
        
        myBank.closeAccount();
        System.out.print('\n');
        for (accountIndex = 0; accountIndex < myBank.noOfAccounts; accountIndex++)
            myBank.myAccountsArray[accountIndex].print();
    }
}
