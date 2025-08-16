package day9;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class ClassSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> setData=new HashSet<Integer>();
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
