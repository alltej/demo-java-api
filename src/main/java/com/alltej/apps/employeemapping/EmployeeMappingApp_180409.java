package com.alltej.apps.employeemapping;

import com.alltej.models.Department;
import com.alltej.models.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 4/9/2018
 */
public class EmployeeMappingApp_180409 {
    private static final Department DepartmentHR = Department.of( 1, "HR" );
    private static final Department DepartmentPayroll = Department.of( 2, "Payroll" );
    private static final Department DepartmentIT = Department.of( 3, "IT" );
    private static final Department DepartmentCompliance = Department.of( 4, "Compliance" );

    private static final Collection<Employee> ee = asList(
            Employee.of( "HR-A", 21, "M", DepartmentHR, 50 ),
            Employee.of( "HR-B", 22, "F", DepartmentHR, 55 ),
            Employee.of( "PR-A", 23, "M", DepartmentPayroll, 60 ),
            Employee.of( "PR-B", 24, "F", DepartmentPayroll, 65 ),
            Employee.of( "IT-A", 31, "M", DepartmentIT, 70 ),
            Employee.of( "IT-B", 32, "F", DepartmentIT, 75 ),
            Employee.of( "CP-A", 41, "M", DepartmentCompliance, 80 ),
            Employee.of( "CP-B", 42, "F", DepartmentCompliance, 85 )
    );

    // Group employees by department then_forEach_with_lambda
    @Test public void group_employees_by_department_then_forEach_with_lambda() {
        Map<Department, List<Employee>> eeByDept = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment, Collectors.toList() ) );
        eeByDept.entrySet().forEach( e -> {
            System.out.println(e.getKey().getName());
            e.getValue().forEach( System.out::println);
            System.out.println("*******");
        } );
    }

    // Group employees by department then_forEach_with_stream_api
    @Test public void group_employees_by_department_then_forEach_with_stream_api() {
        Map<Department, List<Employee>> collect = ee.stream()
                .collect( Collectors.groupingBy( Employee::getDepartment, Collectors.toList() ) );
        collect.entrySet().stream().forEach( s -> {
            System.out.println(s.getKey().getName());
            s.getValue().stream().forEach( System.out::println );
        } );
    }

    // Compute sum of salaries by department
    @Test public void compute_salaries_by_dept() {
        Map<Department, Integer> salaryByDept = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summingInt( Employee::getSalary ) ) );
        salaryByDept.entrySet().stream().forEach( s ->{
            System.out.println(s.getKey().getName() + "::" + s.getValue());
        } );
    }

    // get Map of Department and Employee with max salary
    @Test public void get_employee_w_max_salary_by_dept() {
        Map<Department, Employee> collect = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment,
                Collectors.collectingAndThen( Collectors
                                .reducing( ( Employee e1, Employee e2 ) -> e1.getSalary() > e2.getSalary() ? e1 : e2 ),
                        Optional::get ) ) );
        collect.entrySet().stream().forEach( c -> {
            System.out.println(c.getKey().getName() + "::" + c.getValue());
        });

    }


    // Compute average of salaries by department
    @Test public void compute_average_salary_by_dept() {
        Map<Department, Double> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.averagingDouble( Employee::getSalary ) ) );
        collect.entrySet().forEach( c ->{
            System.out.println(c.getKey().getName() + "::" + c.getValue());
        } );
    }

    // Compute total and average of salaries by department
    @Test public void compute_total_and_average_salary_by_dept() {
        Map<Department, IntSummaryStatistics> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summarizingInt( Employee::getSalary ) ) );
        collect.entrySet().stream().forEach( c -> {
            System.out.println(c.getKey().getName() + "::Count=" + c.getValue().getCount() + "::Sum=" + c.getValue().getSum() + "::Ave=" + c.getValue().getAverage());
        } );
    }
}
