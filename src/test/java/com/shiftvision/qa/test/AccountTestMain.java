package com.shiftvision.qa.test;

import com.shiftvision.qa.bank.Account;

public class AccountTestMain {
    public static void main(String[] args) {
        depositTest1();
        depositTest2();
        withdrawTest();
    }

    public static void depositTest1(){
        System.out.println("DepositTest1...");
        Account account1 = new Account("123456789", "Iftekhar Ivaan");
        account1.deposit(100);
        double balance = account1.getBalance();
        System.out.println("Balance:" + balance);
        if(balance == 100.0){
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }
    }
    public static void depositTest2(){
        System.out.println("DepositTest2...");
        Account account1 = new Account("123456789", "Iftekhar Ivaan");
        account1.deposit(-100);
        double balance = account1.getBalance();
        System.out.println("Balance:" + balance);
        if(balance == -100.0){
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }
    }
    public static void withdrawTest(){
        System.out.println("WithdrawTest1...");
        Account account1 = new Account("123456789", "Iftekhar Ivaan");
        account1.deposit(100);
        account1.withdraw(20);
        double balance = account1.getBalance();
        System.out.println("Balance:" + balance);
        if(balance == 80.0){
            System.out.println("Test pass");
        } else {
            System.out.println("Test Fail");
        }
    }
}
