package junit5;

import EmployeeMapping.Employee;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class RangeGroupByTest {
    //private List<Employee> e = new ArrayList<>();
    private static final List<Employee> employees = Arrays
            .asList( Employee.of( "John", 29, "M" ),
                    Employee.of( "Joshua", 30, "M" ),
                    Employee.of( "James", 31, "M" ),
                    Employee.of( "Jasmine", 35, "F" ),
                    Employee.of( "Mike", 41, "M" ),
                    Employee.of( "Mary", 42, "F" ),
                    Employee.of( "Mel", 42, "F" ),
                    Employee.of( "Mark", 44, "M" ),
                    Employee.of( "Martin", 44, "M" ),
                    Employee.of( "Max", 44, "M" ),
                    Employee.of( "Melinda", 44, "F" ),
                    Employee.of( "Mercy", 45, "F" ),
                    Employee.of( "Matthew", 47, "M" ),
                    Employee.of( "Mat", 49, "M" ),
                    Employee.of( "Pat", 50, "M" ),
                    Employee.of( "Peter", 56, "M" ) );

    @Test public void groupByAge_listOfEmployees() {
        Map<Integer, List<Employee>> employeesByAge = employees.stream()
                .filter( e -> e.getAge() > 35 )
                .collect( Collectors.groupingBy( Employee::getAge, toList() ));

    }

    @Test public void groupByAge_countNumberOfEmployees() {
        Map<Integer, Long> employeesByAge = employees.stream().filter( e -> e.getAge() > 35 )
                .collect( Collectors.groupingBy( Employee::getAge, Collectors.counting() ) );
        employeesByAge.entrySet().stream().forEach( e -> System.out.println( e.getKey() + "::" + e.getValue() ) );
    }

    @Test public  void groupByAge_then_gender_listOfEmployees() {
        Map<Integer, Map<String, List<Employee>>> mapOfEmployees= employees.stream().collect(
                Collectors.groupingBy( Employee::getAge, Collectors.groupingBy( Employee::getGender, toList() ) ) );

        mapOfEmployees.entrySet().forEach( e -> {
            System.out.println("------------");
            System.out.println("Age: " + e.getKey());
            System.out.println("\t");
            e.getValue().entrySet().forEach( g -> {
                System.out.println("Gender:"+ g.getKey());
                g.getValue().forEach( l -> {
                    System.out.println("name: " + l.getName() + ", age:" + l.getAge());
                } );
            }  );
        } );
    }














    @Test public void groupByAge_count( ) {

        Map<Integer, Long> ageCount = employees.stream()
                .filter( e -> e.getAge() > 30 )
                .sorted( Employee::compareTo )
                .collect( Collectors.groupingBy( Employee::getAge,
                        Collectors.counting() ) );

        ageCount.forEach((a,c)-> {
            System.out.println(a + "::" + c);
        } );
    }

    @Test public void grouping_byAge_then_list() {
        Map<Integer, List<Employee>> map = employees.stream()
                .filter( e -> e.getAge() > 30 )
                .sorted( (e1, e2) -> Integer.compare( e1.getAge(), e2.getAge() ) )
                .collect( Collectors.groupingBy( Employee::getAge , toList())) ;
        map.forEach( (Integer k , List<Employee> v ) -> {
            System.out.println(k);
            v.forEach( System.out::println );
        } );
    }

    @Test public void groupByAge_toSet( ) {

        Map<Integer, Set<Employee>> result = employees.stream()
                .filter( e -> e.getAge() > 30 )
                .collect( Collectors.groupingBy( Employee::getAge, toSet() ) );

        //System.out.println(result);
        result.forEach( (Integer k, Set<Employee> e) ->{
            System.out.println(k);
            e.forEach( System.out::println );
        });

    }

    @Test public void groupByAge_then_groupByGender_list( ) {

        Map<Integer, Map<String, Set<Employee>>> result = employees.stream()
                .filter( e -> e.getAge() > 30 )
                .collect( Collectors.groupingBy( Employee::getAge,
                        Collectors.groupingBy(Employee::getGender, toSet()) ) );
                //.collect(groupingBy(BlogPost::getAuthor, groupingBy(BlogPost::getType)));
        result.forEach( ( Integer k, Map<String, Set<Employee>> v ) ->{
            System.out.println();
            System.out.print(k + "::");
            v.forEach( (g,c) ->
                    System.out.print(g + "::" + c) );
        });
    }

    @Test public void groupByAge_then_groupByGender_list_with_count( ) {

        Map<Integer, Map<String, Long>> result = employees.stream()
                .sorted(comparing(Employee::getAge))
                .filter( e -> e.getAge() > 30 )
                .collect( Collectors.groupingBy( Employee::getAge,
                        Collectors.groupingBy(Employee::getGender, Collectors.counting() ) ) );
        result.forEach( ( Integer k, Map<String, Long> v ) -> {
                    System.out.println();
                    System.out.print(k + "::");
                        v.forEach( (g,c) ->
                                System.out.print(g + "::" + c) );
                    } );
    }
    @Test public void natural_sorting_by_age( ) {

        List<Employee> results = employees.stream()
                .sorted( comparing( Employee::getAge ) )
                .collect( Collectors.toList() );
        results.forEach(e -> System.out.println("Age:" + e.getAge() + "::" + e.getName()) );
    }

    @Test
    public void sorting() {
        employees.stream()
                .filter( e->e.getAge()>40 )
                .sorted( Comparator.comparingInt( Employee::getAge ) )
                .forEach(e -> System.out.println(e));
    }

    @Test
    public void sort_then_to_grouping_by() {
        Map<Integer, List<Employee>> unsorted = employees.stream()
                .filter( e -> e.getAge() > 40 )
                .sorted( Comparator.comparingInt( Employee::getAge ) )
                .collect( Collectors.groupingBy( Employee::getAge, toList() ) );
        Map<Integer, List<Employee>> sorted = unsorted.entrySet().stream()
                .sorted( Map.Entry.comparingByKey() )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sorted);
    }
}
