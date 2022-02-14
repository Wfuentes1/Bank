package com.company;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.*;




public class Bank {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        // write your code here
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Revature Bank. Are you a 1) New Customer 2)Existing Customer or 3) Employee?");
        int user = input.nextInt();
        switch (user) {
            case 1:
                new_Customer();
                break;
            case 2:
                ex_Customer();
                break;
            case 3:
                Employee();
               // System.out.println("You are an employee");


                break;
            default:
                throw new IllegalStateException("Unexpected value: " + user);
        }


    }

    private static void Employee() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Login");
        EmployeeDao empDao = EmpDaoFactory.getEmployeeDao();
        Employee emp = new Employee();
       EmployeeDao.emp_Login(emp);

        System.out.println("What will you like to do 1) Check accounts 2) Reject account 3)Check transactions ");


    }

    private static void ex_Customer() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Login");
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Customer customer = new Customer();
        customerDao.Login(customer);
        Scanner scan = new Scanner(System.in);

            System.out.println("Would like to make a 1)Deposit 2)Withdraw 3)Transfer  4)Check or 5)Quit");
            int user = scanner.nextInt();

            switch (user) {
                case 1:
                    Deposit();
                    break;
                case 2:
                    Withdraw();
                    break;
                case 3:
                    //Transfer();
                case 4:
                    Check();
                    break;
                case 5:
                    System.out.println("Thank for your service");
                    System.exit(0);

                    break;


            }
    }

    private static void Check() throws SQLException {
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Customer customer = new Customer();
        customerDao.Check(customer);
    }


    private static void new_Customer() throws SQLException {
        System.out.println("Welcome new customer! Please follow instructions to create your account.\n");
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Customer customer = new Customer();
        customerDao.addCustomer(customer);


            System.out.println("Would like to make a 1)Deposit 2)Withdraw 3)Transfer or 4)Quit");
            Scanner scan = new Scanner(System.in);
            int user = scan.nextInt();
            switch (user) {
                case 1:
                    Deposit();
                    break;
                case 2:
                    Withdraw();
                    break;
                case 3:
                    //Transfer();
                case 4:
                    System.out.println("Thank for your service");
                    System.exit(0);
                    break;


            }





    }

    private static void Withdraw() throws SQLException {
        System.out.println("Please enter amount you wished to withdraw.");
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Customer customer = new Customer();
        customerDao.Withdraw(customer);

    }

    private static void Deposit() throws SQLException {
        System.out.println("Please enter amount you wished to deposit.");
        CustomerDao customerDao = CustomerDaoFactory.getCustomerDao();
        Customer customer = new Customer();
        customerDao.addDeposit(customer);
    }
}