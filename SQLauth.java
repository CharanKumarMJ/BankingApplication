package com.Bank.pack;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLauth {
    private final static String URL = "jdbc:mysql://localhost:3306/bankacdetails";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "8310081967";
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Class loaded");
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Connection established...");
            //createQuery(connection);
            return connection;
        } catch (Exception e) {
            System.out.println("class not loaded");
            throw new RuntimeException(e);
        }
    }
    public static void createQuery(Connection c){
        String query = "CREATE TABLE credentials(customer_id VARCHAR(10), customer_name VARCHAR(20))";
        try {
            PreparedStatement preparedStatement = c.prepareStatement(query);
            preparedStatement.execute();
            System.out.println("Created table successfully");
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insertQuery(Connection c,CustDetails details){
        String query = "INSERT INTO acstatement VALUES(?,?,?)";
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1,details.getCustid());
            ps.setString(2, details.getCustname());
            ps.setDouble(3,details.getBalance());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void selectQuery(Connection c,String userid, String username){
        String query = "SELECT * FROM acstatement";
        DataObject data = new DataObject();
        try {
            String custname;
            String custid ;
            PreparedStatement preparedStatement = c.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                custid = resultSet.getString(1);
                custname = resultSet.getString(2);

                data.setId(custid);
                data.setName(custname);

                String cid = data.getId();
                String cname = data.getName();

                if((userid.equals(cid) && username.equals(cname))) {
                    SampleBank.Display(c, cid);
                    return;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Invalid Credentials");
    }
}

class DataObject {
    public String id;
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
