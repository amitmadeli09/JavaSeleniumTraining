package day2;

public class MaxAndMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 50, 40, 60, 30};

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) { 
            	max = arr[i];
            }
            if (arr[i] < min) {
            	min = arr[i];
            }
        }

        System.out.println("Maximum element in array is = " + max);
        System.out.println("Minimum element in array is = " + min);

	}

}
