package com.company;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao {

    Connection connection;
    private Customer customer;

    public CustomerDaoImpl() {

        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public void addCustomer(Customer customer) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        String sql = "insert into customer (user_name, password, balance) values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        System.out.println("Please make your user_name.");
        String cust_username = scanner.nextLine();
        System.out.println("Please make your password.");
        String cust_password = scanner.nextLine();
        System.out.println("Please give insert your starting amount to deposit.");
        String cust_Bala = scanner.nextLine();

        preparedStatement.setString(1, cust_username);

        preparedStatement.setString(2, cust_password);

        preparedStatement.setInt(3, Integer.parseInt(cust_Bala));
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer saved\n");
        } else {
            System.out.println("Oops!, something went wrong");

        }
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        String sql = "update customer (balance) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customer.getBalance());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer updated");
        } else {
            System.out.println("Oops!, something went wrong");
            ;
        }

    }

    @Override
    public void addDeposit(Customer customer) throws SQLException {
        String sql = "Update customer set balance= balance + (?) where user_name=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        int custBala = scanner.nextInt();
        //int amount = custBala;
        preparedStatement.setInt(1, custBala);
        if (custBala > 0) {
            System.out.println("Please give your username.");
            String username = scanner.next();
            preparedStatement.setString(2, username);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Customer saved\n");
            } else {
                System.out.println("Oops!, something went wrong");

            }
        }
    }


    @Override
    public void Withdraw(Customer customer) throws SQLException {
        String query = "Update customer set balance= balance - (?) where user_name=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        Scanner scanner = new Scanner(System.in);
        // int amt = scanner.nextInt();
        int custBala = scanner.nextInt();
        // String amount = "Select from Customer balance where user_name=(?)";
        preparedStatement.setInt(1, custBala);
        if (custBala > 0) {
            System.out.println("Please give your password.");
            String cust_pass = scanner.next();
            preparedStatement.setString(2, cust_pass);
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Withdrawl saved\n");
            } else {
                System.out.println("Oops!, something went wrong");
            }
        } else {
            System.out.println("Invalid withdraw.");
        }

    }


    @Override
    public void deleteCustomer(int id) throws SQLException {
        String sql = "delete from customer where username=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getUsername());
        // preparedStatement.setString(2, customer.getPassword());
        //  preparedStatement.setInt(3, customer.getBalance());
        int count = preparedStatement.executeUpdate();
        if (count > 0) {
            System.out.println("Customer deleted");
        } else {
            System.out.println("Oops!, something went wrong");
            ;
        }

    }

    @Override
    public void Login(Customer customer) throws SQLException {
        String sql = "Select * from customer where user_name=(?) AND password=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give username");
        String cust_username = scanner.next();
        preparedStatement.setString(1, cust_username);
        System.out.println("Please give password");
        String cust_pass = scanner.next();
        preparedStatement.setString(2, cust_pass);


        ResultSet count = preparedStatement.executeQuery();
    }

    @Override
    public void Check(Customer customer) throws SQLException {
        String sql = "Select * from customer where user_name=(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give password");
        String cust_pass = scanner.next();
        preparedStatement.setString(1, cust_pass);


        ResultSet count = preparedStatement.executeQuery();
        while (count.next()) {
            System.out.println("Id: " + count.getInt(1) + ", Username: " +
                    count.getString(2) + ", balance: " + count.getString(4));
        }
    }


}