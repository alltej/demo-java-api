package com.alltej.apps.troof;

import org.junit.jupiter.api.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author atejano
 */
public class FriendsApp_prob {

//Given Person B are friends of A,C,D
//A -> B
//B -> A, C, D
//C -> D, E
//D -> B, E, F
//E -> C, D, F
//F -> D, E
//G -> H
//H -> G

//Find if two persons are friends

    @Test
    public void are_connected_tests() {

        Person a = new Person("A");
        Person b = new Person("B");
        Person c = new Person("C");
        Person d = new Person("D");
        Person e = new Person("E");
        Person f = new Person("F");
        Person g = new Person("G");
        Person h = new Person("H");


        a.addFriend(b);
        b.addFriends(asList(a, c, d));
        c.addFriends(asList(d,e ));
        d.addFriends(asList(b,e,f ));
        e.addFriends(asList(c,d,f ));
        f.addFriends(asList(d,e));
        g.addFriend(h);
        h.addFriend(g);

        assertTrue(areConnected(a, b));
        assertTrue(areConnected(a, f));
        assertFalse(areConnected(a, g));

    }

    public static boolean areConnected(Person x, Person y) {

        //code here

        return false;
    }

    public static class Person {
        final private String name;
        private List<Person> friends=new ArrayList<>();

        public Person(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        public List<Person> getFriends() {
            return friends;
        }

        public void addFriend(Person person) {
            friends.add(person);
        }
        public void addFriends(List<Person> persons) {
            friends.addAll(persons);
        }

        public String getName() {
            return name;
        }
    }

}


