package day7;
import java.util.Scanner;

public class FactorialTryCatch {

    public static void main(String[] args) {
        int fact = 1;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a Number: ");
            int num = sc.nextInt();

            if (num < 1) {
                throw new Exception("Number can't be less than 1");
            }

            for (int i = 1; i <= num; i++) {
                fact *= i;
            }

            System.out.println("Result after Factorial: " + fact);

        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Execution complete.");
    }
}