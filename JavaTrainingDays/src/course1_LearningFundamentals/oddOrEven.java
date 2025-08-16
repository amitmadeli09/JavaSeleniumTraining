package course1_LearningFundamentals;

import java.util.Scanner;

public class oddOrEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("The Number is Even");
		}else {
			System.out.println("The Number is Odd");
		}
		sc.close();
	}

}
