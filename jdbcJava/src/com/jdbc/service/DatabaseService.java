package com.jdbc.service;

import com.jdbc.model.Employee;
import com.jdbc.util.DatabaseUtil;
import com.jdbc.util.QueryUtil;

import java.sql.*;

public class DatabaseService {

    DatabaseUtil databaseUtil = new DatabaseUtil();

    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = databaseUtil.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insertEmployeeQuery());) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeAddress());
            preparedStatement.setDouble(3, employee.getEmployeeSalary());
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Record created successfully");
            } else {
                System.out.println("Insert record failed");
            }
        }
    }//End of insert employee method

    public void getAllEmployees() throws SQLException {
        try (Connection connection = databaseUtil.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(QueryUtil.selectAllEmployeeQuery());) {
            while (resultSet.next()) {
                printEmployee(new Employee(resultSet.getInt("Employee_ID"), resultSet.getString("Employee_name"), resultSet.getString("Employee_address"), resultSet.getDouble("employee_salary")));
            }
        }
    } //End of getALlEmployees

    private void printEmployee(Employee employee) {
        System.out.println("Employee id: " + employee.getEmployeeId());
        System.out.println("Employee name: " + employee.getEmployeeName());
        System.out.println("Employee address: " + employee.getEmployeeAddress());
        System.out.println("Employee Salary: " + employee.getEmployeeSalary());
        System.out.println("------------------------------");

    }

    public void getEmployeeById(int id) throws SQLException {
        try (Connection connection = databaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.getEmployeeByIdQuery(id));

        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                printEmployee(new Employee(resultSet.getInt("Employee_ID"), resultSet.getString("Employee_name"), resultSet.getString("Employee_address"), resultSet.getDouble("employee_salary")));
            }
        }
    }//End Of Get employee by ID

    public void deleteEmployeeById(int id) throws SQLException{
        try( Connection connection = databaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.deleteEmployeeQuery(id));
        ){
            int rows = preparedStatement.executeUpdate();
            if(rows>0){
                System.out.println("Records Updated successfully");
            }
            else{
                System.out.println("Please enter correct employeeId");
            }
        }
    }

}
