package day1;

public class ReferenceVar {

    public static void changeName(Person p) {
        p.name = "abc to Changed";
    }

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = num1;
        num2 = 20;
        System.out.println("The num1 is: " + num1);
        System.out.println("The num2 is: " + num2);

        Person p1 = new Person("Amit");

        System.out.println("p1 = " + p1);

        Person p2 = p1;

        System.out.println("p2 = " + p2);

        p2.name = "abc";

        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);

        changeName(p1);

        System.out.println("p1 after changeName = " + p1);
        System.out.println("p2 = " + p2);
    }
}