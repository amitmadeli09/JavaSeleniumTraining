package course2_MasteryIntermediate;
import java.util.Random;

public class AssessmentTest1 {

	public static void main(String[] args) {
		long randomTenDigitNum = GenerateTenDigitRandomNum();
		System.out.println("Random 10-digit Number :"+randomTenDigitNum);
		

	}
	
	public static long GenerateTenDigitRandomNum() {
		Random random = new Random();
		long min = 1000000000L;
		long max = 9999999999L;
		
		long randomTenDigitNum = min +((long)(random.nextDouble() * (max - min + 1)));
		return randomTenDigitNum;
	}

}
