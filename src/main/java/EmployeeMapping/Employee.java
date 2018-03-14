package EmployeeMapping;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class Employee implements Comparable<Employee> {
    private String name;
    private Integer age;
    private String gender;

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
}
