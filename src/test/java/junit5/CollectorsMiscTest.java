package junit5;

import models.EmployeeSalary;
import models.Person;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectorsMiscTest {

    private static final Collection<Person> persons = asList(
            Person.of( "AA", 21 ), Person.of( "ZZ",41 ),
            Person.of( "BB",22 ), Person.of( "YY", 42 ),
            Person.of( "CC", 23 ), Person.of("XX", 43) );

    private static final Collection<EmployeeSalary> salaries = asList(
            EmployeeSalary.of( 1 ), EmployeeSalary.of( 2 ),
            EmployeeSalary.of( 3 ), EmployeeSalary.of( 4 ),
            EmployeeSalary.of( 5 ), EmployeeSalary.of( 6 ),
            EmployeeSalary.of( 7 ), EmployeeSalary.of( 8 ),
            EmployeeSalary.of( 9 ), EmployeeSalary.of( 10 )
    );

    // Accumulate names into a List
    @Test public void accumulateNamesToList() {
        List<String> names = persons.stream().map( Person::getName ).collect( Collectors.toList() );
        names.forEach( System.out::println);
    }

    // Accumulate names into a TreeSet, sorted
    @Test public  void accumulate_names_into_a_treeset() {
        Set<String> set = persons.stream().map( Person::getName ).collect( Collectors.toCollection( TreeSet::new ) );
        set.forEach( System.out::println );
    }

    // Convert elements to strings and concatenate them, separated by commas
    @Test public void convert_elements_toString_and_concatenate_them_separated_by_comma() {
        String collect = persons.stream().map( Object::toString ).collect( Collectors.joining( " ," ) );
        System.out.println(collect);
    }

    // // Compute sum of salaries of employee
    @Test public void compute_sum_of_salaries_of_employee() {
        Long sumOfSalaries = salaries.stream().collect( Collectors.summingLong(EmployeeSalary::getSalary) );
        assertEquals( Long.valueOf(55  ), sumOfSalaries );
    }
}
