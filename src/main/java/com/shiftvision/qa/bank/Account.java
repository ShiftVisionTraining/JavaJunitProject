package com.shiftvision.qa.bank;

import com.shiftvision.qa.exception.ShiftVisionException;

public class Account {
    private String accountNumber;
    private String accountName;
    protected double balance;
    private double interestRate = 0;


    private Account(){
        System.out.println("Account class getting init...");

    }
    public Account(String accountNumber, String accountName){
        this();
        if(accountNumber.length() <= 4){
            throw new ShiftVisionException("Account number can not be less then or equal to 4 char");
        } else {
            this.accountNumber = accountNumber;
        }
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if( amount > 0){
            balance += amount;
        } else if ( amount == 0){
            throw new ShiftVisionException("Deposit amount can not be 0");
        }
        else{
            throw new ShiftVisionException("Deposit amount can not be less then 0");
        }
    }

    public  void withdraw(double amount){
        if( amount > 0 && amount <= this.balance){
            balance -= amount;
            balance -= getFine();
            System.out.println("Withdraw Amount: " + amount);
        } else{
            throw new ShiftVisionException("Withdraw amount can not be less then 0 or more then balance");
        }
    }
    public  void withdraw(double amount, String message) {
        this.withdraw(amount);

        System.out.println("Withdraw Message: " + message);
    }



   public  double getFine(){
        return 0;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }
}
