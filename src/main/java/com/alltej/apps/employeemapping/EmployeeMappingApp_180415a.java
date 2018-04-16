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
 * 4/15/2018
 */
public class EmployeeMappingApp_180415a {
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
    }

    @Test public void get_total_salary_by_dept() {
    }

    @Test public void get_employee_w_max_salary_by_dept() {

        Map<Department, Employee> eeWMaxByDept = EmployeeMappingApp_180415a.ee.stream().collect( Collectors.groupingBy( Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.reducing( ( e1, e2 ) -> e1.getSalary() > e2.getSalary() ? e1 : e2 ),
                        Optional::get ) ) );
        eeWMaxByDept.entrySet().forEach( e -> {
            System.out.println(e.getKey().getName() + "::" + e.getValue());
        } );
    }

    @Test public void get_employee_w_max_salary() {
        Employee eeMaxSal = ee.stream().collect( Collectors
                .collectingAndThen( Collectors.reducing( ( e1, e2 ) -> e1.getSalary() > e2.getSalary() ? e1 : e2 ),
                        Optional::get ) );
        System.out.println(eeMaxSal);
    }

    @Test public void get_salary_stats_by_dept() {
    }

    @Test public void sort_employee_by_salary_using_lambda() {
    }

    @Test public void sort_employee_by_salary_using_comparator() {
    }

    @Test public void sort_employee_by_age_then_salary_using_comparator() {
        ee.stream().sorted( Comparator.comparing( Employee::getAge ).thenComparing( Employee::getSalary ) )
            .forEach( System.out::println );
    }

    @Test public void sort_employee_by_name() {
        ee.stream().sorted( Comparator.comparing( Employee::getAge ) ).forEach( System.out::println );
    }

    @Test public void reverse_list() {
        ee.stream().collect( Collectors.collectingAndThen( Collectors.toList(),
                l-> {
                    Collections.reverse( l );
                    return l;
                }) ).forEach( System.out::println );
    }
}
