package day10;

public class InputExample {

    public static void main(String[] args) throws java.io.IOException {
        System.out.println("Please enter a value:");

        int inputValue = System.in.read();
        System.out.println("Test 1: ASCII value = " + inputValue); //only for single digit
        System.out.println("Test 2: Value entered = " + (char) inputValue);
        
        
        System.out.println("Input returned");
    }
}