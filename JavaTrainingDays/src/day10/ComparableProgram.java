package day10;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

class Person implements Comparable<Person> {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person other) {
		return Integer.compare(this.age, other.age);
	}

	@Override
	public String toString() {
		return name + " age is " + age;
	}
}

public class ComparableProgram {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Person 1", 24),
				new Person("Person 2", 60),
				new Person("Person 3", 18),
				new Person("Person 4", 45)
			);
			
			Collections.sort(people);
			for (Person per : people) {
				System.out.println(per);
			}
	}

}
