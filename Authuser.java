package com.Bank.pack;

import java.sql.Connection;
import java.util.Scanner;

public class Authuser {
    public static void Log_in() {
        System.out.println("----------------User Login--------------------");
        Connection connection = SQLauth.getConnection();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Customer ID(9 characters only):");
        String userId = scan.next();
        System.out.println("Enter Customer Name:");
        String username = scan.next();

        CustDetails c = new CustDetails();
        c.setCustid(userId);
        c.setCustname(username);

        SQLauth.selectQuery(connection,userId,username);
    }
    public static void Sign_In(){
        Connection connection = SQLauth.getConnection();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Customer ID(9 characters only):");
        String userId = sc.next();
        System.out.println("Enter Customer Name:");
        String username = sc.next();
        System.out.println("Enter Balance");
        double balance = sc.nextDouble();

        CustDetails c = new CustDetails();
        c.setCustid(userId);
        c.setCustname(username);
        c.setBalance(balance);

        SQLauth.insertQuery(connection,c);
        System.out.println("Account added successfully, login to access your account.");
        Log_in();
    }
}
