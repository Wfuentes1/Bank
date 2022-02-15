package com.company;
import java.sql.SQLException;
import java.util.List;


public interface CustomerDao {
    void addCustomer(Customer customer) throws SQLException;

void Login(Customer customer) throws SQLException;

    void Check(Customer customer) throws SQLException;



    void addDeposit(Customer customer) throws SQLException;
    void Withdraw(Customer customer) throws SQLException;


    void TransferTo(Customer customer) throws SQLException;

    void Transfer(Customer customer) throws SQLException;
}
