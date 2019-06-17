package com.alltej.models;

import java.util.Random;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Employee implements Comparable<Employee> {
    private final Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    private String name;
    private Integer age;
    private String gender;

    private Department department;
    private Integer salary;

    private Employee(Integer id,  String name, Integer age, String gender ) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.id = id;
    }
    private Employee( String name, Integer age, String gender ) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.id = new Random().nextInt();
    }

    @Override public int compareTo( Employee ob ) {
        return age.compareTo(ob.getAge());
    }

    public static Employee of(String name, Integer age, String gender) {
        return new Employee( name, age, gender );
    }
    public static Employee of(Integer id, String name, Integer age, String gender, Department department, Integer salary){
        Employee employee = new Employee( id, name, age, gender );

        employee.setDepartment( department );
        employee.setSalary( salary );
        return employee;
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

    public Integer getId() {
        return id;
    }
}
