package day2;

public class Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 3;
		
		// Arithmetic operators
		System.out.println("The sum is: " + (a+b));
		System.out.println("The subtraction is: " + (a-b));
		System.out.println("The multiplication is: " + a*b);
		System.out.println("The divide is: " + a/b);
		System.out.println("The remainder is: " + a%b);
		
		// Relational / Comparison Operators
		System.out.println(a == b);
		
		
		// Logical Operators
		System.out.println(a > 0 && b > 0) ;
		
		// Assignment Operators
		int c = a + b;
		System.out.println(c);
		
		// Unary Operators
		System.out.println(c++);
		System.out.println(++c);
		
		// Ternary Operator
		
		int min = (a < b) ? a : b;
		System.out.println("Smaller number is: "+min);
	}

}
