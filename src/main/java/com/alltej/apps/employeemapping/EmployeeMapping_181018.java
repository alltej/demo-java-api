package com.alltej.apps.employeemapping;

import com.alltej.models.Department;
import com.alltej.models.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author atejano
 */
public class EmployeeMapping_181018 {
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
        Map<Department, List<Employee>> map = ee.stream().collect(groupingBy(Employee::getDepartment));
        map.entrySet().stream().forEach(m ->{
            System.out.println(m.getKey().getName());
            System.out.println("--------------");
            m.getValue().forEach(System.out::println);
            System.out.println();
        });
    }

    @Test public void get_total_salary_by_dept() {
        Map<Department, Integer> map = ee.stream().collect(groupingBy(Employee::getDepartment, summingInt(Employee::getSalary)));
        map.entrySet().forEach(m -> {
            System.out.println(m.getKey() + ": " + m.getValue() );
        });

    }

    @Test public void get_employee_w_max_salary_by_dept() {
//        Map<Department, List<Employee>> collect = ee.stream()
//                .collect( groupingBy( Employee::getDepartment, toList() ) );
//        Map<Department, Employee> eeMaxSalByDept = new HashMap<>();

        Map<Department, Employee> eeWithMaxSalByDept = ee.stream().collect(groupingBy(Employee::getDepartment,
                collectingAndThen(reducing((Employee e1, Employee e2)
                        -> e1.getSalary() > e2.getSalary() ? e1 : e2), Optional::get)));
        assertEquals( "IT-C", eeWithMaxSalByDept.get( DepartmentIT ).getName() );
    }

    @Test public void get_employee_w_max_salary() {
        Employee employee = ee.stream().collect(collectingAndThen(reducing((Employee e1, Employee e2) ->
                e1.getSalary() > e2.getSalary() ? e1 : e2), Optional::get));
        assertEquals( "CP-B", employee.getName() );
    }

    @Test public void get_salary_stats_by_dept() {
//        Map<Department, List<Employee>> collect = ee.stream()
//                .collect( groupingBy( Employee::getDepartment, toList() ) );
//        Map<Department, IntSummaryStatistics> deptStats = new HashMap<>();
//
//        deptStats.entrySet().stream().forEach( d -> {
//            System.out.println(d.getKey().getName());
//            System.out.println(d.getValue());
//            System.out.println("--------------");
//        } );

        Map<Department, IntSummaryStatistics> statsByDept = ee.stream().collect(
                groupingBy(Employee::getDepartment, summarizingInt(Employee::getSalary)));

        statsByDept.entrySet().stream().forEach( d -> {
            System.out.println(d.getKey().getName());
            System.out.println(d.getValue());
            System.out.println("--------------");
        } );
    }

    @Test public void sort_employee_by_salary_using_lambda() {
//        List<Employee> collect = null;
//        collect.forEach( System.out::println );

        ee.stream().sorted(comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList()).forEach(System.out::println);

    }

    @Test public void sort_employee_by_salary_using_comparator() {
        List<Employee> collect = null;
        collect.forEach( System.out::println );
    }

    @Test public void sort_employee_by_age_then_salary_using_comparator() {
        List<Employee> collect = null;
        collect.forEach( System.out::println );
    }

    @Test public void sort_employee_by_name() {
            ee.stream().sorted(comparing(Employee::getName).reversed())
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
    }

    @Test public void reverse_list() {
        List<Employee> collect = null;
        collect.forEach( System.out::println );
    }
}
