package day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlFileHandling {

    public static void main(String[] args) {
        
        String filePath = "C:\\Users\\Gme\\Desktop\\Wipro\\sample.html";

        try {
           
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            
            String line;
            System.out.println("Reading HTML content:\n");
            
            
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}