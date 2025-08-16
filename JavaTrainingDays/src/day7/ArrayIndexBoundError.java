package day7;

public class ArrayIndexBoundError {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};  //length = 5
		
		try {
			System.out.println("6th Element :"+arr[5]);  //not present
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid Value: "+e.getMessage());
		}
		
	}

}
