package day3;

public class Calculator {
	class Calculator1 {
		public int add(int a,int b) {
			return a+b;
		}
		
		public double add(double a,double b) {
			return a+b;
	}
		
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		Calculator1 c1 = c.new Calculator1();
		System.out.println("Sum of Integers: "+c1.add(20,10));
		System.out.println("Sum of Decimals: "+c1.add(20.23d,13.29d));

	}

}
