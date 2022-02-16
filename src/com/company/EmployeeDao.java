package com.company;

import java.sql.SQLException;

public interface EmployeeDao {


     void Login(Employee employee) throws SQLException;




    void emp_Check(Employee employee) throws SQLException;


    void app_Status(Employee employee) throws SQLException;

    void rej_Status(Employee employee) throws SQLException;

    void Log(Employee employee) throws SQLException;
}
