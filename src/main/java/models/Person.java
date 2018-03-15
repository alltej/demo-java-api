package models;

/**
 * @author Allan Tejano
 * 3/15/2018
 */

public class Person {
    private Person( String name, Integer age ) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public static Person of( String name, Integer age ) {
        return new Person( name,age );
    }

    @Override public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
