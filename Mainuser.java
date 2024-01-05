package com.Bank.pack;

import java.sql.Connection;
import java.util.Scanner;

public class Mainuser {
    public static void main(String[] args) {
        System.out.println("------------------------Good Morning!, Welcome to Sample Bank--------------------------");
        System.out.println("1.New Customer");
        System.out.println("2.Registered Customer");
        System.out.println("Enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();

        if(user == 1){
            Authuser.Sign_In();
        } else if (user == 2) {
            Authuser.Log_in();
        }
        else {
            System.out.println("Invalid code");
        }
    }
}
