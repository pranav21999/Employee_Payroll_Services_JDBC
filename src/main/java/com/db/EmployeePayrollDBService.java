package com.db;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollDBService {

    public static void main(String[] args) {
        EmployeePayrollDBService employeePayrollDBService = new EmployeePayrollDBService();

        List<EmployeePayrollData> dataList = employeePayrollDBService.readData();
        System.out.println(dataList);
    }

    /**
     * Purpose : Using JDBC read employee payroll data from database
     *
     * @return employee payroll list
     */
    public List<EmployeePayrollData> readData() {

        String sql = "SELECT * from employee_details ;";
        List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

        try (Connection connection = this.getConnection()) {

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {

                int id = result.getInt("employee_id");
                String name = result.getString("name");
                double salary = result.getDouble("net_pay");
                LocalDate startDate = result.getDate("start").toLocalDate();
                employeePayrollList.add(new EmployeePayrollData(id, name, salary, startDate));

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return employeePayrollList;

    }

    /**
     * To create connection with the database
     * @throws SQLException
     */
    private Connection getConnection() throws SQLException {

        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "root1999";
        Connection connection;
        System.out.println("Connecting to database: " + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful! " + connection);
        return connection;

    }

}