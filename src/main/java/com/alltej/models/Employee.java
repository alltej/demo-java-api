package com.alltej.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    private String name;
    private Integer age;
    private String gender;

    private Department department;
    private Integer salary;

    private Employee( String name, Integer age, String gender ) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    @Override public int compareTo( Employee ob ) {
        return age.compareTo(ob.getAge());
    }

    public static Employee of(String name, Integer age, String gender) {
        return new Employee( name, age, gender );
    }
    public static Employee of(String name, Integer age, String gender, Department department, Integer salary) {
        Employee employee = new Employee( name, age, gender );
        employee.setDepartment( department );
        employee.setSalary( salary );
        return employee;
    }

    @Override public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", gender='" + gender + '\'' + ", department="
                + department.getName() + ", salary=" + salary + '}';
    }
}
