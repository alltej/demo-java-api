package junit5;

import com.alltej.models.Department;
import com.alltej.models.Employee;
import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

/**
 * @author Allan Tejano
 * 3/15/2018
 */

public class EmployeeDepartmentTests_180318
{
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
        Map<Department, List<Employee>> eeByDept = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment ) );
        eeByDept.forEach( (m, v) -> {
            System.out.println(m.getName());
            v.forEach( e -> System.out.println( e.getName() ) );
            System.out.println("**************");
        } );
    }

    // Group employees by department then_forEach_with_stream_api
    @Test public void group_employees_by_department_then_forEach_with_stream_api() {
        Map<Department, List<Employee>> eebyDept = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment ) );
        eebyDept.entrySet().stream().forEach( e ->{
            System.out.println(e.getKey().getName());
            e.getValue().stream().map(Employee::getName ).forEach( System.out::println );
            System.out.println("**************");
        } );
    }

    // Compute sum of salaries by department
    @Test public void compute_salaries_by_dept() {
        Map<Department, Integer> eeByDepartmentAndSumOfSalary = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summingInt( Employee::getSalary ) ) );
        eeByDepartmentAndSumOfSalary.forEach( (d,s) ->{
            System.out.println(d.getName() + "::" + s.toString());
        } );
    }

    // Compute average of salaries by department
    @Test public void compute_average_salary_by_dept() {
        Map<Department, Double> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.averagingInt( Employee::getSalary ) ) );
        collect.entrySet().stream().forEach( m -> {
            System.out.println(m.getKey().getName() + "::" + m.getValue());
        } );
    }

    // Compute total and average of salaries by department
    @Test public void compute_total_and_average_salary_by_dept() {
        Map<Department, IntSummaryStatistics> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summarizingInt( Employee::getSalary ) ) );
        collect.entrySet().forEach(  c ->{
            System.out.println(c.getKey().getName() + ";Count=" + c.getValue().getCount() + ";Total=" + c.getValue().getSum() + ";Ave="+ c.getValue().getAverage());
        } );
    }
}
