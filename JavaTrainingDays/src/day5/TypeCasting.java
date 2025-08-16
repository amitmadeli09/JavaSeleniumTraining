package day5;

public class TypeCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int intValue = 10;
		System.out.println("Normal INT Value: "+intValue);
		double doubleValue = 99.9;
		
		float floatValue = (int)intValue;
		System.out.println("INT Value Converted into FLOAT: "+floatValue);
		
		int intFromDouble = (int)doubleValue;
		System.out.println("DOUBLE value converted to INT: "+intFromDouble);
		
	}

}
