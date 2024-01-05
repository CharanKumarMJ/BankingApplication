package com.Bank.pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sampleoperations {
    public static void deposit(Connection c,double amount,String cusid){
        String bal_query = "SELECT balance FROM acstatement WHERE cid=?";
        String update_query = "UPDATE acstatement SET balance= ? WHERE cid = ?" ;
        if(amount > 0){
            try {
                double balance = 0;
                PreparedStatement ps = c.prepareStatement(bal_query);
                ps.setString(1,cusid);
                ResultSet result = ps.executeQuery();
                while (result.next()){
                    balance= result.getDouble(1);
                }
                CustDetails customer = new CustDetails();
                customer.setBalance(balance);

                double bal = customer.getBalance();
                bal = bal+amount;


                PreparedStatement pstmt = c.prepareStatement(update_query);
                pstmt.setDouble(1,bal);
                pstmt.setString(2,cusid);
                //c.prepareStatement("UPDATE acstatement SET balance= "+bal+"WHERE cid = "+cusid);
                pstmt.executeUpdate();
                System.out.println("-----------------------------Deposit successful----------------------");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("!!!!!!!!!!!!!!!!!!!Invalid deposit!!!!!!!!!!!!!!!!!");
        }
    }
    public static void withdraw(Connection c,double amount,String cusid) {
        String bal_query = "SELECT balance FROM acstatement WHERE cid=?";
        String with_query = "UPDATE acstatement SET balance= ? WHERE cid = ?";
        try {
            double balance = 0;
            PreparedStatement ps = c.prepareStatement(bal_query);
            ps.setString(1, cusid);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                balance = result.getDouble(1);
            }
            CustDetails customer = new CustDetails();
            customer.setBalance(balance);

            double bal = customer.getBalance();

            if (amount < bal) {
                bal = bal - amount;
                PreparedStatement pstmt = c.prepareStatement(with_query);
                pstmt.setDouble(1,bal);
                pstmt.setString(2,cusid);
                //c.prepareStatement("UPDATE acstatement SET balance= " + bal + " WHERE cid = " + cusid);
                pstmt.executeUpdate();
                System.out.println("------------------Withdraw successful------------------");
            } else {
                System.out.println("!!!!!!!!!!!!!!!!!Insufficient Balance!!!!!!!!!!!!!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void enquiry(Connection c, String cusid){
        try {
            double balance = 0;
            String bal_query = "SELECT balance FROM acstatement WHERE cid=?";
            PreparedStatement ps = c.prepareStatement(bal_query);
            ps.setString(1, cusid);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                balance = result.getDouble(1);
            }
            CustDetails customer = new CustDetails();
            customer.setBalance(balance);

            double bal = customer.getBalance();
            System.out.println("Your account "+cusid+ " balance is: " + bal);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
