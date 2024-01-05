package com.Bank.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLacdetails {
    private final static String URL = "jdbc:mysql://localhost:3306/bankacdetails";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "8310081967";

    public static void main(String[] args) {

        /*Scanner sc = new Scanner(System.in);
        System.out.println("---------------Bank Account details--------------");
        System.out.println("Enter Customer ID:");
        String custid = sc.next();
        System.out.println("Enter Customer Name:");
        String custname = sc.next();
        System.out.println("Enter Balance:");
        double balance = sc.nextDouble();

        Pojo p = new Pojo();
        p.setCustid(custid);
        p.setCustname(custname);
        p.setBal(balance);*/

        Connection connection = SQLauth.getConnection();
        //Operation.insertQuery(connection,p);
        Accoperations.selectQuery(connection);
    }
}
class Pojo{
    String cusid;
    String cusname;
    double bal;

    public String getCusid() {
        return cusid;
    }

    public void setCusid(String cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }
}

class Operation{
    public static void insertQuery(Connection c,Pojo p){
        String query = "INSERT INTO acstatement VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatement.setString(1,p.getCusid());
            preparedStatement.setString(2, p.getCusname());
            preparedStatement.setDouble(3,p.getBal());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
