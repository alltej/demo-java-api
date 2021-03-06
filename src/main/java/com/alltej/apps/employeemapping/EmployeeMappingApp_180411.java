package com.alltej.apps.employeemapping;

import com.alltej.models.Department;
import com.alltej.models.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * @author Allan Tejano
 * 4/11/2018
 */
public class EmployeeMappingApp_180411 {
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
            Employee.of( "IT-C", 32, "M", DepartmentIT, 80 ),
            Employee.of( "CP-A", 41, "M", DepartmentCompliance, 80 ),
            Employee.of( "CP-B", 42, "F", DepartmentCompliance, 85 )
    );

    @Test public void group_employees_by_department_then_list_employees_by_dept() {
        ee.stream()
                .collect( Collectors.groupingBy( Employee::getDepartment, toList() ) ).entrySet().forEach(
                        s -> {
                            System.out.println(s.getKey().getName());
                            //s.getValue().forEach( System.out::println );
                            System.out.println("-----------------");
                            s.getValue().stream().map( e -> e.getName() ).collect( toList() ).forEach( System.out::println );
                            System.out.println("=================");
                        }
                );
    }

    @Test public void get_total_salary_by_dept() {
        ee.stream().collect( Collectors.groupingBy( Employee::getDepartment, Collectors.summingInt( Employee::getSalary ) ) )
                .entrySet().forEach( s -> {
            System.out.println(s.getKey().getName() + "::" + s.getValue() );
        } );
    }

    @Test public void get_employee_w_max_salary_by_dept() {
        Map<Department, Employee> eeWmax = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.collectingAndThen( Collectors.reducing( (Employee e1, Employee e2) ->
            e1.getSalary() > e2.getSalary()? e1:e2
        ), Optional::get) ) );
        eeWmax.entrySet().forEach( e -> System.out.println(e.getKey().getName() + "::" + e.getValue())
        );
    }

    @Test public void get_employee_w_max_salary() {
        Employee employee = ee.stream().collect( Collectors.collectingAndThen(
                Collectors.reducing( ( Employee e1, Employee e2 ) -> e1.getSalary() > e2.getSalary() ? e1 : e2 ),
                Optional::get ) );
        System.out.println(employee  + "::Dept=" + employee.getDepartment().getName());
    }

    @Test public void get_salary_stats_by_dept() {
        Map<Department, IntSummaryStatistics> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summarizingInt( Employee::getSalary ) ) );
        collect.entrySet().forEach( c -> System.out.println(c.getKey().getName() + "::" + c.getValue()) );
    }

    @Test public void sort_employee_by_salary_using_lambda() {
        List<Employee> collect = ee.stream().sorted( ( e1, e2 ) -> e1.getSalary().compareTo( e2.getSalary() ) )
                .collect( toList() );
        collect.forEach( System.out::println );

    }

    @Test public void sort_employee_by_salary_using_comparator() {
        List<Employee> collect = ee.stream().sorted( Comparator.comparing( Employee::getSalary ) )
                .collect( toList() );
        collect.forEach( System.out::println );
    }

    @Test public void sort_employee_by_age_then_salary_using_comparator() {
        List<Employee> collect = ee.stream().sorted( Comparator.comparing( Employee::getAge ).thenComparing( Employee::getSalary) )
                .collect( toList() );
        collect.forEach( System.out::println );
    }

}
