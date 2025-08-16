package day10;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorSample {

	public static void main(String[] args) {
		
		Comparator<Integer> c1 = new Comparator<>() {
			public int compare(Integer i,Integer j) {
				if (i%10 > j%10) return 1;
				else return -1;
			}
		};
		
		List<Integer> count  = new ArrayList<>();
		count.add(33);
		count.add(55);
		count.add(11);
		count.add(44);
		count.add(22);
		System.out.println("Before Sorting :"+count);
		Collections.sort(count,c1);
		System.out.println("After Sorting :"+count);
	}

}
