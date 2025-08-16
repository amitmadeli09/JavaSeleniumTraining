package day7;
import java.util.Scanner;

public class TryAndCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1st Number :");
		int a = sc.nextInt();
		System.out.println("Enter 1st Number :");
		int b = sc.nextInt();
		int result = 0;
		
		try {
			result = a+b;
		}catch(Exception err) {
			System.out.println("Invalid Result"+err);
		}
		System.out.println("The result is: "+result);
		
		sc.close();
	}

}
