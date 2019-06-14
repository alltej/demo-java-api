package com.alltej.apps.employeemapping;

import com.alltej.models.Department;
import com.alltej.models.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Allan Tejano
 * 3/9/2018
 */
public class EmployeeMappingApp_ex {

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

    @Test
    public void group_employees_by_department_then_list_employees_by_dept() {
        Map<Department, List<Employee>> collect = ee.stream().collect(Collectors.groupingBy(Employee::getDepartment, toList()));
        collect.entrySet().stream().forEach(k -> {
            System.out.println(k.getKey().getName());
            k.getValue().forEach(n -> {
                System.out.println(n.getName());
            });
        });
    }

    @Test public void get_total_salary_by_dept() {
        Map<Department, Integer> collect = ee.stream().
                collect(Collectors.groupingBy(Employee::getDepartment, summingInt(Employee::getSalary)));
        collect.forEach((k,v) -> {
            System.out.println(k.getName() + ": " + v);
        });

    }

    @Test public void get_employee_w_max_salary_by_dept() {
        HashMap<Department, Employee> eeWithMaxSal = new HashMap<>();
        Map<Department, List<Employee>> map = ee.stream().collect(Collectors.groupingBy(Employee::getDepartment, toList()));
            map.entrySet().stream().forEach(kv -> {
                Employee employee = kv.getValue().stream().reduce((o, n) -> n.getSalary() > o.getSalary() ? n : o).orElse(null);
                eeWithMaxSal.put(kv.getKey(), employee);

            });
        assertEquals( "IT-C", eeWithMaxSal.get( DepartmentIT ).getName() );
    }

    @Test public void get_employee_w_max_salary() {
        Optional<Employee> employee = ee.stream().reduce((o, n) -> n.getSalary() > o.getSalary() ? n : o);
        assertEquals( "CP-B", employee.get().getName() );
    }

    @Test public void get_salary_stats_by_dept() {
        Map<Department, IntSummaryStatistics> deptStats = ee.stream()
                .collect(groupingBy(Employee::getDepartment, summarizingInt(Employee::getSalary)));

        deptStats.entrySet().stream().forEach( d -> {
            System.out.println(d.getKey().getName());
            System.out.println(d.getValue());
            System.out.println("--------------");
        } );
    }

    @Test public void sort_employee_by_salary_using_lambda() {
        List<Employee> collect = null;
        collect.forEach( System.out::println );

    }

    @Test public void sort_employee_by_salary_using_comparator() {
        List<Employee> collect = ee.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(toList());
        collect.forEach( System.out::println );
    }

    @Test public void sort_employee_by_age_then_salary_using_comparator() {
        List<Employee> collect = ee.stream().sorted((Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getSalary))).collect(toList());
        collect.forEach( System.out::println );
    }

    @Test public void sort_employee_by_name() {
        List<Employee> collect = null;
        collect.forEach( System.out::println );
    }

    @Test public void reverse_list() {
        List<Employee> collect = null;
        collect.forEach( System.out::println );
    }
}
