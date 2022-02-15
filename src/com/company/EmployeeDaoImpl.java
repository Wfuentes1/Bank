package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


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
        System.out.println("Please give emp_name");
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
        //String sql = "Select * from customer where user_name=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet count = preparedStatement.executeQuery();
        while (count.next()) {
            System.out.println("Id: " + count.getInt(1) + ", name: " +
                    count.getString(2) + ", balance: " + count.getString(4));
        }
    }

@Override
    public void app_Status(Employee employee) throws SQLException{
        String sql="update into  customer value status=('approve') where user_name =(?)";
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
    }

}
@Override
    public void rej_Status(Employee employee) throws SQLException{
        String sql="Update into  customer value status='reject' where user_name =(?)";
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
        }

    }

}
