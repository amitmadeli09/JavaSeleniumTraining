package day10;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CollectionComparable implements Comparable<CollectionComparable> {
    private String name;
    private int age;

    public CollectionComparable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(CollectionComparable other) {
        return this.age - other.age; // Sorting by age
    }

    @Override
    public String toString() {
        return name + " age is " + age;
    }
}

public class ComparableList {
    public static void main(String[] args) {
        List<CollectionComparable> a = Arrays.asList(
            new CollectionComparable("Person 1 :", 24),
            new CollectionComparable("Person 2 :", 60),
            new CollectionComparable("Person 3 :", 18)
        );

        Collections.sort(a);

        for (CollectionComparable people : a) {
            System.out.println(people);
        }
    }
}