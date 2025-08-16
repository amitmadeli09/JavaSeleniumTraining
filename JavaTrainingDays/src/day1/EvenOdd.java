package day1;
import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		if(num % 2 != 0) {
			System.out.println("Number is Odd");
		}
		else {
			System.out.println("Number is Even");
		}
		sc.close();

	}

}
