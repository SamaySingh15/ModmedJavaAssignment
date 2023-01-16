package com.jdbc.student;

import java.sql.*;
import java.util.Scanner;

public class StudentDatabase{

    private static Connection connection= null;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){

        StudentDatabase studentDatabase = new StudentDatabase();

        //Load and Register the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");


            String dbURL = "jdbc:mysql://localhost:3306/jdbcdb";
            String username = "root";
            String password = "Samay@123";

            //Establish the connection
            connection =DriverManager.getConnection(dbURL , username , password);

            System.out.println("Enter choice \n 1. Insert record \n 2. Select record \n 3. Callable Statement : Select All Record \n 4. Callable Statement : select Records by roll number ");
            System.out.println(" 5. Update record");
            System.out.println(" 6. Delete record");
            System.out.println(" 7 Transaction control");
            System.out.println(" 8 Batch processing");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice){
                case 1:
                    studentDatabase.insertRecord();
                    break;
                case 2:
                    studentDatabase.selectRecord();
                    break;
                case 3:
                    studentDatabase.selectAllRecords();
                    break;
                case 4:
                    studentDatabase.selectRecordsByRollNumber();
                    break;
                case 5:
                    studentDatabase.updateRecord();
                    break;
                case 6:
                    studentDatabase.deleteRecord();
                    break;
                case 7:
                    studentDatabase.transaction();
                case 8:
                    studentDatabase.batchProcessing();
                default:
                    break;
            }
        }
        catch(Exception e){
            throw new RuntimeException("Something went wrong");
        }

    }

    private void insertRecord() throws SQLException {

        String sql = "insert into student (name , percentage ,address) values(? ,? ,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        String name = scanner.nextLine();
        preparedStatement.setString(1 , scanner.nextLine());
        System.out.println("Enter percentage");
        preparedStatement.setDouble(2, Double.parseDouble(scanner.nextLine()));
        System.out.println("Enter Address");
        preparedStatement.setString(3, scanner.nextLine());
        int rows= preparedStatement.executeUpdate();
        if(rows>0){
            System.out.println("Record inserted succesfully");
        }

    }

    private void selectRecord() throws SQLException{
        System.out.println("Enter the roll number ");
        int number = Integer.parseInt(scanner.nextLine());

        String sql = "select * from student where roll_number="+number;
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while(result.next()){
            int rollNumber = result.getInt("roll_number");
            String name =  result.getString("name");
            Double percentage = result.getDouble("percentage");
            String address = result.getString("address");

            System.out.println("Roll no is : "+ rollNumber);
            System.out.println("Name is : " +name);
            System.out.println("percentage is :"+percentage);
            System.out.println("address is :"+ address);
        }
    }

    private void selectAllRecords() throws SQLException{
            CallableStatement callableStatement= connection.prepareCall("{call GET_ALL() }");
            ResultSet result = callableStatement.executeQuery();

            while(result.next()){
                System.out.println("Roll number is "+result.getInt("roll_number"));
                System.out.println("Name is : "+result.getString("name"));
                System.out.println("percentage is :"+ result.getDouble("percentage"));
                System.out.println("Address is : "+ result.getString("address"));
            }
    }

    private void selectRecordsByRollNumber() throws SQLException{
        CallableStatement callableStatement= connection.prepareCall("{call GET_RECORD(?) }");
        callableStatement.setInt(1,4);
        ResultSet result = callableStatement.executeQuery();

        while(result.next()){
            System.out.println("Roll number is "+result.getInt("roll_number"));
            System.out.println("Name is : "+result.getString("name"));
            System.out.println("percentage is :"+ result.getDouble("percentage"));
            System.out.println("Address is : "+ result.getString("address"));
        }
    }

    private void updateRecord() throws SQLException{
        System.out.println("Enter the roll number to update record");
        int roll = Integer.parseInt(scanner.nextLine());
        String sql= "select * from student where roll_number="+roll;
        Statement statement=connection.createStatement();
        ResultSet result= statement.executeQuery(sql);
        if(result.next()){
           int rollNumber= result.getInt("roll_number");
           String name = result.getString("name");
           double percentage = result.getDouble("percentage");
           String address =result.getString("address");
           System.out.println("Roll number is : "+rollNumber);
            System.out.println("Name is : "+name);
            System.out.println("percentage is : "+percentage);
            System.out.println("address is : "+address);

            System.out.println("What do you want to update?");
            System.out.println("1.Name \n 2.Percentage \n 3. Address");
            int choice =Integer.parseInt(scanner.nextLine());

            String sqlQuery = "update student set";

            switch(choice){
                case 1:
                    System.out.println("Enter the new name");
                    String tempname = scanner.nextLine();
                    sqlQuery = sqlQuery+ " name='"+tempname+"' where roll_number="+rollNumber;
                    PreparedStatement preparedStatement=connection.prepareStatement(sqlQuery);
                    int rows =preparedStatement.executeUpdate();
                    if(rows>0){
                        System.out.println("record updated successfully");
                    }
                    break;

                case 2:
                    System.out.println("Enter the percentage");
                    Double percent = Double.parseDouble(scanner.nextLine());
                    sqlQuery = sqlQuery+ " percentage="+percent+" where roll_number="+rollNumber;
                    PreparedStatement preparedStatemen=connection.prepareStatement(sqlQuery);
                    int row =preparedStatemen.executeUpdate();
                    if(row>0){
                        System.out.println("record updated successfully");
                    }
                    break;
                case 3:
                    System.out.println("Enter the new Address");
                    String newaddress = scanner.nextLine();
                    sqlQuery = sqlQuery+ " address='"+newaddress+"' where roll_number="+rollNumber;
                    PreparedStatement preparedStatement2=connection.prepareStatement(sqlQuery);
                    int rows2 =preparedStatement2.executeUpdate();
                    if(rows2>0){
                        System.out.println("record updated successfully");
                    }
                    break;
            }
        }
        else{
            System.out.println("Records not found.. ");
        }
    }

    private void deleteRecord() throws SQLException{
        System.out.println("Please enter the roll no");
        int roll = Integer.parseInt(scanner.nextLine());
        String query = "DELETE FROM student where roll_number="+roll;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int affectedRows =preparedStatement.executeUpdate();
        if(affectedRows>0){
            System.out.println("Record deleted successfully");
        }
        else{
            System.out.println("record could not be deleted");
        }

    }
    public void transaction() throws SQLException {
        // we want both of them to be executed or none of them should be executed if their is a error in any of these than whole transaction should be rolled back
        connection.setAutoCommit(false); //dont commit until I tell you
        String sql1 = "Insert into student(name , percentage , address) values ('XYZ' , 76.8 ,'Pune')";
        String sql2 = "Insert into student(name , percentage , address) values ('PQR' , 56.6,'Pushkar')"; // if there is a mistake in sql2 then first will get inserted while second not

        PreparedStatement preparedStatement = connection.prepareStatement(sql1);
        int row= preparedStatement.executeUpdate();

        preparedStatement=connection.prepareStatement(sql2);
        int row2=preparedStatement.executeUpdate();
        if(row>0 && row2>0){
            connection.commit();  // if both of the query are executed then commit will happen
            System.out.println("Records updated successfully");
        }
        else{
            connection.rollback();
            System.out.println("Update could not be completed");
        }
    }

    public void batchProcessing() throws SQLException {
        // we want both of them to be executed or none of them should be executed if their is a error in any of these than whole transaction should be rolled back
        connection.setAutoCommit(false); //don't commit until I tell you
        String sql1 = "Insert into student(name , percentage , address) values ('Binod' , 86.8 ,'gangtok')";
        String sql2 = "Insert into student(name , percentage , address) values ('Eshika' , 53.6,'Amritsar')";
        String sql3 = "Insert into student(name , percentage , address) values ('Geetnamika' , 89.6,'chennai')";

        Statement statement = connection.createStatement();
        statement.addBatch(sql1);
        statement.addBatch(sql2);
        statement.addBatch(sql3);
        int[] rows = statement.executeBatch();

        for(int i: rows){
            if(i>0){
                continue;
            }
            else{
                connection.rollback();
            }
        }
        System.out.println("Records Updated successfully");
        connection.commit();

    }

}
