package day12;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class BufferedReaderExample1 {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\Gme\\Desktop\\Wipro\\New folder\\File4.txt";

        System.out.println("Reading the file:");

        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String lines;
            while ((lines = bf.readLine()) != null) {
                System.out.println(lines);
            }
        } catch (IOException e) {
            System.out.println("Could Not Read the File: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
