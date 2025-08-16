package day12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample2 {

    public static void main(String[] args) {
        String filename = "C:\\Users\\Gme\\Desktop\\Wipro\\New folder\\File5.txt";

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(filename))) {
            bf.write("This is just an example.");
            bf.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("File writing operation completed.");
        }
    }
}