package day12;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample2 {

	public static void main(String[] args) throws IOException{
		
		FileWriter file = new FileWriter("C:\\Users\\Gme\\Desktop\\Wipro\\New folder\\File5.txt");
		file.write("Hello Word");
		System.out.println("File Written Successfully");
		file.close();
	}
}
