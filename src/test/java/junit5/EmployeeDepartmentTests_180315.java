package junit5;

import models.Department;
import models.Employee;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 3/15/2018
 */
public class EmployeeDepartmentTests_180315 {

    private static final Department DepartmentHR = Department.of( 1, "HR" );
    private static final Department DepartmentPayroll = Department.of( 2, "Payroll" );
    private static final Department DepartmentIT = Department.of( 3, "IT" );
    private static final Department DepartmentCompliance = Department.of( 4, "Compliance" );

    private static final Collection<Employee> ee = asList(
            Employee.of( "EE-HR-A", 21, "M", DepartmentHR, 50 ),
            Employee.of( "EE-HR-B", 22, "F", DepartmentHR, 55 ),
            Employee.of( "EE-PR-A", 23, "M", DepartmentPayroll, 60 ),
            Employee.of( "EE-PR-B", 24, "F", DepartmentPayroll, 65 ),
            Employee.of( "EE-IT-A", 31, "M", DepartmentIT, 70 ),
            Employee.of( "EE-IT-B", 32, "F", DepartmentIT, 75 ),
            Employee.of( "EE-CP-A", 41, "M", DepartmentCompliance, 80 ),
            Employee.of( "EE-CP-B", 42, "F", DepartmentCompliance, 85 )
    );

    // Group employees by department then_forEach_with_lambda
    @Test public void group_employees_by_department_then_forEach_with_lambda() {
        Map<Department,List<Employee>> eeByDept = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment ) );
        eeByDept.forEach( (k, v) -> {
            System.out.println(k.getName());
            v.stream().map( Employee::getName ).forEach(System.out::println );
        } );
    }

    // Group employees by department then_forEach_with_stream_api
    @Test public void group_employees_by_department_then_forEach_with_stream_api() {
        Map<Department, List<Employee>> eeByDept = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment ) );
        eeByDept.entrySet().stream().forEach(  e -> {
            System.out.println(e.getKey().getName());
            e.getValue().stream().map( Employee::getName).forEach( System.out::println );
        } );

    }

    // Compute sum of salaries by department
    @Test public void compute_salaries_by_dept() {
        Map<Department, Integer> eeDeptSalaries = ee.stream()
                .collect( Collectors.groupingBy( Employee::getDepartment,
                Collectors.summingInt( Employee::getSalary ) ) );
        eeDeptSalaries.entrySet().forEach( e  ->{
            System.out.println(e.getKey().getName() + "::" + e.getValue());
        } );
    }

    // Compute average of salaries by department
    @Test public void compute_average_salary_by_dept() {
        Map<Department, Double> deptAveSalary = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.averagingInt( Employee::getSalary ) ) );
        deptAveSalary.forEach( (k,v)->{
            System.out.println(k.getName() + "::" + v);
        } );
    }

    // Compute total and average of salaries by department
    @Test public void compute_total_and_average_salary_by_dept() {
        Map<Department, IntSummaryStatistics> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summarizingInt( Employee::getSalary ) ) );
        collect.forEach( (k,v)->{
            System.out.println(k.getName() + "::" + v.getSum() + "::" + v.getAverage());
        } );
    }
}
