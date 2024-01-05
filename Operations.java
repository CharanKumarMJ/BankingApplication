package com.Bank.pack;

public class Operations {
    static double balance=10000;

    public static void deposit(int amount){
        if(amount > 0){
            balance +=amount;
            System.out.println("Deposit successful");
        }
        else{
            System.out.println("Invalid deposit");
        }
    }
    public static void withdraw(int amount){
        if(amount > balance){
            System.out.println("Insufficient Balance");
        }
        else{
            balance -=amount;
            System.out.println("Withdraw successful");
        }
    }
    public static void enquiry(){
        System.out.println("Your balance is: "+balance);
    }
}
