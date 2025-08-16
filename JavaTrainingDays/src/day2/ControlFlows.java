package day2;

public class ControlFlows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 18;
		if(age >= 18) {
			System.out.println("Age is greater than or equal to 18");
		}
		else {
			System.out.println("Age is lesser than or equal to 18");
		}
		
		switch(age) {
			case 1:
				System.out.println("Age is greater than or equal to 18");
				break;
			case 2: 
				System.out.println("Age is lesser than or equal to 18");
				
		}

	}

}
