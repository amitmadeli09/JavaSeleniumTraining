package day5;
import java.util.Arrays;

public class SortNames {
    public static void main(String[] args) {
        String[] names = {"Subham", "Amit", "Anwesha", "Satyabrata", "Satabdi"};

        // Sorting the array in ascending
        Arrays.sort(names);

        // Displaying the sorted names
        System.out.println("Sorted Names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}