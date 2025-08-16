package day5;
import java.util.Random;

public class RandomClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int randomNum = random.nextInt(1000); //random number between 0 to 999
		
		System.out.println("The Random Number :"+randomNum);
	}

}
