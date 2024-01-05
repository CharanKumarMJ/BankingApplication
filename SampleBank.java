package com.Bank.pack;

import java.sql.Connection;
import java.util.Scanner;

public class SampleBank {
    public static void Display(Connection conn,String custid) {
        Mesg m = new Mesg();

        int choice;
        do {
            m.message();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice");
            choice = sc.nextInt();
            Scanner scan = new Scanner(System.in);
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit: Rs.");
                    double amount = scan.nextDouble();
                    Sampleoperations.deposit(conn,amount,custid);
                    break;
                case 2:
                    System.out.println("Enter amount to be withdrawn: Rs.");
                    double wamount = scan.nextDouble();
                    Sampleoperations.withdraw(conn,wamount,custid);
                    break;
                case 3:
                    Sampleoperations.enquiry(conn,custid);
                    break;
                case 4:
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=0);
    }

}
class Mesg{
    public static void message(){
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Balance Enquiry");
        System.out.println("4.Exit");
    }
}
