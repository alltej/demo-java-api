package junit5;

import com.alltej.models.Department;
import com.alltej.models.Employee;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 3/15/2018
 */

public class EmployeeDepartmentTests_180328
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
        Map<Department, List<Employee>> collect = ee.stream()
                .collect( Collectors.groupingBy( Employee::getDepartment, Collectors.toList() ) );
        collect.entrySet().forEach( m -> {
            System.out.println("**********");
            System.out.println(m.getKey().getName());
            m.getValue().forEach( e -> {
                System.out.println(e.getName());
            } );
        } );
    }

    // Group employees by department then_forEach_with_stream_api
    @Test public void group_employees_by_department_then_forEach_with_stream_api() {
        Map<Department, List<Employee>> collect = ee.stream()
                .collect( Collectors.groupingBy( Employee::getDepartment, Collectors.toList() ) );
        collect.entrySet().stream().forEach( s -> {
            System.out.println("********");
            System.out.println(s.getKey().getName());
            s.getValue().stream().forEach( e -> {
                System.out.println(e.getName());
            } );
        } );
    }

    // Compute sum of salaries by department
    @Test public void compute_salaries_by_dept() {
        Map<Department, Integer> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summingInt( Employee::getSalary ) ) );
        collect.entrySet().stream().forEach( c ->  {
            System.out.println(c.getKey().getName() + "::" + c.getValue().toString());
        });
    }

    // Compute average of salaries by department
    @Test public void compute_average_salary_by_dept() {
        Map<Department, Double> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.averagingInt( Employee::getSalary ) ) );
        collect.entrySet().stream().forEach( c -> {
            System.out.println(c.getKey().getName() + "::" + c.getValue().doubleValue());
        } );
    }

    // Compute total and average of salaries by department
    @Test public void compute_total_and_average_salary_by_dept() {
        Map<Department, IntSummaryStatistics> collect = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summarizingInt( Employee::getSalary ) ) );
        collect.entrySet().stream().forEach( c ->{
            System.out.println(c.getKey().getName() + ";Count=" + c.getValue().getCount() + ";Sum=" + c.getValue().getSum() + ";Ave=" + c.getValue().getAverage() + ";Max=" + c.getValue().getMax());

        } );
    }
}
