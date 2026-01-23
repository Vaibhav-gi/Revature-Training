package StreamDemo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemoPerson {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(
                new Person(1, "Pratik"),
                new Person(2, "Vikas"),
                new Person(3, "Vishnu"),
                new Person(4, "Neha")
        );

        persons.stream()
                .forEach(p -> System.out.println(p));


        // We have to use Map
        List<String> names = persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        System.out.println(names);


        Set<Person> personSet = persons.stream()
                .collect(Collectors.toSet());

        personSet.forEach(System.out::println);


        Stream.of(
                new Person(5, "Kiran"),
                new Person(6, "Sneha")
        ).forEach(System.out::println);
    }
}

// This is POJO class (NON-public)
class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + name + "'}";
    }
}
