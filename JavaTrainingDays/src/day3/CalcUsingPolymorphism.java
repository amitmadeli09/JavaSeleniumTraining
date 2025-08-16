package day3;
import java.util.Scanner;

//Polymorphism using method overriding

class Operation{
	public void operation(int a,int b){
		System.out.println("Operation Class function called");
	}
}

class Addition extends Operation{ // by overriding
	@Override
	public void operation(int a,int b){
		System.out.println("Addition of entered number is: "+(a+b));
	}
}
class Subtraction extends Operation{
	@Override
	public void operation(int a,int b){
		System.out.println("Subtraction of entered number is: "+(a-b));
	}
}
class Multiplication extends Operation{
	@Override
	public void operation(int a,int b){
		System.out.println("Multiplition of entered number is: "+(a*b));
	}
}
class Division extends Operation{
	@Override
	public void operation(int a,int b){
		System.out.println("Division of entered number is: "+(a/b));
	}
	}
class Remainder extends Operation{
	@Override
	public void operation(int a,int b){
		System.out.println("Remainder of entered number is: "+(a%b));
	}
}
public class CalcUsingPolymorphism extends Operation{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.print("Enter number 1: ");
		int a = sc.nextInt();
		System.out.print("Enter number 2: ");
		int b = sc.nextInt();
		
		Operation o1;
		
		System.out.println("\nEnter your operation choice:\n1. Add\n2. Subtract\n3. Multiply \n4. Divide\n5. Remainder");
		int operationChoice = sc.nextInt();
		switch(operationChoice) {
			case 1: 
				o1 = new Addition(); // Polymorphic reference
				o1.operation(a,b);
				break;
			case 2: 
				o1 = new Subtraction();
				o1.operation(a,b);
				break;
			case 3: 
				o1 = new Multiplication();
				o1.operation(a,b);
				break;
			case 4: 
				o1 = new Division();
				o1.operation(a,b);
				break;
			case 5: 
				o1 = new Remainder();
				o1.operation(a,b);
				break;
			default: 
				o1 = new Operation();
				o1.operation(a,b);
				break;
		}
		sc.close();

	}

}
