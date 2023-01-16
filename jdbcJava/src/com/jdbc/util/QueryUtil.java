package com.jdbc.util;

public class QueryUtil {
    public static String insertEmployeeQuery(){
        return "INSERT INTO EMPLOYEE_INFO(employee_name ,employee_address , employee_salary) VALUES (?,?,?)";
    }
    public static String selectAllEmployeeQuery(){
        return "SELECT * FROM EMPLOYEE_INFO";
    }
    public static String getEmployeeByIdQuery(int id){
        return "SELECT * FROM EMPLOYEE_INFO WHERE EMPLOYEE_ID="+id;
    }
    public static String deleteEmployeeQuery(int id){
        return "Delete from Employee_info where employee_id="+id;
    }
}
