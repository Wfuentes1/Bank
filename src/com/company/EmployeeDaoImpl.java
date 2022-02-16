package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.Bank.*;


public class EmployeeDaoImpl implements EmployeeDao {
    Connection connection;
    private Employee employee;

    public EmployeeDaoImpl() {

        this.connection = ConnectionFactory.getConnection();
    }



    @Override
    public void Login(Employee employee) throws SQLException {
        String sql = "Select * from employee where emp_name=(?) AND emp_pass=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give Admin ID");
        String emp_username = scanner.next();
        preparedStatement.setString(1, emp_username);
        System.out.println("Please give password");
        String emp_pass = scanner.next();
        preparedStatement.setString(2, emp_pass);


        ResultSet count = preparedStatement.executeQuery();
        while (count.next()) {
            System.out.println("Id: " + count.getInt(1) + ", Username: " +
                    count.getString(2));

        }


    }



    @Override
    public void emp_Check(Employee employee) throws SQLException {
        String sql="Call getCustomers()";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet count = preparedStatement.executeQuery();
        while (count.next()) {
            System.out.println("Id: " + count.getInt(1) + ", name: " +
                    count.getString(2) + ", balance: " + count.getString(4));
        }
        new_Employee();
    }

@Override
    public void app_Status(Employee employee) throws SQLException{
        String sql="update customer set status='approve' where user_name =?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    Scanner scanner = new Scanner(System.in);
    System.out.println("Give username");
    String name=scanner.next();
    preparedStatement.setString(1, name);
    int count = preparedStatement.executeUpdate();
    if (count > 0) {
        System.out.println("Update saved\n");
    } else {
        System.out.println("Oops!, something went wrong");
        System.exit(0);
    }
    ex_Customer();

}
@Override
    public void rej_Status(Employee employee) throws SQLException{
        String sql="Update customer set status='reject', balance=NULL,transfer_in=NULL,transfer_out=NULL where user_name =(?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give username");
        String name=scanner.next();
        preparedStatement.setString(1, name);
        int count = preparedStatement.executeUpdate();
       // Lock(employee);
        if (count > 0) {
            System.out.println("Customer rejected\n");
            coo_Employee();
        } else {
            System.out.println("Oops!, something went wrong");
            System.exit(0);
        }

    }
    @Override
    public void Lock(Employee employee) throws SQLException{//gets only the last transaction time
        String sql ="Call del()";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.executeQuery();



    }



    @Override
    public void Log(Employee employee) throws SQLException{//gets only the last transaction time
        String sql ="Call LOG()";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet count = preparedStatement.executeQuery();
        while (count.next()) {
            System.out.println("Id: " + count.getInt(1) + ", user_name: " +
                    count.getString(2) + ", Last Action: " + count.getString(3));
        }

        new_Employee();
    }

}
