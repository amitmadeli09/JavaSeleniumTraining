package day10;

import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ComparatorObjects {

    static class Student {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + "]";
        }
    }

    public static void main(String[] args) {
        
        Comparator<Student> com = new Comparator<Student>() {
            public int compare(Student i, Student j) {
                return Integer.compare(i.age, j.age); 
            }
        };

        List<Student> stud = new ArrayList<>();
        stud.add(new Student("Amit", 24));
        stud.add(new Student("Subham", 21));
        stud.add(new Student("Ronit", 20));
        stud.add(new Student("Anwesha", 22));

        System.out.println("Before Sorting:");
        for (Student s : stud) {
            System.out.println(s);
        }

        Collections.sort(stud, com);

        System.out.println("\nAfter Sorting by Age:");
        for (Student s : stud) {
            System.out.println(s);
        }
    }
}
