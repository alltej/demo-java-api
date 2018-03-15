package junit5;

import models.Department;
import models.Employee;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Allan Tejano
 * 3/15/2018
 */
//
//class EmployeeWithDepartment {
//    private String employeeId;
//    private String name;
//    private Integer age;
//    private Department department;
//
//    public EmployeeWithDepartment( String employeeId, String name, Integer age, Department department ) {
//        this.employeeId = employeeId;
//        this.name = name;
//        this.age = age;
//        this.department = department;
//    }
//}

public class EmployeeDepartmentTests {
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

    // Group employees by department
    @Test public void group_employees_by_department_then_forEach_with_lambda() {
        Map<Department, List<Employee>> eeByDepts = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment ) );
        eeByDepts.forEach( (k, v) -> {
            System.out.println("**********************");
            System.out.println( k.getName() );
            v.forEach( n ->{
                System.out.println(n.getName());
            } );
        } );
    }


    @Test public void group_employees_by_department_then_forEach_with_stream_api() {
        Map<Department, List<Employee>> eeByDepts = ee.stream().collect( Collectors.groupingBy( Employee::getDepartment ) );
        eeByDepts.entrySet().stream().forEach( m ->{
            System.out.println("**********************");
            System.out.println(m.getKey().getName());
            m.getValue().forEach( e -> {
                System.out.println(e.getName());
            } );
        } );
    }

    // Compute sum of salaries by department
    @Test public void compute_salaries_by_dept() {
        Map<Department, Integer> salarySumByDept = ee.stream().collect(
                Collectors.groupingBy( Employee::getDepartment, Collectors.summingInt( Employee::getSalary ) ) );
        salarySumByDept.entrySet().stream().forEach(  e ->{
            System.out.println(e.getKey().getName() + "::" + e.getValue());
        } );
    }
}
