package com.jdbc.main;

import com.jdbc.model.Employee;
import com.jdbc.service.DatabaseService;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        try (Scanner scanner = new Scanner(System.in);) {
            boolean isRunning = true;
            while (isRunning) {
                System.out.println("Enter choice");
                System.out.println("1. Insert");
                System.out.println("2. Select All");
                System.out.println("3. Select Employee by an ID");
                System.out.println("4. Delete Employee");
                System.out.println("5. Update Employee");
                System.out.println("6. Exit");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter name , address , salary");
                        databaseService.insertEmployee(new Employee(scanner.nextLine(), scanner.nextLine(), Double.parseDouble(scanner.nextLine())));
                        break;
                    case 2:
                        databaseService.getAllEmployees();
                        break;
                    case 3:
                        System.out.println("Please enter the Id");
                        databaseService.getEmployeeById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        System.out.println("Please enter the Id");
                        databaseService.deleteEmployeeById(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Thanks for your visit");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Incorrect choice");
                        break;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("something went wrong" + e);
        }

    }
}
