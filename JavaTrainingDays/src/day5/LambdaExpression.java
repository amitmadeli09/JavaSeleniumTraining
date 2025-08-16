package day5;

interface LambdaCalculator {
	void operate (double a,double b);
}

public class LambdaExpression{
	public static void main(String[] args) {
		
		//adding 
		LambdaCalculator add = (double a, double b) -> System.out.println(a+b);
		//subtracting
		LambdaCalculator substract = (double a,double b) -> System.out.println(a-b);
		
		add.operate(2, 3);
		substract.operate(4,2);
		
	}
}