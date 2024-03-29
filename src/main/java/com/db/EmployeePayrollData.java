package com.db;

import java.time.LocalDate;

public class EmployeePayrollData {
    public int employee_id;
    public String name;
    public double salary;
    public LocalDate start;

    public EmployeePayrollData(int id, String name, double salary, LocalDate start) {
        this.employee_id = id;
        this.name = name;
        this.salary = salary;
        this.start = start;
    }
}