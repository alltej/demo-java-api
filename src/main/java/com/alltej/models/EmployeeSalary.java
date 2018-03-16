package com.alltej.models;

/**
 * @author Allan Tejano
 * 3/15/2018
 */
public class EmployeeSalary{
    private EmployeeSalary( Integer salary ) {
        this.salary = salary;
    }

    private Integer salary;

    public Integer getSalary() {
        return salary;
    }

    public static EmployeeSalary of( Integer salary ) {
        return new EmployeeSalary( salary );
    }
}
