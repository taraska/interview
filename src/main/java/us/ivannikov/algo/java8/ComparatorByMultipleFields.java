package us.ivannikov.algo.java8;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    String lastName;
    String firstName;
    int age;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class ComparatorByMultipleFields {

    public static void main(String[] args) {
        List<Person> people = new java.util.ArrayList<>(List.of(new Person("A", "A", 1),
            new Person("C", "C", 3),
            new Person("B", "B", 2)));// your list of Person objects

// Sort by lastName ascending, then firstName descending, then age ascending
        List<Person> sortedPeople = people.stream()
            .sorted(Comparator.comparing(Person::getLastName)
                .thenComparing(Comparator.comparing(Person::getFirstName).reversed())
                .thenComparingInt(Person::getAge))
            .collect(Collectors.toList());

        people.sort(Comparator.comparing(Person::getLastName)
            .thenComparing(Person::getFirstName)
            .thenComparingInt(Person::getAge));

        for (Person p : people) {
            System.out.println(p.getFirstName());
            System.out.println(p.getLastName());
            System.out.println(p.getAge());
        }

        for (Person p : sortedPeople) {
            System.out.println(p.getFirstName());
            System.out.println(p.getLastName());
            System.out.println(p.getAge());
        }
    }
}
