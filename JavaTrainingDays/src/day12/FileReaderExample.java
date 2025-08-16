package day12;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Gme\\Desktop\\Wipro\\New folder\\File5.txt";

        try (FileReader readFile = new FileReader(filePath)) {
            int character;
            System.out.println("File content:");
            while ((character = readFile.read())!=-1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}