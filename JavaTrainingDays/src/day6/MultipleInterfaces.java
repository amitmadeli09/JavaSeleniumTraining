package day6;

import java.util.Scanner;

interface Addition {
    default double add(double a, double b) {
        return a + b;
    }
}

interface Subtraction {
    default double subtract(double a, double b) {
        return a - b;
    }
}

interface Multiplication {
    default double multiply(double a, double b) {
        return a * b;  
    }
}

// Calculator implements all 3 interfaces
class Calculator implements Addition, Subtraction, Multiplication {
    // No need to override anything because we're using default methods
}

public class MultipleInterfaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.print("Enter the First Number: ");
        double a = sc.nextDouble();

        System.out.print("Enter the Second Number: ");
        double b = sc.nextDouble();

        System.out.println("----------------------------------");
        System.out.println("1 - Addition");
        System.out.println("2 - Subtraction");
        System.out.println("3 - Multiplication");
        System.out.print("Select an Option: ");
        int choice = sc.nextInt();

        double result = 0;

        switch (choice) {
            case 1:
                result = calc.add(a, b);
                System.out.println("Addition Result: " + result);
                break;
            case 2:
                result = calc.subtract(a, b);
                System.out.println("Subtraction Result: " + result);
                break;
            case 3:
                result = calc.multiply(a, b);
                System.out.println("Multiplication Result: " + result);
                break;
            default:
                System.out.println("Invalid option selected.");
        }

        System.out.println("----------------------------------");
        sc.close();
    }
}