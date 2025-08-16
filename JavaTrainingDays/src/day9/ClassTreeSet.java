package day9;
import java.util.TreeSet;
import java.util.Set;
import java.util.Iterator;

public class ClassTreeSet {

	public static void main(String[] args) {
		
		Set<Integer> setData = new TreeSet<Integer>();
		setData.add(10);
		//setData.add("hello");
		setData.add(10);
		setData.add(98);
		//setData.add("hello");
		setData.add(16);
		System.out.println(setData);
		Iterator<Integer> iterator=setData.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}

}
